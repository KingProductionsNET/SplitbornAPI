package net.kingproductions.splitbornAPI.StaminaContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.PerkContainer.PerkID;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class StaminaConsumptionEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private int removalTicks = 4;

    public StaminaConsumptionEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setRemovalTicks(int removeTicks) {
        this.removalTicks = removeTicks;
    }
    public int getRemovalTicks() {
        return removalTicks;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
