package net.kingproductions.splitbornAPI.MobContainer;

import net.kingproductions.splitbornAPI.DeathEventContainer.DeathEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MobDeathEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player killer;
    private final Mob_ID mobId;
    private final Entity mob;
    private boolean cancelled;

    public MobDeathEvent(Mob_ID mobId, Player killer, Entity mob, boolean cancelled) {
        this.mobId = mobId;
        this.killer = killer;
        this.mob = mob;
        this.cancelled = cancelled;
    }

    public Player getKiller() {
        return killer;
    }
    public Mob_ID getMobID(){
        return mobId;
    }
    public Entity getMob(){
        return mob;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public enum DEATH_REASON {
        MOB,
        DROWNED,
        YOURSELF,
        UNKNOWN,
        CUSTOM
    }

}
