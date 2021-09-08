package zEvents;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Holograms implements CommandExecutor, Listener
{
    public static ArrayList<Player> Build;
    
    static {
        Holograms.Build = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        if (Label.equalsIgnoreCase("Build")) {
            final Player p = (Player)Sender;
            if (Args.length == 0) {
                Sender.sendMessage("§cUse: /build On/Off");
                return true;
            }
            if (!p.hasPermission("kitpvp.build")) {
                p.sendMessage("§e >> §cSem Permiss\u00e3o!");
                return true;
            }
            if (Args[0].equalsIgnoreCase("On")) {
                p.sendMessage("§7[§e!§7]Modo Constru\u00e7\u00e3o§a§l>> §2§oAtivado");
                Holograms.Build.add(p);
            }
            if (Args[0].equalsIgnoreCase("Off")) {
                p.sendMessage("§7[§e!§7]Modo Constru\u00e7\u00e3o§a§l>> §2§oDesativado");
                Holograms.Build.remove(p);
            }
        }
        return false;
    }
}
