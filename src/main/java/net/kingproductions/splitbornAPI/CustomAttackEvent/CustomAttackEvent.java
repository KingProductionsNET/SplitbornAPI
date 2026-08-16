package net.kingproductions.splitbornAPI.CustomAttackEvent;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Triggers when a splitborn mob attacks with either an ability
 * attack or something unnatural.
 */
public class CustomAttackEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Mob_ID mobId;
    private final Entity mob;
    private boolean cancelled;

    public CustomAttackEvent(Player player, Mob_ID mobId, Entity mob, boolean cancelled){
        this.player = player;
        this.mobId = mobId;
        this.mob = mob;
        this.cancelled = cancelled;
    }

    public Player getPlayer(){
        return player;
    }
    public Mob_ID getMobId(){return mobId;}
    public Entity getMob(){
        return mob;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
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

}
