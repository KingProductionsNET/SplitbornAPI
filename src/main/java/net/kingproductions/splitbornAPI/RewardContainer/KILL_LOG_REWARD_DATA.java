package net.kingproductions.splitbornAPI.RewardContainer;


import net.kingproductions.splitbornAPI.Main.SplitbornAPI;
import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;

import java.util.ArrayList;
import java.util.List;

public class KILL_LOG_REWARD_DATA {

    public static int getGleamReward(Mob_ID mobId, int Kill_Log_Level){
        return 0;
    }

    public static int getXPReward(Mob_ID mobId, int Kill_Log_Level){


        return  0;
    }

    public static List<String> Rewards(Mob_ID mobId, int Kill_Log_Level){
        List<String> rewardList = new ArrayList<>();
        rewardList.add("");
        rewardList.add("§7Rewards:");
        rewardList.add(SplitbornAPI.getHelper().getListingSymbol() + "§c+" + -1 + SplitbornAPI.getHelper().getHeartSymbol());
        rewardList.add(SplitbornAPI.getHelper().getListingSymbol() + "§b+" + -1 + "XP");
        rewardList.add(SplitbornAPI.getHelper().getListingSymbol() + "§7Gleams: §6" + -1 + SplitbornAPI.getHelper().getGleamSymbol());

        if (mobId.equals(Mob_ID.CHUP)){
            if (Kill_Log_Level == 5){
                rewardList.add("5");
            }
        }

        return rewardList;
    }
}
