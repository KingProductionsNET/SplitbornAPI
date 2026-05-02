package net.kingproductions.splitbornAPI.RewardContainer;

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
            gleamReward = 500;
        }
        if (location.equals(Locations.The_Fold)){
            gleamReward = 1000;
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

        return xpReward;
    }

    public static Map<Item_ID, Integer> getExtraRewards(Locations location){
        Map<Item_ID, Integer> map = new HashMap<>();
        if (location.equals(Locations.The_Fold)){

        }

        return map;
    }

}
