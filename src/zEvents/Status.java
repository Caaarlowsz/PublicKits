package zEvents;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class Status implements Listener {
	@EventHandler
	public void onJoin(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		if (PublicPvP.getPlugin().getConfig().get("status." + p.getName().toLowerCase() + ".kills") == null) {
			PublicPvP.getPlugin().getConfig().set("status." + p.getName().toLowerCase() + ".kills", (Object) 0);
		}
		if (PublicPvP.getPlugin().getConfig().get("status." + p.getName().toLowerCase() + ".mortes") == null) {
			PublicPvP.getPlugin().getConfig().set("status." + p.getName().toLowerCase() + ".mortes", (Object) 0);
		}
		PublicPvP.getPlugin().saveConfig();
	}

	@EventHandler
	public void onDeath(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		final Player k = p.getKiller();
		if (!(p instanceof Player)) {
			return;
		}
		if (!(k instanceof Player)) {
			return;
		}
		k.sendMessage("�6>> �e Voc\u00ea Eliminou o Player " + p.getName());
		k.sendMessage("�6>> �e + 75 COINS ");
		k.sendMessage("�6>> �e + 2 LEVEL ");
		PublicPvP.cash.put((OfflinePlayer) k, PublicPvP.cash.get(k) + 2);
		PublicPvP.econ.depositPlayer(k.getName(), 75.0);
		p.sendMessage("�6>> �eVoce morreu eliminado por " + k.getName());
		p.sendMessage("�6>> �e - 20 COINS ");
		p.sendMessage("�6>> �e - 1 LEVEL ");
		PublicPvP.cash.put((OfflinePlayer) p, (PublicPvP.cash.get(p) < 0) ? 0 : (PublicPvP.cash.get(p) - 0));
		PublicPvP.cash.put((OfflinePlayer) p, PublicPvP.cash.get(p) - 1);
		PublicPvP.econ.withdrawPlayer(p.getName(), 20.0);
		if (!(k instanceof Player)) {
			e.setDeathMessage("�6>> �cVoce morreu!");
		}
		final int kills = PublicPvP.getPlugin().getConfig().getInt("status." + k.getName().toLowerCase() + ".kills");
		PublicPvP.getPlugin().getConfig().set("status." + k.getName().toLowerCase() + ".kills", (Object) (kills + 1));
		final int mortes = PublicPvP.getPlugin().getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes");
		PublicPvP.getPlugin().getConfig().set("status." + p.getName().toLowerCase() + ".mortes", (Object) (mortes + 1));
		PublicPvP.getPlugin().saveConfig();
	}
}
