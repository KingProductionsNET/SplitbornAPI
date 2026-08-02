package net.kingproductions.splitbornAPI.AbilityCastEventContainer;

import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AbilityCastEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Item_ID itemId;
    private boolean cancelled;

    public AbilityCastEvent(Player player, Item_ID itemId, boolean cancelled){
        this.player = player;
        this.itemId = itemId;
        this.cancelled = cancelled;
    }

    public Player getPlayer(){
        return player;
    }
    public Item_ID getItemId(){return itemId;}

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
