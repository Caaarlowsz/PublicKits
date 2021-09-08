package zKits;

import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
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

public class Turtle implements CommandExecutor, Listener
{
    private Object Pegos1;
    private Arrays Habilidade;
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
        final Player p = (Player)sender;
        if (cmd.getLabel().equalsIgnoreCase("turtle")) {
            if (!p.hasPermission("kitxc.turtle")) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
                return true;
            }
            if (Arrays.used.contains(p.getName())) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
                return true;
            }
            Arrays.turtle.add(p.getName());
            Arrays.turtle.add(p.getName());
            p.getInventory().clear();
            p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Turtle");
            Tab.sendTitle(p, "§cTurtle");
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
            BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lTurtle", 10);
            KitsManager.darSopas(p);
        }
        return false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (Arrays.turtle.contains(p.getName()) && p.isSneaking() && (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION || e.getCause() == EntityDamageEvent.DamageCause.CONTACT || e.getCause() == EntityDamageEvent.DamageCause.CUSTOM || e.getCause() == EntityDamageEvent.DamageCause.DROWNING || e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK || e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION || e.getCause() == EntityDamageEvent.DamageCause.FALL || e.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK || e.getCause() == EntityDamageEvent.DamageCause.FIRE || e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK || e.getCause() == EntityDamageEvent.DamageCause.LAVA || e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING || e.getCause() == EntityDamageEvent.DamageCause.MAGIC || e.getCause() == EntityDamageEvent.DamageCause.MELTING || e.getCause() == EntityDamageEvent.DamageCause.POISON || e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE || e.getCause() == EntityDamageEvent.DamageCause.STARVATION || e.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION || e.getCause() == EntityDamageEvent.DamageCause.THORNS || e.getCause() == EntityDamageEvent.DamageCause.VOID || e.getCause() == EntityDamageEvent.DamageCause.WITHER)) {
            e.setDamage(1.0);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerTurleDamage(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getDamager();
        if (!p.isSneaking()) {
            return;
        }
        if (Arrays.turtle.contains(p.getName())) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.RED + "Voce nao pode bater enquanto estiver segurando o shift");
        }
    }
}
