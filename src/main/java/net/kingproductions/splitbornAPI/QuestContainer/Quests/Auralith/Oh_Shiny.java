package net.kingproductions.splitbornAPI.QuestContainer.Quests.Auralith;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Oh_Shiny extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.OH_SHINY;
    }

    @Override
    public String questDisplayName() {
        return "§dOh, Shiny!";
    }

    @Override
    public Locations questLocation() {
        return Locations.Auralith;
    }

    @Override
    public Material displayMaterial() {
        return Material.AMETHYST_BLOCK;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of();
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of(
                "§7Mine §b100 §dPale Amethyst§7."
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
