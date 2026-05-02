package net.kingproductions.splitbornAPI.QuestContainer;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import org.bukkit.Material;

public class QuestData {

    private Quests questID;
    private Locations questLocation;
    private Material material;

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

    public Quests getQuestID(){
        return questID;
    }
    public Locations getQuestLocation(){
        return questLocation;
    }
    public Material getDisplayMaterial(){
        return material;
    }

}
