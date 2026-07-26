package net.kingproductions.splitbornAPI.CustomMiscEventsContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ChupAttackEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Entity entity;
    private boolean cancelled;

    public ChupAttackEvent(Player receiver, Entity entity, boolean cancelled){
        this.player = receiver;
        this.entity = entity;
        this.cancelled = cancelled;
    }

    public Player getPlayer(){
        return player;
    }
    public Entity getChup(){return entity;}

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
