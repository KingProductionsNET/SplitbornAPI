package net.kingproductions.splitbornAPI.QuestContainer.Quests;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Scrap_For_Pip extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.SCRAP_FOR_PIP;
    }

    @Override
    public String questDisplayName() {
        return "§6Scrap for Pip";
    }

    @Override
    public Locations questLocation() {
        return Locations.Junkyard;
    }

    @Override
    public Material displayMaterial() {
        return Material.IRON_CHAIN;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of("§fCollect " + questRelatedValues().get("SC") + "x §aScrap Coil §fand ",
                "§f" + questRelatedValues().get("SPC") + "x §aSpark Capacitor §ffor §6Pip§f.");
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of();
    }

    @Override
    public Map<String, Object> questRelatedValues() {
        return Map.of("SC", 28,
                "SPC", 10);
    }

    @Override
    public List<NPC_ID> whitelistedNPCsWhileQuestIsActive() {
        return List.of(NPC_ID.PIP_CINDERWICK);
    }
}
