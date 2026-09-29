package net.kingproductions.splitbornAPI.BanContainer;

import java.util.concurrent.CompletableFuture;

public interface PunishProvider {

    /**
     *
     * @param TargetName The name of the player which is about to get banned.
     * @param banReason The reason why this player will be banned.
     * @return A future containing whether the player was successfully banned.
     */
    CompletableFuture<Boolean> BanPlayer(String TargetName, BanReason banReason);

    /**
     *
     * @param TargetName The name of the player which is about to get muted.
     * @param muteReason The reason why this player will be muted.
     * @return A future containing whether the player was successfully muted.
     */
    CompletableFuture<Boolean> MutePlayer(String TargetName, MuteReason muteReason);

}
