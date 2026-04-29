package net.kingproductions.splitbornAPI.ProfileContainer;

import java.util.UUID;

public interface Profile {

    UUID getUUID();
    int getXP();
    void setXP(int xp);

    boolean getBoolean(String Path);
    boolean getString(String Path);
    boolean getInteger(String Path);
}