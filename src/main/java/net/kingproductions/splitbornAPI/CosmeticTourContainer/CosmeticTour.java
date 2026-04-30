package net.kingproductions.splitbornAPI.CosmeticTourContainer;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;
import java.util.function.Consumer;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;
import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.random;

public class CosmeticTour implements Listener {

    private final int INGORE = 10;

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
        Location startLocation = connectionPoints.getFirst();

        LivingEntity Shuttle = (LivingEntity) startLocation.getWorld().spawn(startLocation, TourGuide.getEntityClass());
        Shuttle.setInvulnerable(true);
        Shuttle.setAI(false);
        Shuttle.setSilent(true);
        Shuttle.setInvisible(Invisible);

        Passenger.playSound(Passenger.getLocation(), Sound.BLOCK_ANVIL_LAND, 1F, random.nextFloat());

        //!!!!
        Passenger.setSneaking(false);
        Shuttle.addPassenger(Passenger);
        //!!!!

        Iterator<Location> iter = connectionPoints.iterator();
        iter.next();
        if (iter.hasNext()) {
            Location firstTarget = iter.next();
            startSegment(Passenger, Shuttle, startLocation, firstTarget, Speed, iter);
        }

//        if (!Music.equalsIgnoreCase("-")) NoteBlockAPI.Play(Passenger, Music, true);
    }

    private void startSegment(Player passenger, Entity shuttle, Location loc1, Location loc2, int speed, Iterator<Location> remainingLocations) {
        if (passenger == null || shuttle == null) return;
        isInATour.add(Passenger);


        double distance = loc1.distance(loc2);
        int points = (int) (distance * INGORE);

        new BukkitRunnable() {
            int currentPoint = 0;
            int playGallop = 0;

            @Override
            public void run() {
                if (passenger == null || !passenger.isOnline()){
                    shuttle.remove();
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

                        if (endLoc == null){
                            Passenger.teleport(loc2);
                        } else {
                            Passenger.teleport(endLoc);
                        }
                        Passenger.playSound(Passenger.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1F, 2F);

                        if (consumer != null){
                            consumer.accept(Passenger);
                        }
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

    public void lookAt(Entity entity, Location target) {
        Location loc = entity.getLocation();
        double dx = target.getX() - loc.getX();
        double dy = target.getY() - loc.getY();
        double dz = target.getZ() - loc.getZ();

        float yaw = (float) Math.toDegrees(Math.atan2(-dx, dz));

        double distanceXZ = Math.sqrt(dx * dx + dz * dz);
        float pitch = (float) Math.toDegrees(-Math.atan2(dy, distanceXZ));

        loc.setYaw(yaw);
        loc.setPitch(pitch);
        entity.teleport(loc);
    }

    @EventHandler
    public void noExit(PlayerToggleSneakEvent event){
        if (isInATour.contains(event.getPlayer())) event.setCancelled(true);
    }
}