package net.kingproductions.splitbornAPI.Dojo;

import net.kingproductions.splitbornAPI.EntityClickEventContainer.EntityClickEvent;
import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Triggers at the end of a sumo match.
 */
public class SumoEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Opponent opponent;
    private final Winner winner;
    private final int matchSeconds;

    public SumoEvent(Player receiver, Opponent opponent, Winner winner, int matchSeconds){
        this.player = receiver;
        this.opponent = opponent;
        this.winner = winner;
        this.matchSeconds = matchSeconds;
    }

    public Player getPlayer(){
        return player;
    }
    public Opponent getOpponent(){return opponent;}
    public Winner getWinner() {
        return winner;
    }
    public int getMatchSeconds (){
        return matchSeconds;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public enum Winner {
        PLAYER,
        BAOT
    }

    public enum Opponent {
        WHELP,
        BRACKET,
        IRON_PAW,
        STORMTAIL,
        BO_KANS_SHADOW
    }
}
