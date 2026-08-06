package net.kingproductions.splitbornAPI.SpecialMovementEventContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.MiningContainer.Block_ID;
import net.kingproductions.splitbornAPI.PerkContainer.PerkID;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Called whenever a player is moved by a custom Splitborn ability rather than
 * normal vanilla movement (e.g. teleports, dashes, double jumps, grapples).
 */
public class SpecialMovementEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Item_ID itemId;
    private final PerkID perkID;
    private boolean cancelled;

    public SpecialMovementEvent(Player player, Item_ID itemId, PerkID perkID, boolean cancelled) {
        this.player = player;
        this.cancelled = cancelled;
        this.itemId = itemId;
        this.perkID = perkID;
    }

    public Player getPlayer() {
        return player;
    }
    public Item_ID getItemId(){
        return itemId;
    }
    public PerkID getPerkID() {
        return perkID;
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
