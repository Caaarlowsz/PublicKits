package zEvents;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import zPublic.Main;

public class RemoveR implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("fecharrdm") && p.hasPermission("kitpvp.rdma")) {
			Main.getPlugin().getServer().dispatchCommand(
					(CommandSender) Main.getPlugin().getServer().getConsoleSender(),
					"pex group default remove kitpvp.rdmabrir");
			Bukkit.broadcastMessage(Main.getPlugin().getConfig().getString("server").replace("&", "�")
					+ " �6>> �bRDM Foi Fechada Tente na Proxima!");
			return true;
		}
		return false;
	}
}
