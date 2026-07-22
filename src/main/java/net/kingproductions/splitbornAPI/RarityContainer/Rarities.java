package net.kingproductions.splitbornAPI.RarityContainer;

import org.bukkit.ChatColor;

public enum Rarities {

    COMMON("§6⭐ §a§lCOMMON ", ChatColor.GREEN),
    RARE("§6⭐ §3§lRARE ", ChatColor.AQUA),
    EPIC("§6⭐ §d§lEPIC ", ChatColor.LIGHT_PURPLE),
    LEGENDARY("§6⭐ §6§lLEGENDARY ", ChatColor.GOLD),
    MYTHIC("§6⭐ §c§lMYTHIC ", ChatColor.RED),
    QUEST_ITEM("§6⭐ §4§lQUEST", ChatColor.DARK_RED);

    private final String value;
    private final ChatColor color;

    Rarities(String value, ChatColor color){
        this.value = value;
        this.color = color;
    }

    public String getString(){
        return this.value;
    }

    public ChatColor getColor(){
        return this.color;
    }
}
