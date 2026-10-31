package net.kingproductions.splitbornAPI.CustomMiscEventsContainer;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Triggers whenever a player collects a blood pod.
 */
public class BloodPodCollectEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final int bloodpods;

    public BloodPodCollectEvent(Player player, int bloodpods){
        this.player = player;
        this.bloodpods = bloodpods;
    }

    public Player getPlayer(){
        return player;
    }

    /**
     *
     * @return The players current blood pods.
     */
    public int getBloodpods() {
        return bloodpods;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
