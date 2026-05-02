package net.kingproductions.splitbornAPI.CategoryRewardBuilderContainer;

import net.kingproductions.splitbornAPI.AchievementContainer.ACHIEVEMENT_ID;
import net.kingproductions.splitbornAPI.CuriosityContainer.Curiosities;
import net.kingproductions.splitbornAPI.DatabankContainer.DATABANK_PATHS;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.Main.SplitbornAPI;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.NoteBlockAPIContainer.NBS_FILE_NAMES;
import net.kingproductions.splitbornAPI.NoteBlockAPIContainer.NoteBlockAPI;
import net.kingproductions.splitbornAPI.ProfileContainer.Profile;
import net.kingproductions.splitbornAPI.QuestContainer.Quests;
import net.kingproductions.splitbornAPI.RewardReasonContainer.REWARD_REASON;
import net.kingproductions.splitbornAPI.VoidGateContainer.VOID_GATE_ID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;


public class CategoryRewardBuilder {

    private REWARD_REASON rewardReason;

    private int XPReward = 0;
    private int GleamReward = 0;

    private List<String> BenefitList;
    private Map<Item_ID, Integer> ExtraRewards;
    private String InfoText;

    private Quests quest;
    private Locations location;
    private NPC_ID npcId;
    private ACHIEVEMENT_ID achievementId;
    private VOID_GATE_ID voidGateId;
    private Curiosities curiosities;

    public void setBenefits(List<String> list){
        BenefitList = list;
    }
    public void setExtraReward(Map<Item_ID, Integer> list){
        ExtraRewards = list;
    }

    public void setQuest(Quests t){
        quest = t;
    }
    public void setLocation(Locations l){
        location = l;
    }
    public void setNPC(NPC_ID n){
        npcId = n;
    }
    public void setAchievement(ACHIEVEMENT_ID a){
        achievementId = a;
    }
    public void setVoidGateID(VOID_GATE_ID v){
        voidGateId = v;
    }
    public void setCuriosity(Curiosities c){
        curiosities = c;
    }

    public void setGleamReward(int Amount){
        GleamReward = Amount;
    }
    public void setXPReward(int Amount){
        XPReward = Amount;
    }

    public void applyOnTarget(Player player, REWARD_REASON reason){
        Profile profileData = SplitbornAPI.getProfile(player.getUniqueId());

        rewardReason = reason;

        String chatReason = "§cUnknown";
        String DatabankPath = null;
        String inputAssistForDatabank = null;

        List<String> rewardReasonText = new ArrayList<>();
        if (rewardReason != null){
            if (rewardReason.equals(REWARD_REASON.QUEST)){
                InfoText = quest.toString();
                chatReason = "§a§lCOMPLETED TASK! §7(§6§l" + SplitbornAPI.getHelper().formatEnumName(InfoText) + "§7)";

                rewardReasonText.add("You have completed a task");
                rewardReasonText.add("and were rewarded for it!");
            }
            if (rewardReason.equals(REWARD_REASON.AREA)){
                InfoText = location.toString();
                chatReason = "§e§lDISCOVERED AREA! §7(§6§l" + SplitbornAPI.getHelper().formatEnumName(InfoText) + "§7)";

                rewardReasonText.add("You have discovered an area");
                rewardReasonText.add("and were rewarded for it!");

            }
            if (rewardReason.equals(REWARD_REASON.NPC)){
                InfoText = npcId.toString();
                chatReason = "§b§lALLY MET! §7(§6§l" + SplitbornAPI.getHelper().formatEnumName(InfoText) + "§7)";

                rewardReasonText.add("You have met an ally");
                rewardReasonText.add("and were rewarded for it!");
            }
            if (rewardReason.equals(REWARD_REASON.ACHIEVEMENT)){
                InfoText = achievementId.toString();
                chatReason = "§d§lACHIEVEMENT! §7(§6§l" + SplitbornAPI.getHelper().formatEnumName(InfoText) + "§7)";

                rewardReasonText.add("You have unlocked an achievement");
                rewardReasonText.add("and were rewarded for it!");
            }
            if (rewardReason.equals(REWARD_REASON.SEALED_VOID_GATE)){
                InfoText = voidGateId.toString();
                chatReason = "§5§lSEALED VOID GATE! §7(§6§l" + SplitbornAPI.getHelper().formatEnumName(InfoText) + "§7)";

                rewardReasonText.add("You have sealed a void gate");
                rewardReasonText.add("and were rewarded for it!");
            }
            if (rewardReason.equals(REWARD_REASON.CURIOSITY)){
                InfoText = curiosities.toString();
                chatReason = "§6§lCURIOSITY FOUND! §7(§6§l" + SplitbornAPI.getHelper().formatEnumName(InfoText) + "§7)";

                rewardReasonText.add("You found a curiosity");
                rewardReasonText.add("and were rewarded for it!");
            }
        }

        List<String> extraRewardsAsString = new ArrayList<>();

        if (ExtraRewards != null && !ExtraRewards.isEmpty()){
            for (Item_ID itemId : ExtraRewards.keySet()){
                ItemStack preItem = SplitbornAPI.getItem(itemId);
                int amount = ExtraRewards.get(itemId);

                extraRewardsAsString.add(preItem.getItemMeta().getDisplayName() + " §7(" + amount + "x)");
                profileData.addUnclaimedItem(itemId, amount);

                Bukkit.getScheduler().runTaskLater(plugin, () ->{
                    player.sendMessage("§6§lDELIVERY BOX! §8→ §b" + amount + "x " + SplitbornAPI.getItem(itemId).getItemMeta().getDisplayName());
                }, 30);
            }
        }

        player.sendMessage("§8§m⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍");
        player.sendMessage("§8➤ " + chatReason);
        for (String rewardMessage : rewardReasonText) player.sendMessage("§7" + rewardMessage);
        player.sendMessage("");
        if (BenefitList != null && !BenefitList.isEmpty()){
            player.sendMessage("§8➤ §a§lBENEFITS:");
            for (String Benefit : BenefitList) player.sendMessage(SplitbornAPI.getHelper().getListingSymbol() + Benefit);
            player.sendMessage("");
        }
        player.sendMessage("§7Rewards:");
        for (String rewardsAsString : extraRewardsAsString) player.sendMessage(SplitbornAPI.getHelper().getListingSymbol() + rewardsAsString);
        player.sendMessage(SplitbornAPI.getHelper().getListingSymbol() + "§7Gleams: §6+" + GleamReward + SplitbornAPI.getHelper().getGleamSymbol());
        if (XPReward != 0) player.sendMessage(SplitbornAPI.getHelper().getListingSymbol() + "§7Splitborn XP §b+" + XPReward);
        player.sendMessage("§8§m⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍");

        if (reason.equals(REWARD_REASON.CURIOSITY)){
            NoteBlockAPI.Play(player, NBS_FILE_NAMES.CURIOSITY_FOUND.toString(), false);
            DatabankPath = DATABANK_PATHS.CURIOSITIES_COMPLETED_PATH_.toString();
            inputAssistForDatabank = curiosities.toString();
        }
        if (reason.equals(REWARD_REASON.NPC)){
            NoteBlockAPI.Play(player, NBS_FILE_NAMES.ALLY_MET.toString(), false);
            DatabankPath = DATABANK_PATHS.ALLY_MET_PATH_.toString();
            inputAssistForDatabank = npcId.toString();
        }
        if (reason.equals(REWARD_REASON.QUEST)){
            NoteBlockAPI.Play(player, NBS_FILE_NAMES.QUEST_COMPLETE.toString(), false);
            DatabankPath = DATABANK_PATHS.COMPLETED_QUEST_PATH_.toString();
            inputAssistForDatabank = quest.toString();
        }
        if (reason.equals(REWARD_REASON.AREA)){
            DatabankPath = DATABANK_PATHS.AREA_DISCOVERED_PATH_.toString();
            inputAssistForDatabank = location.toString();
        }
        if (reason.equals(REWARD_REASON.ACHIEVEMENT)){
            DatabankPath = DATABANK_PATHS.ACHIEVEMENT_UNLOCKED_PATH_.toString();
            inputAssistForDatabank = achievementId.toString();
        }
        if (reason.equals(REWARD_REASON.SEALED_VOID_GATE)){
            DatabankPath = DATABANK_PATHS.SEALED_VOID_GATE_PATH_.toString();
            inputAssistForDatabank = voidGateId.toString();
        }

        int PlayersXPAmount = profileData.getXP();
        if (SplitbornAPI.getHelper().eligibleForUpgrade(PlayersXPAmount, XPReward)){
            SplitbornAPI.getHelper().upgradePlayersLevel(player, XPReward);
        } else {
            profileData.setXP(PlayersXPAmount + XPReward);
        }
        profileData.setGleams(profileData.getGleams() + GleamReward);

        profileData.setBoolean(DatabankPath + inputAssistForDatabank, true);
        SplitbornAPI.getHelper().updatePlayersScoreboard(player);
    }
}
