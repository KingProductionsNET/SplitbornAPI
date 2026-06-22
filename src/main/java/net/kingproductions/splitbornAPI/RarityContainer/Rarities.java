package net.kingproductions.splitbornAPI.RarityContainer;

public enum Rarities {

    COMMON("§6⭐ §a§lCOMMON "),
    RARE("§6⭐ §3§lRARE "),
    EPIC("§6⭐ §d§lEPIC "),
    LEGENDARY("§6⭐ §6§lLEGENDARY "),
    MYTHIC("§6⭐ §c§lMYTHIC "),
    QUEST_ITEM("§6⭐ §4§lQUEST ITEM");

    private final String value;

    Rarities(String value){
        this.value = value;
    }

    public String getString(){
        return this.value;
    }
}
