package net.kingproductions.splitbornAPI.DialogueContainer;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.util.Transformation;

import java.util.*;
import java.util.function.Consumer;

import static net.kingproductions.splitbornAPI.Commands.NPCCommandAction.getPlayersDedicatedNCA;
import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;

public class EasyDialogue implements Listener {

    public static Map<TextDisplay, UUID> Special_Visibility_Stand = new HashMap<>();
    public static Set<Player> NPC_Dialogue_Cooldown = new HashSet<>();

    public static Set<UUID> IS_CURRENTLY_IN_DIALOGUE = new HashSet<>();

    private List<String> text = new ArrayList<>();
    private Sound sound;
    private int TalkSpeed = 20;
    private String ActionCommand = null;
    private String FinalActionCommandMessage = null;
    private String Prefix = null;
    private float pitch = 1F;

    private Consumer<Player> consumer;

    public EasyDialogue(){}

    public EasyDialogue addText(List<String> list){
        text = list;
        return this;
    }
    public EasyDialogue setPrefix(String prefix){
        Prefix = prefix;
        return this;
    }
    public EasyDialogue setSound(Sound sound){
        this.sound = sound;
        return this;
    }
    public EasyDialogue setActionCommand(String ChatMessage, String Command){
        FinalActionCommandMessage = ChatMessage;
        ActionCommand = "nca " + Command;
        return this;
    }
    public EasyDialogue setTalkSpeed(int Speed){
        TalkSpeed = Speed;
        return this;
    }
    public EasyDialogue talkPitch(float f){
        this.pitch = f;
        return this;
    }
    public EasyDialogue applyEndAction(Consumer<Player> c){
        this.consumer = c;
        return this;
    }

    private static final Map<UUID, UUID> playersSessionUUID = new HashMap<>();
    private static final Map<UUID, UUID> playersSpecialText = new HashMap<>();
    public void Start(Player player, Entity npc){
        UUID sessionUUID = UUID.randomUUID();
        playersSessionUUID.put(player.getUniqueId(), sessionUUID);
        getPlayersDedicatedNCA.remove(player.getUniqueId());

        NPC_Dialogue_Cooldown.add(player);

        TextDisplay textDisplay = npc.getWorld().spawn(npc.getLocation().clone().add(0, 2, 0), TextDisplay.class);
        textDisplay.setDefaultBackground(true);
        textDisplay.setBillboard(TextDisplay.Billboard.CENTER);
        textDisplay.setSeeThrough(true);
        textDisplay.setAlignment(TextDisplay.TextAlignment.CENTER);
        textDisplay.setShadowed(true);
        textDisplay.setTransformation(new Transformation(textDisplay.getTransformation().getTranslation(), textDisplay.getTransformation().getLeftRotation(), textDisplay.getTransformation().getScale().add(0.1f, 0.1f, 0.1f), textDisplay.getTransformation().getRightRotation()));

        playersSpecialText.put(player.getUniqueId(), textDisplay.getUniqueId());
        Special_Visibility_Stand.put(textDisplay, player.getUniqueId());

        for (Player online : Bukkit.getOnlinePlayers()){
            if (!online.getUniqueId().equals(player.getUniqueId())){
                online.hideEntity(plugin, textDisplay);
            }
        }

//        List<TextDisplay> assignedTextStands = NPCCreator.NPCsAssignedArmorStands.getOrDefault(npc, null);
//        if (assignedTextStands != null && !assignedTextStands.isEmpty()){
//            for (TextDisplay stand : assignedTextStands){
//                player.hideEntity(plugin, stand);
//            }
//        }

        IS_CURRENTLY_IN_DIALOGUE.add(player.getUniqueId());

        int delay = 0;
        for (String Dialogue_Message : text){
            Bukkit.getScheduler().runTaskLater(plugin, () ->{
                UUID sUUID = playersSessionUUID.getOrDefault(player.getUniqueId(), null);
                if (sUUID == null || !sUUID.equals(sessionUUID)) return;

                textDisplay.text(Component.text(Dialogue_Message).color(NamedTextColor.WHITE));
                if (Prefix != null){
                    player.sendMessage("§6[NPC] " + Prefix + "§f: " + Dialogue_Message);
                } else {
                    player.sendMessage("§6[NPC]§f: " + Dialogue_Message);
                }
                player.playSound(player.getLocation(), sound, 1F, this.pitch);
            }, delay);

            delay += TalkSpeed;
        }

        if (FinalActionCommandMessage != null && ActionCommand != null){
            Bukkit.getScheduler().runTaskLater(plugin, () ->{
                getPlayersDedicatedNCA.put(player.getUniqueId(), ActionCommand.replace("nca ", ""));

                Component message = Component.text("§eSelect an option §8➵ §8[" + FinalActionCommandMessage + "§8]").hoverEvent(HoverEvent.showText(Component.text("§eSelect an option."))).clickEvent(ClickEvent.runCommand("/" + ActionCommand));

                player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, 1F, 2F);
                player.sendMessage(message);
            }, (delay + 5L));
        }

        Bukkit.getScheduler().runTaskLater(plugin, () ->{
            IS_CURRENTLY_IN_DIALOGUE.remove(player.getUniqueId());
            NPC_Dialogue_Cooldown.remove(player);

            Special_Visibility_Stand.remove(textDisplay);
            textDisplay.remove();

//            if (assignedTextStands != null && !assignedTextStands.isEmpty()){
//                for (TextDisplay stand : assignedTextStands){
//                    player.showEntity(plugin, stand);
//                }
//            }

            if (consumer != null){
                consumer.accept(player);
            }

        },delay);
    }

    @EventHandler
    public void onJoinHide(PlayerJoinEvent event){
        Player player = event.getPlayer();

        for (Entity e : player.getWorld().getEntitiesByClasses(TextDisplay.class)){
            if (e instanceof TextDisplay stand){
                if (Special_Visibility_Stand.containsKey(stand)){
                    UUID allowedUUID = Special_Visibility_Stand.get(stand);

                    if (!allowedUUID.equals(player.getUniqueId())){
                        player.hideEntity(plugin, stand);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();

        UUID tUUID = playersSpecialText.getOrDefault(player.getUniqueId(), null);
        if (tUUID != null){
            Entity e = Bukkit.getEntity(tUUID);

            if (e != null) e.remove();
        }

        playersSessionUUID.remove(player.getUniqueId());
        getPlayersDedicatedNCA.remove(player.getUniqueId());
        IS_CURRENTLY_IN_DIALOGUE.remove(player.getUniqueId());
    }
}
