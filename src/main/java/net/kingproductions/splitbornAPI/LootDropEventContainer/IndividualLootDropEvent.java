package net.kingproductions.splitbornAPI.LootDropEventContainer;

import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * This event gets called for every single drop before a mob's loot pool is being finalized. For bigger tasks use {@link net.kingproductions.splitbornAPI.LootDropEventContainer.LootDropEvent}
 */
public class IndividualLootDropEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Mob_ID mobId;
    private double chance;

    private Item_ID itemId;
    private Essence_ID essenceId;

    public IndividualLootDropEvent(Player player, Item_ID itemId, double chance, Mob_ID mobId) {
        this.player = player;
        this.mobId = mobId;
        this.chance = chance;

        this.itemId = itemId;
    }
    public IndividualLootDropEvent(Player player, Essence_ID essenceId, double chance, Mob_ID mobId) {
        this.player = player;
        this.mobId = mobId;
        this.chance = chance;

        this.essenceId = essenceId;
    }

    public Player getPlayer() {
        return player;
    }
    public double getChance(){
        return chance;
    }
    public Mob_ID mobId(){
        return mobId;
    }

    /**
     *
     * @param additional_chance The additional chance will be added on top of the base chance of the drop. It can also lower the chance by using minus.
     */
    public void addChance(double additional_chance){
        chance += additional_chance;
    }

    @Nullable
    public Item_ID itemId(){
        return itemId;
    }
    @Nullable
    public Essence_ID essenceId(){
        return essenceId;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
