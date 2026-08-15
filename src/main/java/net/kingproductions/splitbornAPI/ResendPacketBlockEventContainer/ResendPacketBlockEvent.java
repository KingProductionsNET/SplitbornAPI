package net.kingproductions.splitbornAPI.ResendPacketBlockEventContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.PerkContainer.PerkID;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ResendPacketBlockEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Location location;
    private boolean cancelled;

    /**
     * Called when a player interacts with a location
     * surrounding a fake block sent via packets.
     */
    public ResendPacketBlockEvent(Player player, Location location, boolean cancelled) {
        this.player = player;
        this.location = location;
        this.cancelled = cancelled;
    }

    public Player getPlayer() {
        return player;
    }
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
