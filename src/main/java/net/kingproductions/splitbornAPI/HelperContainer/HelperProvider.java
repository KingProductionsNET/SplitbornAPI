package net.kingproductions.splitbornAPI.HelperContainer;

import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
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

}
