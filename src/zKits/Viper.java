package zKits;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;
import zEvents.Tab;

public class Viper implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
		final Player p = (Player) sender;
		if (cmd.getLabel().equalsIgnoreCase("viper")) {
			if (!p.hasPermission("kitxc.viper")) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
				return true;
			}
			if (Arrays.used.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
				return true;
			}
			Arrays.used.add(p.getName());
			Arrays.viper.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Viper");
			Tab.sendTitle(p, "§cViper");
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lViper", 10);
			KitsManager.darSopas(p);
		}
		return false;
	}

	@EventHandler
	public void onViperHit(final EntityDamageByEntityEvent e) {
		final Player p = (Player) e.getEntity();
		final Player d = (Player) e.getDamager();
		if (p instanceof Player && d instanceof Player && Arrays.viper.contains(d.getName())) {
			final Random rand = new Random();
			final int percent = rand.nextInt(100);
			if (percent <= 33) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 120, 0));
			}
		}
	}
}
