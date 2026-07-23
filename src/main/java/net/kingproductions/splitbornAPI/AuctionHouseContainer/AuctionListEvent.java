package net.kingproductions.splitbornAPI.AuctionHouseContainer;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AuctionListEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player seller;
    private final AuctionListing listing;

    public AuctionListEvent(Player seller, AuctionListing listing) {
        this.seller = seller;
        this.listing = listing;
    }

    public Player getSeller() {
        return seller;
    }

    public AuctionListing getListing() {
        return listing;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
