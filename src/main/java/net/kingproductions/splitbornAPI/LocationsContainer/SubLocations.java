package net.kingproductions.splitbornAPI.LocationsContainer;

import java.util.ArrayList;
import java.util.List;

public class SubLocations {

    public static List<Locations> HEARTHGROVE_SUBLOCATIONS = List.of(
            Locations.Dojo,
            Locations.The_Undercroft,
            Locations.Brinehollow,
            Locations.The_Molten_Ring
    );
    public static List<Locations> SPOREWOOD_SUBLOCATIONS = List.of(
            Locations.Little_Spore,
            Locations.Sunken_Trenches
    );
    public static List<Locations> DRYOAK_SUBLOCATIONS = List.of(
            Locations.Darkshaft
    );
    public static List<Locations> JUNKYARD_SUBLOCATIONS = List.of(
            Locations.Hollowdeep,
            Locations.Auralith,
            Locations.Ochrefall,
            Locations.The_Unfound
    );

    public static List<Locations> getSubLocations(Locations location){
        return switch (location){
            case Hearthgrove -> HEARTHGROVE_SUBLOCATIONS;
            case Sporewood -> SPOREWOOD_SUBLOCATIONS;
            case Dryoak -> DRYOAK_SUBLOCATIONS;
            case Junkyard -> JUNKYARD_SUBLOCATIONS;
            default -> new ArrayList<>();
        };
    }

}
