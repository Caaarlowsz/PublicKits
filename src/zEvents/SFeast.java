package zEvents;

import zPublic.Main;
import org.bukkit.Bukkit;

public class SFeast
{
    public static void start() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("§6>> §eO Feast Spawnou !");
                Ffeast.miniFeast();
            }
        }, 0L, 1500L);
    }
    
    public static void start1() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
                Ffeast.miniFeast1();
            }
        }, 0L, 1300L);
    }
}
