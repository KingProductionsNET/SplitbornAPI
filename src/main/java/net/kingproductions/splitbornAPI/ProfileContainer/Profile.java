package net.kingproductions.splitbornAPI.ProfileContainer;

import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.RankContainer.Ranks;
import net.kingproductions.splitbornAPI.StatContainer.Stat;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface Profile {

    UUID getUUID();
    int getXP();
    void setXP(int xp);

    int getGleams();
    int getLevel();
    int getMAX_HEALTH();
    int getSpeed();
    int getMAX_STAMINA();
    int getSupplyLevel();
    double getSupplyBonusChance();
    int getClaimedSupplies();
    int getRange();
    int getReelSpeed();
    int getLeap();
    int getHeat();
    int getExcavationSpeed();
    int getExcavationFortune();
    int getQuickTravelPoints();

    void setGleams(int amount);
    void setMAX_HEALTH(int amount);
    void setSPEED(int amount);
    void setMAX_STAMINA(int amount);
    void setSupplyLevel(int i);
    void setSupplyBonusChance(double i);
    void setClaimedSupplies(int i);
    void setRange(int i);
    void setReelSpeed(int i);
    void setLeap(int i);
    void setHeat(int i);
    void setExcavationSpeed(int i);
    void setExcavationFortune(int i);
    void setQuickTravelPoints(int i);

    void setStat(Stat stat, int i);

    void setBoolean(String path, boolean b);
    void setString(String path, String s);
    void setInteger(String path, int i);
    boolean getBoolean(String Path);
    String getString(String Path);
    int getInteger(String Path);
    Ranks getRank();

    void addUnclaimedItem(Item_ID itemId, int Amount, String reason);
    default void addUnclaimedItem(Item_ID itemId, int amount) {
        addUnclaimedItem(itemId, amount, null);
    }
    boolean getSetting_Drop_Announcement(int tier);

    String getPlayersRankAsString();

    void addEssence(Essence_ID essence, int amount);
    void removeEssence(Essence_ID essenceId, int Amount);

    void addSplitbornXP(int Amount);

    int getEssence(Essence_ID essenceId);
    int getBaseStatValue(Stat stat);
    int getFullStatValue(Stat stat);

    List<String> getStringList(String key);
    List<UUID> getUUIDList(String key);

    void setStringListSavingMap(String key, List<String> list);
    void setUUIDListSavingMap(String key, List<UUID> list);

}