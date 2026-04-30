package net.kingproductions.splitbornAPI.RewardContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.Main.SplitbornAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;

public class LEVEL_REWARD_DATA {

    public static List<String> getRewards_And_Logic(Player player, int newLevel, boolean EXECUTE_REWARDING_LOGIC){
        Map<Item_ID, Integer> physicalRewards = new HashMap<>();
        int defaultGleamReward = 30;

        List<String> list = new ArrayList<>();
        list.add("§7Rewards:");
        list.add(SplitbornAPI.getHelper().getListingSymbol() + "§7Gleams: §6+" + defaultGleamReward + SplitbornAPI.getHelper().getGleamSymbol());

        if (!physicalRewards.isEmpty()){
            for (Item_ID itemId : physicalRewards.keySet()){
                final int amount = physicalRewards.get(itemId);
                list.add(SplitbornAPI.getHelper().getListingSymbol() + "§b" + amount + "x " + SplitbornAPI.getItem(itemId).getItemMeta().getDisplayName());

                Bukkit.getScheduler().runTaskLater(plugin, () ->{
                    player.sendMessage("§6§lDELIVERY BOX! §8→ §b" + amount + "x " + SplitbornAPI.getItem(itemId).getItemMeta().getDisplayName());
                }, 10);
            }
        }

        return list;
    }

}
