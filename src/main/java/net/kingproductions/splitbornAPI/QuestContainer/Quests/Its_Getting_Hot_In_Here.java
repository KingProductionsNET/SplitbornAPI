package net.kingproductions.splitbornAPI.QuestContainer.Quests;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestPreset;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public class Its_Getting_Hot_In_Here extends QuestPreset {
    @Override
    public boolean isMainQuest() {
        return true;
    }

    @Override
    public Quests questID() {
        return Quests.ITS_GETTING_HOT_IN_HERE;
    }

    @Override
    public String questDisplayName() {
        return "§6It's Getting Hot In Here";
    }

    @Override
    public Locations questLocation() {
        return Locations.Ashvein_Mine;
    }

    @Override
    public Material displayMaterial() {
        return Material.LAVA_BUCKET;
    }

    @Override
    public List<String> inQuestDescriptionText() {
        return List.of("§fJump into an §cEmber Pit");
    }

    @Override
    public List<String> inventoryDescriptionText() {
        return List.of("");
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
