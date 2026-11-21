
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

    private static final Map<UUID, VisibilityData> entityVisibility = new HashMap<>();
    private static BukkitTask visibilityTask;

    private static class VisibilityData {
        boolean visibleByDefault;
        Map<UUID, Boolean> overrides = new HashMap<>();

        VisibilityData(boolean visibleByDefault) {
            this.visibleByDefault = visibleByDefault;
        }

        boolean isVisible(UUID playerUUID) {
            return overrides.getOrDefault(playerUUID, visibleByDefault);
        }
    }

    /**
     * Hides the entity for everyone except for the worthy player.
     * @param entity The entity.
     * @param worthyPlayer The only player which will see the entity.
     */
    public static void HideEntityForUnworthy(Entity entity, Player worthyPlayer) {
        VisibilityData data = new VisibilityData(false);
        data.overrides.put(worthyPlayer.getUniqueId(), true);
        entityVisibility.put(entity.getUniqueId(), data);
        applyEntityVisibility(entity);
    }

    public static void HideEntityForPlayer(Entity entity, Player player) {
        VisibilityData data = entityVisibility.computeIfAbsent(entity.getUniqueId(), k -> new VisibilityData(true));
        data.overrides.put(player.getUniqueId(), false);
        applyVisibility(player, entity);
    }

    public static void UnhideEntityForEveryone(Entity entity) {
        entityVisibility.remove(entity.getUniqueId());

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.showEntity(plugin, entity);
        }
    }

    public static void UnhideEntityForPlayer(Entity entity, Player player) {
        VisibilityData data = entityVisibility.get(entity.getUniqueId());

        if (data != null) {
            data.overrides.put(player.getUniqueId(), true);
        }

        player.showEntity(plugin, entity);
    }

    public static boolean canSeeEntity(Player player, Entity entity) {
        return player.canSee(entity);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        for (UUID entityUUID : new HashSet<>(entityVisibility.keySet())) {
            Entity entity = Bukkit.getEntity(entityUUID);
            if (entity != null) applyVisibility(player, entity);
        }
    }

    public static void orderHiddenEntities() {
        if (visibilityTask != null && !visibilityTask.isCancelled()) return;

        visibilityTask = new BukkitRunnable() {
            @Override
            public void run() {
                for (UUID entityUUID : new HashSet<>(entityVisibility.keySet())) {
                    Entity entity = Bukkit.getEntity(entityUUID);
                    if (entity != null) applyEntityVisibility(entity);
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
        VisibilityData data = entityVisibility.get(entity.getUniqueId());
        boolean visible = data == null || data.isVisible(player.getUniqueId());

        if (visible) player.showEntity(plugin, entity);
        else player.hideEntity(plugin, entity);
    }
}
