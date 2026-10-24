package net.kingproductions.splitbornAPI.RewardContainer;

import net.kingproductions.splitbornAPI.CuriosityContainer.Curiosities;
import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.LocationsContainer.Locations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LOCATION_REWARD_DATA {

    public static int getGleamReward(Locations location){
        int gleamReward = 0;

        if (location.equals(Locations.Hearthgrove)){
            gleamReward = 10;
        }
        if (location.equals(Locations.The_Fold)){
            gleamReward = 10;
        }
        if (location.equals(Locations.Sporewood)){
            gleamReward = 50;
        }
        if (location.equals(Locations.Ashvein_Mine)){
            gleamReward = 25;
        }
        if (location.equals(Locations.Junkyard)){
            gleamReward = 50;
        }
        if (location.equals(Locations.Dryoak)){
            gleamReward = 50;
        }
        if (location.equals(Locations.Brinehollow)){
            gleamReward = 10;
        }
        if (location.equals(Locations.The_Undercroft)){
            gleamReward = 10;
        }
        if (location.equals(Locations.Dojo)){
            gleamReward = 10;
        }
        if (location.equals(Locations.Doomrest)){
            gleamReward = 10;
        }
        if (location.equals(Locations.Little_Spore)){
            gleamReward = 50;
        }
        if (location.equals(Locations.Sunken_Trenches)){
            gleamReward = 25;
        }
        if (location.equals(Locations.The_Molten_Ring)){
            gleamReward = 50;
        }
        if (location.equals(Locations.Darkshaft)){
            gleamReward = 50;
        }
        if (location.equals(Locations.Hollowdeep)){
            gleamReward = 10;
        }
        if (location.equals(Locations.Auralith)){
            gleamReward = 10;
        }
        if (location.equals(Locations.Ochrefall)){
            gleamReward = 10;
        }
        if (location.equals(Locations.The_Unfound)){
            gleamReward = 10;
        }

        return gleamReward;
    }

    public static int getXPReward(Locations location){
        int xpReward = 0;


        if (location.equals(Locations.Hearthgrove)){
            xpReward = 100;
        }
        if (location.equals(Locations.The_Fold)){
            xpReward = 100;
        }
        if (location.equals(Locations.Sporewood)){
            xpReward = 100;
        }
        if (location.equals(Locations.Ashvein_Mine)){
            xpReward = 100;
        }
        if (location.equals(Locations.Junkyard)){
            xpReward = 100;
        }
        if (location.equals(Locations.Dryoak)){
            xpReward = 100;
        }
        if (location.equals(Locations.Brinehollow)){
            xpReward = 100;
        }
        if (location.equals(Locations.The_Undercroft)){
            xpReward = 100;
        }
        if (location.equals(Locations.Dojo)){
            xpReward = 100;
        }
        if (location.equals(Locations.Doomrest)){
            xpReward = 100;
        }
        if (location.equals(Locations.Little_Spore)){
            xpReward = 100;
        }
        if (location.equals(Locations.Sunken_Trenches)){
            xpReward = 100;
        }
        if (location.equals(Locations.The_Molten_Ring)){
            xpReward = 100;
        }
        if (location.equals(Locations.Darkshaft)){
            xpReward = 100;
        }
        if (location.equals(Locations.Hollowdeep)){
            xpReward = 100;
        }
        if (location.equals(Locations.Auralith)){
            xpReward = 100;
        }
        if (location.equals(Locations.Ochrefall)){
            xpReward = 100;
        }
        if (location.equals(Locations.The_Unfound)){
            xpReward = 100;
        }

        return xpReward;
    }
    public static Map<Essence_ID, Integer> getEssenceRewards(Locations location){
        Map<Essence_ID, Integer> map = new HashMap<>();

        return map;
    }

    public static Map<Item_ID, Integer> getExtraRewards(Locations location){
        Map<Item_ID, Integer> map = new HashMap<>();

        return map;
    }

}
