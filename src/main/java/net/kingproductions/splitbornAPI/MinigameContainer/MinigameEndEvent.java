package net.kingproductions.splitbornAPI.MinigameContainer;

import net.kingproductions.splitbornAPI.MobContainer.MobSpawnEvent;
import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MinigameEndEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Minigame_ID minigameId;
    private final int score;
    private boolean cancelled;

    public MinigameEndEvent(Player player, int score, Minigame_ID minigameId, boolean cancelled) {
        this.player = player;
        this.minigameId = minigameId;
        this.score = score;
        this.cancelled = cancelled;
    }

    public Player getPlayer(){
        return player;
    }
    public Minigame_ID getMinigameId(){
        return minigameId;
    }
    public int getScore(){
        return score;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
