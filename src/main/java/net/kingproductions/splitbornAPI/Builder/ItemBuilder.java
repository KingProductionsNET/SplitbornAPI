package net.kingproductions.splitbornAPI.Builder;

import net.kingproductions.splitbornAPI.EssenceContainer.Essence_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_ID;
import net.kingproductions.splitbornAPI.ItemContainer.Item_Paths;
import net.kingproductions.splitbornAPI.Main.SplitbornAPI;
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

import java.util.*;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;


public class ItemBuilder {
    private final ItemStack itemStack;
    private final ItemMeta itemMeta;
    private String SkinValue = null;
    private boolean glint = false;
    private boolean addUniqueID = false;
    private Player player;

    private final Map<String, Object> addedHiddenObjects = new HashMap();

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
    public ItemBuilder addHiddenObject(String key, PersistentDataType persistentDataType, Object value){
        NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
        PersistentDataContainer container = itemMeta.getPersistentDataContainer();
        container.set(namespacedKey, persistentDataType, value);

        addedHiddenObjects.put(key, value);
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

    @Deprecated (since = "Always")
    public static ItemStack TransformItem_NPC_BUY(ItemStack stack){
        ItemMeta meta = stack.getItemMeta();
        List<String> lore = meta.getLore();
        if (lore == null || lore.isEmpty()) return null;

        String raw = ItemBuilder.getHiddenValueString(meta, Item_Paths.NPC_BUY_PRICE_PATH.toString());
        if (raw.equalsIgnoreCase("0")){
            return new ItemBuilder(Material.BEDROCK).setDisplayName(meta.getDisplayName() + " NO PRICE SET!").build();
        }

        String[] costList = raw.split(",");

        lore.add("");
        lore.add("§7Cost:");
        List<String> gleamLore = new ArrayList<>();
        List<String> essenceLore = new ArrayList<>();
        List<String> itemLore = new ArrayList<>();

        for (String itemString : costList) {
            int lastUnderscore = itemString.lastIndexOf("_");

            String itemID = itemString.substring(0, lastUnderscore);
            int amount = Integer.parseInt(itemString.substring(lastUnderscore + 1));

            if (itemID.equalsIgnoreCase(Item_ID.GLEAMS.toString())) {
                gleamLore.add("§6" + SplitbornAPI.getHelper().formatInteger(amount)
                        + " Gleams" + SplitbornAPI.getHelper().getGleamSymbol());
                continue;
            }

            try {
                Essence_ID essenceId = Essence_ID.valueOf(itemID);

                essenceLore.add("§e" + SplitbornAPI.getHelper().formatInteger(amount)
                        + " §d" + SplitbornAPI.getHelper().formatEnumName(essenceId.toString())
                        + " Essence" + SplitbornAPI.getHelper().getEssenceSymbol());
                continue;
            } catch (Exception ignore) {}

            ItemStack finalItem = SplitbornAPI.getItem(Item_ID.valueOf(itemID));
            itemLore.add("§7" + amount + "x " + finalItem.getItemMeta().getDisplayName());
        }

        lore.addAll(gleamLore);
        lore.addAll(essenceLore);
        lore.addAll(itemLore);
        lore.add("");
        lore.add("§eClick to purchase.");
        meta.setLore(lore);

        stack.setItemMeta(meta);

        return stack;
    }

    public static ItemStack getShopItem(Item_ID itemId){
        if (itemId == null){
            return new ItemBuilder(Material.BEDROCK).setDisplayName("§cNO ITEM_ID SET!").build();
        }

        ItemStack stack = SplitbornAPI.getItem(itemId);

        ItemMeta meta = stack.getItemMeta();
        List<String> lore = meta.getLore();
        if (lore == null || lore.isEmpty()) return null;

        String raw = ItemBuilder.getHiddenValueString(meta, Item_Paths.NPC_BUY_PRICE_PATH.toString());
        if (raw.equalsIgnoreCase("0")){
            lore.add("");
            lore.add("§7Cost:");
            lore.add("§a§lFREE");
            lore.add("");
            lore.add("§aClick to receive.");

            meta.setLore(lore);
            stack.setItemMeta(meta);

            return stack;
        }

        String[] costList = raw.split(",");

        lore.add("");
        lore.add("§7Cost:");
        List<String> gleamLore = new ArrayList<>();
        List<String> essenceLore = new ArrayList<>();
        List<String> itemLore = new ArrayList<>();

        for (String itemString : costList) {
            int lastUnderscore = itemString.lastIndexOf("_");

            String itemID = itemString.substring(0, lastUnderscore);
            int amount = Integer.parseInt(itemString.substring(lastUnderscore + 1));

            if (itemID.equalsIgnoreCase(Item_ID.GLEAMS.toString())) {
                gleamLore.add("§6" + SplitbornAPI.getHelper().formatInteger(amount) + " Gleams" + SplitbornAPI.getHelper().getGleamSymbol());
                continue;
            }

            try {
                Essence_ID essenceId = Essence_ID.valueOf(itemID);

                essenceLore.add("§e" + SplitbornAPI.getHelper().formatInteger(amount)
                        + " §d" + SplitbornAPI.getHelper().formatEnumName(essenceId.toString())
                        + " Essence" + SplitbornAPI.getHelper().getEssenceSymbol());
                continue;
            } catch (Exception ignore) {}

            ItemStack finalItem = SplitbornAPI.getItem(Item_ID.valueOf(itemID));
            itemLore.add("§7" + amount + "x " + finalItem.getItemMeta().getDisplayName());
        }

        lore.addAll(gleamLore);
        lore.addAll(essenceLore);
        lore.addAll(itemLore);
        lore.add("");
        lore.add("§eClick to purchase.");
        meta.setLore(lore);

        stack.setItemMeta(meta);

        return stack;
    }

    public ItemBuilder setColor(Color color) {
        if (itemMeta instanceof LeatherArmorMeta leatherMeta) {
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
    public ItemBuilder setGlint(boolean b){
        this.glint = b;
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
            Meta.addItemFlags(ItemFlag.HIDE_DYE);
            Meta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            Meta.setUnbreakable(true);

            if (glint){
                Meta.addEnchant(Enchantment.AQUA_AFFINITY, 1, true);
            }

            AttributeModifier modifier = new AttributeModifier(STACKABLE_UUID, "dummy", 1.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            itemMeta.addAttributeModifier(Attribute.ARMOR, modifier);

            for (String path : addedHiddenObjects.keySet()){
                Object o = addedHiddenObjects.get(path);

                PersistentDataType persistentDataType = PersistentDataType.STRING;
                if (o instanceof Integer) persistentDataType = PersistentDataType.INTEGER;

                addHiddenValue(Meta, path, persistentDataType, o);
            }

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
            meta.addItemFlags(ItemFlag.HIDE_DYE);
            meta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            meta.setUnbreakable(true);
            meta.setLore(itemMeta.getLore());

            if (glint){
                itemMeta.addEnchant(Enchantment.AQUA_AFFINITY, 1, false);
            }

            AttributeModifier modifier = new AttributeModifier(STACKABLE_UUID, "dummy", 1.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            itemMeta.addAttributeModifier(Attribute.ARMOR, modifier);

            for (String path : addedHiddenObjects.keySet()){
                Object o = addedHiddenObjects.get(path);

                PersistentDataType persistentDataType = PersistentDataType.STRING;
                if (o instanceof Integer) persistentDataType = PersistentDataType.INTEGER;

                addHiddenValue(meta, path, persistentDataType, o);
            }

            Skull.setItemMeta(meta);

            return Skull;
        }
        if (itemMeta != null) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            itemMeta.addItemFlags(ItemFlag.HIDE_DYE);
            itemMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            itemMeta.setUnbreakable(true);

            if (glint){
                itemMeta.addEnchant(Enchantment.AQUA_AFFINITY, 1, false);
            }

            AttributeModifier modifier = new AttributeModifier(STACKABLE_UUID, "dummy", 1.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
            itemMeta.addAttributeModifier(Attribute.ARMOR, modifier);

            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
}

