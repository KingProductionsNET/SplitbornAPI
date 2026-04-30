package net.kingproductions.splitbornAPI.TeleportContainer;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;

public class FancyTeleportForEntity {

    public static Set<UUID> immediatelyStop = new HashSet<>();
    public static Set<UUID> entityNotPathingAnymore = new HashSet<>();

    public static void Start(Entity entity, Location loc2, int speed) {
        entityNotPathingAnymore.add(entity.getUniqueId());

        if (entity == null || loc2 == null || loc2.getWorld() == null) return;
        if (entity.getWorld() == null) return;
        if (!entity.getWorld().equals(loc2.getWorld())) return;

        Location loc1 = entity.getLocation().clone();

        double distance = loc1.distance(loc2);

        if (distance < 0.5) {
            entity.teleport(loc2);
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
                    cancel();
                    return;
                }

                if (entity.getLocation().distance(loc2) <= 0.5) {
                    entityNotPathingAnymore.remove(entity.getUniqueId());
                    cancel();
                    return;
                }

                for (int j = 0; j < speed && currentPoint <= points; j++) {

                    double ratio = currentPoint / (double) points;

                    if (!Double.isFinite(ratio)) {
                        cancel();
                        return;
                    }

                    ratio = Math.max(0.0, Math.min(1.0, ratio));

                    double x = loc1.getX() + ratio * (loc2.getX() - loc1.getX());
                    double y = loc1.getY() + ratio * (loc2.getY() - loc1.getY());
                    double z = loc1.getZ() + ratio * (loc2.getZ() - loc1.getZ());

                    if (!Double.isFinite(x) || !Double.isFinite(y) || !Double.isFinite(z)) {
                        cancel();
                        return;
                    }

                    Location nextLocation = new Location(loc1.getWorld(), x, y, z);

                    nextLocation.setDirection(
                            loc2.toVector().subtract(nextLocation.toVector())
                    );

                    entity.teleport(nextLocation);

                    currentPoint++;

                    if (currentPoint > points) break;
                }
            }
        }.runTaskTimer(plugin, 0L, 1L);
    }

}
