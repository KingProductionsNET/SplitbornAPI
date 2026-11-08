package net.kingproductions.splitbornAPI.QuestContainer.Quests.Junkyard;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Dumpster_Diving extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.DUMPSTER_DIVING;
    }

    @Override
    public String questDisplayName() {
        return "§2Dumpster §8Diving";
    }

    @Override
    public Locations questLocation() {
        return Locations.Junkyard;
    }

    @Override
    public Material displayMaterial() {
        return Material.COMPOSTER;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of();
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of(
                "§7Mine §b50 §aScrap Ore§7."
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
