package net.kingproductions.splitbornAPI.QuestContainer.Quests.Doomrest;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class S_Rank_Hunter extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.S_RANK_HUNTER;
    }

    @Override
    public String questDisplayName() {
        return "§6S-Rank Hunter";
    }

    @Override
    public Locations questLocation() {
        return Locations.Doomrest;
    }

    @Override
    public Material displayMaterial() {
        return Material.COOKIE;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of(
        );
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of("§7Wear the fully upgraded §dAbyss Stalker Armor",
                "§7and have at least §b70 §cAttack Damage§7.");
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
