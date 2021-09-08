package zKits;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import me.confuser.barapi.BarAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Pvp implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
        final Player p = (Player)sender;
        if (cmd.getLabel().equalsIgnoreCase("pvp")) {
            if (!p.hasPermission("kitxc.pvp")) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
                return true;
            }
            if (Arrays.used.contains(p.getName())) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
                return true;
            }
            Arrays.used.add(p.getName());
            Arrays.pvp.add(p.getName());
            p.getInventory().clear();
            p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " PvP");
            BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lPvP", 10);
            final ItemStack bow = new ItemStack(Material.STONE_SWORD);
            final ItemMeta bowmeta = bow.getItemMeta();
            bowmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            bowmeta.setDisplayName("§9Espada de Pedra");
            bow.setItemMeta(bowmeta);
            p.getInventory().setItem(0, bow);
            KitsManager.darSopas(p);
        }
        return false;
    }
}
