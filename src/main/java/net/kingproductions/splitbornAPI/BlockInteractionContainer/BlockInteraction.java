package net.kingproductions.splitbornAPI.BlockInteractionContainer;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.*;

public class BlockInteraction implements Listener {

    public static Map<UUID, List<Location>> usersAllowedInteractionLocation = new HashMap<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if (event.getClickedBlock() != null){
            List<Location> list = usersAllowedInteractionLocation.getOrDefault(player.getUniqueId(), new ArrayList<>());

            for (Location loc : list){
                if (event.getClickedBlock().getLocation().equals(loc)){
                    event.setCancelled(false);
                }
            }
        }
    }
}
