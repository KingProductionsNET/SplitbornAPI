package net.kingproductions.splitbornAPI.QuestContainer.Quests.Sporewood;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Ring_The_Bell extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.RING_THE_BELL;
    }

    @Override
    public String questDisplayName() {
        return "§eRing the Bell";
    }

    @Override
    public Locations questLocation() {
        return Locations.Sporewood;
    }

    @Override
    public Material displayMaterial() {
        return Material.CAKE;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of(
                "§7Wear full §dCharoom Armor §7and have atleast §b260 §cAttack Damage§7."
        );
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

    @Override
    public boolean isAreaKeyQuest(){
        return true;
    }
}
