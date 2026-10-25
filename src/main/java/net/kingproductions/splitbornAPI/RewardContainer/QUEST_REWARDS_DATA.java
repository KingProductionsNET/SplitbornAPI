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

        if (quest.equals(Quests.CHUP_HUNTER)) gleamReward = 20;
        if (quest.equals(Quests.DEFEAT_ROTMAW)) gleamReward = 60;
        if (quest.equals(Quests.ELIMINATE_THE_CREATURE)) gleamReward = 20;
        if (quest.equals(Quests.THE_LOST_CARAVAN)) gleamReward = 150;
        if (quest.equals(Quests.LAZY_FISHER)) gleamReward = 20;
        if (quest.equals(Quests.ITS_GETTING_HOT_IN_HERE)) gleamReward = 20;
        if (quest.equals(Quests.COOLING_CORE)) gleamReward = 300;
        if (quest.equals(Quests.HEAT_CORE)) gleamReward = 300;
        if (quest.equals(Quests.SCRAP_FOR_PIP)) gleamReward = 300;
        if (quest.equals(Quests.THE_GOBLINS_HUSTLE)) gleamReward = 20;
        if (quest.equals(Quests.JERNIKS_LEDGER)) gleamReward = 500;
        if (quest.equals(Quests.CRUSHING_THE_NESTS)) gleamReward = 30;
        if (quest.equals(Quests.THE_VEILED_ECHO)) gleamReward = 500;
        if (quest.equals(Quests.UNWANTED_GUESTS)) gleamReward = 100;
        if (quest.equals(Quests.THE_LAKE_RUN)) gleamReward = 20;
        if (quest.equals(Quests.THE_HIDDEN_VAULT)) gleamReward = 50;
        if (quest.equals(Quests.BIG_CHUP_HUNTER)) gleamReward = 20;
        if (quest.equals(Quests.KING_OF_CHUPS)) gleamReward = 200;
        if (quest.equals(Quests.FIRST_TALENT)) gleamReward = 20;
        if (quest.equals(Quests.REACTION_TIME)) gleamReward = 20;
        if (quest.equals(Quests.A_FISHER)) gleamReward = 20;
        if (quest.equals(Quests.A_MINER)) gleamReward = 20;
        if (quest.equals(Quests.MANY_SUPPLIES)) gleamReward = 20;
        if (quest.equals(Quests.AREOS_GUIDANCE)) gleamReward = 20;
        if (quest.equals(Quests.BRING_DOOM_TO_UMBRAL)) gleamReward = 20;
        if (quest.equals(Quests.GIVE_REST_TO_CRAWLERS)) gleamReward = 20;
        if (quest.equals(Quests.NESTBREAKER)) gleamReward = 20;
        if (quest.equals(Quests.FRACTURE_TOUCHER)) gleamReward = 20;
        if (quest.equals(Quests.BE_LIGHTWORK)) gleamReward = 20;
        if (quest.equals(Quests.COOL_FOOTDANCER)) gleamReward = 40;
        if (quest.equals(Quests.FAST_TORNADO_KICK)) gleamReward = 60;
        if (quest.equals(Quests.GREAT_THUNDERFEET)) gleamReward = 80;
        if (quest.equals(Quests.THE_IMMOVABLE_LEGS)) gleamReward = 100;
        if (quest.equals(Quests.AFTER_PRACTICE)) gleamReward = 20;
        if (quest.equals(Quests.ANGLERFISH)) gleamReward = 20;
        if (quest.equals(Quests.BRINES)) gleamReward = 20;
        if (quest.equals(Quests.GLOOMFINS)) gleamReward = 20;
        if (quest.equals(Quests.OLD_MANS_WAY)) gleamReward = 20;
        if (quest.equals(Quests.KISS_THE_FROG)) gleamReward = 20;
        if (quest.equals(Quests.FISHING_LICENSE)) gleamReward = 20;

        return gleamReward;
    }

    public static int getXPReward(Quests quest){
        int xpReward = 0;

        if (quest.equals(Quests.CHUP_HUNTER)) xpReward = 300;
        if (quest.equals(Quests.DEFEAT_ROTMAW)) xpReward = 300;
        if (quest.equals(Quests.ELIMINATE_THE_CREATURE)) xpReward = 300;
        if (quest.equals(Quests.THE_LOST_CARAVAN)) xpReward = 300;
        if (quest.equals(Quests.LAZY_FISHER)) xpReward = 300;
        if (quest.equals(Quests.ITS_GETTING_HOT_IN_HERE)) xpReward = 300;
        if (quest.equals(Quests.COOLING_CORE)) xpReward = 300;
        if (quest.equals(Quests.HEAT_CORE)) xpReward = 300;
        if (quest.equals(Quests.SCRAP_FOR_PIP)) xpReward = 300;
        if (quest.equals(Quests.THE_GOBLINS_HUSTLE)) xpReward = 300;
        if (quest.equals(Quests.JERNIKS_LEDGER)) xpReward = 300;
        if (quest.equals(Quests.CRUSHING_THE_NESTS)) xpReward = 300;
        if (quest.equals(Quests.THE_VEILED_ECHO)) xpReward = 300;
        if (quest.equals(Quests.UNWANTED_GUESTS)) xpReward = 300;
        if (quest.equals(Quests.THE_LAKE_RUN)) xpReward = 300;
        if (quest.equals(Quests.THE_HIDDEN_VAULT)) xpReward = 300;
        if (quest.equals(Quests.BIG_CHUP_HUNTER)) xpReward = 300;
        if (quest.equals(Quests.KING_OF_CHUPS)) xpReward = 300;
        if (quest.equals(Quests.A_FISHER)) xpReward = 300;
        if (quest.equals(Quests.A_MINER)) xpReward = 300;
        if (quest.equals(Quests.REACTION_TIME)) xpReward = 300;
        if (quest.equals(Quests.MANY_SUPPLIES)) xpReward = 300;
        if (quest.equals(Quests.FIRST_TALENT)) xpReward = 300;
        if (quest.equals(Quests.AREOS_GUIDANCE)) xpReward = 300;
        if (quest.equals(Quests.GIVE_REST_TO_CRAWLERS)) xpReward = 300;
        if (quest.equals(Quests.BRING_DOOM_TO_UMBRAL)) xpReward = 300;
        if (quest.equals(Quests.NESTBREAKER)) xpReward = 300;
        if (quest.equals(Quests.FRACTURE_TOUCHER)) xpReward = 300;
        if (quest.equals(Quests.BE_LIGHTWORK)) xpReward = 300;
        if (quest.equals(Quests.COOL_FOOTDANCER)) xpReward = 300;
        if (quest.equals(Quests.FAST_TORNADO_KICK)) xpReward = 600;
        if (quest.equals(Quests.GREAT_THUNDERFEET)) xpReward = 1000;
        if (quest.equals(Quests.THE_IMMOVABLE_LEGS)) xpReward = 1000;
        if (quest.equals(Quests.AFTER_PRACTICE)) xpReward = 300;
        if (quest.equals(Quests.ANGLERFISH)) xpReward = 300;
        if (quest.equals(Quests.BRINES)) xpReward = 300;
        if (quest.equals(Quests.GLOOMFINS)) xpReward = 300;
        if (quest.equals(Quests.KISS_THE_FROG)) xpReward = 300;
        if (quest.equals(Quests.OLD_MANS_WAY)) xpReward = 300;
        if (quest.equals(Quests.FISHING_LICENSE)) xpReward = 300;

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
