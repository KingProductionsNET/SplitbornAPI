package net.kingproductions.splitbornAPI.QuestContainer;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.ReplaceOptions;
import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import org.bson.Document;
import org.bukkit.Material;

import java.util.HashSet;
import java.util.Set;

import static com.mongodb.client.model.Filters.eq;

public class QuestCreator {

    public static void InitializeQuest(MongoCollection<Document> collection){
        Set<QuestData> set = new HashSet<>();
        set.add(QUEST_Chup_Hunter());
        set.add(QUEST_Defeat_Rotmaw());

        for (QuestData questData : set){
            String ID = questData.getQuestID().toString();
            String Location = questData.getQuestLocation().toString();
            String Material = questData.getDisplayMaterial().toString();

            Document QUEST_DATA = new Document("_id", ID).append("location", Location).append("material", Material);
            collection.replaceOne(eq("_id", ID), QUEST_DATA, new ReplaceOptions().upsert(true));
        }
    }

    private static QuestData QUEST_Chup_Hunter(){
        QuestData questData = new QuestData();
        questData.setQuestID(Quests.Chup_Hunter);
        questData.setQuestLocation(Locations.Hearthgrove);
        questData.setDisplayMaterial(Material.ARMADILLO_SCUTE);

        return questData;
    }
    private static QuestData QUEST_Defeat_Rotmaw(){
        QuestData questData = new QuestData();
        questData.setQuestID(Quests.DEFEAT_ROTMAW);
        questData.setQuestLocation(Locations.Hearthgrove);
        questData.setDisplayMaterial(Material.IRON_SWORD);

        return questData;
    }

}
