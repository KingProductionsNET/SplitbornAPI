package net.kingproductions.splitbornAPI.MobContainer;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface RPGMobProvider {

    Entity spawnMob(Mob_ID mobId, Location spawnLocation, boolean respawn);

    /**
     * Adds a kill for that mob to the player kill log.
     * @param player The player.
     * @param Mob The mob id will be automatically fetched from this mob.
     */
    void addKillToKillLog(Player player, LivingEntity Mob);
    /**
     * Adds a kill for that mob to the player kill log.
     * @param player The player.
     * @param mobId The mob id.
     */
    void addKillToKillLog(Player player, Mob_ID mobId);

}
