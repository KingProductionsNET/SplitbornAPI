package net.kingproductions.splitbornAPI.FishingContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class FishingLootCalculationEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private Mob_ID mobId;
    private Item_ID itemId;
    private double additionalChance = 0.0;

    /**
     * Event is being called when the loot calculation of each possible loot starts. This can be useful when trying to add more or less chance to a specific drop.
     * @param player The player which is the receiver of final loot
     */
    public FishingLootCalculationEvent(Player player) {
        this.player = player;
    }

    /**
     * Not for public usage.
     * @param itemId
     */
    public void setItemId(Item_ID itemId) {
        this.itemId = itemId;
    }
    public Item_ID getItemId() {
        return itemId;
    }

    public double getAdditionalChance() {
        return additionalChance;
    }

    public void setAdditionalChance(double additionalChance) {
        this.additionalChance = additionalChance;
    }

    public Mob_ID getMobId() {
        return mobId;
    }

    /**
     * Not for public usage.
     * @param mobId
     */
    public void setMobId(Mob_ID mobId) {
        this.mobId = mobId;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
