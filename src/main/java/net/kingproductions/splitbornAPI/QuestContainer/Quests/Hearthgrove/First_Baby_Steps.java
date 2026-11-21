package net.kingproductions.splitbornAPI.QuestContainer.Quests.Hearthgrove;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class First_Baby_Steps extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.FIRST_BABY_STEPS;
    }

    @Override
    public String questDisplayName() {
        return "§3First Baby Steps";
    }

    @Override
    public Locations questLocation() {
        return Locations.Hearthgrove;
    }

    @Override
    public Material displayMaterial() {
        return Material.PUMPKIN_PIE;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of(
                "§7Wear full §3Challenger Armor §7and have atleast §b35 §cAttack Damage§7."
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
