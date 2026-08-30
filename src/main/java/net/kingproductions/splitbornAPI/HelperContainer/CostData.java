package net.kingproductions.splitbornAPI.HelperContainer;

import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;

import java.util.HashMap;
import java.util.Map;

public class CostData {

    private final Map<Essence_ID, Integer> essenceCost = new HashMap<>();
    private final Map<Item_ID, Integer> itemCost = new HashMap<>();

    public CostData addEssenceCost(Essence_ID essenceId, int amount){
        essenceCost.put(essenceId, amount);
        return this;
    }
    public CostData addItemCost(Item_ID itemId, int Amount){
        itemCost.put(itemId, Amount);
        return this;
    }

    public Map<Essence_ID, Integer> getEssenceCost() {
        return essenceCost;
    }
    public Map<Item_ID, Integer> getItemCost() {
        return itemCost;
    }
}
