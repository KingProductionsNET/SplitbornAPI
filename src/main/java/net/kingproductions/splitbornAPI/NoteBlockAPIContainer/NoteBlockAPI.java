package net.kingproductions.splitbornAPI.NoteBlockAPIContainer;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.EntitySongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static net.kingproductions.splitbornAPI.CosmeticTourContainer.CosmeticTour.isInATour;
import static net.kingproductions.splitbornAPI.Main.SplitbornAPI.plugin;

public class NoteBlockAPI {

    public static Set<UUID> StopSong = new HashSet<>();

    public static void Play(Player player, String SongName, boolean isTour){
        StopSong.remove(player.getUniqueId());

        Song song = NBSDecoder.parse(new File("plugins/Splitborn/Songs/" + SongName + ".nbs"));

        EntitySongPlayer esp = new EntitySongPlayer(song);
        esp.setEntity(player);
        esp.setDistance(32);
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
                        this.cancel();
                    }
                }
            }.runTaskTimer(plugin, 0, 10);
        }
    }
    public static void stopSong(Player player){
        StopSong.add(player.getUniqueId());
    }
}
