package net.kingproductions.splitbornAPI.LocationChangeEvent;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LocationChangeEvent extends Event{

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Locations fromLocation;
    private final Locations toLocation;
    private Reason reason;

    public LocationChangeEvent(Player player, Locations fromLocation, Locations toLocation) {
        this.player = player;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }

    public Player getPlayer() {
        return player;
    }
    public Locations getFromLocation(){
        return fromLocation;
    }
    public Locations getToLocation(){
        return toLocation;
    }
    public Reason getReason(){
        return reason;
    }

    public void setReason(Reason reason){
        this.reason = reason;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public enum Reason {

        DEATH,
        WALKING

    }
}
