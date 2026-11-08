package net.kingproductions.splitbornAPI.QuestContainer.Quests.The_Unfound;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Oil_Rigs extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.OIL_RIGS;
    }

    @Override
    public String questDisplayName() {
        return "§1Oil Rigs";
    }

    @Override
    public Locations questLocation() {
        return Locations.The_Unfound;
    }

    @Override
    public Material displayMaterial() {
        return Material.DIAMOND_PICKAXE;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of();
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of(
                "§7Mine §b100 §aProspectors Emerald§7."
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
