package net.kingproductions.splitbornAPI.EssenceContainer;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class EssenceGainEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Essence_ID essenceId;
    private final int Amount;
    private boolean cancelled;
    private int percentageModifier;

    public EssenceGainEvent(Player player, Essence_ID essenceId, int Amount, boolean cancelled){
        this.player = player;
        this.essenceId = essenceId;
        this.Amount = Amount;
        this.cancelled = cancelled;
    }

    public Player getPlayer(){
        return player;
    }
    public Essence_ID getEssenceId(){
        return essenceId;
    }
    public int getAmount(){
        return Amount;
    }
    public void addModifier(int value){
        percentageModifier += value;
    }
    public int getFinalAmount(){
        return (int) Math.floor(Amount * (1 + percentageModifier / 100.0));
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
