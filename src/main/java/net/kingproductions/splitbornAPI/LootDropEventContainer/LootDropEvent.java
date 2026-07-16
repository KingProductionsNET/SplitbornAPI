package net.kingproductions.splitbornAPI.LootDropEventContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.*;

public class LootDropEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Mob_ID mobId;
    private final Map<Item_ID, Double> getItemsFinalModifiedDropChance = new HashMap<>();
    private final Set<Item_ID> disallowedItems = new HashSet<>();
    private final Map<Item_ID, Integer> GuaranteedExtraDrops = new HashMap<>();
    private boolean cancelled;

    public LootDropEvent(Player player, Mob_ID mobId, boolean cancelled) {
        this.player = player;
        this.mobId = mobId;
        this.cancelled = cancelled;
    }

    public Player getPlayer() {
        return player;
    }
    public Mob_ID getDroppersMobID(){
        return mobId;
    }
    public double getBonusChanceForItemID(Item_ID itemId){
        return getItemsFinalModifiedDropChance.getOrDefault(itemId, 0.0);
    }
    public List<Item_ID> getDisallowedItems(){
        return disallowedItems.stream().toList();
    }
    public Map<Item_ID, Integer> getGuaranteedExtraDrops(){
        return GuaranteedExtraDrops;
    }

    public void modifyChanceForItemID(Item_ID itemId, double chance){
        double currentModifiedChance = getItemsFinalModifiedDropChance.getOrDefault(itemId, 0.0);
        currentModifiedChance += chance;

        getItemsFinalModifiedDropChance.put(itemId, currentModifiedChance);
    }
    public void addDisallowedItemID(Item_ID itemId){
        disallowedItems.add(itemId);
    }
    public void addGuaranteedExtraDrop(Item_ID itemId, int Amount){
        GuaranteedExtraDrops.put(itemId, Amount);
    }


    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
