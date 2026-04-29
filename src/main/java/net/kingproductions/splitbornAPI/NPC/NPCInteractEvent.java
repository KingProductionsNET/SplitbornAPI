package net.kingproductions.splitbornAPI.NPC;

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

    public NPCInteractEvent(Player player, NPC_ID npcId, ClickType clickType) {
        this.player = player;
        this.npcId = npcId;
        this.clickType = clickType;
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

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
