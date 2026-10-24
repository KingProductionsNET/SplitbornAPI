package net.kingproductions.splitbornAPI.FishingContainer;

public interface FishingProvider {

    /**
     *
     * @param Level The fishing level.
     * @return The required catches for this level. Returns -1 if the level wasn't found.
     */
    int getRequiredCatches(int Level);

}
