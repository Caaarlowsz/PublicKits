package zKits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import zEvents.Tab;
import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class Terrorista implements Listener, CommandExecutor {
	public static ArrayList<Player> cooldownm;

	static {
		Terrorista.cooldownm = new ArrayList<Player>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
		final Player p = (Player) sender;
		if (cmd.getLabel().equalsIgnoreCase("terrorista")) {
			if (!p.hasPermission("kitxc.terrorista")) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
				return true;
			}
			if (Arrays.used.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
				return true;
			}
			Arrays.used.add(p.getName());
			Arrays.terrorista.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit �6 >> " + ChatColor.GRAY + " Terrorista");
			Tab.sendTitle(p, "�cTerrorista");
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MAGMA_CREAM) });
			BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lTerrorista", 10);
			KitsManager.darSopas(p);
		}
		return false;
	}

	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.MAGMA_CREAM
				&& Arrays.terrorista.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (Terrorista.cooldownm.contains(p)) {
				p.sendMessage(String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
						+ ">> �eKit em Cooldown!");
				return;
			}
			final Vector vector = p.getEyeLocation().getDirection();
			vector.multiply(0.0f);
			vector.setY(6.0f);
			p.setVelocity(vector);
			final Location loc = p.getLocation();
			p.getWorld().playSound(loc, Sound.ENDERMAN_TELEPORT, 5.0f, -5.0f);
			Terrorista.cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					Terrorista.cooldownm.remove(p);
					p.sendMessage("�eVoce pode usar novamente!");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
				}
			}, 400L);
		}
	}

	@EventHandler
	public void idknow(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (e.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
				return;
			}
			if (Arrays.terrorista.contains(p.getName())) {
				e.setCancelled(true);
			} else {
				e.setDamage(e.getDamage() * 2.0);
			}
		}
	}

	@EventHandler
	public void stomper(final EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		final Player p = (Player) event.getEntity();
		if (Arrays.terrorista.contains(p.getName()) && event.getDamage() >= 8.0) {
			event.setDamage(8.0);
			for (final Entity e : p.getNearbyEntities(3.0, 3.0, 3.0)) {
				if (e instanceof Player && !((Player) e).isSneaking()) {
					p.getWorld().createExplosion(p.getLocation(), 3.0f);
				}
			}
		}
	}
}
