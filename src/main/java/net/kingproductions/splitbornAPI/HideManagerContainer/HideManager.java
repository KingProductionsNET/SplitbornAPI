package net.kingproductions.splitbornAPI.HideManagerContainer;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.*;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;

public class HideManager implements Listener {

    public static Map<UUID, List<UUID>> playersPacketEntities = new HashMap<>();

    public static void HideEntityForUnworthy(Entity entity, Player worthyPlayer)  {
        List<UUID> list = playersPacketEntities.getOrDefault(worthyPlayer.getUniqueId(), new ArrayList<>());
        list.add(entity.getUniqueId());

        playersPacketEntities.put(worthyPlayer.getUniqueId(), list);

        for (Player online : Bukkit.getOnlinePlayers()){
            if (online.getUniqueId().equals(worthyPlayer.getUniqueId())) continue;
            online.hideEntity(plugin, entity );
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        List<UUID> hideList = new ArrayList<>();
        for (UUID uuid : playersPacketEntities.keySet()){
            if (uuid.equals(player.getUniqueId())) continue;

            List<UUID> otherPlayersEntities = playersPacketEntities.get(uuid);
            for (UUID oUUID : otherPlayersEntities){
                if (Bukkit.getEntity(oUUID) == null){
                    otherPlayersEntities.remove(oUUID);
                    playersPacketEntities.put(player.getUniqueId(), otherPlayersEntities);

                    continue;
                }

                hideList.add(oUUID);
            }
        }
        for (UUID uuid : hideList){
            Entity entityToHide = Bukkit.getEntity(uuid);
            if (entityToHide == null) continue;

            player.hideEntity(plugin, entityToHide);
        }

        player.setGameMode(GameMode.ADVENTURE);
    }
}
