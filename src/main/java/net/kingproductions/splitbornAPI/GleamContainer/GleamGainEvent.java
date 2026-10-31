package net.kingproductions.splitbornAPI.GleamContainer;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GleamGainEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private int gleamGainAmount;
    private Source source = Source.UNKNOWN;
    private boolean cancelled;

    public GleamGainEvent(Player player, int Amount){
        this.player = player;
        this.gleamGainAmount = Amount;
    }

    public void setSource(Source source){
        this.source = source;
    }

    public Player getPlayer(){
        return player;
    }
    public void addGleams(int Amount){
        this.gleamGainAmount += Amount;
    }
    public int getAmount(){
        return (gleamGainAmount);
    }

    public Source getSource(){
        return source;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public enum Source {
        MOB_DROP,
        UNKNOWN
    }

}
