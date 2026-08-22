package net.kingproductions.splitbornAPI.CrawlerNestDestroyEventContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CrawlerNestDestroyEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;

    /**
     * Called when a player destroys a crawler nest.
     * @param player
     */
    public CrawlerNestDestroyEvent(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }


    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
