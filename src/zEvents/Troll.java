package zEvents;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Troll implements Listener, CommandExecutor
{
    public static ArrayList<Player> admin;
    
    static {
        Troll.admin = new ArrayList<Player>();
    }
    
    @EventHandler
    public void onInteract12(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.BOOK) {
            final Player r = (Player)e.getRightClicked();
            p.openInventory((Inventory)r.getInventory());
        }
    }
    
    @EventHandler
    public void onInteract1234(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.BEDROCK) {
            final Player r = (Player)e.getRightClicked();
            r.getLocation().add(1.0, 14.0, 1.0).getBlock().setType(Material.OBSIDIAN);
            r.getLocation().add(1.0, 12.0, 2.0).getBlock().setType(Material.OBSIDIAN);
            r.getLocation().add(2.0, 12.0, 1.0).getBlock().setType(Material.OBSIDIAN);
            r.getLocation().add(1.0, 12.0, -2.0).getBlock().setType(Material.OBSIDIAN);
            r.getLocation().add(-2.0, 12.0, 1.0).getBlock().setType(Material.OBSIDIAN);
            r.getLocation().add(1.0, 11.0, 1.0).getBlock().setType(Material.OBSIDIAN);
            r.teleport(r.getLocation().add(0.0, 11.0, -0.05));
            p.sendMessage("§6Arena Criada !");
        }
    }
    
    public boolean onCommand(final CommandSender arg0, final Command arg1, final String arg2, final String[] arg3) {
        return false;
    }
}
