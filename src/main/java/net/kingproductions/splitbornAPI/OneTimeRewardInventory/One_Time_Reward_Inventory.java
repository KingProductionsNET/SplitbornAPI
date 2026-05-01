package net.kingproductions.splitbornAPI.OneTimeRewardInventory;

import net.kingproductions.splitbornAPI.Builder.ItemBuilder;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.Main.SplitbornAPI;
import net.kingproductions.splitbornAPI.ProfileContainer.Profile;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;
import java.util.function.Consumer;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;

public class One_Time_Reward_Inventory implements Listener {

    private static final String Title = "§8Free Reward";

    private static final Set<UUID> claimedReward = new HashSet<>();
    private static final Map<UUID, Item_ID> getRewardsItemID = new HashMap<>();
    private static final Map<UUID, Integer> getRewardsItemAmount = new HashMap<>();
    private static final Set<UUID> closeAnimation = new HashSet<>();

    public static final Map<UUID, Consumer<Player>> on_Claim_Action = new HashMap<>();

    public static void Inventory(Player player, Item_ID itemId, int Amount, Consumer<Player> c){
        Inventory inv = Bukkit.createInventory(player, 5*9, Title);
        for (int i = 0; i < inv.getSize(); i++) inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setDisplayName("§e").build());
        for (int i = 10; i <= inv.getSize() - 10; i++){
            if (i == 17 || i == 18 || i == 26 || i == 27 || i==35 || i == 36 || i == 44) continue;
            inv.setItem(i, new ItemStack(Material.AIR));
        }

        ItemStack DisplayReward = SplitbornAPI.getItem(itemId);
        DisplayReward.setAmount(Amount);

        if (c != null) on_Claim_Action.put(player.getUniqueId(), c);

        ItemMeta meta = DisplayReward.getItemMeta();
        List<String> lore = (meta.getLore() == null ? new ArrayList<>() : meta.getLore());
        lore.add(""); lore.add("§a§lFREE");
        meta.setDisplayName(meta.getDisplayName() + " §8[§b" + Amount + "x§8]");
        meta.setLore(lore);
        DisplayReward.setItemMeta(meta);

        player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST_FAR, 1F, 0.5F);
        inv.setItem(22, DisplayReward);

        List<Integer> rotatingSlots = new ArrayList<>();
        rotatingSlots.add(12);
        rotatingSlots.add(13);
        rotatingSlots.add(14);

        rotatingSlots.add(23);
        rotatingSlots.add(32);

        rotatingSlots.add(31);
        rotatingSlots.add(30);
        rotatingSlots.add(21);

        for (int animationSlot : rotatingSlots){
            inv.setItem(animationSlot, new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE).setDisplayName("").build());
        }

        new BukkitRunnable(){
            final List<Integer> latestChangedSlot = new ArrayList<>();

            boolean cancelled = false;
            boolean nextIterationCanStart = true;

            float f = 0.2F;

            @Override
            public void run() {
                if (!player.isOnline() || cancelled || closeAnimation.contains(player.getUniqueId())){
                    closeAnimation.remove(player.getUniqueId());
                    this.cancel();
                    return;
                }

                if (nextIterationCanStart){
                    int delay = 0;

                    for (int animationSlot : rotatingSlots){
                        float pitch = f;

                        Bukkit.getScheduler().runTaskLater(plugin, () ->{
                            inv.setItem(animationSlot, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayName("§e").build());
                            if (!claimedReward.contains(player.getUniqueId())) player.playSound(player.getLocation(), Sound.BLOCK_BELL_RESONATE, 0.1F, pitch);

                            if (!latestChangedSlot.isEmpty()){
                                inv.setItem(latestChangedSlot.getFirst(), new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE).setDisplayName("").build());
                                latestChangedSlot.clear();
                            }

                            latestChangedSlot.add(animationSlot);
                        }, delay);

                        delay += 5;
                        f += 0.1f;
                    }

                    Bukkit.getScheduler().runTaskLater(plugin, () ->{
                        inv.setItem(rotatingSlots.getFirst(), new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setDisplayName("§e").build());
                        if (!claimedReward.contains(player.getUniqueId())) player.playSound(player.getLocation(), Sound.BLOCK_BELL_RESONATE, 0.1F, f);

                        for (int animationSlot : rotatingSlots){
                            if (animationSlot == rotatingSlots.getFirst()) continue;

                            inv.setItem(animationSlot, new ItemBuilder(Material.CYAN_STAINED_GLASS_PANE).setDisplayName("").build());
                        }

                        f = 0.2F;
                        nextIterationCanStart = true;
                    }, delay);

                    nextIterationCanStart = false;
                }


                if (player.getOpenInventory().getTopInventory().equals(inv) && claimedReward.contains(player.getUniqueId())){
                    player.closeInventory();
                    cancelled = true;
                }
            }
        }.runTaskTimer(plugin, 0, 5);

        getRewardsItemID.put(player.getUniqueId(), itemId);
        getRewardsItemAmount.put(player.getUniqueId(), Amount);

        player.openInventory(inv);
    }

    private static void handleClaimProcess(Player player){
        Item_ID thisItem_ID = getRewardsItemID.getOrDefault(player.getUniqueId(), null);
        int Amount = getRewardsItemAmount.getOrDefault(player.getUniqueId(), 1);

        if (thisItem_ID != null){
            claimedReward.add(player.getUniqueId());
            player.closeInventory();

            if (player.getInventory().firstEmpty() != -1){
                player.sendMessage("§aYou have claimed your free reward!");
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1F, 2F);

                for (int i = 0; i <= (Amount - 1); i++) player.getInventory().addItem(SplitbornAPI.getItem(thisItem_ID));
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1F, 2F);

                Consumer<Player> c = on_Claim_Action.getOrDefault(player.getUniqueId(), null);
                if (c != null) c.accept(player);
            } else {
                player.sendMessage("§cYour inventory didn’t have enough free space to claim this reward, which is why it was transferred to the §6Delivery Box §cmenu.");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1F, 1F);

                Profile profile = SplitbornAPI.getProfile(player.getUniqueId());
                profile.addUnclaimedItem(thisItem_ID, Amount);

                Consumer<Player> c = on_Claim_Action.getOrDefault(player.getUniqueId(), null);
                if (c != null) c.accept(player);

                getRewardsItemID.remove(player.getUniqueId());
                getRewardsItemAmount.remove(player.getUniqueId());
            }

            Bukkit.getScheduler().runTaskLater(plugin, () ->{
                claimedReward.remove(player.getUniqueId());
            }, 6);
        }
        closeAnimation.add(player.getUniqueId());
    }

    private static void handleForgottenProcess(Player player){
        Item_ID forgottenItem = getRewardsItemID.getOrDefault(player.getUniqueId(), null);
        int Amount = getRewardsItemAmount.getOrDefault(player.getUniqueId(), 1);

        Profile profile = SplitbornAPI.getProfile(player.getUniqueId());
        profile.addUnclaimedItem(forgottenItem, Amount);

        getRewardsItemAmount.remove(player.getUniqueId());
        getRewardsItemID.remove(player.getUniqueId());

        player.sendMessage("§cSince you didn’t collect your free reward, it was transferred to the §6Delivery Box §cmenu. (/deliverybox)");
        player.playSound(player.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1F, 2F);
        player.sendTitle("§8[§c§l!§8]", "", 10, 30, 10);

        closeAnimation.add(player.getUniqueId());
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(Title)){
            event.setCancelled(true);

            ItemStack itemStack = event.getCurrentItem();
            if (itemStack == null) return;
            if (itemStack.getItemMeta() == null) return;
            if (event.getClickedInventory() == null) return;

            if (event.getSlot() == 22){
                handleClaimProcess(player);
            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();

        if (event.getView().getTitle().equalsIgnoreCase(Title)){
            if (!claimedReward.contains(player.getUniqueId())){
                Item_ID forgottenItem = getRewardsItemID.getOrDefault(player.getUniqueId(), null);

                if (forgottenItem != null){
                    handleForgottenProcess(player);
                } else {
                    player.sendMessage("§cAn error has occurred. Please report this! #1");
                }
            }
        }
    }
}
