package net.kingproductions.splitbornAPI.QuestContainer.Quests;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Immovable_Legs extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.THE_IMMOVABLE_LEGS;
    }

    @Override
    public String questDisplayName() {
        return "§8The Immovable Legs";
    }

    @Override
    public Locations questLocation() {
        return Locations.Dojo;
    }

    @Override
    public Material displayMaterial() {
        return Material.GOLD_INGOT;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of();
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of(
                "§7Get a §aBest Time §7of under",
                "§b40 §7seconds against §8Bo-Kan's Shadow§7."
        );
    }

    @Override
    public Map<String, Object> questRelatedValues() {
        return Map.of(
        );
    }

    @Override
    public List<NPC_ID> whitelistedNPCsWhileQuestIsActive() {
        return List.of();
    }
}
