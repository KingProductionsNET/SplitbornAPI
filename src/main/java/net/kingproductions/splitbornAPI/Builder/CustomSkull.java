package net.kingproductions.splitbornAPI.Builder;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.UUID;

import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;

public class CustomSkull {

    public static ItemStack getCustomSkull_1_20(String value) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();

        if (skullMeta != null) {
            GameProfile profile = new GameProfile(UUID.randomUUID(), "");
            profile.getProperties().put("textures", new Property("textures", value));

            try {
                Field profileField = skullMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(skullMeta, profile);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

            skull.setItemMeta(skullMeta);
        }
        return skull;
    }

    public static ItemStack giveCustomSkull(String base64Texture) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) skull.getItemMeta();

        if (meta != null) {
            PlayerProfile profile = Bukkit.createPlayerProfile(UUID.randomUUID(), null);
            PlayerTextures textures = profile.getTextures();

            try {
                String url = extractTextureUrl(base64Texture);
                textures.setSkin(new URL(url));
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return skull;
            }

            meta.setOwnerProfile(profile);
            skull.setItemMeta(meta);
        }

        return skull;
    }

    private static String extractTextureUrl(String base64) {
        String json = new String(Base64.getDecoder().decode(base64));
        JsonObject obj = JsonParser.parseString(json)
                .getAsJsonObject()
                .getAsJsonObject("textures")
                .getAsJsonObject("SKIN");
        return obj.get("url").getAsString();
    }


    public static ItemStack getCustomSkull(String value) {
        String version = Bukkit.getBukkitVersion();
        if (version.contains("26.1") || version.contains("1.21.4") || version.contains("1.21.1")  || version.contains("1.21.11") ||version.contains("1.21.2") || version.contains("1.21.3") || version.contains("1.21.5") || version.contains("1.21.6") || version.contains("1.21.7") || version.contains("1.21.8") || version.contains("1.21.9") || version.contains("1.21.10")) {
            return giveCustomSkull(value);
        } else {
            return getCustomSkull_1_20(value);
        }
    }

    public static void applySkinByNameAsync(ItemStack head, String name, Runnable afterApplyOnMain) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            com.destroystokyo.paper.profile.PlayerProfile profile = Bukkit.createProfile(name);
            boolean ok = profile.complete(true);

            Bukkit.getScheduler().runTask(plugin, () -> {
                head.editMeta(SkullMeta.class, meta -> {
                    if (ok) meta.setPlayerProfile(profile);
                    else meta.setOwner(name);
                });

                if (afterApplyOnMain != null) afterApplyOnMain.run();
            });
        });
    }

}
