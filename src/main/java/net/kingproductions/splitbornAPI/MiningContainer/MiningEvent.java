package net.kingproductions.splitbornAPI.MiningContainer;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MiningEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Block_ID blockId;
    private final Location location;
    private boolean cancelled;

    public MiningEvent(Player player, Location loc, Block_ID blockId, boolean cancelled) {
        this.player = player;
        this.cancelled = cancelled;
        this.location = loc;
        this.blockId = blockId;
    }

    public Player getPlayer() {
        return player;
    }
    public Block_ID getBlockID(){
        return blockId;
    }

    /**
     *
     * @return The location of the block the player is attempting to break.
     */
    public Location getLocation(){
        return location;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }
}
