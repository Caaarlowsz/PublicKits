package zEvents;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import zPublic.Main;

public class VerCash implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] a) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cApenas Players!");
		}
		final Player p = (Player) sender;
		if (!cmd.getName().equalsIgnoreCase("cash")) {
			return false;
		}
		if (a.length == 0) {
			p.sendMessage("§6" + Main.cash.get(p) + " §7de Cash");
			return true;
		}
		if (a.length != 1) {
			if (a.length == 3) {
				if (a[0].equals("set")) {
					final Player target = Bukkit.getPlayerExact(a[2]);
					if (target == null) {
						p.sendMessage("§cEste Player n\u00e3o existe ou n\u00e3o esta online.");
						return true;
					}
					try {
						final Integer numero = Integer.valueOf(a[1]);
						Main.cash.put((OfflinePlayer) target, numero);
						p.sendMessage("§7Level do Player " + target.getName() + " §6" + Main.cash.get(p));
					} catch (Exception e) {
						p.sendMessage("§c Isso n\u00e3o \u00e9 um numero!");
					}
					return true;
				} else if (a[0].equals("take")) {
					final Player target = Bukkit.getPlayerExact(a[2]);
					if (target == null) {
						p.sendMessage("§cEste Player n\u00e3o existe ou n\u00e3o esta online.");
						return true;
					}
					try {
						final Integer numero = Integer.valueOf(a[1]);
						Main.cash.put((OfflinePlayer) target,
								(numero > Main.cash.get(p)) ? 0 : (Main.cash.get(p) - numero));
						p.sendMessage("§7Level do Player " + target.getName() + " §6" + Main.cash.get(p));
					} catch (Exception e) {
						p.sendMessage("§c Isso n\u00e3o \u00e9 um numero!");
					}
					return true;
				} else if (a[0].equals("add")) {
					final Player target = Bukkit.getPlayerExact(a[2]);
					if (target == null) {
						p.sendMessage("§cEste Player n\u00e3o existe ou n\u00e3o esta online.");
						return true;
					}
					try {
						final Integer numero = Integer.valueOf(a[1]);
						Main.cash.put((OfflinePlayer) target, Main.cash.get(p) + numero);
						p.sendMessage("§7Level do Player " + target.getName() + " §6" + Main.cash.get(p));
					} catch (Exception e) {
						p.sendMessage("§c Isso n\u00e3o \u00e9 um numero!");
					}
					return true;
				}
			}
			return false;
		}
		final Player target = Bukkit.getPlayerExact(a[0]);
		if (target == null) {
			p.sendMessage("§cEste Player n\u00e3o existe ou n\u00e3o esta online.");
			return true;
		}
		p.sendMessage("§7Level do Player " + target.getName() + " §6 " + Main.cash.get(p));
		return true;
	}
}
