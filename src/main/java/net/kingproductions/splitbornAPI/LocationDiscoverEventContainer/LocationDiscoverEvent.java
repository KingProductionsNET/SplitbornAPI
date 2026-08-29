package net.kingproductions.splitbornAPI.LocationDiscoverEventContainer;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LocationDiscoverEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Locations location;
    private boolean cancelled;

    public LocationDiscoverEvent(Player player, Locations location, boolean cancelled){
        this.player = player;
        this.location = location;
        this.cancelled = cancelled;
    }

    public Player getPlayer(){
        return player;
    }
    public Locations getLocation(){
        return location;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
