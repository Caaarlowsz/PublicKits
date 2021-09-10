package zKits;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.mrchunkys.api.ActionBar;
import me.confuser.barapi.BarAPI;

public class BarKit implements Listener {
	@EventHandler
	public void onPlayerKit(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.pvp.contains(t.getName())) {
			final ActionBar bar = new ActionBar(p, "§a§l>> §fPvP §a§l<<");
			bar.sendPlayerAnnouncement();
		}
	}

	@EventHandler
	public void onPlayerKit1(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.viper.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Viper", 8);
			final ActionBar bar = new ActionBar(p, "§a§l>> §fViper §a§l<<");
			bar.sendPlayerAnnouncement();
		}
	}

	@EventHandler
	public void onPlayerKit3(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.stomper.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Stomper", 8);
			final ActionBar bar = new ActionBar(p, "§a§l>> §fStomper §a§l<<");
			bar.sendPlayerAnnouncement();
		}
	}

	@EventHandler
	public void onPlayerKit31(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.urano.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Urano", 8);
		}
	}

	@EventHandler
	public void onPlayerKit4(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.ninja.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Ninja", 8);
			final ActionBar bar = new ActionBar(p, "§a§l>> §fNinja §a§l<<");
			bar.sendPlayerAnnouncement();
		}
	}

	@EventHandler
	public void onPlayerKit2(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.kangaroo.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Kangaroo", 8);
			final ActionBar bar = new ActionBar(p, "§a§l>> §fKangaroo §a§l<<");
			bar.sendPlayerAnnouncement();
		}
	}

	@EventHandler
	public void onPlayerKit5(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.terrorista.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Terrorista", 8);
			final ActionBar bar = new ActionBar(p, "§a§l>> §fTerrorista §a§l<<");
			bar.sendPlayerAnnouncement();
		}
	}

	@EventHandler
	public void onPlayerKit6(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.shadow.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Sonic", 8);
			final ActionBar bar = new ActionBar(p, "§a§l>> §fSonic §a§l<<");
			bar.sendPlayerAnnouncement();
		}
	}

	@EventHandler
	public void onPlayerKit7(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.desh.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6DeshFire", 8);
			final ActionBar bar = new ActionBar(p, "§a§l>> §fDeshFire §a§l<<");
			bar.sendPlayerAnnouncement();
		}
	}

	@EventHandler
	public void onPlayerKit8(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.pulo.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Fisherman", 8);
			final ActionBar bar = new ActionBar(p, "§a§l>> §fFisherman §a§l<<");
			bar.sendPlayerAnnouncement();
		}
	}

	@EventHandler
	public void onPlayerKit9(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.endermage.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Endermage", 8);
			final ActionBar bar = new ActionBar(p, "§a§l>> §fEndermage §a§l<<");
			bar.sendPlayerAnnouncement();
		}
	}

	@EventHandler
	public void onPlayerKit10(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.turtle.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Turtle", 8);
			final ActionBar bar = new ActionBar(p, "§a§l>> §fTurtle §a§l<<");
			bar.sendPlayerAnnouncement();
		}
	}

	@EventHandler
	public void onPlayerKit11(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.troll.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6WoodMan", 8);
			final ActionBar bar = new ActionBar(p, "§a§l>> §fWoodMan §a§l<<");
			bar.sendPlayerAnnouncement();
		}
	}

	@EventHandler
	public void onPlayerKit12(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.viking.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Viking", 8);
			final ActionBar bar = new ActionBar(p, "§a§l>> §fViking §a§l<<");
			bar.sendPlayerAnnouncement();
		}
	}

	@EventHandler
	public void onPlayerKit121(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.thor.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Thor", 8);
		}
	}

	@EventHandler
	public void onPlayerKit1211(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.urgal.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Velotrol", 8);
		}
	}

	@EventHandler
	public void onPlayerKit12111(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.kiwwi.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6SuperNova", 8);
		}
	}

	@EventHandler
	public void onPlayerKit121111(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.avatar.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Iceman", 8);
		}
	}

	@EventHandler
	public void onPlayerKit1211111(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.ironman.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Mago", 8);
		}
	}

	@EventHandler
	public void onPlayerKit12111111(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.magma.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Firer", 8);
		}
	}

	@EventHandler
	public void onPlayerKit121111111(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.teste.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Rain", 8);
		}
	}

	@EventHandler
	public void onPlayerKit1211111111(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (Arrays.reaper.contains(t.getName())) {
			BarAPI.setMessage(p, String.valueOf(t.getDisplayName()) + "§f - §6Tornado", 8);
		}
	}
}
