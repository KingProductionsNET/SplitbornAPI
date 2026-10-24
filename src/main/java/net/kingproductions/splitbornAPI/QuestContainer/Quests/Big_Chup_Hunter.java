package net.kingproductions.splitbornAPI.QuestContainer.Quests;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Big_Chup_Hunter extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return false;
    }

    @Override
    public Quests questID() {
        return Quests.BIG_CHUP_HUNTER;
    }

    @Override
    public String questDisplayName() {
        return "§bBig Chup Hunter";
    }

    @Override
    public Locations questLocation() {
        return Locations.The_Fold;
    }

    @Override
    public Material displayMaterial() {
        return Material.ARMADILLO_SCUTE;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of();
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of(
                "§7Kill one §bElder Chup§7."
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
