package net.kingproductions.splitbornAPI.QuestContainer.Quests;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Red_Cross extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.RED_CROSS;
    }

    @Override
    public String questDisplayName() {
        return "§cRed Cross";
    }

    @Override
    public Locations questLocation() {
        return Locations.Dryoak;
    }

    @Override
    public Material displayMaterial() {
        return Material.DRAGON_BREATH;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of();
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of(
                "§7Kill §b10 §5Quiesser§7."
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
