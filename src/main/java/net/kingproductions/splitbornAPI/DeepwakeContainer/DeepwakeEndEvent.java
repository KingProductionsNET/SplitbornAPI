package net.kingproductions.splitbornAPI.DeepwakeContainer;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DeepwakeEndEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    public DeepwakeEndEvent(){

    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
