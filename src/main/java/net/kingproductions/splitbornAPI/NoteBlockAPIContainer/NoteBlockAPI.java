package net.kingproductions.splitbornAPI.NoteBlockAPIContainer;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.EntitySongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.*;

import static net.kingproductions.splitbornAPI.CosmeticTourContainer.CosmeticTour.isInATour;
import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;

public class NoteBlockAPI {

    public static Set<UUID> StopSong = new HashSet<>();
    private static Map<UUID, List<EntitySongPlayer>> playersSongs = new HashMap<>();

    public static void Play(Player player, String SongName, boolean isTour){
        Song song = NBSDecoder.parse(new File("plugins/Splitborn/Songs/" + SongName + ".nbs"));

        EntitySongPlayer esp = new EntitySongPlayer(song);
        esp.setEntity(player);
        esp.setDistance(40);
        esp.setAutoDestroy(true);
        esp.setVolume((byte) 100);
        esp.addPlayer(player);
        esp.setPlaying(true);

        new BukkitRunnable(){

            @Override
            public void run() {
                if (isTour && !isInATour.contains(player)){
                    esp.setPlaying(false);
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 10);

        if (!isTour) {
            new BukkitRunnable() {

                @Override
                public void run() {
                    if (StopSong.contains(player.getUniqueId())) {
                        esp.setPlaying(false);
                        StopSong.remove(player.getUniqueId());
                        esp.removePlayer(player.getUniqueId());

                        for (EntitySongPlayer entitySongPlayer : playersSongs.getOrDefault(player.getUniqueId(), new ArrayList<>())){
                            if (entitySongPlayer != null){
                                entitySongPlayer.removePlayer(player.getUniqueId());
                                entitySongPlayer.setPlaying(false);
                            }
                        }
                        this.cancel();
                    }
                }
            }.runTaskTimer(plugin, 0, 1);
        }

        List<EntitySongPlayer> list = playersSongs.getOrDefault(player.getUniqueId(), new ArrayList<>());
        list.add(esp);

        playersSongs.put(player.getUniqueId(), list);
    }
    public static void stopSong(Player player){
        StopSong.add(player.getUniqueId());
    }
}
