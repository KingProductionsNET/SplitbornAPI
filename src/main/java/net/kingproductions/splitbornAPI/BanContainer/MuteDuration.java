package net.kingproductions.splitbornAPI.BanContainer;

import java.util.concurrent.TimeUnit;

public enum MuteDuration {

    SPAM(TimeUnit.DAYS.toMillis(3));

    private final long value;

    MuteDuration(long value){
        this.value = value;
    }

    public long getValue() {
        return value;
    }

}
