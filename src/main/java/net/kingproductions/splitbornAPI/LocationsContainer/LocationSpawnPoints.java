package net.kingproductions.splitbornAPI.LocationsContainer;

import org.bukkit.Location;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.world_splitborn;

public class LocationSpawnPoints {

    public static Location Hearthgrove_Spawn = null;
    public static Location The_Fold_Spawn = null;

    public static void InitializeLocations(){
        Hearthgrove_Spawn = new Location(world_splitborn, 44.5, 94, 214.5, 164, 0);
        The_Fold_Spawn = new Location(world_splitborn, 43.5, 82, 180.5, -54, 1);
    }

}
