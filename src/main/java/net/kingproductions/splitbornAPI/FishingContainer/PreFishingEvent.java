package net.kingproductions.splitbornAPI.FishingContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PreFishingEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Item_ID itemId;
    private boolean cancelled;

    /**
     * Called when a player attempts to cast a fishing rod.
     * @param player The player which is trying to cast the fishing rod.
     */
    public PreFishingEvent(Player player, Item_ID itemId) {
        this.player = player;
        this.itemId = itemId;
    }

    public Player getPlayer() {
        return player;
    }
    public Item_ID getFishingRod(){
        return itemId;
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
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
