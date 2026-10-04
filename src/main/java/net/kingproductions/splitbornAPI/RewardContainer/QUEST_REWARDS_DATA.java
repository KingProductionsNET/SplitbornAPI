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

        if (quest.equals(Quests.CHUP_HUNTER)) gleamReward = 50;
        if (quest.equals(Quests.DEFEAT_ROTMAW)) gleamReward = 200;
        if (quest.equals(Quests.ELIMINATE_THE_CREATURE)) gleamReward = 50;
        if (quest.equals(Quests.THE_LOST_CARAVAN)) gleamReward = 150;
        if (quest.equals(Quests.LAZY_FISHER)) gleamReward = 50;
        if (quest.equals(Quests.ITS_GETTING_HOT_IN_HERE)) gleamReward = 50;
        if (quest.equals(Quests.COOLING_CORE)) gleamReward = 300;
        if (quest.equals(Quests.HEAT_CORE)) gleamReward = 500;
        if (quest.equals(Quests.SCRAP_FOR_PIP)) gleamReward = 300;
        if (quest.equals(Quests.THE_GOBLINS_HUSTLE)) gleamReward = 2000;
        if (quest.equals(Quests.JERNIKS_LEDGER)) gleamReward = 500;
        if (quest.equals(Quests.CRUSHING_THE_NESTS)) gleamReward = 30;
        if (quest.equals(Quests.THE_VEILED_ECHO)) gleamReward = 500;
        if (quest.equals(Quests.UNWANTED_GUESTS)) gleamReward = 100;
        if (quest.equals(Quests.THE_LAKE_RUN)) gleamReward = 50;
        if (quest.equals(Quests.THE_HIDDEN_VAULT)) gleamReward = 50;

        return gleamReward;
    }

    public static int getXPReward(Quests quest){
        int xpReward = 0;

        if (quest.equals(Quests.CHUP_HUNTER)) xpReward = 100;
        if (quest.equals(Quests.DEFEAT_ROTMAW)) xpReward = 100;
        if (quest.equals(Quests.ELIMINATE_THE_CREATURE)) xpReward = 100;
        if (quest.equals(Quests.THE_LOST_CARAVAN)) xpReward = 100;
        if (quest.equals(Quests.LAZY_FISHER)) xpReward = 100;
        if (quest.equals(Quests.ITS_GETTING_HOT_IN_HERE)) xpReward = 100;
        if (quest.equals(Quests.COOLING_CORE)) xpReward = 100;
        if (quest.equals(Quests.HEAT_CORE)) xpReward = 100;
        if (quest.equals(Quests.SCRAP_FOR_PIP)) xpReward = 100;
        if (quest.equals(Quests.THE_GOBLINS_HUSTLE)) xpReward = 100;
        if (quest.equals(Quests.JERNIKS_LEDGER)) xpReward = 100;
        if (quest.equals(Quests.CRUSHING_THE_NESTS)) xpReward = 100;
        if (quest.equals(Quests.THE_VEILED_ECHO)) xpReward = 100;
        if (quest.equals(Quests.UNWANTED_GUESTS)) xpReward = 100;
        if (quest.equals(Quests.THE_LAKE_RUN)) xpReward = 100;
        if (quest.equals(Quests.THE_HIDDEN_VAULT)) xpReward = 100;

        return xpReward;
    }

    public static Map<Essence_ID, Integer> getEssenceRewards(Quests quests){
        Map<Essence_ID, Integer> map = new HashMap<>();

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
        return map;
    }

}
