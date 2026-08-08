package net.kingproductions.splitbornAPI.KillEffectCastEventContainer;

import net.kingproductions.splitbornAPI.KillEffectsContainer.KillEffectID;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class KillEffectCastEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final KillEffectID killEffectID;
    private boolean cancelled;

    public KillEffectCastEvent(Player player, KillEffectID killEffectID, boolean cancelled){
        this.player = player;
        this.killEffectID = killEffectID;
        this.cancelled = cancelled;
    }

    public Player getPlayer(){
        return player;
    }
    public KillEffectID getKillEffectID() {
        return killEffectID;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        cancelled = b;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
