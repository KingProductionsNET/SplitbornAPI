package net.kingproductions.splitbornAPI.CommandBlockContainer;

import org.bukkit.entity.Player;

public interface CommandBlockProvider {

    /**
     * Instead use {@link net.kingproductions.splitbornAPI.CustomMiscEventsContainer.CustomCommandExecuteEvent}
     */
    @Deprecated
    void BlockCommand(Player player, COMMAND_ID commandId);
    /**
     * Instead use {@link net.kingproductions.splitbornAPI.CustomMiscEventsContainer.CustomCommandExecuteEvent}
     */
    @Deprecated
    void UnblockCommand(Player player, COMMAND_ID commandId);

}
