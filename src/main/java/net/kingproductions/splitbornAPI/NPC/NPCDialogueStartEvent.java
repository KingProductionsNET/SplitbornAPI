package net.kingproductions.splitbornAPI.NPC;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NPCDialogueStartEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final NPC_ID npcId;
    private final List<UUID> npcHologram;
    private final List<String> textHologram;

    public NPCDialogueStartEvent(Player player, NPC_ID npcId, List<UUID> npcHolograms, List<String> text) {
        this.player = player;
        this.npcId = npcId;
        this.npcHologram = npcHolograms;
        this.textHologram = text;
    }

    public Player getPlayer() {
        return player;
    }

    public List<String> getTextHologram() {
        return textHologram;
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
