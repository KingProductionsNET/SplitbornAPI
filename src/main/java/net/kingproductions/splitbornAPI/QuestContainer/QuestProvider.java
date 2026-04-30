package net.kingproductions.splitbornAPI.QuestContainer;

import org.bukkit.entity.Player;

public interface QuestProvider {

    void clearPlayersQuest(Player player);
    void ApplyQuest(Player player, String Quest, double progress);
    void CompletedQuest(Player player, Quests quest);
    Quests getPlayersQuest(Player player);

}
