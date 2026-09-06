package net.kingproductions.splitbornAPI.MiningContainer;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface MiningManagerProvider {

    /**
     * Simulates a block break as if the player were normally mining a valid Splitborn mining block.
     * @param player The player which will receive credits.
     * @param targetLocation The location of the valid Splitborn mining block.
     */
    void triggerBlockBreak(Player player, Location targetLocation);

}
