package net.kingproductions.splitbornAPI.QuestContainer.QuestCancelEventContainer;

import net.kingproductions.splitbornAPI.MiningContainer.Block_ID;
import net.kingproductions.splitbornAPI.NPC.NPCInteractEvent;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.Location;
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
    private Location respawnLocation;
    private String reason = null;

    public QuestCancelEvent(Player player, Quests quests, boolean cancelled) {
        this.player = player;
        this.questID = quests;
        this.cancelled = cancelled;
    }

    /**
     * If the event is canceled, this string will be sent to the player as the reason.
     * @param s The deny reason.
     */
    public void setReason(String s){
        this.reason = s;
    }

    /**
     * Sets the respawn location. By default, the player will respawn in Hearthgrove.
     * @param location The respawn location.
     */
    public void setRespawnLocation(Location location){
        this.respawnLocation = location;
    }

    public Player getPlayer() {
        return player;
    }
    public Quests getQuest(){
        return questID;
    }
    public String getReason(){
        return reason;
    }
    public Location getRespawnLocation(){
        return respawnLocation;
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
