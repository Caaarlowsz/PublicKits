package zEvents;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class CombatLog implements Listener {
	public Plugin plugin;
	public static List<String> Sair;

	static {
		CombatLog.Sair = new ArrayList<String>();
	}

	public CombatLog(final PublicPvP plugin) {
		this.plugin = (Plugin) plugin;
	}

	@EventHandler
	public void onEntityDamage(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			final Player bateu = (Player) e.getDamager();
			if (!CombatLog.Sair.contains(p.getName()) && !CombatLog.Sair.contains(bateu.getName())) {
				CombatLog.Sair.add(p.getName());
				CombatLog.Sair.add(bateu.getName());
				p.sendMessage("�6>> �cVoc\u00ea entrou em combate com �4" + bateu.getName() + " �c!");
				bateu.sendMessage("�6>> �cVoc\u00ea entrou em combate com �4" + p.getName() + " �c!");
				Bukkit.getScheduler().scheduleSyncDelayedTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						CombatLog.Sair.remove(p.getName());
						CombatLog.Sair.remove(bateu.getName());
						p.sendMessage("�6>> �aVoc\u00ea N\u00e3o Esta Mais em Combate.");
						bateu.sendMessage("�6>> �aVoc\u00ea N\u00e3o Esta Mais em Combate.");
					}
				}, 300L);
			}
		}
	}

	@EventHandler
	public void onPlayerExit(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (CombatLog.Sair.contains(p.getName())) {
			p.setHealth(0.0);
			p.teleport(p.getWorld().getSpawnLocation());
			Bukkit.broadcastMessage("�6>> �f" + p.getName() + "�f Deslogou em PvP !");
		}
	}
}
