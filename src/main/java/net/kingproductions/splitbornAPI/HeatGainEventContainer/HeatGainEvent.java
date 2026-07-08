package net.kingproductions.splitbornAPI.HeatGainEventContainer;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class HeatGainEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final int heatGainAmount;
    private boolean cancelled;

    public HeatGainEvent(Player player, int Amount){
        this.player = player;
        this.heatGainAmount = Amount;
    }

    public Player getPlayer(){
        return player;
    }
    public int getAmount(){
        return heatGainAmount;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return null;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
