package net.kingproductions.splitbornAPI.CustomMiscEventsContainer;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SprayAndPrayCastEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Entity projectile;

    public SprayAndPrayCastEvent(Player player, Entity projectile){
        this.player = player;
        this.projectile = projectile;
    }

    public Player getPlayer(){
        return player;
    }
    public Entity getProjectile(){return projectile;}

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
