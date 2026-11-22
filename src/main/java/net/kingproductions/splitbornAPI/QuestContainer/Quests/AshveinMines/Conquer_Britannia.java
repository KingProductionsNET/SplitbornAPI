package net.kingproductions.splitbornAPI.QuestContainer.Quests.AshveinMines;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Conquer_Britannia extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.CONQUER_BRITANNIA;
    }

    @Override
    public String questDisplayName() {
        return "§8Conquer Britannia";
    }

    @Override
    public Locations questLocation() {
        return Locations.Ashvein_Mine;
    }

    @Override
    public Material displayMaterial() {
        return Material.HONEYCOMB;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of(
                "§7Wear the §dChosni Armor §7and have atleast §b130 §cAttack Damage§7."
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
