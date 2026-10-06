package net.kingproductions.splitbornAPI.NPC;

import java.util.concurrent.CompletableFuture;

public interface NPCProvider {

    SplitbornNPC spawnNPC(SplitbornNPC splitbornNPC);
    CompletableFuture<Void> getNpcLocationsLoaded();

}
