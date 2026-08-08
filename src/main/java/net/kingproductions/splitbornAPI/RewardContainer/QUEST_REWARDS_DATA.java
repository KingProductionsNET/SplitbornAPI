package net.kingproductions.splitbornAPI.RewardContainer;

import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import net.kingproductions.splitbornAPI.StatContainer.Stat;

import java.util.HashMap;
import java.util.Map;

public class QUEST_REWARDS_DATA {

    public static int getGleamReward(Quests quest){
        int gleamReward = 0;

        if (quest.equals(Quests.CHUP_HUNTER)) gleamReward = 1000;
        if (quest.equals(Quests.DEFEAT_ROTMAW)) gleamReward = 5000;
        if (quest.equals(Quests.ELIMINATE_THE_CREATURE)) gleamReward = 1250;
        if (quest.equals(Quests.THE_LOST_CARAVAN)) gleamReward = 2000;
        if (quest.equals(Quests.LAZY_FISHER)) gleamReward = 500;
        if (quest.equals(Quests.ITS_GETTING_HOT_IN_HERE)) gleamReward = 1000;
        if (quest.equals(Quests.COOLING_CORE)) gleamReward = 1000;
        if (quest.equals(Quests.HEAT_CORE)) gleamReward = 2000;
        if (quest.equals(Quests.SCRAP_FOR_PIP)) gleamReward = 2000;
        if (quest.equals(Quests.THE_GOBLINS_HUSTLE)) gleamReward = 1500;

        return gleamReward;
    }

    public static int getXPReward(Quests quest){
        int xpReward = 0;

        if (quest.equals(Quests.CHUP_HUNTER)) xpReward = 100;
        if (quest.equals(Quests.DEFEAT_ROTMAW)) xpReward = 300;
        if (quest.equals(Quests.ELIMINATE_THE_CREATURE)) xpReward = 250;
        if (quest.equals(Quests.THE_LOST_CARAVAN)) xpReward = 300;
        if (quest.equals(Quests.LAZY_FISHER)) xpReward = 500;
        if (quest.equals(Quests.ITS_GETTING_HOT_IN_HERE)) xpReward = 300;
        if (quest.equals(Quests.COOLING_CORE)) xpReward = 400;
        if (quest.equals(Quests.HEAT_CORE)) xpReward = 500;
        if (quest.equals(Quests.SCRAP_FOR_PIP)) xpReward = 700;
        if (quest.equals(Quests.THE_GOBLINS_HUSTLE)) xpReward = 300;
        if (quest.equals(Quests.JERNIKS_LEDGER)) xpReward = 300;

        return xpReward;
    }

    public static Map<Essence_ID, Integer> getEssenceRewards(Quests quests){
        Map<Essence_ID, Integer> map = new HashMap<>();

        if (quests.equals(Quests.DEFEAT_ROTMAW)){
            map.put(Essence_ID.CHALLENGE, 500);
        }

        return map;
    }

    public static Map<Item_ID, Integer> getExtraRewards(Quests quest){
        Map<Item_ID, Integer> map = new HashMap<>();

        if (quest.equals(Quests.CHUP_HUNTER)){
            map.put(Item_ID.SWEEPIS_MASK, 1);
        }

        return map;
    }

    public static Map<Stat, Integer> getStatReward(Quests quests){
        Map<Stat, Integer> map = new HashMap<>();

        if (quests.equals(Quests.CHUP_HUNTER)) map.put(Stat.HEALTH, 5);

        return map;
    }

}
