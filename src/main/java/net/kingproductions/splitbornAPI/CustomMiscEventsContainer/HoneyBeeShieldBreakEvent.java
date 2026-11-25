package net.kingproductions.splitbornAPI.CustomMiscEventsContainer;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class HoneyBeeShieldBreakEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Entity Bee;

    public HoneyBeeShieldBreakEvent(Player player, Entity Bee){
        this.player = player;
        this.Bee = Bee;
    }

    public Player getPlayer(){
        return player;
    }
    public Entity getBee(){return Bee;}

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
