package zEvents;

import org.bukkit.GameMode;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Gm implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("gm") && sender.hasPermission("kitpvp.gm")) {
            if (args.length != 1) {
                p.sendMessage(ChatColor.GRAY + "Use Gm 0 ou Gm 1");
                return true;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("0")) {
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage("§6>>§7Modo de Jogo Alterado Para Sobreviv\u00eancia");
                }
                if (args[0].equalsIgnoreCase("1")) {
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage("§6>>§7Modo de Jogo Alterado Para Criativo");
                }
                return true;
            }
        }
        return false;
    }
}
