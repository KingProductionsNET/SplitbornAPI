package net.kingproductions.splitbornAPI.CuriosityContainer;

import org.bukkit.Material;

public class CuriosityData {

    private Curiosities ID;
    private Material material;
    private String skullValue;

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

    public Curiosities getID(){
        return ID;
    }

    public Material getMaterial(){
        return material;
    }

    public String getSkullValue(){
        return skullValue;
    }

}
