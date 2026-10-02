package net.kingproductions.splitbornAPI.BanContainer;

import org.bukkit.command.CommandSender;

import java.util.concurrent.CompletableFuture;

public interface PunishProvider {

    /**
     * @param sender The sender can either be a player or the console.
     * @param TargetName The name of the player which is about to get banned.
     * @param banReason The reason why this player will be banned.
     */
     void BanPlayer(CommandSender sender, String TargetName, BanReason banReason);

    /**
     * @param sender The sender can either be a player or the console.
     * @param TargetName The name of the player which is about to get muted.
     * @param muteReason The reason why this player will be muted.
     */
    void MutePlayer(CommandSender sender, String TargetName, MuteReason muteReason);

}
