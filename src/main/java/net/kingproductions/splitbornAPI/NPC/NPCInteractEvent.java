package net.kingproductions.splitbornAPI.NPC;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class NPCInteractEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    public enum ClickType {
        LEFT,
        RIGHT
    }

    private final Player player;
    private final NPC_ID npcId;
    private final ClickType clickType;
    private final Entity entity;

    public NPCInteractEvent(Player player, NPC_ID npcId, ClickType clickType, Entity NPC) {
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

    public ClickType getClickType() {
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

}
