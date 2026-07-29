package net.kingproductions.splitbornAPI.LocationsContainer;

import org.bukkit.Location;

import java.util.EnumMap;
import java.util.Map;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.world_splitborn;

public class LocationSpawnPoints {

    public static Location Hearthgrove_Spawn = null;
    public static Location The_Fold_Spawn = null;
    public static Location Doomrest_Spawn = null;
    public static Location The_Beyond_Spawn = null;
    public static Location Sporewood_Spawn = null;
    public static Location Ashvein_Mine_Spawn = null;
    public static Location Junkyard_Spawn = null;

    private static final Map<Locations, Location> SPAWN_POINTS = new EnumMap<>(Locations.class);

    public static void InitializeLocations(){
        Hearthgrove_Spawn = new Location(world_splitborn, 44.5, 94, 214.5, 164, 0);
        The_Fold_Spawn = new Location(world_splitborn, 43.5, 82, 180.5, -54, 0);
        Sporewood_Spawn = new Location(world_splitborn, -60, 109, 117.5, 139, 0);
        Ashvein_Mine_Spawn = new Location(world_splitborn, 72.5, 91, 133.5, -180, 0);
        Junkyard_Spawn = new Location(world_splitborn, -51.5, 100, 246.5, -37, 0);

        SPAWN_POINTS.put(Locations.Hearthgrove, Hearthgrove_Spawn);
        SPAWN_POINTS.put(Locations.The_Fold, The_Fold_Spawn);
        SPAWN_POINTS.put(Locations.Doomrest, Doomrest_Spawn);
        SPAWN_POINTS.put(Locations.The_Beyond, The_Beyond_Spawn);
        SPAWN_POINTS.put(Locations.Sporewood, Sporewood_Spawn);
        SPAWN_POINTS.put(Locations.Ashvein_Mine, Ashvein_Mine_Spawn);
        SPAWN_POINTS.put(Locations.Junkyard, Junkyard_Spawn);
    }

    public static Location getSpawnPoint(Locations location){
        Location spawn = SPAWN_POINTS.get(location);
        return spawn != null ? spawn : Hearthgrove_Spawn;
    }

}
