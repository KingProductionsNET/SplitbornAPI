package net.kingproductions.splitbornAPI.NPC;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;
import java.util.UUID;

public class NPCDialogueEndEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final NPC_ID npcId;
    private final List<UUID> npcHologram;

    public NPCDialogueEndEvent(Player player, NPC_ID npcId, List<UUID> npcHolograms) {
        this.player = player;
        this.npcId = npcId;
        this.npcHologram = npcHolograms;
    }

    public Player getPlayer() {
        return player;
    }

    public List<UUID> getNpcHologram() {
        return npcHologram;
    }
    public NPC_ID getNpcId() {
        return npcId;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
