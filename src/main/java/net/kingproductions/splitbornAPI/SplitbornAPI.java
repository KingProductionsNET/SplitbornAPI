package net.kingproductions.splitbornAPI;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class SplitbornAPI{


    private static ProfileProvider provider;

    private SplitbornAPI() {}

    public static void init(ProfileProvider p) {
        provider = p;
    }

    public static Profile getProfile(UUID uuid) {
        if (provider == null) {
            throw new IllegalStateException("SplitbornAPI not initialized!");
        }
        return provider.getProfile(uuid);
    }
}