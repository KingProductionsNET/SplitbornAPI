package net.kingproductions.splitbornAPI.FishingContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FishingLootPoolCreationEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final List<Item_ID> itemId = new ArrayList<>();
    private final List<Mob_ID> mobId = new ArrayList<>();

    /**
     * Called when a player's loot pool is created. This can be used to add specific items or mobs to the loot pool.
     * @param player The player which's loot pool is being modified.
     */
    public FishingLootPoolCreationEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void addItemID(Item_ID itemId) {
        this.itemId.add(itemId);
    }

    public void addMobID(Mob_ID mobId) {
        this.mobId.add(mobId);
    }

    /**
     * Not for public usage.
     * @return
     */
    public List<Mob_ID> getMobIds() {
        return mobId;
    }

    /**
     * Not for public usage.
     * @return
     */
    public List<Item_ID> getItemIds() {
        return itemId;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
