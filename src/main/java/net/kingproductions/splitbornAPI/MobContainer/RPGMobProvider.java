package net.kingproductions.splitbornAPI.MobContainer;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public interface RPGMobProvider {

    Entity spawnMob(Mob_ID mobId, Location spawnLocation, boolean respawn);

}
