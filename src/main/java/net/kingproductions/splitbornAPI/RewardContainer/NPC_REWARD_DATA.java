package net.kingproductions.splitbornAPI.RewardContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;

import java.util.HashMap;
import java.util.Map;

public class NPC_REWARD_DATA {

    public static int getGleamReward(NPC_ID npcId){
        int gleamReward = 0;

        if (npcId.equals(NPC_ID.BONSAI)) gleamReward = 1000;


        return gleamReward;
    }

    public static int getXPReward(NPC_ID npcId){
        int xpReward = 0;

        if (npcId.equals(NPC_ID.BONSAI)) xpReward = 200;


        return xpReward;
    }

    public static Map<Item_ID, Integer> getExtraRewards(NPC_ID npcId){
        Map<Item_ID, Integer> map = new HashMap<>();

        if (npcId.equals(NPC_ID.BONSAI)){

        }

        return map;
    }

}
