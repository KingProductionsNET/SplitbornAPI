package net.kingproductions.splitbornAPI.TalentContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class TalentPurchaseEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final TalentID talentID;

    public TalentPurchaseEvent(Player player, TalentID purchasedTalent){
        this.player = player;
        this.talentID = purchasedTalent;
    }

    public Player getPlayer(){
        return player;
    }
    public TalentID getTalentID(){
        return talentID;
    }


    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
