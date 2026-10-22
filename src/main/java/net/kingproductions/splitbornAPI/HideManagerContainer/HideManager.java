package net.kingproductions.splitbornAPI.HideManagerContainer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;

public class HideManager implements Listener {
    private static final Map<UUID, Set<UUID>> entityAllowedPlayers = new HashMap<>();
    private static BukkitTask visibilityTask;

    /**
     * Hides an entity from everyone except the worthy player.
     * Calling this again replaces the existing allowed-player list.
     */
    public static void HideEntityForUnworthy(Entity entity, Player worthyPlayer) {
        entityAllowedPlayers.put(entity.getUniqueId(), new HashSet<>(Set.of(worthyPlayer.getUniqueId())));
        applyEntityVisibility(entity);
    }

    /**
     * Makes an entity visible to everyone, as far as this manager is concerned.
     */
    public static void UnhideEntityForEveryone(Entity entity) {
        entityAllowedPlayers.remove(entity.getUniqueId());

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.showEntity(plugin, entity);
        }
    }

    /**
     * Allows one player to see an entity without changing visibility for other players.
     */
    public static void UnhideEntityForPlayer(Entity entity, Player player) {
        Set<UUID> allowedPlayers = entityAllowedPlayers.get(entity.getUniqueId());

        if (allowedPlayers != null) {
            allowedPlayers.add(player.getUniqueId());
        }

        player.showEntity(plugin, entity);
    }

    /**
     * Returns whether the player can currently see the entity.
     */
    public static boolean canSeeEntity(Player player, Entity entity) {
        return player.canSee(entity);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        for (UUID entityUUID : new HashSet<>(entityAllowedPlayers.keySet())) {
            Entity entity = Bukkit.getEntity(entityUUID);
            if (entity == null) continue;

            applyVisibility(player, entity);
        }
    }

    /**
     * Starts the visibility reconciliation task.
     * Call this once during plugin startup, after registering this listener.
     */
    public static void orderHiddenEntities() {
        if (visibilityTask != null && !visibilityTask.isCancelled()) return;

        visibilityTask = new BukkitRunnable() {
            @Override
            public void run() {
                for (UUID entityUUID : new HashSet<>(entityAllowedPlayers.keySet())) {
                    Entity entity = Bukkit.getEntity(entityUUID);

                    if (entity == null) continue;

                    applyEntityVisibility(entity);
                }
            }
        }.runTaskTimer(plugin, 1L, 25L);
    }

    private static void applyEntityVisibility(Entity entity) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            applyVisibility(player, entity);
        }
    }

    private static void applyVisibility(Player player, Entity entity) {
        Set<UUID> allowedPlayers = entityAllowedPlayers.get(entity.getUniqueId());

        if (allowedPlayers == null || allowedPlayers.contains(player.getUniqueId())) {
            player.showEntity(plugin, entity);
        } else {
            player.hideEntity(plugin, entity);
        }
    }
}