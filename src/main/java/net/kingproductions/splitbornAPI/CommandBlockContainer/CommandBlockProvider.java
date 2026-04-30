package net.kingproductions.splitbornAPI.CommandBlockContainer;

import org.bukkit.entity.Player;

public interface CommandBlockProvider {

    void BlockCommand(Player player, COMMAND_ID commandId);

}
