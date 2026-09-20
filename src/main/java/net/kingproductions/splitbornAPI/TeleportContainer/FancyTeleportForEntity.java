package net.kingproductions.splitbornAPI.TeleportContainer;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;

public class FancyTeleportForEntity {

    public static Set<UUID> immediatelyStop = new HashSet<>();
    public static Set<UUID> entityNotPathingAnymore = new HashSet<>();

    public static void Start(Entity entity, Location loc2, int speed, Consumer<Entity> consumer) {
        entityNotPathingAnymore.add(entity.getUniqueId());

        if (entity == null || loc2 == null || loc2.getWorld() == null) return;
        if (entity.getWorld() == null) return;
        if (!entity.getWorld().equals(loc2.getWorld())) return;

        Location loc1 = entity.getLocation().clone();
        double distance = loc1.distance(loc2);

        if (distance < 0.5) {
            entity.teleport(loc2);

            if (consumer != null){
                consumer.accept(entity);
            }

            entityNotPathingAnymore.remove(entity.getUniqueId());
            return;
        }

        int points = Math.max(1, (int) (distance * 10.0));

        new BukkitRunnable() {
            int currentPoint = 0;

            @Override
            public void run() {
                if (entity.isDead() || immediatelyStop.contains(entity.getUniqueId())) {
                    immediatelyStop.remove(entity.getUniqueId());
                    entityNotPathingAnymore.remove(entity.getUniqueId());

                    if (consumer != null){
                        consumer.accept(entity);
                    }

                    cancel();
                    return;
                }

                if (entity.getLocation().distance(loc2) <= 1) {
                    entityNotPathingAnymore.remove(entity.getUniqueId());

                    if (consumer != null){
                        consumer.accept(entity);
                    }

                    cancel();
                    return;
                }

                for (int j = 0; j < speed && currentPoint <= points; j++) {

                    double ratio = currentPoint / (double) points;

                    if (!Double.isFinite(ratio)) {
                        if (consumer != null){
                            consumer.accept(entity);
                        }

                        cancel();
                        return;
                    }

                    ratio = Math.clamp(ratio, 0.0, 1.0);

                    double x = loc1.getX() + ratio * (loc2.getX() - loc1.getX());
                    double y = loc1.getY() + ratio * (loc2.getY() - loc1.getY());
                    double z = loc1.getZ() + ratio * (loc2.getZ() - loc1.getZ());

                    if (!Double.isFinite(x) || !Double.isFinite(y) || !Double.isFinite(z)) {
                        if (consumer != null){
                            consumer.accept(entity);
                        }

                        cancel();
                        return;
                    }

                    Location nextLocation = new Location(loc1.getWorld(), x, y, z, entity.getYaw(), entity.getPitch());

                    if (!(entity instanceof ItemDisplay)){
                        nextLocation.setDirection(loc2.toVector().subtract(nextLocation.toVector()));
                    }

                    entity.teleport(nextLocation);

                    currentPoint++;

                    if (currentPoint > points) {
                        if (consumer != null) {
                            consumer.accept(entity);
                        }
                        this.cancel();
                        return;
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 1L);
    }

}
