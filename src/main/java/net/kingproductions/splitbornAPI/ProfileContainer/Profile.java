package net.kingproductions.splitbornAPI.ProfileContainer;

import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.StatContainer.Stat;
import org.bukkit.entity.Player;

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

    void setBoolean(String path, boolean b);
    void setString(String path, String s);
    void setInteger(String path, int i);
    boolean getBoolean(String Path);
    String getString(String Path);
    int getInteger(String Path);

    void addUnclaimedItem(Item_ID itemId, int Amount);
    boolean getSetting_Drop_Announcement(int tier);

    String getPlayersRankAsString();

    void addEssence(Essence_ID essence, int amount);
    void removeEssence(Essence_ID essenceId, int Amount);

    int getEssence(Essence_ID essenceId);
    int getBaseStatValue(Stat stat);
    int getFullStatValue(Stat stat);

}