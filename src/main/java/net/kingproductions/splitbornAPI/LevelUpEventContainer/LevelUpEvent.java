package net.kingproductions.splitbornAPI.LevelUpEventContainer;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LevelUpEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final int newLevel;
    private final int previousLevel;

    public LevelUpEvent(Player player, int newLevel, int previousLevel) {
        this.player = player;
        this.newLevel = newLevel;
        this.previousLevel = previousLevel;
    }

    public Player getPlayer() {
        return player;
    }
    public int getNewLevel(){
        return newLevel;
    }
    public int getPreviousLevel(){
        return previousLevel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
