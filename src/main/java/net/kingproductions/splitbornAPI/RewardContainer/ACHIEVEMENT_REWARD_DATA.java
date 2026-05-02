package net.kingproductions.splitbornAPI.RewardContainer;

import net.kingproductions.splitbornAPI.AchievementContainer.ACHIEVEMENT_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.Main.SplitbornAPI;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ACHIEVEMENT_REWARD_DATA {

    public static int getGleamReward(ACHIEVEMENT_ID achievementId){
        int gleamReward = 0;

        if (achievementId.equals(ACHIEVEMENT_ID.RADIOACTIVE_RELIEF)){
            gleamReward = 1000;
        }

        return gleamReward;
    }

    public static int getXPReward(ACHIEVEMENT_ID achievementId){
        int xpReward = 0;

        if (achievementId.equals(ACHIEVEMENT_ID.RADIOACTIVE_RELIEF)){
            xpReward = 1000;
        }

        return xpReward;
    }
    public static Map<Item_ID, Integer> getExtraRewards(ACHIEVEMENT_ID achievementId){
        Map<Item_ID, Integer> map = new HashMap<>();

        if (achievementId.equals(ACHIEVEMENT_ID.WHAT_DID_YOU_EXPECT)){
            map.put(Item_ID.CHUP_FLUFF, 60);
        }

        return map;
    }

}
