package net.kingproductions.splitbornAPI.NPC;

import org.bukkit.Location;

public interface NPCProvider {

    SplitbornNPC spawnNPC(NPC_ID id, Location location);

}
