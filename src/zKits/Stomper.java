package zKits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import me.confuser.barapi.BarAPI;
import zEvents.Tab;
import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class Stomper implements Listener, CommandExecutor {
	public static PublicPvP plugin;
	public static HashMap<String, Long> cooldown;
	public static List<Player> cooldownm;

	static {
		Stomper.cooldown = new HashMap<String, Long>();
		Stomper.cooldownm = new ArrayList<Player>();
	}

	public Stomper(final PublicPvP main) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
		final Player p = (Player) sender;
		if (cmd.getLabel().equalsIgnoreCase("stomper")) {
			if (!p.hasPermission("kitxc.stomper")) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
				return true;
			}
			if (Arrays.used.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
				return true;
			}
			Arrays.used.add(p.getName());
			Arrays.stomper.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit �6 >> " + ChatColor.GRAY + " Stomper");
			Tab.sendTitle(p, "�cStomper");
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
			BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lStomper", 10);
			KitsManager.darSopas(p);
		}
		return false;
	}

	@EventHandler
	public void StomperFall(final EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			final Player p = (Player) event.getEntity();
			if (event.getCause() == EntityDamageEvent.DamageCause.FALL && Arrays.stomper.contains(p.getName())) {
				for (final Entity pertos : p.getNearbyEntities(8.0, 5.0, 8.0)) {
					if (!(pertos instanceof Player)) {
						continue;
					}
					final Player stompados = (Player) pertos;
					if (stompados.isSneaking()) {
						stompados.damage(4.0);
						stompados.playSound(p.getLocation(), Sound.ANVIL_LAND, 4.0f, 4.0f);
						p.playSound(p.getLocation(), Sound.ANVIL_LAND, 4.0f, 4.0f);
					} else {
						stompados.damage((double) (p.getFallDistance() - 8.0f));
						stompados.playSound(p.getLocation(), Sound.ANVIL_LAND, 4.0f, 4.0f);
						p.playSound(p.getLocation(), Sound.ANVIL_LAND, 4.0f, 4.0f);
						stompados.isDead();
					}
				}
				if (event.getDamage() > 4.0) {
					event.setDamage(4.0);
				}
			}
		}
	}
}
