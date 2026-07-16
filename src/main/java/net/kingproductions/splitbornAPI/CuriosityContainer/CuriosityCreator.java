package net.kingproductions.splitbornAPI.CuriosityContainer;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import org.bukkit.Material;

import java.util.HashSet;
import java.util.Set;

public class CuriosityCreator {

    // TODO: swap in a real base64 texture value from minecraft-heads.com for each PLAYER_HEAD entry below.
    private static final String PLACEHOLDER_SKIN_VALUE = null;

    public static Set<CuriosityData> getCuriosityData(){
        Set<CuriosityData> set = new HashSet<>();
        set.add(CURIOSITY_Headless_Eye());
        set.add(CURIOSITY_CAT_ON_TREE());
        set.add(CURIOSITY_SLEEPY_CAPYBARA());
        set.add(CURIOSITY_GHOST_MINER());
        set.add(CURIOSITY_RESTLESS_SKULL());
        set.add(CURIOSITY_FLICKER_MAN());
        set.add(CURIOSITY_VOID_LANTERN());
        set.add(CURIOSITY_JUNK_SENTINEL());

        return set;
    }

    private static CuriosityData CURIOSITY_Headless_Eye(){
        CuriosityData curiosityData = new CuriosityData();
        curiosityData.setID(Curiosities.HEADLESS_EYE);
        curiosityData.setDisplayMaterial(Material.PLAYER_HEAD);
        curiosityData.setLocation(Locations.Hearthgrove);
        curiosityData.setSkullValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjYwYTc3ZDJiN2ZjYWI5MTZkZDk1NjcwOGFhNTEwMTZjZjVhZmQwNDU5ZmNhMzQ2YmQ2OTgyZmI1ZDViOTQ0In19fQ==" );

        return curiosityData;
    }
    private static CuriosityData CURIOSITY_CAT_ON_TREE(){
        CuriosityData curiosityData = new CuriosityData();
        curiosityData.setID(Curiosities.CAT_ON_TREE);
        curiosityData.setDisplayMaterial(Material.PLAYER_HEAD);
        curiosityData.setLocation(Locations.Hearthgrove);
        curiosityData.setSkullValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmI4MzYwZjc0OWUwYWNkYjRhM2IzZDNhMTBmOTQwMWI2YzllOGNmZDgyZjJiNGQ0N2FhZDlhN2JkMTY5ZDJmNyJ9fX0=");
        return curiosityData;
    }

    private static CuriosityData CURIOSITY_SLEEPY_CAPYBARA(){
        CuriosityData curiosityData = new CuriosityData();
        curiosityData.setID(Curiosities.SLEEPY_CAPYBARA);
        curiosityData.setDisplayMaterial(Material.PLAYER_HEAD);
        curiosityData.setLocation(Locations.Sporewood);
        curiosityData.setSkullValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjc5ZmUwNTRhOTIzZGZiODg0ZjZjNjAzMTk4MmJkMDlhY2IwNDQ2Y2Q0NzExYjRjYjQzM2JlOTA0ZDVkNWJmZCJ9fX0=");
        return curiosityData;
    }

    private static CuriosityData CURIOSITY_GHOST_MINER(){
        CuriosityData curiosityData = new CuriosityData();
        curiosityData.setID(Curiosities.GHOST_MINER);
        curiosityData.setDisplayMaterial(Material.WITHER_SKELETON_SKULL);
        curiosityData.setLocation(Locations.Ashvein_Mine);
        return curiosityData;
    }

    private static CuriosityData CURIOSITY_RESTLESS_SKULL(){
        CuriosityData curiosityData = new CuriosityData();
        curiosityData.setID(Curiosities.RESTLESS_SKULL);
        curiosityData.setDisplayMaterial(Material.SKELETON_SKULL);
        curiosityData.setLocation(Locations.Doomrest);
        return curiosityData;
    }

    private static CuriosityData CURIOSITY_FLICKER_MAN(){
        CuriosityData curiosityData = new CuriosityData();
        curiosityData.setID(Curiosities.FLICKER_MAN);
        curiosityData.setDisplayMaterial(Material.PLAYER_HEAD);
        curiosityData.setLocation(Locations.The_Fold);
        curiosityData.setSkullValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDBkNGNhYWE1NTRhZWY4OWM4ZDA3NDc2Zjg3ZTA2NzlkYjBkZmJiYjM1YmVhMGVkMjQ4ZjgzZWZhYWQ4YjgzOCJ9fX0=");
        return curiosityData;
    }

    private static CuriosityData CURIOSITY_VOID_LANTERN(){
        CuriosityData curiosityData = new CuriosityData();
        curiosityData.setID(Curiosities.VOID_LANTERN);
        curiosityData.setDisplayMaterial(Material.SOUL_LANTERN);
        curiosityData.setLocation(Locations.The_Beyond);
        return curiosityData;
    }

    private static CuriosityData CURIOSITY_JUNK_SENTINEL(){
        CuriosityData curiosityData = new CuriosityData();
        curiosityData.setID(Curiosities.JUNK_SENTINEL);
        curiosityData.setDisplayMaterial(Material.PLAYER_HEAD);
        curiosityData.setLocation(Locations.Junkyard);
        curiosityData.setSkullValue("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2QxZmVjN2QwMDBmYmYzMmIwN2IxMmNiNWNkZmNkZWZiYTJmMTc4ZmExM2EzODgzYmMyOTE0ODM4NzNkZDBmYyJ9fX0=");
        return curiosityData;
    }

}
