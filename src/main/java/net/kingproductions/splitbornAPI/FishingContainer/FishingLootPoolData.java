package net.kingproductions.splitbornAPI.FishingContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;

public class FishingLootPoolData {

    private Item_ID itemId;
    private Mob_ID mobId;
    private int minAmount;
    private int maxAmount;
    private double chance;

    public Item_ID getItemId() {
        return itemId;
    }

    public Mob_ID getMobId() {
        return mobId;
    }

    public FishingLootPoolData setItemId(Item_ID itemId) {
        this.itemId = itemId;
        return this;
    }

    public double getChance() {
        return chance;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public FishingLootPoolData setChance(double chance) {
        this.chance = chance;
        return this;
    }

    public FishingLootPoolData setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
        return this;
    }

    public FishingLootPoolData setMinAmount(int minAmount) {
        this.minAmount = minAmount;
        return this;
    }

    public FishingLootPoolData setMobId(Mob_ID mobId) {
        this.mobId = mobId;
        return this;
    }
}
