package net.kingproductions.splitbornAPI.Main;

import net.kingproductions.splitbornAPI.BlockInteractionContainer.BlockInteraction;
import net.kingproductions.splitbornAPI.CommandBlockContainer.CommandBlockProvider;
import net.kingproductions.splitbornAPI.CosmeticTourContainer.CosmeticTour;
import net.kingproductions.splitbornAPI.HelperContainer.HelperProvider;
import net.kingproductions.splitbornAPI.HideManagerContainer.HideManager;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.ItemContainer.SplitbornItemProvider;
import net.kingproductions.splitbornAPI.LocationsContainer.LocationSpawnPoints;
import net.kingproductions.splitbornAPI.MobContainer.RPGMobProvider;
import net.kingproductions.splitbornAPI.NPC.NPCProvider;
import net.kingproductions.splitbornAPI.NPC.SplitbornNPC;
import net.kingproductions.splitbornAPI.OneTimeRewardInventory.One_Time_Reward_Inventory;
import net.kingproductions.splitbornAPI.ProfileContainer.Profile;
import net.kingproductions.splitbornAPI.ProfileContainer.ProfileProvider;
import net.kingproductions.splitbornAPI.QuestContainer.QuestCreation.QuestProvider;
import net.kingproductions.splitbornAPI.Util.UtilProvider;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public final class SplitbornAPI extends JavaPlugin {
    public static Plugin plugin;
    public static Random random = new Random();
    public static World world_splitborn = null;

    private static final String API_NOT_FOUND_STRING = "Splitborn API not found!";

    private static ProfileProvider profileProvider;
    private static NPCProvider npcProvider;
    private static HelperProvider helperProvider;
    private static QuestProvider questProvider;
    private static CommandBlockProvider commandBlockProvider;
    private static UtilProvider utilProvider;
    private static RPGMobProvider rpgMobProvider;

    private static final List<SplitbornItemProvider> itemProviders = new ArrayList<>();

    public SplitbornAPI() {}

    public static void init(ProfileProvider p, SplitbornItemProvider i, NPCProvider n, HelperProvider h, QuestProvider q, CommandBlockProvider c, UtilProvider u) {
        profileProvider = p;
        itemProviders.add(i);
        npcProvider = n;
        helperProvider = h;
        questProvider = q;
        commandBlockProvider = c;
        utilProvider = u;
    }
    public static void initRPGMobs(RPGMobProvider r){
        rpgMobProvider = r;
    }
    public static void addItemProvider(SplitbornItemProvider s){
        itemProviders.add(s);
    }

    public static Profile getProfile(UUID uuid) {
        if (profileProvider == null) {throw new API_NOT_FOUND(API_NOT_FOUND_STRING);}
        return profileProvider.getProfile(uuid);
    }
    public static ItemStack getItem(Item_ID itemId){
        for (SplitbornItemProvider provider : itemProviders){
            ItemStack item = provider.getItem(itemId);

            if (item != null){
                return item;
            }
        }

        throw new API_NOT_FOUND("Item not found: " + itemId);
    }
    public static SplitbornNPC spawnNPC(SplitbornNPC id) {
        if (npcProvider == null) {throw new API_NOT_FOUND(API_NOT_FOUND_STRING);}
        return npcProvider.spawnNPC(id);
    }
    public static HelperProvider getHelper() {
        if (helperProvider == null) {throw new API_NOT_FOUND(API_NOT_FOUND_STRING);}
        return helperProvider;
    }
    public static QuestProvider QuestManager(){
        if (questProvider == null) {throw new API_NOT_FOUND(API_NOT_FOUND_STRING);}
        return questProvider;
    }
    public static CommandBlockProvider BlockCommand(){
        if (commandBlockProvider == null) {throw new API_NOT_FOUND(API_NOT_FOUND_STRING);}
        return commandBlockProvider;
    }
    public static UtilProvider getUtil(){
        if (utilProvider == null) {throw new API_NOT_FOUND(API_NOT_FOUND_STRING);}
        return utilProvider;
    }
    public static RPGMobProvider getMobSystem(){
        if (utilProvider == null) {throw new API_NOT_FOUND(API_NOT_FOUND_STRING);}
        return rpgMobProvider;
    }

    @Override
    public void onEnable() {
        plugin = this;

        world_splitborn = Bukkit.getWorld("world");

        Bukkit.getPluginManager().registerEvents(new HideManager(), this);
        Bukkit.getPluginManager().registerEvents(new BlockInteraction(), this);

        Bukkit.getPluginManager().registerEvents(new One_Time_Reward_Inventory(), this);
        Bukkit.getPluginManager().registerEvents(new CosmeticTour(), this);

        Bukkit.getScheduler().runTask(plugin, () ->{
            LocationSpawnPoints.InitializeLocations();
        });
    }

    @Override
    public void onDisable() {

    }
}