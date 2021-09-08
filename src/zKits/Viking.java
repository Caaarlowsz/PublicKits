package zKits;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import me.confuser.barapi.BarAPI;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import zEvents.Tab;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Viking implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
        final Player p = (Player)sender;
        if (cmd.getLabel().equalsIgnoreCase("viking")) {
            if (!p.hasPermission("kitxc.viking")) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
                return true;
            }
            if (Arrays.used.contains(p.getName())) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
                return true;
            }
            Arrays.used.add(p.getName());
            Arrays.viking.add(p.getName());
            p.getInventory().clear();
            p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Viking");
            Tab.sendTitle(p, "§cViking");
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_AXE) });
            BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lViking", 10);
            KitsManager.darSopas(p);
        }
        return false;
    }
    
    @EventHandler
    public void main(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player d = (Player)e.getDamager();
            if (Arrays.viking.contains(d.getName()) && (d.getItemInHand().getType() == Material.WOOD_AXE || d.getItemInHand().getType() == Material.STONE_AXE || p.getItemInHand().getType() == Material.GOLD_AXE || p.getItemInHand().getType() == Material.IRON_AXE || p.getItemInHand().getType() == Material.DIAMOND_AXE)) {
                e.setDamage(e.getDamage() * 2.5);
            }
        }
    }
}
