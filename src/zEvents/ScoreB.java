package zEvents;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import zPublic.Main;

public class ScoreB implements Listener {
	public static void setScoreBoard(final Player p) {
		final Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
		final Objective o = score.registerNewObjective("Score", "KitPvP");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName(new StringBuilder().append(Main.getPlugin().getConfig().getString("server").replace("&", "§"))
				.toString());
		final Score espaco3 = o.getScore(Bukkit.getOfflinePlayer("§2"));
		final Score kills = o.getScore(Bukkit.getOfflinePlayer("§7Matou§6>>"));
		final Score killsr = o.getScore(Bukkit.getOfflinePlayer(
				"§a" + Main.getPlugin().getConfig().getInt("status." + p.getName().toLowerCase() + ".kills")));
		final Score deaths = o.getScore(Bukkit.getOfflinePlayer("§7Morreu§6>>"));
		final Score deathsr = o.getScore(Bukkit.getOfflinePlayer(
				"§c" + Main.getPlugin().getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes")));
		final Score nick = o.getScore(Bukkit.getOfflinePlayer("§4"));
		final Score espaco4 = o.getScore(Bukkit.getOfflinePlayer("§7Level§6>>"));
		final Score nickr = o.getScore(Bukkit.getOfflinePlayer("§a" + Main.cash.get(p)));
		final Score deathsr2 = o.getScore(Bukkit.getOfflinePlayer("§7Coins§6>>"));
		final Score espaco5 = o.getScore(Bukkit.getOfflinePlayer("§a" + Main.econ.getBalance((OfflinePlayer) p)));
		espaco3.setScore(13);
		kills.setScore(12);
		killsr.setScore(11);
		deaths.setScore(10);
		deathsr.setScore(9);
		nick.setScore(8);
		espaco4.setScore(7);
		nickr.setScore(6);
		deathsr2.setScore(5);
		espaco5.setScore(4);
		p.setScoreboard(score);
	}
}
