package net.kingproductions.splitbornAPI.QuestContainer.Quests;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Grugs_Request extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return false;
    }

    @Override
    public Quests questID() {
        return Quests.GRUGS_REQUEST;
    }

    @Override
    public String questDisplayName() {
        return "§cGrugs Request";
    }

    @Override
    public Locations questLocation() {
        return null;
    }

    @Override
    public Material displayMaterial() {
        return null;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of("Bring Grug " + questRelatedValues().get("CF") + "x §fChup Fluff and " + questRelatedValues().get("QP") + "x Quivering Pebbles.");
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of();
    }

    @Override
    public Map<String, Object> questRelatedValues() {
        return Map.of(
                "CF", 64,
                "QP", 20);
    }

    @Override
    public List<NPC_ID> whitelistedNPCsWhileQuestIsActive() {
        return List.of(NPC_ID.GRUG);
    }
}
