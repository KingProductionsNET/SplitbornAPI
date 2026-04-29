package net.kingproductions.splitbornAPI.NPC;

import org.bukkit.entity.Entity;

import java.util.UUID;

public class SplitbornNPC {

    private final UUID uuid;
    private final NPC_ID id;

    public SplitbornNPC(UUID uuid, NPC_ID id) {
        this.uuid = uuid;
        this.id = id;
    }

    public UUID getUUID() {
        return uuid;
    }

    public NPC_ID getID() {
        return id;
    }

    public Entity getEntity() {
        return org.bukkit.Bukkit.getEntity(uuid);
    }

}
