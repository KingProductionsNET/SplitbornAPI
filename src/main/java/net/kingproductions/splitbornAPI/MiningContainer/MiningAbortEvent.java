package net.kingproductions.splitbornAPI.MiningContainer;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Called whenever a player stops mining a valid Mining Block.
 */
public class MiningAbortEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;

    public MiningAbortEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
