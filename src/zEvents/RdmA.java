package zEvents;

import org.bukkit.Bukkit;
import zPublic.Main;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class RdmA implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("abrirrdm") && p.hasPermission("kitpvp.rdma")) {
            Main.getPlugin().getServer().dispatchCommand((CommandSender)Main.getPlugin().getServer().getConsoleSender(), "pex group default add kitpvp.rdmabrir");
            Bukkit.broadcastMessage(Main.getPlugin().getConfig().getString("server").replace("&", "§") + " §6>> §bRDM Foi Aberta Corram Para Entrar!");
            return true;
        }
        return false;
    }
}
