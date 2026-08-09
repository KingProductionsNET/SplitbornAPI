package net.kingproductions.splitbornAPI.QuestContainer.QuestCancelEventContainer;

import net.kingproductions.splitbornAPI.MiningContainer.Block_ID;
import net.kingproductions.splitbornAPI.NPC.NPCInteractEvent;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class QuestCancelEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Quests questID;
    private boolean cancelled;

    public QuestCancelEvent(Player player, Quests quests, boolean cancelled) {
        this.player = player;
        this.questID = quests;
        this.cancelled = cancelled;
    }

    public Player getPlayer() {
        return player;
    }
    public Quests getQuest(){
        return questID;
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
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

}
