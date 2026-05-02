package net.kingproductions.splitbornAPI.RewardContainer;

import net.kingproductions.splitbornAPI.CuriosityContainer.Curiosities;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.QuestContainer.Quests;

import java.util.HashMap;
import java.util.Map;

public class CURIOSITIES_REWARD_DATA {

    public static int getGleamReward(Curiosities curiosities){
        int gleamReward = 0;

        return gleamReward;
    }

    public static int getXPReward(Curiosities curiosities){
        int xpReward = 0;


        return xpReward;
    }

    public static Map<Item_ID, Integer> getExtraRewards(Curiosities curiosity){
        Map<Item_ID, Integer> map = new HashMap<>();

        if (curiosity.equals(Curiosities.HEADLESS_EYE)){
            map.put(Item_ID.FUNNY_SWORD, 1);
        }

        return map;
    }

}
