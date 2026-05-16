package net.kingproductions.splitbornAPI.CuriosityContainer;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import org.bukkit.Material;

import java.util.HashSet;
import java.util.Set;

public class CuriosityCreator {

    public static Set<CuriosityData> getCuriosityData(){
        Set<CuriosityData> set = new HashSet<>();
        set.add(CURIOSITY_Headless_Eye());
        set.add(CURIOSITY_CAT_ON_TREE());

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

}
