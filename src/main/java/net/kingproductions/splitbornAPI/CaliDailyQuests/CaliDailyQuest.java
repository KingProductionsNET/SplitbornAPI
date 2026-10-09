package net.kingproductions.splitbornAPI.CaliDailyQuests;

import net.kingproductions.splitbornAPI.MiningContainer.Block_ID;
import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;

import java.util.List;

public enum CaliDailyQuest {

    HUNTER(
            QuestType.KILL,
            "§cMob Hunter",
            300,
            List.of("§7Kill §a" + 300 + " §7Mobs"),
            null
    ),
    GLEAM_HUNTER(
            QuestType.KILL,
            "§6Gleam Bug Hunter",
            100,
            List.of("§7Kill §a" + 100 + " §6Gleam Bugs§"),
            Mob_ID.GLEAM_BUG
    ),
    PRACTICE_DUMMY_HUNTER(
            QuestType.KILL,
            "§ePractice Dummy Hunter",
            100,
            List.of("§7Kill §a" + 100 + " §ePractice Dummies"),
            Mob_ID.PRACTICE_DUMMY
    ),

    MOLTASO_SLAYER(
            QuestType.KILL,
            "§4Moltaso Slayer",
            1,
            List.of("§7Kill §4Moltaso"),
            Mob_ID.MOLTASO
    ),

    SCRAP_MINER(
            QuestType.MINING,
            "§aScrap Miner",
            200,
            List.of("§7Mine §a" + 200 + " §eScrap Ores"),
            Block_ID.SCRAP_ORE
    ),
    SPARK_MINER(
            QuestType.MINING,
            "§aSpark Miner",
            200,
            List.of("§7Mine §a" + 200 + " §eSpark Ores"),
            Block_ID.SPARK_ORE
    ),
    SUNSTONE_MINER(
            QuestType.MINING,
            "§aSunstone Miner",
            200,
            List.of("§7Mine §a" + 200 + " §eSunstones"),
            Block_ID.SUNSTONE
    ),

    FISHERMAN(
            QuestType.FISHING,
            "§bFisherman",
            100,
            List.of("§7Make §a" + 100 + " §7catches"),
            null
    ),

    DROP_OF_HOPE(
            QuestType.MISC,
            "§bDrop Of Hope",
            14,
            List.of("§7Water " + 14 + " §aSappling §7in §eDryoak"),
            null
    );

    private final List<String> description;
    private final String displayName;
    private final int Amount;
    private final QuestType questType;
    private final Object object;

    CaliDailyQuest(QuestType questType, String DisplayName, int Amount, List<String> list, Object o){
        this.description = list;
        this.displayName = DisplayName;
        this.Amount = Amount;
        this.questType = questType;
        this.object = o;
    }

    public String getDisplayName(){
        return displayName;
    }
    public int getAmount(){
        return Amount;
    }
    public List<String> getDescription(){
        return description;
    }
    public QuestType getQuestType(){
        return questType;
    }
    public Object getObject(){
        return object;
    }
}
