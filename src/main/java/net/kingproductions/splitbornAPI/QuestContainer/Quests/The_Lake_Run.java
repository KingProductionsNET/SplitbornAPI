package net.kingproductions.splitbornAPI.QuestContainer.Quests;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class The_Lake_Run extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.THE_LAKE_RUN;
    }

    @Override
    public String questDisplayName() {
        return "§bThe Lake Run";
    }

    @Override
    public Locations questLocation() {
        return Locations.Hearthgrove;
    }

    @Override
    public Material displayMaterial() {
        return Material.OAK_CHEST_BOAT;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of("§7Escort the §aSupply §7to",
                "§7the §6Supply Docks§7.");
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
