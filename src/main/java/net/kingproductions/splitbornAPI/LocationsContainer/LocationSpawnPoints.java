package net.kingproductions.splitbornAPI.LocationsContainer;

import org.bukkit.Location;

import java.util.EnumMap;
import java.util.Map;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.world_splitborn;

public class LocationSpawnPoints {

    public static Location Hearthgrove_Spawn = null;
    public static Location The_Fold_Spawn = null;
    public static Location The_Beyond_Spawn = null;
    public static Location Sporewood_Spawn = null;
    public static Location Ashvein_Mine_Spawn = null;
    public static Location Junkyard_Spawn = null;
    public static Location Dojo_Spawn = null;
    public static Location The_Undercroft_Spawn = null;
    public static Location Brinehollow_Spawn = null;
    public static Location Dryoak_Spawn = null;
    public static Location Darkshaft_Spawn = null;
    public static Location SunkenTrenches_Spawn = null;
    public static Location TheMoltenRing_Spawn = null;
    public static Location Hollowdeep_Spawn = null;
    public static Location Doomrest_Spawn = null;
    public static Location Auralith_Spawn = null;
    public static Location Ochrefall_Spawn = null;
    public static Location Unfound_Spawn = null;

    private static final Map<Locations, Location> SPAWN_POINTS = new EnumMap<>(Locations.class);

    public static void InitializeLocations(){
        Hearthgrove_Spawn = new Location(world_splitborn, 44.5, 94, 214.5, 164, 0);
        The_Fold_Spawn = new Location(world_splitborn, 43.5, 82, 180.5, -54, 0);
        Sporewood_Spawn = new Location(world_splitborn, -60, 109, 117.5, 139, 0);
        Ashvein_Mine_Spawn = new Location(world_splitborn, 72.5, 91, 133.5, -180, 0);
        Junkyard_Spawn = new Location(world_splitborn, -51.5, 100, 246.5, -37, 0);
        Dojo_Spawn = new Location(world_splitborn, 121.5, 53, 153.5, 90, 0);
        The_Undercroft_Spawn = new Location(world_splitborn, 148.5, 106, 119.5, -99, 0);
        Brinehollow_Spawn = new Location(world_splitborn, 78.5, 110, 125.5, -150, 0);
        Dryoak_Spawn = new Location(world_splitborn, -43.5, 106, 196.5, 43, 0);

        Darkshaft_Spawn = new Location(world_splitborn, -107.5,119,259.5,90,0);
        SunkenTrenches_Spawn = new Location(world_splitborn, -94.3,114,21.6,141,18);
        TheMoltenRing_Spawn = new Location(world_splitborn, -50.5,106,183.5,90,0);
        Hollowdeep_Spawn = new Location(world_splitborn, -35.5,113,329.5,49,33);
        Doomrest_Spawn = new Location(world_splitborn, 145.9,120.9,188.7,-63,-19);
        Auralith_Spawn = new Location(world_splitborn, -40.7,80,367.3,-65,0);
        Ochrefall_Spawn = new Location(world_splitborn, -77.5,98,375.7,-16,25);
        Unfound_Spawn = new Location(world_splitborn, -100.5,70,392.3,90,0);

        SPAWN_POINTS.put(Locations.Hearthgrove, Hearthgrove_Spawn);
        SPAWN_POINTS.put(Locations.The_Fold, The_Fold_Spawn);
        SPAWN_POINTS.put(Locations.The_Beyond, The_Beyond_Spawn);
        SPAWN_POINTS.put(Locations.Sporewood, Sporewood_Spawn);
        SPAWN_POINTS.put(Locations.Ashvein_Mine, Ashvein_Mine_Spawn);
        SPAWN_POINTS.put(Locations.Junkyard, Junkyard_Spawn);
        SPAWN_POINTS.put(Locations.Dojo, Dojo_Spawn);
        SPAWN_POINTS.put(Locations.The_Undercroft, The_Undercroft_Spawn);
        SPAWN_POINTS.put(Locations.Brinehollow, Brinehollow_Spawn);
        SPAWN_POINTS.put(Locations.Dryoak, Dryoak_Spawn);

        SPAWN_POINTS.put(Locations.Darkshaft, Darkshaft_Spawn);
        SPAWN_POINTS.put(Locations.Sunken_Trenches, SunkenTrenches_Spawn);
        SPAWN_POINTS.put(Locations.The_Molten_Ring, TheMoltenRing_Spawn);
        SPAWN_POINTS.put(Locations.Hollowdeep, Hollowdeep_Spawn);
        SPAWN_POINTS.put(Locations.Doomrest, Doomrest_Spawn);
        SPAWN_POINTS.put(Locations.Auralith, Auralith_Spawn);
        SPAWN_POINTS.put(Locations.Ochrefall, Ochrefall_Spawn);
        SPAWN_POINTS.put(Locations.The_Unfound, Unfound_Spawn);
    }

    public static Location getSpawnPoint(Locations location){
        Location spawn = SPAWN_POINTS.get(location);
        return spawn != null ? spawn : Hearthgrove_Spawn;
    }

}
