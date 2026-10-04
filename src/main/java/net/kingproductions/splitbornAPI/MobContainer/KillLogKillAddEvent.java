package net.kingproductions.splitbornAPI.MobContainer;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Triggers whenever a kill is added to a player's profile for any reason.
 */
public class KillLogKillAddEvent extends Event  {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Mob_ID mobId;
    private final int Amount;

    public KillLogKillAddEvent(Player player, Mob_ID mobId, int Amount) {
        this.mobId = mobId;
        this.player = player;
        this.Amount = Amount;
    }

    public Player getPlayer() {
        return player;
    }
    public Mob_ID getMobID(){
        return mobId;
    }
    public int getAmount(){
        return Amount;
    }


    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
