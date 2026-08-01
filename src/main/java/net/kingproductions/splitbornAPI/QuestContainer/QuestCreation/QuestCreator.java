package net.kingproductions.splitbornAPI.QuestContainer.QuestCreation;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.Main.SplitbornAPI;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.Quests.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.util.*;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;

public class QuestCreator {

    public static Set<QuestData> getQuestData(){
        Set<QuestData> set = new HashSet<>();
        set.add(new Defeat_Rotmaw().build());
        set.add(new Eliminate_The_Creature().build());
        set.add(new Find_Andrews_Toy().build());
        set.add(new Grugs_Request().build());
        set.add(new Its_Getting_Hot_In_Here().build());
        set.add(new Lazy_Fisher().build());
        set.add(new Meet_Bonsai().build());
        set.add(new Scrap_For_Pip().build());
        set.add(new Talk_To_Bonsai().build());
        set.add(new The_Lost_Caravan().build());
        set.add(new Meet_Grug().build());
        set.add(new The_Hidden_Vault().build());
        return set;
    }









    public static void sendDataToCore(){
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () ->{
            final String collectionName = "quest_container";

            for (QuestData questData : getQuestData()){
                final Quests questID = questData.getQuestID();

                final boolean isMainQuest = questData.getIsMainQuest();
                final Locations questLocation = questData.getQuestLocation();
                final Material material = questData.getDisplayMaterial();
                final List<String> inQuestDescriptionText = questData.getInQuestDescriptionText();
                final List<String> inventoryDescriptionText = questData.getInventoryDescriptionText();
                final Map<String, Object> questRelatedValues = questData.getQuestRelatedValues();
                final List<NPC_ID> whitelistedNPCs = questData.getWhitelistedNPCsWhileQuestIsActive();

                if (questID != null) SplitbornAPI.getUtil().setObjectIntoDB(collectionName, questID.toString(), "ID", questID.toString(), true);
                SplitbornAPI.getUtil().setObjectIntoDB(collectionName, questID.toString(), "isMainQuest", isMainQuest, true);
                if (questLocation != null) SplitbornAPI.getUtil().setObjectIntoDB(collectionName, questID.toString(), "location", questLocation.toString(), true);
                if (material != null)  SplitbornAPI.getUtil().setObjectIntoDB(collectionName, questID.toString(), "displayMaterial", material.toString(), true);
                SplitbornAPI.getUtil().setObjectIntoDB(collectionName, questID.toString(), "inQuestDescriptionText", inQuestDescriptionText, true);
                SplitbornAPI.getUtil().setObjectIntoDB(collectionName, questID.toString(), "inventoryDescriptionText", inventoryDescriptionText, true);
                SplitbornAPI.getUtil().setObjectIntoDB(collectionName, questID.toString(), "questRelatedValues", questRelatedValues, true);
                SplitbornAPI.getUtil().setObjectIntoDB(collectionName, questID.toString(), "whitelistedNPCs", whitelistedNPCs, true);
            }
        });
    }
}
