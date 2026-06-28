package net.kingproductions.splitbornAPI.RewardContainer;

import net.kingproductions.splitbornAPI.CuriosityContainer.Curiosities;
import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;

import java.util.HashMap;
import java.util.Map;

public class NPC_REWARD_DATA {

    public static int getGleamReward(NPC_ID npcId){
        int gleamReward = 0;

        if (npcId.equals(NPC_ID.BONSAI)) gleamReward = 1000;
        if (npcId.equals(NPC_ID.ANDREW)) gleamReward = 2000;
        if (npcId.equals(NPC_ID.AREO)) gleamReward = 600;
        if (npcId.equals(NPC_ID.STEPHEN)) gleamReward = 1500;


        return gleamReward;
    }

    public static int getXPReward(NPC_ID npcId){
        int xpReward = 0;

        if (npcId.equals(NPC_ID.BONSAI)) xpReward = 200;
        if (npcId.equals(NPC_ID.ANDREW)) xpReward = 300;
        if (npcId.equals(NPC_ID.AREO)) xpReward = 100;
        if (npcId.equals(NPC_ID.STEPHEN)) xpReward = 200;


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

}
