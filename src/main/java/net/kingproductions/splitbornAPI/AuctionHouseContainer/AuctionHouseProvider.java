package net.kingproductions.splitbornAPI.AuctionHouseContainer;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

public interface AuctionHouseProvider {

    List<AuctionListing> getListings();
    List<AuctionListing> getListingsOf(UUID sellerUUID);
    List<AuctionListing> getListingsBidOnBy(UUID bidderUUID);
    AuctionListing getListing(UUID listingId);

    int getMinimumNextBid(UUID listingId);
    int getListingFee(int startingBid);

    /**
     * Lists an item on behalf of a player. The caller must have already removed
     * the item from the seller's inventory; when false is returned the caller
     * keeps ownership of the item.
     */
    boolean createListing(Player seller, ItemStack item, int startingBid, int binPrice, long durationMillis);
    boolean placeBid(Player bidder, UUID listingId, int amount);
    boolean buyNow(Player buyer, UUID listingId);
    boolean cancelListing(Player actor, UUID listingId);

    void openAuctionHouse(Player player);

}
