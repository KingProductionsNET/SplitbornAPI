package net.kingproductions.splitbornAPI.ProfileContainer;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import org.bukkit.entity.Player;

import java.util.UUID;

public interface Profile {

    UUID getUUID();
    int getXP();
    void setXP(int xp);

    boolean getBoolean(String Path);
    String getString(String Path);
    int getInteger(String Path);

    int getGleams();
    int getLevel();
    int getMAX_HEALTH();
    int getSpeed();
    int getMAX_STAMINA();

    void setBoolean(String path, boolean b);
    void setString(String path, String s);
    void setInteger(String path, int i);
    void setGleams(int amount);
    void setMAX_HEALTH(int amount);
    void setSPEED(int amount);
    void setMAX_STAMINA(int amount);

    void addUnclaimedItem(Item_ID itemId, int Amount);

}