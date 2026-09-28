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

        if (curiosities.equals(Curiosities.HEADLESS_EYE)) gleamReward = 25;
        if (curiosities.equals(Curiosities.CAT_ON_TREE)) gleamReward = 25;
        if (curiosities.equals(Curiosities.SLEEPY_CAPYBARA)) gleamReward = 25;
        if (curiosities.equals(Curiosities.GHOST_MINER)) gleamReward = 25;
        if (curiosities.equals(Curiosities.RESTLESS_SKULL)) gleamReward = 25;
        if (curiosities.equals(Curiosities.FLICKER_MAN)) gleamReward = 25;
        if (curiosities.equals(Curiosities.VOID_LANTERN)) gleamReward = 25;
        if (curiosities.equals(Curiosities.JUNK_SENTINEL)) gleamReward = 25;
        if (curiosities.equals(Curiosities.PHANTOM_THIEF)) gleamReward = 25;

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

        return xpReward;
    }
    public static Map<Essence_ID, Integer> getEssenceRewards(Curiosities curiosities){
        Map<Essence_ID, Integer> map = new HashMap<>();

        return map;
    }

    public static Map<Item_ID, Integer> getExtraRewards(Curiosities curiosity){
        Map<Item_ID, Integer> map = new HashMap<>();

        if (curiosity.equals(Curiosities.HEADLESS_EYE)){
            map.put(Item_ID.FUNNY_SWORD, 1);
        }

        return map;
    }
    //
    public static Map<Stat, Integer> getStatReward(Curiosities curiosities){
        Map<Stat, Integer> map = new HashMap<>();

        return map;
    }

}
