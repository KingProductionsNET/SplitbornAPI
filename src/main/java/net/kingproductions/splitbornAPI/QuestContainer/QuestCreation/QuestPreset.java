package net.kingproductions.splitbornAPI.QuestContainer.QuestCreation;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public abstract class QuestPreset {

    public abstract boolean isMainQuest();
    public abstract Quests questID();
    public abstract String questDisplayName();
    public abstract Locations questLocation();
    public abstract Material displayMaterial();
    public abstract List<String> inQuestDescriptionText();
    public abstract List<String> inventoryDescriptionText();
    public abstract Map<String, Object> questRelatedValues();
    public abstract List<NPC_ID> whitelistedNPCsWhileQuestIsActive();

    public QuestData build(){
        return new QuestData()
                .setIsMainQuest(isMainQuest())
                .setQuestID(questID())
                .setQuestLocation(questLocation())
                .setDisplayMaterial(displayMaterial())
                .setInQuestDescriptionText(inQuestDescriptionText())
                .setInventoryDescriptionText(inventoryDescriptionText())
                .setQuestRelatedValues(questRelatedValues())
                .setWhitelistedNPCs(whitelistedNPCsWhileQuestIsActive());
    }

}
