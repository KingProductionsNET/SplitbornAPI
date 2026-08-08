package net.kingproductions.splitbornAPI.QuestContainer.Quests;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class The_Goblins_Hustle extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.THE_GOBLINS_HUSTLE;
    }

    @Override
    public String questDisplayName() {
        return "§aThe Goblins Hustle";
    }

    @Override
    public Locations questLocation() {
        return Locations.Hearthgrove;
    }

    @Override
    public Material displayMaterial() {
        return Material.EMERALD;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        // The goblins deliberately never name the item they want, so neither does the tracker.
        return List.of("§7Bring the §aGoblin siblings §7something §crare§7,",
                "§7something that still carries a bit of §cfire§7.");
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
        return List.of(NPC_ID.GRIX, NPC_ID.SNURK, NPC_ID.MUCKLE);
    }
}
