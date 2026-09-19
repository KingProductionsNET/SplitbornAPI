package net.kingproductions.splitbornAPI.NPC;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Event is called before the NPCInteractEvent
 */
public class PreNPCInteractEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final NPC_ID npcId;
    private final NPCInteractEvent.ClickType clickType;
    private final Entity entity;
    private boolean cancelled = false;

    public PreNPCInteractEvent(Player player, NPC_ID npcId, NPCInteractEvent.ClickType clickType, Entity NPC) {
        this.player = player;
        this.npcId = npcId;
        this.clickType = clickType;
        this.entity = NPC;
    }

    public Player getPlayer() {
        return player;
    }

    public NPC_ID getNPCID() {
        return npcId;
    }

    public NPCInteractEvent.ClickType getClickType() {
        return clickType;
    }

    public Entity getBukkitEntity(){
        return entity;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

}
