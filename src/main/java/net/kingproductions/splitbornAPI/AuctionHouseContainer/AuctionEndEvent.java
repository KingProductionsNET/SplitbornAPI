package net.kingproductions.splitbornAPI.AuctionHouseContainer;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class AuctionEndEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    public enum Outcome {
        SOLD,
        EXPIRED,
        CANCELLED
    }

    private final AuctionListing listing;
    private final Outcome outcome;
    private final UUID winnerUUID;
    private final int finalPrice;

    public AuctionEndEvent(AuctionListing listing, Outcome outcome, UUID winnerUUID, int finalPrice) {
        this.listing = listing;
        this.outcome = outcome;
        this.winnerUUID = winnerUUID;
        this.finalPrice = finalPrice;
    }

    public AuctionListing getListing() {
        return listing;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public UUID getWinnerUUID() {
        return winnerUUID;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
