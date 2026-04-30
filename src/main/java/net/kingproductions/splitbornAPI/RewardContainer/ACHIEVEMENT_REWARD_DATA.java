package net.kingproductions.splitbornAPI.RewardContainer;

import net.kingproductions.splitbornAPI.AchievementContainer.ACHIEVEMENT_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.Main.SplitbornAPI;

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

    public static Map<Item_ID, Integer> handleRewardLogic(ACHIEVEMENT_ID achievementId){
        Map<Item_ID, Integer> map = new HashMap<>();
        if (achievementId.equals(ACHIEVEMENT_ID.RADIOACTIVE_RELIEF)){
            map.put(Item_ID.ZENTIS_U7, 7);
        }

        return map;
    }

    public static List<String> getRewardsAsList(ACHIEVEMENT_ID achievementId){
        List<String> list = new ArrayList<>();
        for (Item_ID itemId : handleRewardLogic(achievementId).keySet()){
            int amount = handleRewardLogic(achievementId).get(itemId);

            list.add(SplitbornAPI.getHelper().getListingSymbol() + "§b" + amount + "x " + SplitbornAPI.getItem(itemId).getItemMeta().getDisplayName());
        }

        return list;
    }

}
