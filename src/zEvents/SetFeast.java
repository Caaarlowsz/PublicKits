package zEvents;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class SetFeast implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String tag, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cVoc\u00ea n\u00e3o \u00e9 um jogador");
            return true;
        }
        final Player p = (Player)sender;
        if (!tag.equalsIgnoreCase("setffeast")) {
            if (cmd.getName().equalsIgnoreCase("ffeast") && p.hasPermission("kitpvp.feast")) {
                Ffeast.miniFeast();
                p.sendMessage(" §bFeast Criado.");
            }
            if (cmd.getName().equalsIgnoreCase("rfeast") && p.hasPermission("kitpvp.feast")) {
                Ffeast.miniFeast1();
                p.sendMessage(" §bFeast removido.");
                Ffeast.setSimulatorCords1(p);
            }
            return false;
        }
        if (!p.hasPermission("kitpvp.feast")) {
            p.sendMessage("§cSem Permiss\u00e3o!");
            return true;
        }
        p.sendMessage("§bVoc\u00ea Setou o Feast");
        Ffeast.setSimulatorCords1(p);
        return true;
    }
}
