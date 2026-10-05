package net.kingproductions.splitbornAPI.GleamContainer;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class GleamGainEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final int gleamGainAmount;
    private boolean cancelled;

    public GleamGainEvent(Player player, int Amount){
        this.player = player;
        this.gleamGainAmount = Amount;
    }

    public Player getPlayer(){
        return player;
    }
    public int getAmount(){
        return (gleamGainAmount);
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
