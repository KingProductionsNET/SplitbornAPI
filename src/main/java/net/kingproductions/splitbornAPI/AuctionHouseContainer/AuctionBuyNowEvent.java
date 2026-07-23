package net.kingproductions.splitbornAPI.AuctionHouseContainer;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AuctionBuyNowEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final Player buyer;
    private final AuctionListing listing;
    private final int price;

    public AuctionBuyNowEvent(Player buyer, AuctionListing listing, int price) {
        this.buyer = buyer;
        this.listing = listing;
        this.price = price;
    }

    public Player getBuyer() {
        return buyer;
    }

    public AuctionListing getListing() {
        return listing;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
