package net.kingproductions.splitbornAPI.BanContainer;

import java.util.concurrent.TimeUnit;

public enum MuteDuration {

    SPAM(TimeUnit.DAYS.toMillis(3)),
    ADVERTISING(TimeUnit.DAYS.toMillis(7)),
    INAPPROPRIATE_BEHAVIOUR(TimeUnit.DAYS.toMillis(14));

    private final long value;

    MuteDuration(long value){
        this.value = value;
    }

    public long getValue() {
        return value;
    }

}
