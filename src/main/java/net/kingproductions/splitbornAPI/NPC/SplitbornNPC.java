package net.kingproductions.splitbornAPI.NPC;

import org.bukkit.entity.EntityType;

public class SplitbornNPC {

    private NPC_ID ID;

    private EntityType type = null;

    private String Value = "ewogICJ0aW1lc3RhbXAiIDogMTc3NzQ3MjM4Mjc1OCwKICAicHJvZmlsZUlkIiA6ICJmNThkZWJkNTlmNTA0MjIyOGY2MDIyMjExZDRjMTQwYyIsCiAgInByb2ZpbGVOYW1lIiA6ICJ1bnZlbnRpdmV0YWxlbnQiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjU1N2M1ZjA1NmVkNDAyZmRhNGYzZWE0NjU3NWQyYmEwYmZjYWFjYjg3ZDhkZDFiMDIzYjc0ODUzMzcyMzc1YSIKICAgIH0KICB9Cn0=";
    private String Signature = "lCurX5AoIFE+Lkn5s8/2Sx7DriYVPRkNh0my8TJvPbtozrbAhXGUsBfvVJnn4mjhErBGzf0OzLjPBYUXUeyHSqflRNjMsskcvJU1Kk6aeJilA6DpM8Ep19t6jKE5hu7kWAb8+q0sSc+4gS5BZaHAIXuEZPVImxbj5PdkjiZp2CKvCDyMCHl9lm0JNZwnL0lPPxb9WT+v9fhgWwzZlVgfevJCvssjs/tye9gi6tG0WtmK6P4PVJLJrj3m277abjRiIgXaMmytqpwhn24QiBHUj3MOCZH95GuAQaeknnz34ow9vgsbiTCr8ClUHw1E4fND42xGnuGOthAZmY/IycJr4bGEc3Idbm9xAA7Mq4SFCXi9/EAAu9Dj++WJ2FNCQZ9MZ6x3nJ/ybVL+6A7hsQ2/ew4qZi3aTb2fiDCgokyXtZhXX8CBqWy8l8gBJmwvTPLgvPloJMZ3F9CHu8h0qlorA0r9TphYunP5FX5KtYKfzCEr367l/XZMU8PE1xkY5iF2xFJB3wVFz7WvnnyyHJvLdH2I+EI3kMM+utf2qYgkhKphTtO87vIFzn6U6JhTDh/eZ93wdCzNoqbmz5WSyaR+VARFyEs7OdwNZaR3MpN46Ymx5u48fJZCmhzH5ouvL+wLjuI0j9ZZqkg1eC+2bhPPeqvwkMyxt6y9hwRcktiZ6fE=";

    private String Name = "§cUnknown";

    public SplitbornNPC(NPC_ID npcId) {
        this.ID = npcId;
    }
    public SplitbornNPC setSkin(String value, String signature){
        Value = value;
        Signature = signature;
        return this;
    }
    public SplitbornNPC setEntityType(EntityType eT){
        type = eT;
        return this;
    }
    public SplitbornNPC setName(String name){
        Name = name;
        return this;
    }

    public String getSkin_Value(){
        return Value;
    }
    public String getSkin_Signature(){
        return Signature;
    }
    public NPC_ID getID(){
        return ID;
    }
    public String getName(){
        return Name;
    }


}
