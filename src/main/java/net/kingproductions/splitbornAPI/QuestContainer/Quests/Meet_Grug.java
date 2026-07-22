package net.kingproductions.splitbornAPI.QuestContainer.Quests;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestProvider;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Meet_Grug extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return false;
    }

    @Override
    public Quests questID() {
        return Quests.MEET_GRUG;
    }

    @Override
    public String questDisplayName() {
        return "§fMeet §cGrug";
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
        return List.of("§fMeet §cGrug");
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
