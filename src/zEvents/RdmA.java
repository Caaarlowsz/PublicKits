package zEvents;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class RdmA implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("abrirrdm") && p.hasPermission("kitpvp.rdma")) {
			PublicPvP.getPlugin().getServer().dispatchCommand(
					(CommandSender) PublicPvP.getPlugin().getServer().getConsoleSender(),
					"pex group default add kitpvp.rdmabrir");
			Bukkit.broadcastMessage(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�")
					+ " �6>> �bRDM Foi Aberta Corram Para Entrar!");
			return true;
		}
		return false;
	}
}
