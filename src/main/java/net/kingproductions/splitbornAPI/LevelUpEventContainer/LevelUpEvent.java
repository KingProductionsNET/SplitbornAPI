package net.kingproductions.splitbornAPI.LevelUpEventContainer;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;

public class LevelUpEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final int newLevel;
    private final int previousLevel;
    private final List<String> rewardList;

    public LevelUpEvent(Player player, int newLevel, int previousLevel, List<String> rewardList) {
        this.player = player;
        this.newLevel = newLevel;
        this.previousLevel = previousLevel;
        this.rewardList = rewardList;
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
    public List<String> getRewardList(){
        return rewardList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
