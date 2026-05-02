package net.kingproductions.splitbornAPI.RewardContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.Quests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QUEST_REWARDS_DATA {

    public static int getGleamReward(Quests quest){
        int gleamReward = 0;

        if (quest.equals(Quests.Chup_Hunter)){
            gleamReward = 1000;
        }

        return gleamReward;
    }

    public static int getXPReward(Quests quest){
        int xpReward = 0;

        if (quest.equals(Quests.Chup_Hunter)){
            xpReward = 100;
        }

        return xpReward;
    }

    public static Map<Item_ID, Integer> getExtraRewards(Quests quest){
        Map<Item_ID, Integer> map = new HashMap<>();

        if (quest.equals(Quests.Chup_Hunter)){
            map.put(Item_ID.SWEEPIS_MASK, 1);
        }

        return map;
    }

}
