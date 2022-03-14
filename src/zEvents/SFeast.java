package zEvents;

import org.bukkit.Bukkit;

import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class SFeast {
	public static void start() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				Bukkit.broadcastMessage("�6>> �eO Feast Spawnou !");
				Ffeast.miniFeast();
			}
		}, 0L, 1500L);
	}

	public static void start1() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				Ffeast.miniFeast1();
			}
		}, 0L, 1300L);
	}
}
