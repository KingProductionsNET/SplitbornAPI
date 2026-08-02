package net.kingproductions.splitbornAPI.CuriosityInteractEventContainer;

import net.kingproductions.splitbornAPI.CuriosityContainer.Curiosities;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CuriosityInteractEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Curiosities curiosityID;
    private final Entity curiosity;

    public CuriosityInteractEvent(Player player, Curiosities curiosityID, Entity curiosity){
        this.player = player;
        this.curiosityID = curiosityID;
        this.curiosity = curiosity;
    }

    public Player getPlayer(){
        return player;
    }
    public Curiosities getCuriosityID(){return curiosityID;}
    public Entity getCuriosityEntity(){return curiosity;}

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
