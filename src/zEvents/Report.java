package zEvents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Report implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("report")) {
			if (args.length == 0) {
				p.sendMessage("§l§6>> §fUse: /report {Jogador} {Motivo}!");
				return true;
			}
			if (args.length == 1) {
				p.sendMessage("§l§6>> §fUse: /report {Jogador} {Motivo}!");
				return true;
			}
			if (args.length >= 2) {
				final String alvo = args[0];
				final Player target = Bukkit.getPlayer(alvo);
				if (target == null) {
					p.sendMessage("§l§6>> §fJogador nao encontrado!");
					return true;
				}
				final StringBuilder sb = new StringBuilder();
				for (int i = 1; i < args.length; ++i) {
					sb.append(args[i]);
					if (i < args.length) {
						sb.append(" ");
					}
				}
				p.sendMessage("§l§6>> §fReport feito com sucesso!");
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, j = 0; j < length; ++j) {
					final Player staff = onlinePlayers[j];
					if (staff.hasPermission("kitpvp.staffreport") || staff.isOp()) {
						staff.sendMessage(
								"§f\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac");
						staff.sendMessage("§ePlayer Reportado: " + ChatColor.RED + target.getName());
						staff.sendMessage("§eQuem Reportou: " + ChatColor.GREEN + p.getName());
						staff.sendMessage("§eMotivo: " + ChatColor.RED + sb.toString());
						staff.sendMessage(
								"§f\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac");
						staff.playSound(staff.getLocation(), Sound.CHICKEN_HURT, 10.0f, 1.0f);
					}
				}
			}
		}
		return false;
	}
}
