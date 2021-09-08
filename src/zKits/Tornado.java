package zKits;

import java.util.Iterator;
import org.bukkit.util.Vector;
import org.bukkit.Effect;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import zPublic.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
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
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Tornado implements Listener, CommandExecutor
{
    public static ArrayList<Player> cooldownm;
    
    static {
        Tornado.cooldownm = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
        final Player p = (Player)sender;
        if (cmd.getLabel().equalsIgnoreCase("tornado")) {
            if (!p.hasPermission("kitxc.tornado")) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
                return true;
            }
            if (Arrays.used.contains(p.getName())) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
                return true;
            }
            Arrays.used.add(p.getName());
            Arrays.reaper.add(p.getName());
            p.getInventory().clear();
            p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Tornado");
            BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lTornado", 10);
            Tab.sendTitle(p, "§cTornado");
            final ItemStack bow = new ItemStack(Material.STONE_SWORD);
            final ItemMeta bowmeta = bow.getItemMeta();
            bowmeta.setDisplayName("§9Espada de Pedra");
            bow.setItemMeta(bowmeta);
            p.getInventory().setItem(0, bow);
            final ItemStack b = new ItemStack(Material.HOPPER);
            final ItemMeta bmeta = b.getItemMeta();
            bmeta.setDisplayName("§aTornado");
            b.setItemMeta(bmeta);
            p.getInventory().setItem(1, b);
            KitsManager.darSopas(p);
        }
        return false;
    }
    
    @EventHandler
    public void stomperApple(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (event.getPlayer().getItemInHand().getType() == Material.HOPPER && Arrays.reaper.contains(event.getPlayer().getName())) {
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                event.setCancelled(true);
            }
            if (Tornado.cooldownm.contains(p)) {
                p.sendMessage("§eKit em cooldown acabar!");
                return;
            }
            final Location loc = p.getLocation();
            p.getWorld().playSound(loc, Sound.AMBIENCE_RAIN, 5.0f, -5.0f);
            Tornado.cooldownm.add(p);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Arrays.barbarian.add(p.getName());
                    p.sendMessage("§eVoc\u00ea utilizou o Tornado.");
                }
            }, 0L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Arrays.barbarian.remove(p.getName());
                }
            }, 100L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Tornado.cooldownm.remove(p);
                    p.sendMessage("§eVoce J\u00e1 pode usar seu Kit!");
                    p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
                }
            }, 1000L);
        }
    }
    
    @EventHandler
    public void fraqueza(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        if (Arrays.barbarian.contains(p.getName())) {
            for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
                if (!(pertos instanceof Player)) {
                    continue;
                }
                p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 100, 1);
                p.getWorld().playEffect(p.getLocation(), Effect.PARTICLE_SMOKE, 100, 1);
                p.getWorld().playEffect(p.getLocation(), Effect.EXPLOSION, 100, 1);
                final Player perto = (Player)pertos;
                pertos.setVelocity(new Vector(2.0, 0.3, 2.0));
                BarAPI.setMessage(perto, String.valueOf(p.getDisplayName()) + " §aTornado Fuja");
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
