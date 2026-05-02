package net.kingproductions.splitbornAPI.CuriosityContainer;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import org.bukkit.Material;

public class CuriosityData {

    private Curiosities ID;
    private Material material;
    private String skullValue;
    private Locations location;

    public CuriosityData setID(Curiosities c){
        ID = c;
        return this;
    }

    public CuriosityData setDisplayMaterial(Material m){
        material = m;
        return this;
    }
    public CuriosityData setSkullValue(String s){
        skullValue = s;
        return this;
    }
    public CuriosityData setLocation(Locations l){
        location = l;
        return this;
    }

    public Curiosities getID(){
        return ID;
    }

    public Material getMaterial(){
        return material;
    }

    public String getSkullValue(){
        return skullValue;
    }
    public Locations getLocation(){
        return location;
    }

}
