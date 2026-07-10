package net.kingproductions.splitbornAPI.DamageEventContainer;

import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class DamageEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final DAMAGE_REASON reason;
    private final Entity damagedMob;
    private final Mob_ID mobId;
    private boolean cancelled;
    private final int damage;
    private double percentageModifier;

    public DamageEvent(Player player, DAMAGE_REASON reason, boolean cancelled, Entity damagedMob, Mob_ID mobId, int damage){
        this.player = player;
        this.reason = reason;
        this.cancelled = cancelled;
        this.damagedMob = damagedMob;
        this.mobId = mobId;
        this.damage = damage;
    }

    public Player getPlayer(){
        return player;
    }
    public DAMAGE_REASON getDamageReason(){
        return reason;
    }
    public Entity getMob(){
        return damagedMob;
    }
    public Mob_ID getMobId(){
        return mobId;
    }
    public int getDamage(){
        return (int) Math.floor(damage * (1 + percentageModifier / 100.0));
    }
    public void addModifier(double value){
        percentageModifier += value;
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
        PLAYER_DAMAGED_MOB,
        PLAYER_DROWNING,
        MOB_DAMAGED_PLAYER,
        HEAT,
        EMBER_PIT,
        CUSTOM,
        UNKNOWN
    }
}
