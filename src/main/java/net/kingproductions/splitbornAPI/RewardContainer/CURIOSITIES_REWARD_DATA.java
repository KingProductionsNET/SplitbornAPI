package net.kingproductions.splitbornAPI.RewardContainer;

import net.kingproductions.splitbornAPI.CuriosityContainer.Curiosities;
import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.StatContainer.Stat;

import java.util.HashMap;
import java.util.Map;

public class CURIOSITIES_REWARD_DATA {

    public static int getGleamReward(Curiosities curiosities){
        int gleamReward = 0;

        if (curiosities.equals(Curiosities.HEADLESS_EYE)) gleamReward = 10;
        if (curiosities.equals(Curiosities.CAT_ON_TREE)) gleamReward = 10;
        if (curiosities.equals(Curiosities.SLEEPY_CAPYBARA)) gleamReward = 10;
        if (curiosities.equals(Curiosities.GHOST_MINER)) gleamReward = 10;
        if (curiosities.equals(Curiosities.RESTLESS_SKULL)) gleamReward = 10;
        if (curiosities.equals(Curiosities.FLICKER_MAN)) gleamReward = 10;
        if (curiosities.equals(Curiosities.VOID_LANTERN)) gleamReward = 10;
        if (curiosities.equals(Curiosities.JUNK_SENTINEL)) gleamReward = 10;
        if (curiosities.equals(Curiosities.PHANTOM_THIEF)) gleamReward = 10;
        if (curiosities.equals(Curiosities.CACTUS_IN_CHEST)) gleamReward = 10;
        if (curiosities.equals(Curiosities.CURIOUS_CAP)) gleamReward = 10;
        if (curiosities.equals(Curiosities.FLUFF_TOTEM)) gleamReward = 10;

        return gleamReward;
    }

    public static int getXPReward(Curiosities curiosities){
        int xpReward = 0;

        if (curiosities.equals(Curiosities.HEADLESS_EYE)) xpReward = 100;
        if (curiosities.equals(Curiosities.CAT_ON_TREE)) xpReward = 100;
        if (curiosities.equals(Curiosities.SLEEPY_CAPYBARA)) xpReward = 100;
        if (curiosities.equals(Curiosities.GHOST_MINER)) xpReward = 100;
        if (curiosities.equals(Curiosities.RESTLESS_SKULL)) xpReward = 100;
        if (curiosities.equals(Curiosities.FLICKER_MAN)) xpReward = 100;
        if (curiosities.equals(Curiosities.VOID_LANTERN)) xpReward = 100;
        if (curiosities.equals(Curiosities.JUNK_SENTINEL)) xpReward = 100;
        if (curiosities.equals(Curiosities.PHANTOM_THIEF)) xpReward = 100;
        if (curiosities.equals(Curiosities.CACTUS_IN_CHEST)) xpReward = 100;
        if (curiosities.equals(Curiosities.CURIOUS_CAP)) xpReward = 100;
        if (curiosities.equals(Curiosities.FLUFF_TOTEM)) xpReward = 100;

        return xpReward;
    }
    public static Map<Essence_ID, Integer> getEssenceRewards(Curiosities curiosities){
        Map<Essence_ID, Integer> map = new HashMap<>();

        return map;
    }

    public static Map<Item_ID, Integer> getExtraRewards(Curiosities curiosity){
        Map<Item_ID, Integer> map = new HashMap<>();

        return map;
    }

    public static Map<Stat, Integer> getStatReward(Curiosities curiosities){
        Map<Stat, Integer> map = new HashMap<>();

        map.put(Stat.HEALTH,5);

        return map;
    }

}
