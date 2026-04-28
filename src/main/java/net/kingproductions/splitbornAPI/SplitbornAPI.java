package net.kingproductions.splitbornAPI;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class SplitbornAPI{

<<<<<<< HEAD

    private static ProfileProvider provider;

    private SplitbornAPI() {}

=======
    private static ProfileProvider provider;

    private SplitbornAPI() {}
    // CORE gibt hier seine Logik rein
>>>>>>> bc1f947b0e9f2959fd92fa13f7addf5bfa16eda5
    public static void init(ProfileProvider p) {
        provider = p;
    }

    public static Profile getProfile(UUID uuid) {
<<<<<<< HEAD
        if (provider == null) {
            throw new IllegalStateException("SplitbornAPI not initialized!");
        }
        return provider.getProfile(uuid);
    }
}
=======
        return provider.getProfile(uuid);
    }
}
>>>>>>> bc1f947b0e9f2959fd92fa13f7addf5bfa16eda5
