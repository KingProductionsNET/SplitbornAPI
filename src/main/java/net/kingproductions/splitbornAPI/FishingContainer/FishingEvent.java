package net.kingproductions.splitbornAPI.FishingContainer;

import net.kingproductions.splitbornAPI.StatContainer.Stat;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class FishingEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private boolean cancelled;
    private final State state;

    private Entity modifiedEntityDrop;
    private ItemStack modifiedItemDrop;

    private Location hookLocation;
    private Entity fishedEntity;
    private ItemStack fishedItemStack;

    /**
     * Event is being called in different states see {@link net.kingproductions.splitbornAPI.FishingContainer.FishingEvent.State}
     * @param player The player which is fishing
     * @param state The state this event has been called in.
     */
    public FishingEvent(Player player, State state) {
        this.player = player;
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }

    public void setModifiedEntityDrop(Entity e){
        this.modifiedEntityDrop = e;
    }
    public void setModifiedItemDrop(ItemStack i){
        this.modifiedItemDrop = i;
    }
    public void setHookLocation(Location loc){
        this.hookLocation = loc;
    }
    public void setFishedEntity(Entity e){
        this.fishedEntity = e;
    }
    public void setFishedItemStack(ItemStack i){
        this.fishedItemStack = i;
    }

    public Entity getModifiedEntityDrop(){
        return modifiedEntityDrop;
    }
    public ItemStack getModifiedItemDrop(){
        return modifiedItemDrop;
    }
    public Location getHookLocation(){
        return hookLocation;
    }
    public Entity getFishedEntity(){return fishedEntity;}
    public ItemStack getFishedItemStack(){return fishedItemStack;}
    public State getState(){return state;}

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public enum State {
        /**
         * The moment the hook hits the water.
         */
        CAST_HOOK,
        /**
         * The moment something bites the hook.
         */
        LOOT_ON_HOOK,
        /**
         * The moment the final loot has been picked, and the player successfully reels their hook in.
         */
        REEL_IN
    }
}
