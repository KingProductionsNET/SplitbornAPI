package net.kingproductions.splitbornAPI.MiningContainer;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MiningBlockBreakEvent extends Event{

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Block_ID blockId;
    private final Location blockBreakLocation;
    private boolean respawn = true;

    public MiningBlockBreakEvent(Player player, Location location, Block_ID blockId) {
        this.player = player;
        this.blockBreakLocation = location;
        this.blockId = blockId;
    }

    public Player getPlayer() {
        return player;
    }
    public Block_ID getBlockID(){
        return blockId;
    }
    public void setRespawn(boolean b){
        this.respawn = b;
    }

    /**
     *
     * @return The location of the broken block.
     */
    public Location getBrokenBlockLocation(){
        return blockBreakLocation;
    }
    public boolean getRespawn(){
        return respawn;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }

}
