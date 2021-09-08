package zKits;

import java.util.List;
import java.util.Arrays;
import java.util.Random;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import zPublic.Main;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Surprise implements CommandExecutor, Listener
{
    public Surprise(final Main main) {
    }
    
    public Surprise() {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("surprise") && p.hasPermission("kitxc.surprise")) {
            final Random random = new Random();
            final List randomCommands = Arrays.asList("PvP", "Viking", "Terrorista", "Ninja", "Kangaroo", "Viper", "DeshFire", "Stomper", "WoodMan", "Sonic", "Turtle", "Fisherman", "Endermage", "Velotrol", "Thor", "Gon", "Firer", "Zeus", "Tornado");
            final int index = random.nextInt(randomCommands.size());
            final String command = randomCommands.get(index);
            p.performCommand(command);
        }
        return false;
    }
}
