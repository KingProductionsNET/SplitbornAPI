package net.kingproductions.splitbornAPI.HideManagerContainer;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;

public class HideManager implements Listener {

    public static Map<UUID, Set<UUID>> playersPacketEntities = new HashMap<>();
    public static Map<UUID, Set<UUID>> playersHiddenEntities = new HashMap<>();

    /**
     * Hides an entity for every online and future player except for the worthyPlayer. Do not use this when trying to hide a text display.
     * It won't work. Instead use {@link net.kingproductions.splitbornAPI.HelperContainer.HelperProvider#hideTextDisplay(TextDisplay, Player)}
     * @param entity the entity that will be hidden for every online and future player except for the worthyPlayer
     * @param worthyPlayer the player which is the only one allowed to see the entity
     */
    public static void HideEntityForUnworthy(Entity entity, Player worthyPlayer)  {
        Set<UUID> list = playersPacketEntities.getOrDefault(worthyPlayer.getUniqueId(), new HashSet<>());
        list.add(entity.getUniqueId());
        playersPacketEntities.put(worthyPlayer.getUniqueId(), list);
        for (Player online : Bukkit.getOnlinePlayers()) {
            if (online.getUniqueId().equals(worthyPlayer.getUniqueId())) continue;
            online.hideEntity(plugin, entity);
        }
    }

    /**
     * Unhides an entity for every online and future player. Do not use this when trying to hide a text display.
     * It won't work. Instead use {@link net.kingproductions.splitbornAPI.HelperContainer.HelperProvider#unhideTextDisplay(TextDisplay, Player)}
     * @param e the entity will be unhidden for everyone
     */
    public static void UnhideEntityForEveryone(Entity e){
        for (UUID uuid : playersPacketEntities.keySet()){
            Set<UUID> list = playersPacketEntities.getOrDefault(uuid, new HashSet<>());

            if (!list.isEmpty() && list.contains(e.getUniqueId())){
                list.remove(e.getUniqueId());
                playersPacketEntities.put(uuid, list);
            }
        }

        Bukkit.getScheduler().runTaskLater(plugin, () ->{
            for (Player player : Bukkit.getOnlinePlayers()){
                player.showEntity(plugin, e);
            }
        }, 10);
    }

    /**
     * Unhides an entity for the player. Do not use this when trying to hide a text display.
     * It won't work. Instead use {@link net.kingproductions.splitbornAPI.HelperContainer.HelperProvider#unhideTextDisplay(TextDisplay, Player)}
     * @param entity the entity that will be unhidden
     * @param player the player which will see the entity
     */
    public static void UnhideEntityForPlayer(Entity entity, Player player){
        UUID uuid = player.getUniqueId();
        Set<UUID> list = playersPacketEntities.getOrDefault(uuid, new HashSet<>());

        if (!list.isEmpty() && list.contains(entity.getUniqueId())){
            list.remove(entity.getUniqueId());
            playersPacketEntities.put(uuid, list);
        }

        Bukkit.getScheduler().runTaskLater(plugin, () ->{
            player.showEntity(plugin, entity);

            Set<UUID> hiddenEntities = playersHiddenEntities.getOrDefault(player.getUniqueId(), new HashSet<>());
            hiddenEntities.remove(entity.getUniqueId());
            playersPacketEntities.put(player.getUniqueId(), hiddenEntities);
        }, 10);
    }
    /**
     *
     * @param player
     * @param entity
     * @return True when the player can see the entity.
     */
    public static boolean canSeeEntity(Player player, Entity entity){
        Set<UUID> hiddenEntities = playersHiddenEntities.getOrDefault(player.getUniqueId(), new HashSet<>());
        return !hiddenEntities.contains(entity.getUniqueId());
    }

    public static void orderHiddenEntities(){
        new BukkitRunnable(){

            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()){
                    List<UUID> hideList = new ArrayList<>();
                    for (UUID uuid : playersPacketEntities.keySet()) {
                        if (uuid.equals(player.getUniqueId())) continue;

                        Set<UUID> otherPlayersEntities = playersPacketEntities.get(uuid);

                        if (otherPlayersEntities == null) continue;

                        Iterator<UUID> iterator = otherPlayersEntities.iterator();

                        while (iterator.hasNext()) {
                            UUID oUUID = iterator.next();
                            Entity entity = Bukkit.getEntity(oUUID);

                            if (entity == null) {
                                iterator.remove();
                                continue;
                            }

                            hideList.add(oUUID);
                        }
                    }

                    for (UUID uuid : hideList) {
                        Entity entityToHide = Bukkit.getEntity(uuid);
                        if (entityToHide == null) continue;
                        player.hideEntity(plugin, entityToHide);

                        Set<UUID> hiddenEntities = playersHiddenEntities.getOrDefault(player.getUniqueId(), new HashSet<>());
                        hiddenEntities.add(entityToHide.getUniqueId());
                        playersPacketEntities.put(player.getUniqueId(), hiddenEntities);
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 25);
    }
}