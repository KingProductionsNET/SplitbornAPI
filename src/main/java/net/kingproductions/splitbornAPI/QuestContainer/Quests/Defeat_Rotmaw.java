package net.kingproductions.splitbornAPI.QuestContainer.Quests;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Defeat_Rotmaw extends QuestPreset {

    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.DEFEAT_ROTMAW;
    }

    @Override
    public String questDisplayName() {
        return "§7Defeat §cRotmaw";
    }

    @Override
    public Locations questLocation() {
        return Locations.Hearthgrove;
    }

    @Override
    public Material displayMaterial() {
        return Material.IRON_SWORD;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of("§fDefeat §cRotmaw§f.");
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
        return List.of();
    }
}
