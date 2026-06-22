package net.kingproductions.splitbornAPI.HelperContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import net.kingproductions.splitbornAPI.RarityContainer.Rarities;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface HelperProvider {

    void addToFreeActionBar(Player player, String Text);
    boolean completedTutorial(Player player);
    void setEntitySize(LivingEntity entity, double size);
    void DebugMessage(String Message);
    ItemStack DUMMY_GLEAMS();
    List<Location> getBlocksInCuboidAsList(Location pointA, Location pointB);
    int convertMillisInViewableInteger(long millis);
    String formatMobIDToViewableString(Mob_ID mobId);
    String formatEnumName(String input);
    String getGleamSymbol();
    String TaskDescSymbol();
    String getRewardSymbol();
    String getEssenceSymbol();
    String getHeartSymbol();
    String getListingSymbol();
    String getAttackDamageSymbol();
    String getSpeedSymbol();
    String getStaminaSymbol();
    String getEquipmentBonusSymbol();
    String getArrowSymbol();
    String getLocationSymbol();
    String getRangeSymbol();
    String getReelSpeedSymbol();
    String getTerrestrialSymbol();
    String getAquaticSymbol();
    boolean playerHasActiveQuest(Player player);
    boolean eligibleForUpgrade(int currentXP, int eventXP);
    void fireworkForLevelUpgrade(Player player);
    void upgradePlayersLevel(Player player, int eventXP);
    float ConvertVisualSpeedToUsableFloat(int intSpeed);
    int unclaimedRewardsCount(Player player);
    void handleBuyProcess(Player player, ItemStack BuyItem);
    void applyInventoryLook(Inventory inv, Material material, boolean TopBottom_Full);
    void applyImmortality(Entity e);
    void updatePlayersScoreboard(Player player);
    String getLoreReady_Health(int value);
    String getLoreReady_Stamina(int value);
    String getLoreReady_Speed(int value);
    String getLoreReady_AttackDamage(int value);
    String getLoreReady_Range(int value);
    String getLoreReady_ReelSpeed(int value);
    boolean isValidSplitbornItem(ItemStack itemStack);
    Item_ID getItemStacksItemID(ItemStack itemStack);
    Locations getPlayersLocation(Player player);
    String customSerialize(Location location);
    Location customDeserialize(String string);
    Locations getBukkitLocationsSplitbornLocation(Location location);
    int getPlayersTotalDamage(Player player);
    boolean isRPGMob(Entity e);
    void markInventoryChanged(Player player);
    int getPlayersExtraReelSpeed(Player player);
    String formatInteger(int i);
    String getTimeAgo(String longAsString);
    String getPlayersDisplayName(Player player);
    boolean bonusItemIsActive(Player player, Item_ID itemId);
    void fillInventory(Inventory inventory, Material material);
    Rarities getItemsRarity(ItemStack itemStack);

}
