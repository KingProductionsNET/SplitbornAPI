package net.kingproductions.splitbornAPI.HelperContainer;

import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;

import java.util.HashMap;
import java.util.Map;

public class CostData {

    private final Map<Essence_ID, Integer> essenceCost = new HashMap<>();
    private final Map<Item_ID, Integer> itemCost = new HashMap<>();

    public void addEssenceCost(Essence_ID essenceId, int amount){
        essenceCost.put(essenceId, amount);
    }
    public void addItemCost(Item_ID itemId, int Amount){
        itemCost.put(itemId, Amount);
    }

    public Map<Essence_ID, Integer> getEssenceCost() {
        return essenceCost;
    }
    public Map<Item_ID, Integer> getItemCost() {
        return itemCost;
    }
}
