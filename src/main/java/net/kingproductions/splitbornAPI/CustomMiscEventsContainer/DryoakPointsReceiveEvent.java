package net.kingproductions.splitbornAPI.CustomMiscEventsContainer;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DryoakPointsReceiveEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private int amount;

    public DryoakPointsReceiveEvent(Player player, int Amount){
        this.player = player;
        this.amount = Amount;
    }

    public Player getPlayer(){
        return player;
    }
    public int getAmount(){
        return amount;
    }

    public void addPoints(int Amount){
        amount += Amount;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
