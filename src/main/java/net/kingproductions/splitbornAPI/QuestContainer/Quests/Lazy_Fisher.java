package net.kingproductions.splitbornAPI.QuestContainer.Quests;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Lazy_Fisher extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.LAZY_FISHER;
    }

    @Override
    public String questDisplayName() {
        return "§9Lazy Fisher";
    }

    @Override
    public Locations questLocation() {
        return Locations.Hearthgrove;
    }

    @Override
    public Material displayMaterial() {
        return Material.FISHING_ROD;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of("§fFish §9Welph's §frod out of the lake.");
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of();
    }

    @Override
    public Map<String, Object> questRelatedValues() {
        return Map.of();
    }

    @Override
    public List<NPC_ID> whitelistedNPCsWhileQuestIsActive() {
        return List.of(NPC_ID.WELPH);
    }
}
