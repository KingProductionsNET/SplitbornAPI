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

        if (npcId.equals(NPC_ID.BONSAI)) gleamReward = 10;
        if (npcId.equals(NPC_ID.GRUG)) gleamReward = 10;
        if (npcId.equals(NPC_ID.WELPH)) gleamReward = 10;
        if (npcId.equals(NPC_ID.ANDREW)) gleamReward = 10;
        if (npcId.equals(NPC_ID.AREO)) gleamReward = 10;
        if (npcId.equals(NPC_ID.STEPHEN)) gleamReward = 10;
        if (npcId.equals(NPC_ID.QUARTERMASTER_BRANNOCK)) gleamReward = 10;
        if (npcId.equals(NPC_ID.CYSTEIN)) gleamReward = 25;
        if (npcId.equals(NPC_ID.LADY_CHRONA)) gleamReward = 10;
        if (npcId.equals(NPC_ID.KAY_TINFOIL)) gleamReward = 10;
        if (npcId.equals(NPC_ID.CALI_THE_GREAT)) gleamReward = 10;
        if (npcId.equals(NPC_ID.VIORICT)) gleamReward = 25;
        if (npcId.equals(NPC_ID.DEBY)) gleamReward = 10;
        if (npcId.equals(NPC_ID.MISTER_CHRONA)) gleamReward = 100;
        if (npcId.equals(NPC_ID.JERNIK)) gleamReward = 10;
        if (npcId.equals(NPC_ID.AUCTION_MASTER)) gleamReward = 10;
        if (npcId.equals(NPC_ID.SCRAPPER_FENN)) gleamReward = 10;
        if (npcId.equals(NPC_ID.BROMM)) gleamReward = 25;
        if (npcId.equals(NPC_ID.FOREMAN_KAELOR)) gleamReward = 10;
        if (npcId.equals(NPC_ID.PIP_CINDERWICK)) gleamReward = 10;
        if (npcId.equals(NPC_ID.MASTER_BO_KAN)) gleamReward = 10;
        if (npcId.equals(NPC_ID.ARCHIVIST_VEYRAN)) gleamReward = 10;
        if (npcId.equals(NPC_ID.VEYR)) gleamReward = 10;
        if (npcId.equals(NPC_ID.VAELITH)) gleamReward = 10;
        if (npcId.equals(NPC_ID.ELIAS)) gleamReward = 100;
        if (npcId.equals(NPC_ID.SNURK)) gleamReward = 10;
        if (npcId.equals(NPC_ID.ORVAYN)) gleamReward = 10;
        if (npcId.equals(NPC_ID.THE_DROWNED_SCHOLAR)) gleamReward = 10;
        if (npcId.equals(NPC_ID.OLD_MARROW)) gleamReward = 10;
        if (npcId.equals(NPC_ID.MARA_TIDEWELL)) gleamReward = 10;
        if (npcId.equals(NPC_ID.CAPTAIN_VAEL)) gleamReward = 10;
        if (npcId.equals(NPC_ID.BOUNCER)) gleamReward = 10;
        if (npcId.equals(NPC_ID.WICK)) gleamReward = 100;
        if (npcId.equals(NPC_ID.TOBIN)) gleamReward = 10;
        if (npcId.equals(NPC_ID.MERRICK)) gleamReward = 10;
        if (npcId.equals(NPC_ID.LINATO)) gleamReward = 10;
        if (npcId.equals(NPC_ID.LINATA)) gleamReward = 10;
        if (npcId.equals(NPC_ID.RIME)) gleamReward = 10;
        if (npcId.equals(NPC_ID.GRIX)) gleamReward = 10;
        if (npcId.equals(NPC_ID.CAFUNE)) gleamReward = 10;
        if (npcId.equals(NPC_ID.TIDECALLER)) gleamReward = 10;
        if (npcId.equals(NPC_ID.SORBIT)) gleamReward = 10;
        if (npcId.equals(NPC_ID.ENCELL)) gleamReward = 10;
        if (npcId.equals(NPC_ID.SUGRA)) gleamReward = 10;
        if (npcId.equals(NPC_ID.OREAL)) gleamReward = 30;
        if (npcId.equals(NPC_ID.DELVEMASTER_ORIN)) gleamReward = 10;
        if (npcId.equals(NPC_ID.MUCKLE)) gleamReward = 10;
        if (npcId.equals(NPC_ID.HUNTER_TERZO)) gleamReward = 10;
        if (npcId.equals(NPC_ID.THE_EXCAVATOR)) gleamReward = 300;
        if (npcId.equals(NPC_ID.MAROSO)) gleamReward = 10;
        if (npcId.equals(NPC_ID.RAVYNE)) gleamReward = 10;
        if (npcId.equals(NPC_ID.THE_REALMKEEPER)) gleamReward = 10;

        return gleamReward;
    }

    public static int getXPReward(NPC_ID npcId){
        int xpReward = 0;

        if (npcId.equals(NPC_ID.BONSAI)) xpReward = 100;
        if (npcId.equals(NPC_ID.GRUG)) xpReward = 100;
        if (npcId.equals(NPC_ID.WELPH)) xpReward = 100;
        if (npcId.equals(NPC_ID.ANDREW)) xpReward = 100;
        if (npcId.equals(NPC_ID.AREO)) xpReward = 100;
        if (npcId.equals(NPC_ID.STEPHEN)) xpReward = 100;
        if (npcId.equals(NPC_ID.QUARTERMASTER_BRANNOCK)) xpReward = 100;
        if (npcId.equals(NPC_ID.ARCHIVIST_VEYRAN)) xpReward = 100;
        if (npcId.equals(NPC_ID.CYSTEIN)) xpReward = 100;
        if (npcId.equals(NPC_ID.LADY_CHRONA)) xpReward = 100;
        if (npcId.equals(NPC_ID.KAY_TINFOIL)) xpReward = 100;
        if (npcId.equals(NPC_ID.CALI_THE_GREAT)) xpReward = 100;
        if (npcId.equals(NPC_ID.VIORICT)) xpReward = 100;
        if (npcId.equals(NPC_ID.DEBY)) xpReward = 100;
        if (npcId.equals(NPC_ID.MISTER_CHRONA)) xpReward = 100;
        if (npcId.equals(NPC_ID.JERNIK)) xpReward = 50;
        if (npcId.equals(NPC_ID.AUCTION_MASTER)) xpReward = 100;
        if (npcId.equals(NPC_ID.SCRAPPER_FENN)) xpReward = 100;
        if (npcId.equals(NPC_ID.BROMM)) xpReward = 100;
        if (npcId.equals(NPC_ID.FOREMAN_KAELOR)) xpReward = 100;
        if (npcId.equals(NPC_ID.PIP_CINDERWICK)) xpReward = 100;
        if (npcId.equals(NPC_ID.MASTER_BO_KAN)) xpReward = 100;
        if (npcId.equals(NPC_ID.VEYR)) xpReward = 100;
        if (npcId.equals(NPC_ID.VAELITH)) xpReward = 100;
        if (npcId.equals(NPC_ID.ELIAS)) xpReward = 100;
        if (npcId.equals(NPC_ID.SNURK)) xpReward = 100;
        if (npcId.equals(NPC_ID.ORVAYN)) xpReward = 100;
        if (npcId.equals(NPC_ID.THE_DROWNED_SCHOLAR)) xpReward = 100;
        if (npcId.equals(NPC_ID.OLD_MARROW)) xpReward = 100;
        if (npcId.equals(NPC_ID.MARA_TIDEWELL)) xpReward = 100;
        if (npcId.equals(NPC_ID.CAPTAIN_VAEL)) xpReward = 100;
        if (npcId.equals(NPC_ID.BOUNCER)) xpReward = 100;
        if (npcId.equals(NPC_ID.WICK)) xpReward = 100;
        if (npcId.equals(NPC_ID.TOBIN)) xpReward = 100;
        if (npcId.equals(NPC_ID.MERRICK)) xpReward = 100;
        if (npcId.equals(NPC_ID.LINATO)) xpReward = 100;
        if (npcId.equals(NPC_ID.LINATA)) xpReward = 100;
        if (npcId.equals(NPC_ID.RIME)) xpReward = 100;
        if (npcId.equals(NPC_ID.GRIX)) xpReward = 100;
        if (npcId.equals(NPC_ID.CAFUNE)) xpReward = 100;
        if (npcId.equals(NPC_ID.TIDECALLER)) xpReward = 100;
        if (npcId.equals(NPC_ID.SORBIT)) xpReward = 100;
        if (npcId.equals(NPC_ID.ENCELL)) xpReward = 100;
        if (npcId.equals(NPC_ID.SUGRA)) xpReward = 100;
        if (npcId.equals(NPC_ID.OREAL)) xpReward = 100;
        if (npcId.equals(NPC_ID.DELVEMASTER_ORIN)) xpReward = 100;
        if (npcId.equals(NPC_ID.MUCKLE)) xpReward = 100;
        if (npcId.equals(NPC_ID.HUNTER_TERZO)) xpReward = 100;
        if (npcId.equals(NPC_ID.THE_EXCAVATOR)) xpReward = 100;
        if (npcId.equals(NPC_ID.MAROSO)) xpReward = 100;
        if (npcId.equals(NPC_ID.RAVYNE)) xpReward = 100;
        if (npcId.equals(NPC_ID.THE_REALMKEEPER)) xpReward = 100;


        return xpReward;
    }

    public static Map<Essence_ID, Integer> getEssenceRewards(NPC_ID npcId){
        Map<Essence_ID, Integer> map = new HashMap<>();
        return map;
    }

    public static Map<Item_ID, Integer> getExtraRewards(NPC_ID npcId){
        Map<Item_ID, Integer> map = new HashMap<>();
        return map;
    }

    public static Map<Stat, Integer> getStatReward(NPC_ID npcId){
        Map<Stat, Integer> map = new HashMap<>();
        return map;
    }

}
