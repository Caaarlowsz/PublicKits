package zKits;

import java.util.Iterator;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import zPublic.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import zEvents.Tab;
import me.confuser.barapi.BarAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Zeus implements CommandExecutor, Listener
{
    public static ArrayList<Player> cooldownm;
    
    static {
        Zeus.cooldownm = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
        final Player p = (Player)sender;
        if (cmd.getLabel().equalsIgnoreCase("zeus")) {
            if (!p.hasPermission("kitxc.zeus")) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
                return true;
            }
            if (Arrays.used.contains(p.getName())) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
                return true;
            }
            Arrays.used.add(p.getName());
            Arrays.teste.add(p.getName());
            p.getInventory().clear();
            p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Rain");
            BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lRain", 10);
            Tab.sendTitle(p, "§cRain");
            final ItemStack bow = new ItemStack(Material.STONE_SWORD);
            final ItemMeta bowmeta = bow.getItemMeta();
            bowmeta.setDisplayName("§9Espada de Pedra");
            bow.setItemMeta(bowmeta);
            p.getInventory().setItem(0, bow);
            final ItemStack nova = new ItemStack(Material.ARROW);
            final ItemMeta novameta = nova.getItemMeta();
            novameta.setDisplayName("§a Flecha Divina");
            nova.setItemMeta(novameta);
            p.getInventory().setItem(1, nova);
            KitsManager.darSopas(p);
        }
        return false;
    }
    
    @EventHandler
    public void onInteract123455(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.ARROW) {
            final Player r = (Player)e.getRightClicked();
            if (Zeus.cooldownm.contains(p)) {
                p.sendMessage("§eKit em cooldown acabar!");
                return;
            }
            final Location loc = p.getLocation();
            p.getWorld().playSound(loc, Sound.ARROW_HIT, 5.0f, -5.0f);
            Zeus.cooldownm.add(p);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Arrays.resouper.add(p.getName());
                    p.sendMessage("§eVoc\u00ea utilizou a Chuva de Raios.");
                }
            }, 50L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Arrays.resouper.remove(p.getName());
                }
            }, 100L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Zeus.cooldownm.remove(p);
                    p.sendMessage("§eVoce J\u00e1 pode usar seu Kit!");
                    p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
                }
            }, 1000L);
        }
    }
    
    @EventHandler
    public void fraqueza(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        if (Arrays.resouper.contains(p.getName())) {
            for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
                if (!(pertos instanceof Player)) {
                    continue;
                }
                final Location loc = pertos.getLocation();
                loc.setY(loc.getY() + 3.0);
                final Entity arrow2 = Bukkit.getServer().getWorld(pertos.getLocation().getWorld().getName()).spawnEntity(loc, EntityType.ARROW);
                final Player perto = (Player)pertos;
                BarAPI.setMessage(perto, String.valueOf(p.getDisplayName()) + " §aChuva de Raios Fuja");
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        BarAPI.removeBar(perto);
                    }
                }, 10L);
            }
        }
    }
}
