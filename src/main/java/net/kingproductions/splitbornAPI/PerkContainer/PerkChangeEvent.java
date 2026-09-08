package net.kingproductions.splitbornAPI.PerkContainer;

import net.kingproductions.splitbornAPI.Main.SplitbornAPI;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.Quests;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nullable;
import java.util.List;

public class PerkChangeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final PerkID newPerk;
    private final List<PerkID> activePerks;

    public PerkChangeEvent(Player player, @Nullable PerkID newPerk, List<PerkID> activePerks) {
        this.player = player;
        this.newPerk = newPerk;
        this.activePerks = activePerks;
    }

    public Player getPlayer() {
        return player;
    }
    public PerkID getNewPerk(){
        return newPerk;
    }
    public List<PerkID> getNewPerks(){
        return activePerks;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
