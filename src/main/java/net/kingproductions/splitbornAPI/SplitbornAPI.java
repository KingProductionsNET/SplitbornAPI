package net.kingproductions.splitbornAPI;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class SplitbornAPI{

    private static ProfileProvider provider;

    private SplitbornAPI() {}
    // CORE gibt hier seine Logik rein
    public static void init(ProfileProvider p) {
        provider = p;
    }

    public static Profile getProfile(UUID uuid) {
        return provider.getProfile(uuid);
    }
}
