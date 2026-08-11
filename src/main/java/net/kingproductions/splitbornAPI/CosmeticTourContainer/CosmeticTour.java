package net.kingproductions.splitbornAPI.CosmeticTourContainer;

import net.kingproductions.splitbornAPI.AbilityCastEventContainer.AbilityCastEvent;
import net.kingproductions.splitbornAPI.CommandBlockContainer.COMMAND_ID;
import net.kingproductions.splitbornAPI.Main.SplitbornAPI;
import net.kingproductions.splitbornAPI.NoteBlockAPIContainer.NoteBlockAPI;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;
import java.util.function.Consumer;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;
import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.random;

public class CosmeticTour implements Listener {
    private final int INGORE = 6;

    private Player Passenger;
    private Consumer<Player> consumer;

    private List<Location> connectionPoints = new ArrayList<>();
    private EntityType TourGuide = EntityType.GOAT;
    private int Speed = 5;
    private boolean Invisible = true;
    private String Music = "-";
    private Particle TourParticles = null;
    private boolean GallopSound = false;
    private Location endLoc;

    public static Set<Player> isInATour = new HashSet<>();

    public CosmeticTour setPassenger(Player player){
        this.Passenger = player;
        return this;
    }
    public CosmeticTour setEndLoc(Location loc){
        endLoc = loc;
        return this;
    }
    public CosmeticTour setTourGuideType(EntityType eT){
        this.TourGuide = eT;
        return this;
    }
    public CosmeticTour addConnectionPoints(List<Location> locationList){
        this.connectionPoints = locationList;
        return this;
    }
    public CosmeticTour setSpeed(int Speed){
        this.Speed = Speed;
        return this;
    }
    public CosmeticTour setMusic(String music){
        this.Music = music;
        return this;
    }
    public CosmeticTour Invisible(boolean b){
        this.Invisible = b;
        return this;
    }
    public CosmeticTour setParticles(Particle particles){
        this.TourParticles = particles;
        return this;
    }
    public CosmeticTour GallopSound(boolean b){
        this.GallopSound = b;
        return this;
    }
    public CosmeticTour addTourEndAction(Consumer<Player> c){
        consumer = c;
        return this;
    }

    public void Start() {
        if (Passenger == null || connectionPoints.isEmpty()) return;
        if (Passenger.hasMetadata("ON_TOUR")) return;

        Location startLocation = connectionPoints.getFirst();
        SplitbornAPI.BlockCommand().BlockCommand(Passenger, COMMAND_ID.SPAWN);

        LivingEntity Shuttle = (LivingEntity) startLocation.getWorld().spawn(startLocation, TourGuide.getEntityClass());
        Shuttle.setInvulnerable(true);
        Shuttle.setAI(false);
        Shuttle.setSilent(true);
        Shuttle.setInvisible(Invisible);

        Passenger.playSound(Passenger.getLocation(), Sound.BLOCK_ANVIL_LAND, 1F, random.nextFloat());

        Passenger.setSneaking(false);
        Shuttle.addPassenger(Passenger);

        Iterator<Location> iter = connectionPoints.iterator();
        iter.next();
        if (iter.hasNext()) {
            Location firstTarget = iter.next();
            startSegment(Passenger, Shuttle, startLocation, firstTarget, Speed, iter);
        }

        Passenger.setMetadata("ON_TOUR", new FixedMetadataValue(plugin, ""));

        if (!Music.equalsIgnoreCase("-")) NoteBlockAPI.Play(Passenger, Music, true);
    }

    private static final Map<UUID, UUID> playersShuttle = new HashMap<>();

    private void startSegment(Player passenger, Entity shuttle, Location loc1, Location loc2, int speed, Iterator<Location> remainingLocations) {
        if (passenger == null || shuttle == null) return;
        isInATour.add(Passenger);
        playersShuttle.put(Passenger.getUniqueId(), shuttle.getUniqueId());

        double distance = loc1.distance(loc2);
        int points = (int) (distance * INGORE);

        passenger.setGameMode(GameMode.ADVENTURE);
        passenger.setInvulnerable(true);

        new BukkitRunnable() {
            int currentPoint = 0;
            int playGallop = 0;

            @Override
            public void run() {
                if (!passenger.isOnline()){
                    shuttle.remove();
                    passenger.setInvulnerable(false);
                    this.cancel();
                    return;
                }
                if (shuttle.getLocation().distance(loc2) <= 0.5) {
                    this.cancel();

                    if (remainingLocations.hasNext()) {
                        Location nextTarget = remainingLocations.next();
                        startSegment(passenger, shuttle, loc2, nextTarget, speed, remainingLocations);
                    } else {
                        shuttle.remove();
                        Passenger.playSound(Passenger.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1F, random.nextFloat());
                        isInATour.remove(Passenger);

                        Passenger.teleport(Objects.requireNonNullElse(endLoc, loc2));
                        Passenger.playSound(Passenger.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 2F);

                        if (consumer != null){
                            consumer.accept(Passenger);
                        }

                        passenger.setInvulnerable(false);
                        Passenger.removeMetadata("ON_TOUR", plugin);
                        passenger.setGameMode(GameMode.SURVIVAL);

                        SplitbornAPI.BlockCommand().UnblockCommand(Passenger, COMMAND_ID.SPAWN);

                        SplitbornAPI.getHelper().forceUpdatePlayersLocation(Passenger);
                    }
                    return;
                }

                for (int j = 0; j < speed && currentPoint <= points; j++) {
                    double ratio = currentPoint / (double) points;
                    double x = loc1.getX() + ratio * (loc2.getX() - loc1.getX());
                    double y = loc1.getY() + ratio * (loc2.getY() - loc1.getY());
                    double z = loc1.getZ() + ratio * (loc2.getZ() - loc1.getZ());
                    Location nextLocation = new Location(loc1.getWorld(), x, y, z);
                    nextLocation.setDirection(loc2.toVector().subtract(nextLocation.toVector()));

                    shuttle.teleport(nextLocation);

                    if (TourParticles != null) Passenger.spawnParticle(TourParticles, shuttle.getLocation().clone().add(0, 0.5, 0), 0, 0, 0, 0, 1);

                    currentPoint++;
                }

                if (GallopSound && playGallop == 3){
                    Passenger.playSound(Passenger.getLocation(), Sound.ENTITY_HORSE_GALLOP, 0.7F, 1F + random.nextFloat());
                    playGallop = 0;
                }

                playGallop ++;
            }
        }.runTaskTimer(plugin, 0L, 1L);
    }

    @EventHandler
    public void noExit(PlayerToggleSneakEvent event){
        if (isInATour.contains(event.getPlayer())) event.setCancelled(true);
    }

    @EventHandler
    public void noTeleport(PlayerTeleportEvent event){
        if (isInATour.contains(event.getPlayer())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        UUID uuid = playersShuttle.getOrDefault(player.getUniqueId(), null);
        if (uuid != null){
            Entity e = Bukkit.getEntity(uuid);

            if (e != null) e.remove();
            playersShuttle.remove(player.getUniqueId());
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        event.getPlayer().removeMetadata("ON_TOUR", plugin);
    }
}