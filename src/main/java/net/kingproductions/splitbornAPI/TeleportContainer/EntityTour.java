package net.kingproductions.splitbornAPI.TeleportContainer;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Iterator;
import java.util.List;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;


public class EntityTour {

    private static final int INGORE = 10;

    public static void Start(Entity Shuttle, List<Location> connectionPoints, int Speed, Particle OptionalParticles) {
        Location startLocation = connectionPoints.getFirst();

        Iterator<Location> iter = connectionPoints.iterator();
        iter.next();
        if (iter.hasNext()) {
            Location firstTarget = iter.next();
            startSegment(Shuttle, startLocation, firstTarget, Speed, iter, OptionalParticles);
        }
    }

    private static void startSegment(Entity shuttle, Location loc1, Location loc2, int speed, Iterator<Location> remainingLocations, Particle OptionalParticles) {
        double distance = loc1.distance(loc2);
        int points = (int) (distance * INGORE);

        new BukkitRunnable() {
            int currentPoint = 0;

            @Override
            public void run() {
                if (shuttle == null || shuttle.isDead()){
                    this.cancel();
                    return;
                }
                if (shuttle.getLocation().distance(loc2) <= 0.5) {
                    this.cancel();
                    if (remainingLocations.hasNext()) {
                        Location nextTarget = remainingLocations.next();
                        startSegment(shuttle, loc2, nextTarget, speed, remainingLocations, OptionalParticles);
                    } else {
                        this.cancel();
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

                    currentPoint++;
                }
            }
        }.runTaskTimer(plugin, 0L, 1L);
    }

}
