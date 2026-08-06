package net.kingproductions.splitbornAPI.BowShootEventContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class BowShootEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Item_ID itemId;
    private final Entity entity;
    private boolean onlyShowArrowForShooter;
    private boolean cancelled;

    public BowShootEvent(Player player, Item_ID itemId, Entity projectile, boolean cancelled){
        this.player = player;
        this.itemId = itemId;
        this.entity = projectile;
        this.cancelled = cancelled;
    }

    public Player getPlayer(){
        return player;
    }
    public Item_ID getBowItemID(){return itemId;}
    public boolean getOnlyShowArrowForShooter(){
        return onlyShowArrowForShooter;
    }
    public Entity getProjectile(){
        return entity;
    }

    public void setOnlyShowArrowForShooter(boolean b){
        this.onlyShowArrowForShooter = b;
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
