package net.kingproductions.splitbornAPI.CaliDailyQuests;

import java.util.List;

public enum CaliDailyQuest {

    GLEAM_HUNTER(
            "§6Gleam Bug Hunter",
            100,
            List.of("§7Kill §a" + 100 + " §6Gleam Bugs§")
    ),
    PRACTICE_DUMMY_HUNTER(
            "§ePractice Dummy Hunter",
            10,
            List.of("§7Kill §a" + 10 + " §ePractice Dummies")
    ),

    MOLTASO_SLAYER(
            "§4Moltaso Slayer",
            1,
            List.of("§7Kill §4Moltaso")
    ),

    SCRAP_MINER(
            "§aScrap Miner",
            20,
            List.of("§7Mine §a" + 20 + " §eScrap Ores")
    ),
    SPARK_MINER(
            "§aSpark Miner",
            20,
            List.of("§7Mine §a" + 20 + " §eSpark Ores")
    ),
    SUNSTONE_MINER(
            "§aSunstone Miner",
            20,
            List.of("§7Mine §a" + 20 + " §eSunstones")
    ),

    FISHERMAN(
            "§bFisherman",
            50,
            List.of("§7Make §a" + 50 + " §7catches")
    ),

    DROP_OF_HOPE(
            "§bDrop Of Hope",
            1,
            List.of("§7Water " + 1 + " §aSappling §7in §eDryoak")
    );

    private final List<String> description;
    private final String displayName;
    private final int Amount;

    CaliDailyQuest(String DisplayName, int Amount, List<String> list){
        this.description = list;
        this.displayName = DisplayName;
        this.Amount = Amount;
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
}
