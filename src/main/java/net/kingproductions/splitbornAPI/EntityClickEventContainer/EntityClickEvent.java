package net.kingproductions.splitbornAPI.EntityClickEventContainer;

import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class EntityClickEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Mob_ID mobId;
    private final Entity mob;
    private final CLICK_TYPE clickType;

    public EntityClickEvent(Player receiver, Mob_ID mobId, Entity mob, CLICK_TYPE clickType){
        this.player = receiver;
        this.mobId = mobId;
        this.mob = mob;
        this.clickType = clickType;
    }

    public Player getPlayer(){
        return player;
    }
    public Mob_ID getMobId(){return mobId;}
    public Entity getMob() {
        return mob;
    }
    public CLICK_TYPE getClickType(){
        return clickType;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public enum CLICK_TYPE {
        LEFT,
        RIGHT
    }
}
