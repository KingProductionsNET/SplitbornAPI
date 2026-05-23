package net.kingproductions.splitbornAPI.DeathEventContainer;

import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import net.kingproductions.splitbornAPI.NPC.NPCInteractEvent;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DeathEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Mob_ID mobId;
    private final Entity killer;
    private final String CustomName;

    public DeathEvent(Player player, Mob_ID mobId, Entity killer, String CustomName) {
        this.player = player;
        this.mobId = mobId;
        this.killer = killer;
        this.CustomName = CustomName;
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

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
