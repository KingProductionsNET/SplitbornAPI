package net.kingproductions.splitbornAPI.CustomMiscEventsContainer;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class QuickTravelEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Locations location;
    private boolean cancelled = false;

    public QuickTravelEvent(Player player, Locations location){
        this.player = player;
        this.location = location;
    }

    public Player getPlayer(){
        return player;
    }

    /**
     *
     * @return The location the player wants to travel to.
     */
    public Locations getLocation(){return location;}


    @Override
    public @NotNull HandlerList getHandlers() {
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
