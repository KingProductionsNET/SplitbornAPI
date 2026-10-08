package net.kingproductions.splitbornAPI.RankContainer;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RankChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Ranks oldRank;
    private final Ranks newRank;

    public RankChangeEvent(Player player, Ranks oldRank, Ranks newRank) {
        this.player = player;
        this.oldRank = oldRank;
        this.newRank = newRank;
    }

    public Player getPlayer() {
        return player;
    }

    public Ranks getOldRank() {
        return oldRank;
    }
    public Ranks getNewRank() {
        return newRank;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }


}
