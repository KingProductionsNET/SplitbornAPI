package net.kingproductions.splitbornAPI.SupplyContainer;

import net.kingproductions.splitbornAPI.TalentContainer.TalentID;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.beans.EventHandler;

public class SupplyLootEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final int getTotalLooted;

    public SupplyLootEvent(Player player, int totalLooted){
        this.player = player;
        this.getTotalLooted = totalLooted;
    }

    public Player getPlayer(){
        return player;
    }
    public int getTotalLootedSupplies(){
        return getTotalLooted;
    }


    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
