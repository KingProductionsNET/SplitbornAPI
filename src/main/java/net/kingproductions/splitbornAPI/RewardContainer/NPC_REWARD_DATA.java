package net.kingproductions.splitbornAPI.RewardContainer;

import net.kingproductions.splitbornAPI.CuriosityContainer.Curiosities;
import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.StatContainer.Stat;

import java.util.HashMap;
import java.util.Map;

public class NPC_REWARD_DATA {

    public static int getGleamReward(NPC_ID npcId){
        int gleamReward = 0;

        if (npcId.equals(NPC_ID.BONSAI)) gleamReward = 1000;
        if (npcId.equals(NPC_ID.GRUG)) gleamReward = 500;
        if (npcId.equals(NPC_ID.WELPH)) gleamReward = 500;
        if (npcId.equals(NPC_ID.ANDREW)) gleamReward = 2000;
        if (npcId.equals(NPC_ID.AREO)) gleamReward = 600;
        if (npcId.equals(NPC_ID.STEPHEN)) gleamReward = 1500;
        if (npcId.equals(NPC_ID.QUARTERMASTER_BRANNOCK)) gleamReward = 1500;
        if (npcId.equals(NPC_ID.CYSTEIN)) gleamReward = 2000;
        if (npcId.equals(NPC_ID.LADY_CHRONA)) gleamReward = 1337;
        if (npcId.equals(NPC_ID.KAY_TINFOIL)) gleamReward = 2500;
        if (npcId.equals(NPC_ID.CALI_THE_GREAT)) gleamReward = 500;
        if (npcId.equals(NPC_ID.VIORICT)) gleamReward = 1000;
        if (npcId.equals(NPC_ID.DEBY)) gleamReward = 1000;
        if (npcId.equals(NPC_ID.MISTER_CHRONA)) gleamReward = 500;
        if (npcId.equals(NPC_ID.JERNIK)) gleamReward = 300;
        if (npcId.equals(NPC_ID.AUCTION_MASTER)) gleamReward = 300;
        if (npcId.equals(NPC_ID.SCRAPPER_FENN)) gleamReward = 300;
        if (npcId.equals(NPC_ID.BROMM)) gleamReward = 300;
        if (npcId.equals(NPC_ID.FOREMAN_KAELOR)) gleamReward = 300;
        if (npcId.equals(NPC_ID.PIP_CINDERWICK)) gleamReward = 300;
        if (npcId.equals(NPC_ID.MASTER_BO_KAN)) gleamReward = 500;

        return gleamReward;
    }

    public static int getXPReward(NPC_ID npcId){
        int xpReward = 0;

        if (npcId.equals(NPC_ID.BONSAI)) xpReward = 200;
        if (npcId.equals(NPC_ID.GRUG)) xpReward = 250;
        if (npcId.equals(NPC_ID.WELPH)) xpReward = 250;
        if (npcId.equals(NPC_ID.ANDREW)) xpReward = 300;
        if (npcId.equals(NPC_ID.AREO)) xpReward = 100;
        if (npcId.equals(NPC_ID.STEPHEN)) xpReward = 200;
        if (npcId.equals(NPC_ID.QUARTERMASTER_BRANNOCK)) xpReward = 300;
        if (npcId.equals(NPC_ID.CYSTEIN)) xpReward = 400;
        if (npcId.equals(NPC_ID.LADY_CHRONA)) xpReward = 300;
        if (npcId.equals(NPC_ID.KAY_TINFOIL)) xpReward = 300;
        if (npcId.equals(NPC_ID.CALI_THE_GREAT)) xpReward = 150;
        if (npcId.equals(NPC_ID.VIORICT)) xpReward = 300;
        if (npcId.equals(NPC_ID.DEBY)) xpReward = 300;
        if (npcId.equals(NPC_ID.MISTER_CHRONA)) xpReward = 300;
        if (npcId.equals(NPC_ID.JERNIK)) xpReward = 300;
        if (npcId.equals(NPC_ID.AUCTION_MASTER)) xpReward = 300;
        if (npcId.equals(NPC_ID.SCRAPPER_FENN)) xpReward = 300;
        if (npcId.equals(NPC_ID.BROMM)) xpReward = 300;
        if (npcId.equals(NPC_ID.FOREMAN_KAELOR)) xpReward = 300;
        if (npcId.equals(NPC_ID.PIP_CINDERWICK)) xpReward = 300;
        if (npcId.equals(NPC_ID.MASTER_BO_KAN)) xpReward = 300;


        return xpReward;
    }

    public static Map<Essence_ID, Integer> getEssenceRewards(NPC_ID npcId){
        Map<Essence_ID, Integer> map = new HashMap<>();

        if (npcId.equals(NPC_ID.BONSAI)){
            map.put(Essence_ID.SEED, 10);
        }

        return map;
    }

    public static Map<Item_ID, Integer> getExtraRewards(NPC_ID npcId){
        Map<Item_ID, Integer> map = new HashMap<>();

        if (npcId.equals(NPC_ID.AREO)){
            map.put(Item_ID.ZENTIS_U7, 1);
        }

        return map;
    }

    public static Map<Stat, Integer> getStatReward(NPC_ID npcId){
        Map<Stat, Integer> map = new HashMap<>();

        if (npcId.equals(NPC_ID.BONSAI)) map.put(Stat.HEALTH, 5);

        return map;
    }

}
