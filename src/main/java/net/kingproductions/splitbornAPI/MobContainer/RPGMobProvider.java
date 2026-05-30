package net.kingproductions.splitbornAPI.MobContainer;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public interface RPGMobProvider {

    Entity spawnRPGMob(Mob_ID mobId, Location spawnLocation);

}
