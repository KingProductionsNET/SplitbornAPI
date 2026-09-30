package net.kingproductions.splitbornAPI.BanContainer;

import net.kingproductions.splitbornAPI.MobContainer.Mob_ID;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class MuteEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private final String Username;

    public MuteEvent(String Username){
        this.Username = Username;
    }

    public String getUsername(){
        return Username;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
