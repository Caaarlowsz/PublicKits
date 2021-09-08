package zKits;

import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import me.confuser.barapi.BarAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Evolucionist implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
        final Player p = (Player)sender;
        if (cmd.getLabel().equalsIgnoreCase("evolucionist")) {
            if (!p.hasPermission("kitxc.evolucionist")) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
                return true;
            }
            if (Arrays.used.contains(p.getName())) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
                return true;
            }
            Arrays.used.add(p.getName());
            Arrays.kriptonita.add(p.getName());
            p.getInventory().clear();
            p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Evolucionist");
            BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lEvolucionist", 10);
            final ItemStack bow = new ItemStack(Material.STONE_SWORD);
            final ItemMeta bowmeta = bow.getItemMeta();
            bowmeta.setDisplayName("§9Espada de Pedra");
            bow.setItemMeta(bowmeta);
            p.getInventory().setItem(0, bow);
            KitsManager.darSopas(p);
        }
        return false;
    }
    
    @EventHandler
    public void onKillLevel(final PlayerDeathEvent event) {
        if (!(event.getEntity().getKiller() instanceof Player)) {
            return;
        }
        if (event.getEntity().getKiller() == null) {
            return;
        }
        final Player p = event.getEntity();
        final Player k = p.getKiller();
        k.setLevel(k.getLevel() + 1);
        p.setLevel(0);
    }
    
    @EventHandler
    public void onLevel(final PlayerLevelChangeEvent e) {
        final Player p = e.getPlayer();
        if (Arrays.kriptonita.contains(p.getName())) {
            if (e.getNewLevel() == 2) {
                p.sendMessage("§aVoc\u00ea Evoluiu!");
                p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
            }
            if (e.getNewLevel() == 4) {
                p.sendMessage("§aVoc\u00ea Evoluiu!");
                p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
            }
            if (e.getNewLevel() == 6) {
                p.sendMessage("§aVoc\u00ea Evoluiu!");
                p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
            }
            if (e.getNewLevel() == 8) {
                p.sendMessage("§aVoc\u00ea Evoluiu!");
                p.getInventory().setLeggings(new ItemStack(Material.GOLD_LEGGINGS));
            }
        }
    }
}
