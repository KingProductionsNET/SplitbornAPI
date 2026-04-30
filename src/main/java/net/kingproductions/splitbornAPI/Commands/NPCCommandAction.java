package net.kingproductions.splitbornAPI.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static net.kingproductions.splitbornAPI.DialogueContainer.EasyDialogue.IS_CURRENTLY_IN_DIALOGUE;

public class NPCCommandAction implements CommandExecutor {

    public static Map<UUID, String> getPlayersDedicatedNCA = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (commandSender instanceof Player player) {
            if (args.length != 1) {
                return true;
            }
            String SubCommand = args[0];
            if (IS_CURRENTLY_IN_DIALOGUE.contains(player.getUniqueId())) return true;

            if (getPlayersDedicatedNCA.getOrDefault(player.getUniqueId(), "null").equalsIgnoreCase(SubCommand)){
                if (SubCommand.equalsIgnoreCase(AREO_NCA.NEW_PART_2)){
                    AREO_DIALOGUES.NEW_TALK_PART_2(player);
                }
                if (SubCommand.equalsIgnoreCase(AREO_NCA.NEW_PART_3)){
                    AREO_DIALOGUES.NEW_TALK_PART_3(player);
                }

                if (SubCommand.equalsIgnoreCase(ANDREW_NCA.PART_2)){
                    ANDREW_DIALOGUES.NEW_PART_2(player);
                }

                if (SubCommand.equalsIgnoreCase(STEPHEN_NCA.NEW_PART_2)){
                    STEPHEN_DIALOGUES.NEW_PART_2(player);
                }
                if (SubCommand.equalsIgnoreCase(STEPHEN_NCA.NEW_PART_3)){
                    STEPHEN_DIALOGUES.NEW_PART_3(player);
                }
                if (SubCommand.equalsIgnoreCase(STEPHEN_NCA.NEW_PART_4)){
                    STEPHEN_DIALOGUES.NEW_PART_4(player);
                }
                if (SubCommand.equalsIgnoreCase(STEPHEN_NCA.NEW_PART_5)){
                    STEPHEN_DIALOGUES.NEW_PART_5(player);
                }
                if (SubCommand.equalsIgnoreCase(STEPHEN_NCA.NEW_PART_6)){
                    STEPHEN_DIALOGUES.NEW_PART_6(player);
                }

                if (SubCommand.equalsIgnoreCase(BONSAI_NCA.NCA_COMMAND_BONSAI_DIALOGUE_PART_2)) {
                    BONSAI_DIALOGUES.Part_2(player);
                }
                if (SubCommand.equalsIgnoreCase(GRUG_NCA.NCA_COMMAND_GRUG_BONSAI_QUEST_DIALOGUE_PART_2)){
                    GRUG_DIALOGUES.Bonsai_Quest_Part_2(player);
                }

                getPlayersDedicatedNCA.remove(player.getUniqueId());
            } else {
                player.sendMessage("§cYou can't use this right now.");
            }
        }
        return false;
    }

}
