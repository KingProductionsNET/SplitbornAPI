package net.kingproductions.splitbornAPI.Main;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.ItemContainer.SplitbornItem;
import net.kingproductions.splitbornAPI.ItemContainer.SplitbornItemProvider;
import net.kingproductions.splitbornAPI.ProfileContainer.Profile;
import net.kingproductions.splitbornAPI.ProfileContainer.ProfileProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class SplitbornAPI extends JavaPlugin {
    private static final String API_NOT_FOUND_STRING = "Splitborn API not found!";

    private static ProfileProvider profileProvider;
    private static SplitbornItemProvider splitbornItemProvider;

    public SplitbornAPI() {}

    public static void init(ProfileProvider p, SplitbornItemProvider i) {
        profileProvider = p;
        splitbornItemProvider = i;
    }
    public static Profile getProfile(UUID uuid) {
        if (profileProvider == null) {throw new API_NOT_FOUND(API_NOT_FOUND_STRING);}
        return profileProvider.getProfile(uuid);
    }

    public static SplitbornItem getItem(Item_ID itemId) {
        if (splitbornItemProvider == null) {throw new API_NOT_FOUND(API_NOT_FOUND_STRING);}
        return splitbornItemProvider.getItem(itemId);
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {

    }
}