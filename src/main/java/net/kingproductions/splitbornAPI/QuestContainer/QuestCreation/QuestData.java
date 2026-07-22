package net.kingproductions.splitbornAPI.QuestContainer.QuestCreation;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestData {

    private boolean isMainQuest = false;
    private Quests questID;
    private Locations questLocation;
    private Material material;
    private List<String> inQuestDescriptionText = new ArrayList<>();
    private List<String> inventoryDescriptionText = new ArrayList<>();
    private Map<String, Object> questRelatedValues = new HashMap<>();
    private List<NPC_ID> whilitedNPCsWhileQuestIsActive = new ArrayList<>();
    private String displayName;

    public QuestData setIsMainQuest(boolean b){
        this.isMainQuest = b;
        return this;
    }
    public QuestData setQuestID(Quests quest){
        questID = quest;
        return this;
    }

    public QuestData setQuestLocation(Locations qL){
        questLocation = qL;
        return this;
    }
    public QuestData setDisplayMaterial(Material m){
        material = m;
        return this;
    }
    public QuestData setInQuestDescriptionText(List<String> list){
        inQuestDescriptionText = list;
        return this;
    }
    public QuestData setInventoryDescriptionText(List<String> list){
        inventoryDescriptionText = list;
        return this;
    }
    public QuestData setQuestRelatedValues(Map<String, Object> map){
        this.questRelatedValues = map;
        return this;
    }
    public QuestData setWhitelistedNPCs(List<NPC_ID> list){
        this.whilitedNPCsWhileQuestIsActive = list;
        return this;
    }
    public QuestData setDisplayName(String s){
        this.displayName = s;
        return this;
    }

    public boolean getIsMainQuest(){
        return isMainQuest;
    }
    public Quests getQuestID(){
        return questID;
    }
    public Locations getQuestLocation(){
        return questLocation;
    }
    public Material getDisplayMaterial(){
        return material;
    }

    public List<String> getInQuestDescriptionText() {
        return inQuestDescriptionText;
    }
    public List<String> getInventoryDescriptionText() {
        return inventoryDescriptionText;
    }
    public Map<String, Object> getQuestRelatedValues() {
        return questRelatedValues;
    }
    public List<NPC_ID> getWhitelistedNPCsWhileQuestIsActive(){
        return whilitedNPCsWhileQuestIsActive;
    }
    public String getDisplayName(){
        return displayName;
    }
}
