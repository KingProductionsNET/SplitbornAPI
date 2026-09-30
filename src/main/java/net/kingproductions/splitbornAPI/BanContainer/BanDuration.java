package net.kingproductions.splitbornAPI.BanContainer;

import java.util.concurrent.TimeUnit;

public enum BanDuration {

    CHEATING(TimeUnit.DAYS.toMillis(30)),
    EXPLOITING(TimeUnit.DAYS.toMillis(14)),
    SERVER_CRASHING(TimeUnit.DAYS.toMillis(365)),
    NAME(TimeUnit.DAYS.toMillis(3)),
    SKIN(TimeUnit.DAYS.toMillis(3)),
    EXCESSIVE_BAN_HISTORY(-1);

    private final long value;

    BanDuration(long value){
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
