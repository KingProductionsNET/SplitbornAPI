package net.kingproductions.splitbornAPI.QuestContainer.QuestCreation;

import net.kingproductions.splitbornAPI.LocationsContainer.Locations;
import org.bukkit.Material;

import java.util.List;

public abstract class QuestPreset {

    public abstract boolean isMainQuest();
    public abstract Quests questID();
    public abstract Locations questLocation();
    public abstract Material displayMaterial();
    public abstract List<String> inQuestDescriptionText();
    public abstract List<String> inventoryDescriptionText();

}
