package net.kingproductions.splitbornAPI.Util;

import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import org.bson.Document;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public interface UtilProvider {

    Location getLocationFromMongo(String locationKey);
    TextDisplay spawnTextDisplay(Location spawnLocation, boolean seeThrough, String Text);
    TextDisplay spawnNPCTextDisplay(Location spawnLocation, boolean seeThrough, String Text, float viewRange);
    String getFancyProgressBar(int current, int max, String filledChar, String emptyChar);
    List<Location> getNearbyBlockLocations(Location centerLoc, int scanRadius, Material material);
    void spawnParticleLine(Player player, Particle particle, Location loc1, Location loc2);
    Location getRandomSurfaceLocation(Location center, int radius);
    void getAllRegisteredUUID(Consumer<List<UUID>> callback);
    void setObjectIntoDB(String CollectionName, String ID, String oPath, Object o, boolean replace);
    Object getDBObject(String CollectionName, String oPath, String path);
    void arcMove(Entity e, Location loc1, Location loc2, int speed, Consumer<Entity> c);
    void boostTo(Entity e, Location targetLoc, double strength);
    void arcMoveForPlayer(Player player, Location loc1, Location loc2, int speed, Consumer<Player> c, Consumer<Entity> shuttle);

    void adjustPlayerGleams(UUID uuid, int delta);

    // Generic atomic per-document Mongo primitives, for callers (e.g. cross-server plugins)
    // that need real atomicity instead of setObjectIntoDB's whole-field overwrite.
    void insertOne(String collectionName, Document doc);
    Document findOneAndUpdate(String collectionName, Document filter, Document update, boolean upsert);
    Document findOneAndDelete(String collectionName, Document filter);
    List<Document> find(String collectionName, Document filter);
    void updateOne(String collectionName, Document filter, Document update, boolean upsert);

}
