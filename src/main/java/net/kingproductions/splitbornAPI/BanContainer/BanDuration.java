package net.kingproductions.splitbornAPI.BanContainer;

import java.util.concurrent.TimeUnit;

public enum BanDuration {

    CHEATING(TimeUnit.SECONDS.toMillis(10));

    private final long value;

    BanDuration(long value){
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
