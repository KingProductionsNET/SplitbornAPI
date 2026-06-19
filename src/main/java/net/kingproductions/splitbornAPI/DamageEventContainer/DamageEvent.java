package net.kingproductions.splitbornAPI.DamageEventContainer;

import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DamageEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final DAMAGE_REASON reason;
    private final Entity damager;
    private final Mob_ID mobId;
    private boolean cancelled;

    public DamageEvent(Player player, DAMAGE_REASON reason, boolean cancelled, Entity damager, Mob_ID mobId){
        this.player = player;
        this.reason = reason;
        this.cancelled = cancelled;
        this.damager = damager;
        this.mobId = mobId;
    }

    public Player getPlayer(){
        return player;
    }
    public DAMAGE_REASON getDamageReason(){
        return reason;
    }
    public Entity getDamager(){
        return damager;
    }
    public Mob_ID getMobId(){
        return mobId;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public enum DAMAGE_REASON{
        MOB,
        DROWNING,
        UNKNOWN
    }
}
