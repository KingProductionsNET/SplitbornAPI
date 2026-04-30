package net.kingproductions.splitbornAPI.Builder;

import net.kingproductions.splitbornAPI.ItemContainer.Item_Paths;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;


public class ItemBuilder {
    private final ItemStack itemStack;
    private final ItemMeta itemMeta;
    private String SkinValue = null;
    private boolean addUniqueID = false;
    private Player player;

    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder skullValue(String value){
        this.SkinValue = value;
        return this;
    }

    public ItemBuilder enableUUID(boolean b){
        addUniqueID = b;
        return this;
    }

    public ItemBuilder setDisplayName(String displayName) {
        if (itemMeta != null) {
            itemMeta.setDisplayName(displayName);
        }
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment){
        if (itemMeta != null){
            itemMeta.addEnchant(enchantment, 1 , true);
        }
        return this;
    }

    public ItemBuilder addLore(String... loreLines) {
        if (itemMeta != null) {
            List<String> lore = itemMeta.hasLore() ? itemMeta.getLore() : new ArrayList<>();
            for (String line : loreLines) {
                lore.add(line);
            }
            itemMeta.setLore(lore);
        }
        return this;
    }
    public static int getHiddenValueInt(ItemMeta meta, String key) {
        if (meta != null) {
            NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
            PersistentDataContainer container = meta.getPersistentDataContainer();
            return container.getOrDefault(namespacedKey, PersistentDataType.INTEGER, 0);
        }
        return 0;
    }
    public static void addHiddenValue(ItemMeta meta, String key, PersistentDataType persistentDataType, Object value){
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(namespacedKey, persistentDataType, value);
    }
    public static String getHiddenValueString(ItemMeta meta, String key) {
        if (meta != null) {
            NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
            PersistentDataContainer container = meta.getPersistentDataContainer();
            return container.getOrDefault(namespacedKey, PersistentDataType.STRING, "0");
        }
        return "0";
    }

    public static ItemStack TransformItem_NPC_BUY(ItemStack stack){
        ItemMeta meta = stack.getItemMeta();
        List<String> lore = meta.getLore();
        if (lore == null || lore.isEmpty()) return null;

        int BuyPrice = ItemBuilder.getHiddenValueInt(meta, Item_Paths.NPC_BUY_PRICE_PATH.toString());
        if (BuyPrice == 0){
            return new ItemBuilder(Material.BEDROCK).setDisplayName("§cNot allowed to sell.").build();
        }

        lore.add("");
        lore.add("§7Cost:");
        lore.add("§6" + BuyPrice + " Gleams §e\uD83D\uDD25");
        lore.add("");
        lore.add("§eClick to purchase.");
        meta.setLore(lore);

        stack.setItemMeta(meta);

        return stack;
    }

    public ItemBuilder setColor(Color color) {
        if (itemMeta instanceof LeatherArmorMeta) {
            LeatherArmorMeta leatherMeta = (LeatherArmorMeta) itemMeta;
            leatherMeta.setColor(color);
        }
        return this;
    }

    public ItemBuilder addItemFlags(ItemFlag... flags) {
        if (itemMeta != null) {
            itemMeta.addItemFlags(flags);
        }
        return this;
    }

    public ItemBuilder setUnbreakable(boolean unbreakable) {
        if (itemMeta != null) {
            itemMeta.setUnbreakable(unbreakable);
        }
        return this;
    }
    public ItemBuilder setPlayer(Player player){
        this.player = player;
        return this;
    }

    private static final UUID STACKABLE_UUID = UUID.fromString("34c267b3-5da5-4407-9498-c90a8cba9f4d");

    public ItemStack build() {
        if (player != null){
            ItemStack Skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta Meta = (SkullMeta) Skull.getItemMeta();

            Meta.setDisplayName(itemMeta.getDisplayName());
            List<String> loreLines = itemMeta.getLore();
            List<String> newLore = new ArrayList<>(loreLines);
            Meta.setLore(newLore);

            Meta.setOwningPlayer(player);
            Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            Meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            itemMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            Meta.setUnbreakable(true);

            AttributeModifier modifier = new AttributeModifier(STACKABLE_UUID, "dummy", 1.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            itemMeta.addAttributeModifier(Attribute.ARMOR, modifier);

            Skull.setItemMeta(Meta);
            return Skull;
        }
        if (SkinValue != null && itemStack.getType().equals(Material.PLAYER_HEAD)){
            ItemStack Skull = CustomSkull.getCustomSkull(SkinValue);
            ItemMeta meta = Skull.getItemMeta();

            meta.setDisplayName(itemMeta.getDisplayName());
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            itemMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            meta.setUnbreakable(true);
            meta.setLore(itemMeta.getLore());

            AttributeModifier modifier = new AttributeModifier(STACKABLE_UUID, "dummy", 1.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            itemMeta.addAttributeModifier(Attribute.ARMOR, modifier);

            Skull.setItemMeta(meta);

            return Skull;
        }
        if (itemMeta != null) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            itemMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            itemMeta.setUnbreakable(true);

            AttributeModifier modifier = new AttributeModifier(STACKABLE_UUID, "dummy", 1.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            itemMeta.addAttributeModifier(Attribute.ARMOR, modifier);

            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
}

