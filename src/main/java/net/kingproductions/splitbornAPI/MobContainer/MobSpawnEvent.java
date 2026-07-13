package net.kingproductions.splitbornAPI.MobContainer;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MobSpawnEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Mob_ID mobId;
    private final SPAWN_REASON spawnReason;
    private final Entity mob;
    private boolean cancelled;

    public MobSpawnEvent(Mob_ID mobId, Entity mob, SPAWN_REASON spawnReason, boolean cancelled) {
        this.mobId = mobId;
        this.mob = mob;
        this.spawnReason = spawnReason;
        this.cancelled = cancelled;
    }

    public Mob_ID getMobID(){
        return mobId;
    }
    public Entity getMob(){
        return mob;
    }
    public SPAWN_REASON getSpawnReason(){
        return spawnReason;
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

    public enum SPAWN_REASON {
        PLUGIN,
        RESPAWN,
    }

}
