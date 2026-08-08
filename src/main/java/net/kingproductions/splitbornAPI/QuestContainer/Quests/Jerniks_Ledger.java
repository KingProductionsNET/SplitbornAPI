package net.kingproductions.splitbornAPI.QuestContainer.Quests;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Jerniks_Ledger extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.JERNIKS_LEDGER;
    }

    @Override
    public String questDisplayName() {
        return "§6Jernik's Ledger";
    }

    @Override
    public Locations questLocation() {
        return Locations.Hearthgrove;
    }

    @Override
    public Material displayMaterial() {
        return Material.WRITABLE_BOOK;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of("§fPay §aJernik §fhis one-time entry fee of",
                "§6" + questRelatedValues().get("FEE") + " Gleams §fto unlock bidding",
                "§fat his auction house.");
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of();
    }

    @Override
    public Map<String, Object> questRelatedValues() {
        return Map.of("FEE", 50000);
    }

    @Override
    public List<NPC_ID> whitelistedNPCsWhileQuestIsActive() {
        return List.of(NPC_ID.JERNIK);
    }
}
