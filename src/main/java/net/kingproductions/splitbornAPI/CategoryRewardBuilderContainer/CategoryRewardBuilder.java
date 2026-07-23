package net.kingproductions.splitbornAPI.CategoryRewardBuilderContainer;

import net.kingproductions.splitbornAPI.AchievementContainer.ACHIEVEMENT_ID;
import net.kingproductions.splitbornAPI.CuriosityContainer.Curiosities;
import net.kingproductions.splitbornAPI.DatabankContainer.DATABANK_PATHS;
import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.Main.SplitbornAPI;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.NoteBlockAPIContainer.NBS_FILE_NAMES;
import net.kingproductions.splitbornAPI.NoteBlockAPIContainer.NoteBlockAPI;
import net.kingproductions.splitbornAPI.ProfileContainer.Profile;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import net.kingproductions.splitbornAPI.RewardContainer.*;
import net.kingproductions.splitbornAPI.RewardReasonContainer.REWARD_REASON;
import net.kingproductions.splitbornAPI.StatContainer.Stat;
import net.kingproductions.splitbornAPI.VoidGateContainer.VOID_GATE_ID;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CategoryRewardBuilder {

    private REWARD_REASON rewardReason;

    private int XPReward = 0;
    private int GleamReward = 0;
    private Map<Item_ID, Integer> ExtraRewards;
    private Map<Essence_ID, Integer> EssenceRewards;
    private Map<Stat, Integer> StatRewards;

    private List<String> BenefitList;
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

                GleamReward = QUEST_REWARDS_DATA.getGleamReward(quest);
                XPReward = QUEST_REWARDS_DATA.getXPReward(quest);
                EssenceRewards = QUEST_REWARDS_DATA.getEssenceRewards(quest);
                ExtraRewards = QUEST_REWARDS_DATA.getExtraRewards(quest);
                StatRewards = QUEST_REWARDS_DATA.getStatReward(quest);
            }
            if (rewardReason.equals(REWARD_REASON.AREA)){
                InfoText = location.toString();
                chatReason = "§e§lDISCOVERED AREA! §7(§6§l" + SplitbornAPI.getHelper().formatEnumName(InfoText) + "§7)";

                rewardReasonText.add("You have discovered an area");
                rewardReasonText.add("and were rewarded for it!");

                GleamReward = LOCATION_REWARD_DATA.getGleamReward(location);
                XPReward = LOCATION_REWARD_DATA.getXPReward(location);
                EssenceRewards = LOCATION_REWARD_DATA.getEssenceRewards(location);
                ExtraRewards = LOCATION_REWARD_DATA.getExtraRewards(location);
            }
            if (rewardReason.equals(REWARD_REASON.NPC)){
                InfoText = npcId.toString();
                chatReason = "§b§lALLY MET! §7(§6§l" + SplitbornAPI.getHelper().formatEnumName(InfoText) + "§7)";

                rewardReasonText.add("You have met an ally");
                rewardReasonText.add("and were rewarded for it!");

                GleamReward = NPC_REWARD_DATA.getGleamReward(npcId);
                XPReward = NPC_REWARD_DATA.getXPReward(npcId);
                EssenceRewards = NPC_REWARD_DATA.getEssenceRewards(npcId);
                ExtraRewards = NPC_REWARD_DATA.getExtraRewards(npcId);
                StatRewards = NPC_REWARD_DATA.getStatReward(npcId);
            }
            if (rewardReason.equals(REWARD_REASON.ACHIEVEMENT)){
                InfoText = achievementId.toString();
                chatReason = "§d§lACHIEVEMENT! §7(§6§l" + SplitbornAPI.getHelper().formatEnumName(InfoText) + "§7)";

                rewardReasonText.add("You have unlocked an achievement");
                rewardReasonText.add("and were rewarded for it!");

                GleamReward = ACHIEVEMENT_REWARD_DATA.getGleamReward(achievementId);
                XPReward = ACHIEVEMENT_REWARD_DATA.getXPReward(achievementId);
                EssenceRewards = ACHIEVEMENT_REWARD_DATA.getEssenceRewards(achievementId);
                ExtraRewards = ACHIEVEMENT_REWARD_DATA.getExtraRewards(achievementId);
                StatRewards = ACHIEVEMENT_REWARD_DATA.getStatReward(achievementId);
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

                GleamReward = CURIOSITIES_REWARD_DATA.getGleamReward(curiosities);
                XPReward = CURIOSITIES_REWARD_DATA.getXPReward(curiosities);
                EssenceRewards = CURIOSITIES_REWARD_DATA.getEssenceRewards(curiosities);
                ExtraRewards = CURIOSITIES_REWARD_DATA.getExtraRewards(curiosities);
                StatRewards = CURIOSITIES_REWARD_DATA.getStatReward(curiosities);
            }
        }

        List<String> extraRewardsAsString = new ArrayList<>();

        if (ExtraRewards != null && !ExtraRewards.isEmpty()){
            for (Item_ID itemId : ExtraRewards.keySet()){

                ItemStack preItem = SplitbornAPI.getItem(itemId);
                int amount = ExtraRewards.get(itemId);

                extraRewardsAsString.add("§a+" + amount + " " + preItem.getItemMeta().getDisplayName());
                profileData.addUnclaimedItem(itemId, amount);
            }
        }
        if (EssenceRewards != null && !EssenceRewards.isEmpty()){
            for (Essence_ID essenceId : EssenceRewards.keySet()){
                int Amount = EssenceRewards.get(essenceId);

                profileData.addEssence(essenceId, Amount);
                extraRewardsAsString.add("§e" + SplitbornAPI.getHelper().formatInteger(Amount) + " §d" + SplitbornAPI.getHelper().formatEnumName(essenceId.toString()) + " Essence" + SplitbornAPI.getHelper().getEssenceSymbol());
            }
        }
        if (StatRewards != null && !StatRewards.isEmpty()){
            for (Stat stat : StatRewards.keySet()){
                int Amount = StatRewards.get(stat);
                int currentStatAmount = profileData.getBaseStatValue(stat);

                if (stat.equals(Stat.HEALTH)){
                    if ((int) player.getHealth() >= (int) player.getMaxHealth()){
                        player.setMaxHealth(currentStatAmount + Amount);
                        player.setHealth(player.getMaxHealth());
                    }
                }

                profileData.setStat(stat, currentStatAmount + Amount);
                extraRewardsAsString.add("§a+" + Amount + " " + SplitbornAPI.getHelper().getStatsColor(stat) + SplitbornAPI.getHelper().formatEnumName(stat.toString()) + SplitbornAPI.getHelper().getStatSymbol(stat));
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
        player.sendMessage(SplitbornAPI.getHelper().getListingSymbol() + "§6" + GleamReward + " Gleams" + SplitbornAPI.getHelper().getGleamSymbol());
        if (XPReward != 0) player.sendMessage(SplitbornAPI.getHelper().getListingSymbol() + "§b" + XPReward + " §bSplitborn XP");
        for (String rewardsAsString : extraRewardsAsString) player.sendMessage(SplitbornAPI.getHelper().getListingSymbol() + rewardsAsString);
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
            NoteBlockAPI.Play(player, NBS_FILE_NAMES.ACHIEVEMENT.toString(), false);
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
        profileData.setString(DatabankPath + inputAssistForDatabank + "_time", String.valueOf(System.currentTimeMillis()));

        SplitbornAPI.getHelper().updatePlayersScoreboard(player);
    }
}
