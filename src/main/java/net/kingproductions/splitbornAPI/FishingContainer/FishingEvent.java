package net.kingproductions.splitbornAPI.FishingContainer;

import net.kingproductions.splitbornAPI.NPC.NPCInteractEvent;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class FishingEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final boolean isAboutToCatchSomething_;
    private boolean cancel;

    public FishingEvent(Player player, boolean isAboutToCatchSomething_, boolean cancel) {
        this.player = player;
        this.isAboutToCatchSomething_ = isAboutToCatchSomething_;
        this.cancel = cancel;
    }

    public Player getPlayer() {
        return player;
    }
    public boolean isAboutToCatchSomething(){
        return this.isAboutToCatchSomething_;
    }

    public FishingEvent setCancelled(boolean b){
        this.cancel = b;
        return this;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
