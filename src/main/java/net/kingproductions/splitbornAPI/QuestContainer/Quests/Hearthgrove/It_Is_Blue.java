package net.kingproductions.splitbornAPI.QuestContainer.Quests.Hearthgrove;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class It_Is_Blue extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.IT_IS_BLUE;
    }

    @Override
    public String questDisplayName() {
        return "§6It is Blue";
    }

    @Override
    public Locations questLocation() {
        return Locations.Hearthgrove;
    }

    @Override
    public Material displayMaterial() {
        return Material.AXOLOTL_BUCKET;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of();
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of(
                "§7Kill §b1 §dBloomfin Axolotl§7."
        );
    }

    @Override
    public Map<String, Object> questRelatedValues() {
        return Map.of();
    }

    @Override
    public List<NPC_ID> whitelistedNPCsWhileQuestIsActive() {
        return List.of();
    }
}
