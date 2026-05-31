package net.kingproductions.splitbornAPI.FishingContainer;

import net.kingproductions.splitbornAPI.NPC.NPCInteractEvent;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FishingEvent extends Event implements Cancellable {


    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final boolean isAboutToCatchSomething;
    private boolean cancelled;

    private Entity modifiedEntityDrop;
    private ItemStack modifiedItemDrop;

    public FishingEvent(Player player, boolean isAboutToCatchSomething, boolean cancelled, Entity modifiedEntityDrop, ItemStack modifiedItemDrop) {
        this.player = player;
        this.isAboutToCatchSomething = isAboutToCatchSomething;
        this.cancelled = cancelled;
        this.modifiedEntityDrop = modifiedEntityDrop;
        this.modifiedItemDrop = modifiedItemDrop;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isAboutToCatchSomething() {
        return isAboutToCatchSomething;
    }

    public void setModifiedEntityDrop(Entity e){
        this.modifiedEntityDrop = e;
    }
    public void setModifiedItemDrop(ItemStack i){
        this.modifiedItemDrop = i;
    }

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
}
