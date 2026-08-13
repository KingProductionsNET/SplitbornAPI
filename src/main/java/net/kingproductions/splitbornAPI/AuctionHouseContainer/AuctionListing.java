package net.kingproductions.splitbornAPI.AuctionHouseContainer;

import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public interface AuctionListing {

    UUID getListingID();

    UUID getSellerUUID();
    String getSellerName();

    ItemStack getItem();
    int getAmount();

    int getStartingBid();
    int getBinPrice();
    boolean hasBin();

    long getCreatedAtMillis();
    long getEndTimeMillis();
    long getSecondsLeft();
    boolean isActive();

    int getCurrentBid();
    int getBidCount();
    UUID getHighestBidderUUID();
    String getHighestBidderName();

}
