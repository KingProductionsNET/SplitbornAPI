package net.kingproductions.splitbornAPI.ItemContainer;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface SplitbornItemProvider {

    ItemStack getItem(Item_ID itemId);
    List<String> getHowToGet(Item_ID itemId);

}
