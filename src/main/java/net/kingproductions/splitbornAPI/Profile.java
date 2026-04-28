package net.kingproductions.splitbornAPI;

import java.util.UUID;

public interface Profile {

    UUID getUUID();

    int getXP();
    void setXP(int xp);
}