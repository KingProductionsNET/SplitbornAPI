package net.kingproductions.splitbornAPI.CustomMiscEventsContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SellEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Item_ID itemId;
    private final int itemAmount;
    private final int gleamAmount;

    public SellEvent(Player player, Item_ID itemId, int itemAmount, int gleamAmount){
        this.player = player;
        this.itemId = itemId;
        this.itemAmount = itemAmount;
        this.gleamAmount = gleamAmount;
    }

    public Player getPlayer(){
        return player;
    }
    public Item_ID getItemId(){return itemId;}
    public int getItemAmount(){
        return itemAmount;
    }
    public int getGleamAmount(){
        return gleamAmount;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
