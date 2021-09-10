package zEvents;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class Invsee implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("So no jogo console!");
			return true;
		}
		final Logger log = Logger.getLogger("Minecraft");
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("invsee")) {
			if (!p.hasPermission("kitpvp.invsee")) {
				p.sendMessage(ChatColor.RED + "Voce nao tem Pprmissao!");
				return true;
			}
			if (args.length == 1) {
				if (p.getServer().getPlayer(args[0]) != null) {
					final Player targetplayer = p.getServer().getPlayer(args[0]);
					p.openInventory((Inventory) targetplayer.getInventory());
					log.info("[Comando] [Commando] " + p.getDisplayName() + ": " + "/" + commandLabel + " "
							+ targetplayer.getDisplayName());
					p.sendMessage(ChatColor.GRAY + "Abriu o inventario de " + targetplayer.getDisplayName() + ".");
				} else {
					p.sendMessage(ChatColor.RED + "Jogador nao encontrado.");
				}
			} else if (args.length > 1 || args.length < 1) {
				p.sendMessage(ChatColor.RED + "Use: /" + commandLabel + " <jogador>");
			}
		}
		return true;
	}
}
