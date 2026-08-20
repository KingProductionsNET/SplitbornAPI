package net.kingproductions.splitbornAPI.RankContainer;

public enum Ranks {

    Admin("Admin"),
    Moderator("Moderator"),
    Builder("Builder"),
    Media("Media"),
    Royal("Royal"),
    Sovereign("Sovereign"),
    Default("Default");

    private final String value;

    Ranks(String value){
        this.value = value;
    }

    public String getString(){
        return this.value;
    }

}
