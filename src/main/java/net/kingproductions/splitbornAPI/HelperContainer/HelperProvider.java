package net.kingproductions.splitbornAPI.HelperContainer;

import net.kingproductions.splitbornAPI.CommandBlockContainer.COMMAND_ID;
import net.kingproductions.splitbornAPI.EmblemContainer.EmblemID;
import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_Category;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.KillEffectsContainer.KillEffectID;
import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import net.kingproductions.splitbornAPI.MobContainer.MobCategory;
import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import net.kingproductions.splitbornAPI.PerkContainer.PerkID;
import net.kingproductions.splitbornAPI.RankContainer.Ranks;
import net.kingproductions.splitbornAPI.RarityContainer.Rarities;
import net.kingproductions.splitbornAPI.StatContainer.Stat;
import net.kingproductions.splitbornAPI.TalentContainer.TalentID;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;

public interface HelperProvider {

    /**
     * Adds text to the player's free actionbar area.
     * The text is stored for the player and automatically removed after approximately 3 seconds
     * if no newer actionbar text has replaced it.
     *
     * @param player the player who should receive the actionbar text
     * @param Text the text to display
     */
    void addToFreeActionBar(Player player, String Text);

    /**
     * Checks whether the player has completed the Chup Hunter quest, which is used
     * by Splitborn as the tutorial completion flag.
     *
     * @param player the player to check
     * @return true if the player has completed the tutorial quest, otherwise false
     */
    boolean completedTutorial(Player player);

    /**
     * Changes the visual scale of a living entity using its SCALE attribute.
     *
     * @param entity the living entity whose size should be changed
     * @param size the new entity scale, where 1.0 represents the default size
     */
    void setEntitySize(LivingEntity entity, double size);

    /**
     * Broadcasts a debug message to all online players.
     * The message is prefixed with "DEBUG: ".
     *
     * @param Message the debug message to broadcast
     */
    void DebugMessage(String Message);

    /**
     * Creates the legacy Gleams item represented by a player head.
     * The item contains the Gleams Item_ID in its hidden item data.
     *
     * @return an ItemStack representing Splitborn Gleams
     * @deprecated Use {@link net.kingproductions.splitbornAPI.ItemContainer.SplitbornItemProvider#getItem(Item_ID)}
     * instead
     */
    @Deprecated
    ItemStack DUMMY_GLEAMS();

    /**
     * Returns the locations of every block inside the cuboid defined by the two
     * supplied corner locations. Both corner blocks are included.
     *
     * @param pointA the first corner of the cuboid
     * @param pointB the second corner of the cuboid
     * @return a list containing the location of every block inside the cuboid
     */
    List<Location> getBlocksInCuboidAsList(Location pointA, Location pointB);

    /**
     * Converts milliseconds into whole seconds by dividing the value by 1000.
     *
     * @param millis the duration in milliseconds
     * @return the duration represented as whole seconds
     */
    int convertMillisInViewableInteger(long millis);

    /**
     * Converts a Mob_ID into a player-viewable string.
     *
     * @param mobId the Mob_ID to format
     * @return the formatted mob name
     */
    String formatMobIDToViewableString(Mob_ID mobId);

    /**
     * Converts an enum-style string such as "ATTACK_DAMAGE" into a readable
     * format such as "Attack Damage".
     *
     * @param input the enum name to format
     * @return the formatted, player-viewable string
     */
    String formatEnumName(String input);

    /**
     * @return the symbol used to represent Gleams
     */
    String getGleamSymbol();

    /**
     * @return the symbol used for task descriptions
     */
    String TaskDescSymbol();

    /**
     * @return the symbol used to represent rewards
     */
    String getRewardSymbol();

    /**
     * @return the symbol used to represent Essence
     */
    String getEssenceSymbol();

    /**
     * @return the symbol used to represent Health
     */
    String getHeartSymbol();

    /**
     * @return the symbol used for listings
     */
    String getListingSymbol();

    /**
     * @return the symbol used to represent Heat
     */
    String getHeatSymbol();

    /**
     * @return the symbol used to represent Attack Damage
     */
    String getAttackDamageSymbol();

    /**
     * @return the symbol used to represent Speed
     */
    String getSpeedSymbol();

    /**
     * @return the symbol used to represent Stamina
     */
    String getStaminaSymbol();

    /**
     * @return the symbol used to represent equipment bonuses
     */
    String getEquipmentBonusSymbol();

    /**
     * @return the symbol used for arrows
     */
    String getArrowSymbol();

    /**
     * @return the symbol used to represent locations
     */
    String getLocationSymbol();

    /**
     * @return the symbol used to represent Range
     */
    String getRangeSymbol();

    /**
     * @return the symbol used to represent Reel Speed
     */
    String getReelSpeedSymbol();

    /**
     * @return the symbol used to represent Terrestrial mobs
     */
    String getTerrestrialSymbol();

    /**
     * @return the symbol used to represent Aquatic mobs
     */
    String getAquaticSymbol();

    /**
     * @return the symbol used to represent Molten mobs
     */
    String getMoltenSymbol();

    /**
     * @return the symbol used to represent Leap
     */
    String getLeapSymbol();

    /**
     * @return the symbol used to represent Excavation Speed
     */
    String getExcavationSpeedSymbol();

    /**
     * @return the symbol used to represent Excavation Fortune
     */
    String getExcavationFortuneSymbol();

    /**
     * Checks whether the player currently has an active quest registered in the quest manager.
     *
     * @param player the player to check
     * @return true if the player currently has an active quest, otherwise false
     */
    boolean playerHasActiveQuest(Player player);

    /**
     * Checks whether the player's current XP combined with the supplied XP amount
     * reaches the configured level requirement.
     *
     * @param currentXP the player's current XP
     * @param eventXP the amount of XP being added
     * @return true if the combined XP is enough to trigger a level upgrade
     */
    boolean eligibleForUpgrade(int currentXP, int eventXP);

    /**
     * Spawns a sequence of four fireworks at the player's location to visually
     * indicate a level upgrade.
     *
     * @param player the player receiving the level-up effect
     */
    void fireworkForLevelUpgrade(Player player);

    /**
     * Processes a player's level upgrade using the supplied XP amount.
     * This handles additional levels, remaining XP, level-up events, level rewards,
     * scoreboard updates, fireworks, a level-up title/message and the level-up sound.
     *
     * @param player the player whose level should be upgraded
     * @param eventXP the amount of XP being added
     */
    void upgradePlayersLevel(Player player, int eventXP);

    /**
     * Converts the visual Splitborn Speed stat into the usable Minecraft movement
     * speed value using the configured visual range of 100-500.
     *
     * @param intSpeed the visual Splitborn Speed value
     * @return the corresponding usable movement speed value
     */
    float ConvertVisualSpeedToUsableFloat(int intSpeed);

    /**
     * Counts the number of currently unclaimed item rewards stored for the player.
     *
     * @param player the player whose unclaimed rewards should be counted
     * @return the number of unclaimed rewards
     */
    int unclaimedRewardsCount(Player player);

    /**
     * Processes the purchase of an item from an NPC shop.
     * The method checks the required Gleams, Essence and items, verifies inventory space,
     * removes the required costs and gives the purchased item to the player.
     *
     * @param player the player attempting to make the purchase
     * @param BuyItem the shop item containing the purchase information and price
     */
    void handleBuyProcess(Player player, ItemStack BuyItem);

    /**
     * Applies decorative items to the border of an inventory.
     * When TopBottom_Full is true, only the top and bottom rows are filled.
     * Otherwise, the left and right columns are filled as well.
     *
     * @param inv the inventory to decorate
     * @param material the material used for the decorative items
     * @param TopBottom_Full whether only the top and bottom rows should be filled
     */
    void applyInventoryLook(Inventory inv, Material material, boolean TopBottom_Full);

    /**
     * Makes an entity invulnerable and registers it as an immortal Splitborn entity.
     *
     * @param e the entity to make immortal
     */
    void applyImmortality(Entity e);

    /**
     * Removes Splitborn immortality from an entity and makes it vulnerable to damage again.
     *
     * @param e the entity to remove immortality from
     */
    void removeImmortality(Entity e);

    /**
     * Updates the player's Splitborn scoreboard.
     *
     * @param player the player whose scoreboard should be updated
     */
    void updatePlayersScoreboard(Player player);

    /**
     * Formats a Health stat value as a player-viewable item lore line.
     * Positive values receive a "+" prefix and zero is displayed as "?".
     *
     * @param value the Health value
     * @return the formatted Health lore line
     */
    String getLoreReady_Health(int value);

    /**
     * Formats a Stamina stat value as a player-viewable item lore line.
     * Positive values receive a "+" prefix and zero is displayed as "?".
     *
     * @param value the Stamina value
     * @return the formatted Stamina lore line
     */
    String getLoreReady_Stamina(int value);

    /**
     * Formats a Speed stat value as a player-viewable item lore line.
     * Positive values receive a "+" prefix and zero is displayed as "?".
     *
     * @param value the Speed value
     * @return the formatted Speed lore line
     */
    String getLoreReady_Speed(int value);

    /**
     * Formats an Attack Damage stat value as a player-viewable item lore line.
     * Positive values receive a "+" prefix and zero is displayed as "?".
     *
     * @param value the Attack Damage value
     * @return the formatted Attack Damage lore line
     */
    String getLoreReady_AttackDamage(int value);

    /**
     * Formats a Range stat value as a player-viewable item lore line.
     * Positive values receive a "+" prefix and zero is displayed as "?".
     *
     * @param value the Range value
     * @return the formatted Range lore line
     */
    String getLoreReady_Range(int value);

    /**
     * Formats a Reel Speed stat value as a player-viewable item lore line.
     * Positive values receive a "+" prefix and zero is displayed as "?".
     *
     * @param value the Reel Speed value
     * @return the formatted Reel Speed lore line
     */
    String getLoreReady_ReelSpeed(int value);

    /**
     * Formats a Heat stat value as a player-viewable item lore line.
     * Positive values receive a "+" prefix and zero is displayed as "?".
     *
     * @param value the Heat value
     * @return the formatted Heat lore line
     */
    String getLoreReady_Heat(int value);

    /**
     * Formats an Excavation Speed stat value as a player-viewable item lore line.
     * Positive values receive a "+" prefix and zero is displayed as "?".
     *
     * @param value the Excavation Speed value
     * @return the formatted Excavation Speed lore line
     */
    String getLoreReady_ExcavationSpeed(int value);

    /**
     * Formats an Excavation Fortune stat value as a player-viewable item lore line.
     * Positive values receive a "+" prefix and zero is displayed as "?".
     *
     * @param value the Excavation Fortune value
     * @return the formatted Excavation Fortune lore line
     */
    String getLoreReady_ExcavationFortune(int value);

    /**
     * Checks whether an ItemStack is a valid Splitborn item.
     * A valid Splitborn item must contain both a valid Item_ID and item rarity
     * in its hidden item data.
     *
     * @param itemStack the item to check
     * @return true if the ItemStack is a valid Splitborn item, otherwise false
     */
    boolean isValidSplitbornItem(ItemStack itemStack);

    /**
     * Retrieves the Splitborn Item_ID stored inside an ItemStack's hidden item data.
     *
     * @param itemStack the item whose Item_ID should be retrieved
     * @return the Item_ID stored in the item, or null if the item is not a Splitborn item
     */
    Item_ID getItemStacksItemID(ItemStack itemStack);

    /**
     * Gets the Splitborn location in which the player is currently located.
     * If no location has been registered for the player, Hearthgrove is returned.
     *
     * @param player the player whose location should be retrieved
     * @return the player's current Splitborn location
     */
    Locations getPlayersLocation(Player player);

    /**
     * Serializes a Bukkit Location into a String containing its world, coordinates,
     * pitch and yaw.
     *
     * @param location the location to serialize
     * @return the serialized location
     */
    String customSerialize(Location location);

    /**
     * Deserializes a location previously created by {@link #customSerialize(Location)}
     * back into a Bukkit Location.
     *
     * @param string the serialized location
     * @return the deserialized Bukkit Location
     */
    Location customDeserialize(String string);

    /**
     * Determines the Splitborn location represented by a Bukkit location.
     * When multiple location zones contain the location, the zone with the highest
     * priority is selected.
     *
     * @param location the Bukkit location to check
     * @return the corresponding Splitborn location
     */
    Locations getBukkitLocationsSplitbornLocation(Location location);

    /**
     * Calculates the player's total Attack Damage by combining their permanent
     * Attack Damage with their currently active temporary Attack Damage.
     *
     * @param player the player whose total Attack Damage should be calculated
     * @return the player's total Attack Damage
     */
    int getPlayersTotalDamage(Player player);

    /**
     * Checks whether an entity has a Splitborn Mob_ID stored in its metadata.
     *
     * @param e the entity to check
     * @return true if the entity has the MOB_ID metadata, otherwise false
     */
    boolean isRPGMob(Entity e);

    /**
     * Marks the player's inventory as changed so that the inventory saving system
     * knows it needs to be updated.
     *
     * @param player the player whose inventory should be marked as changed
     */
    void markInventoryChanged(Player player);

    /**
     * Gets the player's currently active temporary Reel Speed bonus.
     *
     * @param player the player whose temporary Reel Speed should be retrieved
     * @return the player's additional temporary Reel Speed
     */
    int getPlayersExtraReelSpeed(Player player);

    /**
     * Formats an integer using a period as the thousands separator.
     * For example, 10000 becomes "10.000".
     *
     * @param i the integer to format
     * @return the formatted integer
     */
    String formatInteger(int i);

    /**
     * Converts a timestamp into a human-readable description of how long ago it occurred.
     * The result is expressed in seconds, minutes, hours or days depending on the elapsed time.
     *
     * @param longAsString the timestamp in milliseconds represented as a String
     * @return a human-readable description of how long ago the timestamp occurred
     */
    String getTimeAgo(String longAsString);

    /**
     * Returns the player's display name including the color associated with their rank.
     *
     * @param player the player whose display name should be retrieved
     * @return the rank-colored player name
     */
    String getPlayersDisplayName(Player player);

    /**
     * Checks whether the specified bonus item is currently equipped by the player
     * in one of their bonus item slots.
     *
     * @param player the player to check
     * @param itemId the bonus item to search for
     * @return true if the specified bonus item is active, otherwise false
     */
    boolean bonusItemIsActive(Player player, Item_ID itemId);

    /**
     * Fills every slot in an inventory with an item made from the specified material.
     *
     * @param inventory the inventory to fill
     * @param material the material used for the filler items
     */
    void fillInventory(Inventory inventory, Material material);

    /**
     * Retrieves the rarity stored in a valid Splitborn ItemStack.
     *
     * @param itemStack the item whose rarity should be retrieved
     * @return the item's rarity, or null if the item is invalid or its rarity cannot be determined
     */
    Rarities getItemsRarity(ItemStack itemStack);

    /**
     * Applies the visual rarity glow to a dropped item and registers its rarity
     * with the Splitborn rarity glow manager.
     *
     * @param item the dropped item to make glowing
     * @param rarity the rarity that determines its glow color
     */
    void applyRarityGlow(Item item, Rarities rarity);

    /**
     * Checks whether the player is currently wearing the specified Splitborn item
     * in the equipment slot corresponding to the item's category.
     *
     * @param player the player to check
     * @param itemId the item that should be checked
     * @return true if the player is wearing the specified item, otherwise false
     */
    boolean isWearing(Player player, Item_ID itemId);

    /**
     * Checks whether the specified Splitborn item is currently held in the player's main hand.
     *
     * @param player the player to check
     * @param itemId the item that should be checked
     * @return true if the player is holding the specified item, otherwise false
     */
    boolean isHolding(Player player, Item_ID itemId);

    /**
     * Checks whether the player's inventory contains at least one valid Splitborn item
     * with the specified Item_ID.
     *
     * @param player the player to check
     * @param itemId the item to search for
     * @return true if the specified item is present in the inventory, otherwise false
     */
    boolean inventoryContains(Player player, Item_ID itemId);

    /**
     * Retrieves the Item_Category stored in the item's hidden item data.
     *
     * @param itemId the Item_ID whose category should be retrieved
     * @return the category of the specified item, or null if no category is stored
     */
    Item_Category getItemCategory(Item_ID itemId);

    /**
     * Adds Splitborn XP to the player.
     * If the added XP reaches the level requirement, the player's level is upgraded;
     * otherwise the XP is added directly to their current XP.
     *
     * @param player the player receiving the XP
     * @param Amount the amount of Splitborn XP to add
     */
    void addSplitbornXP(Player player, int Amount);

    /**
     * Gets the icon associated with the specified emblem.
     *
     * @param emblemID the emblem whose icon should be retrieved
     * @return the emblem icon
     */
    String getEmblemIcon(EmblemID emblemID);

    /**
     * Creates the player-viewable name of an emblem including its color and icon.
     *
     * @param emblemID the emblem to format
     * @return the formatted emblem name
     */
    String getEmblem(EmblemID emblemID);

    /**
     * Spawns an arrow with the supplied direction and speed and marks it with the
     * shooter's name. The arrow cannot be picked up and optionally can be hidden
     * from other players. The shooter also receives arrow particles while it exists.
     *
     * @param shooter the player who fired the arrow
     * @param spawnLocation the location where the arrow should spawn
     * @param direction the direction in which the arrow travels
     * @param speed the arrow's velocity
     * @param visibleForEveryone whether the arrow should be visible to every player
     * @return the spawned arrow
     */
    Arrow spawnBowArrow(Player shooter, Location spawnLocation, Vector direction, int speed, boolean visibleForEveryone);

    /**
     * Checks whether a solid block is located between two locations using a Bukkit
     * block ray trace.
     *
     * @param loc1 the starting location of the ray trace
     * @param loc2 the target location of the ray trace
     * @return true if a block is detected between the two locations, otherwise false
     */
    boolean blockIsBetween(Location loc1, Location loc2);

    /**
     * Counts the total amount of the specified Splitborn item across every inventory
     * slot of the player.
     *
     * @param player the player whose inventory should be checked
     * @param itemId the item to count
     * @return the total amount of the specified item
     */
    int getPlayersItemCountInWholeInventory(Player player, Item_ID itemId);

    /**
     * Applies damage to the player's configured damage dummy.
     * The dummy is used as the damage source and its custom name is updated first.
     *
     * @param target the player whose damage dummy should deal the damage
     * @param Damage the amount of damage to apply
     * @param CustomName the custom name assigned to the damage dummy
     */
    void applyDummyDamage(Player target, int Damage, String CustomName);

    /**
     * Removes the specified amount of an item from the player's inventory.
     * Item stacks are consumed from the beginning of the inventory until the
     * requested amount has been removed or no matching items remain.
     *
     * @param player the player whose inventory should be modified
     * @param itemId the item to remove
     * @param Amount the amount to remove
     */
    void removeItemAmountFromInventory(Player player, Item_ID itemId, int Amount);

    /**
     * Temporarily modifies one of the player's stats by the specified amount.
     * The modification is automatically reverted after the supplied duration.
     * If this shouldn't expire automatically the Duration should be -1 or INTEGER.MAX_VALUE.
     *
     * @param player the player whose stat should be modified
     * @param stat the stat to modify
     * @param Amount the amount to add temporarily
     * @param Duration_In_Ticks the duration of the modification in ticks
     */
    void modifyPlayersStatTemporarily(Player player, Stat stat, int Amount, int Duration_In_Ticks);

    /**
     * Temporarily modifies one of the player's stats and associates the modification
     * with a specific reason. The modification is automatically reverted after
     * the supplied duration. If this shouldn't expire automatically the Duration should be -1 or INTEGER.MAX_VALUE.
     *
     * @param player the player whose stat should be modified
     * @param Reason the reason used to identify the temporary modification
     * @param stat the stat to modify
     * @param Amount the amount to add temporarily
     * @param Duration_In_Ticks the duration of the modification in ticks
     */
    void modifyPlayersStatTemporarily(Player player, String Reason, Stat stat, int Amount, int Duration_In_Ticks);

    /**
     * Gets the amount of a temporary stat modification currently active under
     * the specified reason.
     *
     * @param player the player whose modification should be checked
     * @param Reason the reason associated with the modification
     * @param stat the stat to retrieve
     * @return the currently active amount for the specified reason and stat
     */
    int getPlayersModifiedStatAmountByReason(Player player, String Reason, Stat stat);

    /**
     * Applies Heat to the player by firing a HeatGainEvent.
     * A one-tick cooldown prevents multiple Heat events from being triggered
     * for the same player within the same tick.
     *
     * @param player the player receiving Heat
     * @param Amount the amount of Heat to apply
     */
    void applyHeat(Player player, int Amount);

    /**
     * Gets all Splitborn bonus items currently equipped by the player.
     *
     * @param player the player whose equipped bonus items should be retrieved
     * @return a list of the player's equipped bonus item IDs
     */
    List<Item_ID> getPlayersEquippedBonusItems(Player player);

    /**
     * Sets a cooldown for the specified item for the player.
     * The cooldown is stored internally and automatically removed after the
     * specified duration.
     *
     * @param player the player receiving the cooldown
     * @param itemId the item whose cooldown should be set
     * @param Duration_In_Seconds the cooldown duration in seconds
     */
    void setItemCooldownForPlayer(Player player, Item_ID itemId, int Duration_In_Seconds);

    /**
     * Gets the remaining cooldown of an item in whole seconds.
     *
     * @param player the player whose cooldown should be checked
     * @param itemId the item whose cooldown should be retrieved
     * @return the remaining cooldown in seconds
     */
    int getCooldownInSeconds(Player player, Item_ID itemId);

    /**
     * Sends the player a message displaying the remaining cooldown of the specified item.
     *
     * @param player the player who should receive the cooldown message
     * @param itemId the item whose cooldown should be displayed
     */
    void sendCooldownMessage(Player player, Item_ID itemId);

    /**
     * Checks whether the specified entity is currently registered as immortal.
     *
     * @param e the entity to check
     * @return true if the entity is registered as immortal, otherwise false
     */
    boolean isImmortal(Entity e);

    /**
     * Gets the MobCategory associated with a Mob_ID.
     *
     * @param mobId the Mob_ID whose category should be retrieved
     * @return the corresponding MobCategory, or null if none is found
     */
    MobCategory getMobCategory(Mob_ID mobId);

    /**
     * Retrieves the Mob_ID stored in an entity's MOB_ID metadata.
     *
     * @param e the entity whose Mob_ID should be retrieved
     * @return the entity's Mob_ID, or null if it does not contain a valid Mob_ID
     */
    Mob_ID getMobID(Entity e);

    /**
     * Gets the player's currently stored Heat value.
     *
     * @param player the player whose Heat should be retrieved
     * @return the player's current Heat
     */
    int getPlayersCurrentHeat(Player player);

    /**
     * Checks whether the player currently has the ON_TOUR metadata.
     *
     * @param player the player to check
     * @return true if the player is currently on a tour, otherwise false
     */
    boolean playerIsOnTour(Player player);

    /**
     * Creates a locked placeholder item for an NPC shop.
     * The supplied description is displayed as the item's lore below an empty line.
     *
     * @param description the description explaining the locked shop entry
     * @return the locked placeholder ItemStack
     */
    ItemStack getPlaceholderLockedItemForNPCShop(List<String> description);

    /**
     * Checks whether the player has at least one completely empty inventory slot.
     *
     * @param player the player to check
     * @return true if the player has an empty inventory slot, otherwise false
     */
    boolean playerHasFreeInventorySpace(Player player);

    /**
     * Forces the player's current location to be processed by the Splitborn
     * location discovery system.
     *
     * @param player the player whose location should be updated
     */
    void forceUpdatePlayersLocation(Player player);

    /**
     * Gets the rank-colored display name of an offline player using their UUID.
     * The player's saved rank and name are used to construct the display name.
     *
     * @param Name the UUID of the player
     * @return the rank-colored display name of the player
     */
    String getOfflinePlayersDisplayNameByUUID(UUID Name);

    /**
     * Adds Ashvein Points to the player, up to the configured maximum Ashvein Points.
     * The player's scoreboard is updated after the points are added.
     *
     * @param player the player receiving Ashvein Points
     * @param Amount the amount of Ashvein Points to add
     */
    void addAshveinPoints(Player player, int Amount);

    /**
     * Converts an integer from 1 to 100 into its Roman numeral representation.
     *
     * @param input the number to convert
     * @return the Roman numeral representation, or an error message if the number
     *         is outside the supported range
     */
    String convertToRomanNumber(int input);

    /**
     * Gets the display symbol associated with the specified stat.
     *
     * @param stat the stat whose symbol should be retrieved
     * @return the symbol associated with the stat
     */
    String getStatSymbol(Stat stat);

    /**
     * Checks whether the entity is registered as a Splitborn NPC.
     *
     * @param e the entity to check
     * @return true if the entity is registered as a Splitborn NPC, otherwise false
     */
    boolean isSplitbornNPC(Entity e);

    /**
     * Gets the Bukkit ChatColor used to display the specified stat.
     *
     * @param stat the stat whose display color should be retrieved
     * @return the color associated with the stat
     */
    ChatColor getStatsColor(Stat stat);

    /**
     * Returns the player-viewable name of the Gleams currency including its symbol.
     *
     * @return the formatted Gleams name
     */
    String getGleamString();

    /**
     * Prevents the player from shooting a bow through the Splitborn bow shooting
     * restriction system.
     *
     * @param player the player whose bow shooting should be disabled
     */
    void disableBowShooting(Player player);

    /**
     * Removes the bow shooting restriction from the player.
     *
     * @param player the player whose bow shooting should be enabled
     */
    void enableBowShooting(Player player);

    /**
     * @return the symbol used to represent cooldowns
     */
    String getCooldownSymbol();

    /**
     * Gets all currently active perks equipped by the player.
     * Up to three perk slots are checked.
     *
     * @param player the player whose active perks should be retrieved
     * @return a list containing all currently active perks
     */
    List<PerkID> getAllActivePerks(Player player);

    /**
     * Checks whether the specified perk is currently active for the player.
     *
     * @param player the player to check
     * @param perkID the perk to check
     * @return true if the perk is currently active, otherwise false
     */
    boolean perkIsActive(Player player, PerkID perkID);

    /**
     * Marks the specified perk as unlocked in the player's profile.
     *
     * @param player the player whose perk should be unlocked
     * @param perkID the perk to unlock
     */
    void unlockPerk(Player player, PerkID perkID);

    /**
     * Creates a player-viewable reward string for an item reward.
     *
     * @param itemId the item being rewarded
     * @param Amount the amount being rewarded
     * @return a formatted item reward string
     */
    String getItemRewardString(Item_ID itemId, int Amount);

    /**
     * Creates a player-viewable reward string for an Essence reward.
     *
     * @param essenceId the Essence type being rewarded
     * @param Amount the amount being rewarded
     * @return a formatted Essence reward string
     */
    String getEssenceRewardString(Essence_ID essenceId, int Amount);

    /**
     * Creates a player-viewable reward string for Splitborn XP.
     *
     * @param Amount the amount of Splitborn XP being rewarded
     * @return a formatted Splitborn XP reward string
     */
    String getSplitbornXPRewardString(int Amount);

    /**
     * Creates a player-viewable reward string for Gleams.
     *
     * @param Amount the amount of Gleams being rewarded
     * @return a formatted Gleam reward string
     */
    String getGleamRewardString(int Amount);

    /**
     * Gets the databank path containing the specified perk in one of the player's
     * active perk slots.
     *
     * @param player the player whose active perk slots should be searched
     * @param perkID the perk whose databank path should be retrieved
     * @return the matching perk path, or the first perk path if the perk is not found
     */
    String getActivePerksDatabankPath(Player player, PerkID perkID);

    /**
     * Creates a player-viewable reward string for a stat increase.
     *
     * @param stat the stat being rewarded
     * @param Amount the amount of the stat increase
     * @return a formatted stat reward string
     */
    String getStatRewardString(Stat stat, int Amount);

    /**
     * Finds the first empty active perk slot in the player's profile.
     *
     * @param player the player whose perk slots should be checked
     * @return the databank path of the first free perk slot, or null if all slots are occupied
     */
    String getFreePerkPath(Player player);

    /**
     * Gets the player's currently selected Kill Effect.
     *
     * @param player the player whose active Kill Effect should be retrieved
     * @return the active KillEffectID, or null if none is selected or the stored value is invalid
     */
    KillEffectID getActiveKillEffect(Player player);

    /**
     * Gets all Kill Effects currently owned by the player.
     *
     * @param player the player whose owned Kill Effects should be retrieved
     * @return a list containing all owned Kill Effect IDs
     */
    List<KillEffectID> getOwnedKillEffects(Player player);

    /**
     * Marks a dropped item as not pickable by adding it to the Splitborn
     * not-pickable item registry.
     *
     * @param item the dropped item that should not be pickable
     */
    void applyNotPickableToItem(Item item);

    /**
     * Generates a random location within the supplied radius of the center location.
     * The Y coordinate remains unchanged.
     *
     * @param center the center location
     * @param radius the maximum horizontal offset
     * @return a randomly generated location around the center
     */
    Location getRandomLocation(Location center, int radius);

    /**
     * Rotates an entity so that it faces the supplied target location.
     * Armor Stands are handled separately to rotate their body and head pose.
     *
     * @param e the entity that should face the target
     * @param targetLocation the location the entity should face
     */
    void forceEntityToFaceLocation(Entity e, Location targetLocation);

    /**
     * Makes an entity glow for the specified player, or for every online player
     * when the player parameter is null. The supplied ChatColor determines
     * the glow color through the player's scoreboard team.
     *
     * @param entity the entity that should glow
     * @param chatColor the color of the entity's glow
     * @param player the player who should see the glow, or null for everyone
     */
    void applyGlowToEntity(Entity entity, ChatColor chatColor, Player player);

    /**
     * Allows the player to interact with the specified block location through
     * Splitborn's custom block interaction system.
     *
     * @param player the player who should be allowed to interact
     * @param location the block location to allow
     */
    void addAllowedInteractBlock(Player player, Location location);

    /**
     * Removes the specified block location from the player's allowed interaction locations.
     *
     * @param player the player whose interaction permission should be removed
     * @param location the block location to remove
     */
    void removeAllowedInteractBlock(Player player, Location location);

    /**
     * Heals the player's health by the specified amount without exceeding
     * their maximum health.
     *
     * @param player the player to heal
     * @param Amount the amount of health to restore
     */
    void healPlayerHealth(Player player, int Amount);

    /**
     * Gets all nearby mobs within 50 blocks that currently target the specified player.
     *
     * @param player the player whose targeting mobs should be retrieved
     * @return a list of nearby mobs currently targeting the player
     */
    List<Mob> getTargetingMobsForPlayer(Player player);

    /**
     * Prevents the player from using Splitborn Quick Travel.
     *
     * @param player the player whose Quick Travel should be blocked
     */
    void BlockQuickTravel(Player player);

    /**
     * Removes the Quick Travel restriction from the player.
     *
     * @param player the player whose Quick Travel should be unblocked
     */
    void UnblockQuickTravel(Player player);

    /**
     * Adds an entity to the player's protected text-display view list and ensures
     * the player can see the entity. Entities registered here are protected from
     * automatic view-range hiding.
     *
     * @param player the player whose view list should be updated
     * @param entity the entity that should be protected from view-range hiding
     */
    void addNotAllowedForViewRangeTextEntity(Player player, Entity entity);

    /**
     * Hides a TextDisplay specifically from the supplied player and registers it
     * so that the automatic view-range system does not immediately show it again.
     *
     * @param textDisplay the TextDisplay to hide
     * @param player the player who should no longer see the TextDisplay
     */
    void hideTextDisplay(TextDisplay textDisplay, Player player);

    /**
     * Shows a previously hidden TextDisplay to the supplied player and removes it
     * from the player's protected hidden-entity list.
     *
     * @param textDisplay the TextDisplay to show
     * @param player the player who should see the TextDisplay
     */
    void unhideTextDisplay(TextDisplay textDisplay, Player player);

    /**
     * Spawns a Mannequin at the specified location and applies a player skin
     * using the supplied texture value and signature.
     *
     * @param SpawnLocation the location where the Mannequin should be spawned
     * @param Value the Base64 skin texture value
     * @param Signature the signature associated with the skin texture
     * @return the spawned Mannequin
     */
    Mannequin spawnMannequin(Location SpawnLocation, String Value, String Signature);

    /**
     *
     * @return The symbol of the Veilborn Mob Category
     */
    String getVeilbornSymbol();

    /**
     *
     * @return A set of all blocked commands for the player.
     */
    Set<COMMAND_ID> getBlockedCommands(Player player);

    /**
     * Adds a location that is allowed for breaking.
     * @param player
     * @param allowedLocation The location that can be broken.
     */
    void addAllowedBlockBreakLocation(Player player, Location allowedLocation);
    /**
     * Removes a location that is allowed for breaking.
     * @param player
     * @param allowedLocation The location that can no longer be broken.
     */
    void removeAllowedBlockBreakLocation(Player player, Location allowedLocation);

    /**
     *
     * @param player
     * @return A list of all allowed break locations for the player.
     */
    Set<Location> getAllowedBlockBreakLocations(Player player);

    /**
     *
     * @return All advantages of the Flex Pass
     */
    List<String> getFlexPassAdvantages();

    /**
     * Sends a message that player needs a flex pass to perform this.
     * @param player
     */
    void sendPurchaseFlexPassMessage(Player player);

    /**
     *
     * @param player
     * @return The Rank and players name with correct color e.g. [ADMIN] ReverseHonig
     */
    String getPlayersDisplayNameWithRank(Player player);

    /**
     *
     * @param rank
     * @return The color of the given Rank
     */
    ChatColor getRanksColor(Ranks rank);

    /**
     * Locks the given Stat to a specific amount meaning it's amount can't change,
     * until it gets unlocked by {@link net.kingproductions.splitbornAPI.HelperContainer.HelperProvider#unlockStat(Player, Stat)}.
     * Use {@link net.kingproductions.splitbornAPI.HelperContainer.HelperProvider#lockMultipleStats(Player, Map)} when trying to lock multiple stats.
     * Stamina can be set to infinite by setting the amount to -1
     * @param player
     * @param stat The stat that should be locked
     * @param Amount The Amount to which the stat should be locked
     */
    void lockStat(Player player, Stat stat, int Amount);

    /**
     * Locks multiple Stats to a specific amount meaning their amount can't change
     * until it gets unlocked by {@link net.kingproductions.splitbornAPI.HelperContainer.HelperProvider#unlockStat(Player, Stat)}.
     * Use {@link net.kingproductions.splitbornAPI.HelperContainer.HelperProvider#lockStat(Player, Stat, int)} when trying to just lock one stat.
     * Stamina can be set to infinite by setting the amount to -1
     * @param player
     * @param map The map which locks the given stat with the value amount.
     */
    void lockMultipleStats(Player player, Map<Stat, Integer> map);

    /**
     * Unlocks a Stat which has been locked by {@link net.kingproductions.splitbornAPI.HelperContainer.HelperProvider#lockStat(Player, Stat, int)}
     * @param player
     * @param stat The Stat that should be unlocked
     */
    void unlockStat(Player player, Stat stat);

    /**
     * Returns a String which can be used in inventories where essence is included in the costs.
     * @param essenceId the essence which is used for the costs.
     * @param Amount the amount of the essence.
     * @return An inventory ready string for a cost list
     */
    String getEssenceIDAsCostString(Essence_ID essenceId, int Amount);
    /**
     * Returns a String which can be used in inventories where the itemId is included in the costs.
     * @param itemId the itemId which is used for the costs.
     * @param Amount the amount of the itemId.
     * @return An inventory ready string for a cost list
     */
    String getItemIDAsCostString(Item_ID itemId, int Amount);

    /**
     * Returns a cost list for inventory lore.
     * @param map_items the map containing itemIds including their amounts
     * @param map_essence the map containing essenceIds including their amounts
     * @return
     */
    List<String> getCostList(Map<Item_ID, Integer> map_items, Map<Essence_ID, Integer> map_essence);

    /**
     *
     * @param player
     * @param talentID
     * @return True if the player owns this Talent
     */
    boolean isOwningTalent(Player player, TalentID talentID);

    /**
     * Simulates the player fishing something out.
     * @param player
     * @param mobId The mobId that is being fished
     * @param startLocation The location where the mob will spawn
     * @param targetLocation The location to where the mob should fly to
     */
    void simulateFishingCatch(Player player, Mob_ID mobId, Location startLocation, Location targetLocation);

    /**
     * Simulates the player fishing something out.
     * @param player
     * @param itemStack The itemstack that is being fished
     * @param startLocation The location where the item will spawn
     * @param targetLocation The location to where the item should fly to
     */
    void simulateFishingCatch(Player player, ItemStack itemStack, Location startLocation, Location targetLocation);

    /**
     *
     * @return If the Deepwake Event is active
     */
    boolean theDeepwakeEventIsActive();

    /**
     *
     * @return If the event is active it returns remaining time in HH:MM:SS till until the event starts. If the event is active it returns the remaining time in HH:MM:SS until the event ends.
     */
    String getDeepwakeEventTimer();

    /**
     * Resets the players modified stat which got changed by a reason. This should only be used if the stat got modified by {@link net.kingproductions.splitbornAPI.HelperContainer.HelperProvider#modifyPlayersStatTemporarily(Player, String, Stat, int, int)} and doesn't expire on its own, cause the duration is INTEGER.MAX_VALUE or -1
     * @param player
     * @param Reason The reason why that stat was changed.
     * @param stat The stat that should be reset 0
     */
    void resetPlayersModifiedStatByReason(Player player, String Reason, Stat stat);

    /**
     *
     * @return A list of all available itemIds during The Deepwake.
     */
    List<Item_ID> getTheDeepwakePossibleDrops();

    /**
     *
     * @return A list of all available mobIds during The Deepwake.
     */
    List<Mob_ID> getTheDeepwakePossibleMobs();

    /**
     *
     * @param player
     * @return True if the player is currently a passenger on another entity.
     */
    boolean playerIsRiding(Player player);

    /**
     * Creates a purchasable item with attached purchase logic, which will be executed as soon as it's being clicked & and if the player has the required items.
     * @param player The player which will see this item.
     * @param costData The data which contains the required items/essence.
     * @param lore The lore of the item (without the cost list).
     * @param material The material of purchasable item.
     * @param displayName The display name of the item.
     * @param skullValue The skull value of the material if it's a player head. This can be null if the material is no player head.
     * @param consumer The purchase logic. It should only focus on updating values. Costs, such as Gleams, are removed automatically same as scoreboard refresh.
     * @param purchaseStop Set this boolean to true whenever the player should no longer be able to purchase this.
     * @return A purchasable ItemStack
     */
    ItemStack createPurchasableItem(Player player, CostData costData, Material material, String displayName, String skullValue, List<String> lore, Consumer<Player> consumer, boolean purchaseStop);
    /**
     * Creates a purchasable item with attached purchase logic, which will be executed as soon as it's being clicked & and if the player has the required items.
     * @param player The player which will see this item.
     * @param costData The data which contains the required items/essence.
     * @param consumer The purchase logic. It should only focus on updating values. Costs, such as Gleams, are removed automatically same as scoreboard refresh.
     * @param purchaseObject The object which is being sold. Following can be sold:
     * {@link net.kingproductions.splitbornAPI.TalentContainer.TalentID} {@link net.kingproductions.splitbornAPI.PerkContainer.PerkID} {@link net.kingproductions.splitbornAPI.KillEffectsContainer.KillEffectID} {@link net.kingproductions.splitbornAPI.EmblemContainer.EmblemID}
     * @return A purchasable ItemStack
     */
    ItemStack createPurchasablePresetItem(Player player, CostData costData, Consumer<Player> consumer, Object purchaseObject);

    /**
     * @param player The player that is being checked.
     * @param itemStack The item that should be checked, and where the CostData is taken from.
     * @return True if the player has all the required items/essence.
     */
    boolean canAfford(Player player, ItemStack itemStack);

    /**
     * Executes the purchase logic of this item (if it has one)
     * @param player The consumer of the execution code.
     * @param stack The item that should be checked.
     */
    void executeItemsPurchaseLogic(Player player, ItemStack stack);

    /**
     * Creates an item which has a hidden execute logic when its being clicked. The hidden code will be executed to the player (clicker) at any time this item is being clicked.
     * @param consumer The hidden code which will be executed when this item is being clicked.
     * @param displayName The display name of this item.
     * @param lore The lore of this item.
     * @param allowedInventoryTitle If this item should only execute its code in a specific inventory, set this to the title of it. If it should work in any inventory set it to null
     * @param material The material of the ItemStack.
     * @param skullValue The skull value of the material if it's a player head.
     * @return A functional item which does something when its being clicked.
     */
    ItemStack createExecutableInventoryItem(Consumer<Player> consumer, String displayName, List<String> lore, String allowedInventoryTitle, Material material, String skullValue);

    /**
     * Unlocks a talent.
     * @param player
     * @param talentID
     */
    void unlockTalent(Player player, TalentID talentID);

    /**
     * Unlocks a emblem.
     * @param player
     * @param emblemID
     */
    void unlockEmblem(Player player, EmblemID emblemID);

    /**
     * Unlocks a kill effect.
     * @param player
     * @param killEffectID
     */
    void unlockKillEffect(Player player, KillEffectID killEffectID);

    /**
     * Creates an inventory.
     * @param player The owner of the inventory.
     * @param size The size of the inventory.
     * @param title The title of the inventory.
     * @param clickable Set to false if player's shouldn't be allowed to take items out of this inventory. (Basically always)
     * @return An inventory.
     */
    Inventory createInventory(Player player, int size, String title, boolean clickable);

    /**
     * Converts costData which is being used for purchasable items, into a list which can be used in the item lore.
     * @param costData The costData which should be converted into a list.
     * @return A list
     */
    List<String> convertCostDataToList(CostData costData);
}
