package net.kingproductions.splitbornAPI.QuestContainer.Quests;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Crushing_The_Nests extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.CRUSHING_THE_NESTS;
    }

    @Override
    public String questDisplayName() {
        return "§5Crushing The Nests";
    }

    @Override
    public Locations questLocation() {
        return Locations.Hearthgrove;
    }

    @Override
    public Material displayMaterial() {
        return Material.COBWEB;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of("§fDestroy §a3 §5Crawler Nests");
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of();
    }

    @Override
    public Map<String, Object> questRelatedValues() {
        return Map.of("CRAWLER_NESTS", 3);
    }

    @Override
    public List<NPC_ID> whitelistedNPCsWhileQuestIsActive() {
        return List.of();
    }
}
