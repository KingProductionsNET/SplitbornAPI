package net.kingproductions.splitbornAPI.RewardContainer;

import net.kingproductions.splitbornAPI.QuestContainer.Quests;

import java.util.ArrayList;
import java.util.List;

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

    public static List<String> getExtraRewards(Quests quest){
        List<String> list = new ArrayList<>();

        return list;
    }

}
