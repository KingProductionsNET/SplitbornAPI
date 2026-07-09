package net.kingproductions.splitbornAPI.DeathEventContainer;

import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import net.kingproductions.splitbornAPI.NPC.NPCInteractEvent;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DeathEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Mob_ID mobId;
    private final Entity killer;
    private final String CustomName;
    private final DEATH_REASON ds;
    private boolean cancelled;

    public DeathEvent(Player player, Mob_ID mobId, Entity killer, String CustomName, DEATH_REASON deathReason, boolean cancelled) {
        this.player = player;
        this.mobId = mobId;
        this.killer = killer;
        this.CustomName = CustomName;
        this.ds = deathReason;
        this.cancelled = cancelled;
    }

    public Player getPlayer() {
        return player;
    }
    public Entity getKiller() {
        return killer;
    }
    public Mob_ID getMobId(){
        return mobId;
    }
    public String getCustomName(){
        return CustomName;
    }
    public DEATH_REASON getDeathReason(){return ds;}

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
        OVERHEAT,
        CUSTOM
    }
}
