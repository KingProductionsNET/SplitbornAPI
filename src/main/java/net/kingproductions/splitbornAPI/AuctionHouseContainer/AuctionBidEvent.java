package net.kingproductions.splitbornAPI.AuctionHouseContainer;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AuctionBidEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player bidder;
    private final AuctionListing listing;
    private final int amount;

    public AuctionBidEvent(Player bidder, AuctionListing listing, int amount) {
        this.bidder = bidder;
        this.listing = listing;
        this.amount = amount;
    }

    public Player getBidder() {
        return bidder;
    }

    public AuctionListing getListing() {
        return listing;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
