package net.kingproductions.splitbornAPI.ProfileContainer;

import java.util.UUID;

public interface Profile {

    UUID getUUID();

    int getXP();
    void setXP(int xp);
}