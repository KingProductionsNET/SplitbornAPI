package net.kingproductions.splitbornAPI.Util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;

import java.util.List;

public interface UtilProvider {

    Location getLocationFromMongo(String locationKey);
    TextDisplay spawnTextDisplay(Location spawnLocation, boolean seeThrough, String Text);
    String getFancyProgressBar(int current, int max, char filledChar, char emptyChar);
    List<Location> getNearbyBlockLocations(Location centerLoc, int scanRadius, Material material);
    void spawnParticleLine(Player player, Particle particle, Location loc1, Location loc2);
    Location getRandomSurfaceLocation(Location center, int radius);

}
