package net.kingproductions.splitbornAPI.CuriosityInteractEventContainer;

import net.kingproductions.splitbornAPI.CuriosityContainer.Curiosities;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CuriosityInteractEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Curiosities curiosityID;

    public CuriosityInteractEvent(Player receiver, Curiosities curiosityID){
        this.player = receiver;
        this.curiosityID = curiosityID;
    }

    public Player getPlayer(){
        return player;
    }
    public Curiosities getCuriosityID(){return curiosityID;}

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
