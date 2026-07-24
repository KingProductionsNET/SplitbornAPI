package net.kingproductions.splitbornAPI.RewardContainer;

import net.kingproductions.splitbornAPI.AchievementContainer.ACHIEVEMENT_ID;
import net.kingproductions.splitbornAPI.CuriosityContainer.Curiosities;
import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.Main.SplitbornAPI;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.StatContainer.Stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ACHIEVEMENT_REWARD_DATA {

    public static int getGleamReward(ACHIEVEMENT_ID achievementId){
        int gleamReward = 0;

        if (achievementId.equals(ACHIEVEMENT_ID.RADIOACTIVE_RELIEF)) gleamReward = 4000;
        if (achievementId.equals(ACHIEVEMENT_ID.WHAT_DID_YOU_EXPECT)) gleamReward = 2000;
        if (achievementId.equals(ACHIEVEMENT_ID.BLOOD_MONEY)) gleamReward = 500;
        if (achievementId.equals(ACHIEVEMENT_ID.SELF_DESTRUCTION)) gleamReward = 500;
        if (achievementId.equals(ACHIEVEMENT_ID.SHORTCUT)) gleamReward = 500;
        return gleamReward;
    }

    public static int getXPReward(ACHIEVEMENT_ID achievementId){
        int xpReward = 0;

        if (achievementId.equals(ACHIEVEMENT_ID.RADIOACTIVE_RELIEF)) xpReward = 1000;
        if (achievementId.equals(ACHIEVEMENT_ID.WHAT_DID_YOU_EXPECT)) xpReward = 200;
        if (achievementId.equals(ACHIEVEMENT_ID.BLOOD_MONEY)) xpReward = 300;
        if (achievementId.equals(ACHIEVEMENT_ID.SELF_DESTRUCTION)) xpReward = 500;
        if (achievementId.equals(ACHIEVEMENT_ID.SHORTCUT)) xpReward = 500;

        return xpReward;
    }
    public static Map<Essence_ID, Integer> getEssenceRewards(ACHIEVEMENT_ID achievementId){
        Map<Essence_ID, Integer> map = new HashMap<>();

        if (achievementId.equals(ACHIEVEMENT_ID.SELF_DESTRUCTION)){
            map.put(Essence_ID.SEED, 10);
        }

        return map;
    }
    public static Map<Item_ID, Integer> getExtraRewards(ACHIEVEMENT_ID achievementId){
        Map<Item_ID, Integer> map = new HashMap<>();

        if (achievementId.equals(ACHIEVEMENT_ID.WHAT_DID_YOU_EXPECT)){
            map.put(Item_ID.CHUP_FLUFF, 60);
        }
        if (achievementId.equals(ACHIEVEMENT_ID.SELF_DESTRUCTION)){
            map.put(Item_ID.ZENTIS_U7, 1);
        }

        return map;
    }
    public static Map<Stat, Integer> getStatReward(ACHIEVEMENT_ID achievementId){
        Map<Stat, Integer> map = new HashMap<>();

        if (achievementId.equals(ACHIEVEMENT_ID.SELF_DESTRUCTION)) map.put(Stat.HEALTH, 5);
        if (achievementId.equals(ACHIEVEMENT_ID.SHORTCUT)) map.put(Stat.STAMINA, 10);

        return map;
    }

}
