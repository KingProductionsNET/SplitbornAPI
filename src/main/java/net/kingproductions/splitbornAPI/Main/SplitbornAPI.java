package net.kingproductions.splitbornAPI.Main;

import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.ItemContainer.SplitbornItemProvider;
import net.kingproductions.splitbornAPI.NPC.NPCProvider;
import net.kingproductions.splitbornAPI.NPC.NPC_ID;
import net.kingproductions.splitbornAPI.NPC.SplitbornNPC;
import net.kingproductions.splitbornAPI.ProfileContainer.Profile;
import net.kingproductions.splitbornAPI.ProfileContainer.ProfileProvider;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class SplitbornAPI extends JavaPlugin {
    private static final String API_NOT_FOUND_STRING = "Splitborn API not found!";

    private static ProfileProvider profileProvider;
    private static SplitbornItemProvider splitbornItemProvider;
    private static NPCProvider npcProvider;

    public SplitbornAPI() {}

    public static void init(ProfileProvider p, SplitbornItemProvider i, NPCProvider n) {
        profileProvider = p;
        splitbornItemProvider = i;
        npcProvider = n;
    }

    public static Profile getProfile(UUID uuid) {
        if (profileProvider == null) {throw new API_NOT_FOUND(API_NOT_FOUND_STRING);}
        return profileProvider.getProfile(uuid);
    }

    public static ItemStack getItem(Item_ID itemId) {
        if (splitbornItemProvider == null) {throw new API_NOT_FOUND(API_NOT_FOUND_STRING);}
        return splitbornItemProvider.getItem(itemId);
    }

    public static SplitbornNPC spawnNPC(SplitbornNPC id) {
        if (npcProvider == null) throw new IllegalStateException("API not initialized!");

        return npcProvider.spawnNPC(id);
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {

    }
}