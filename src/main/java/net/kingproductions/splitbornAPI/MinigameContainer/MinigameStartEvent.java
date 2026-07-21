package net.kingproductions.splitbornAPI.MinigameContainer;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MinigameStartEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Minigame_ID minigameId;

    public MinigameStartEvent(Player player, Minigame_ID minigameId) {
        this.player = player;
        this.minigameId = minigameId;
    }

    public Player getPlayer(){
        return player;
    }
    public Minigame_ID getMinigameId(){
        return minigameId;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
