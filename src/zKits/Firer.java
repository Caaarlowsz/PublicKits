package zKits;

import org.bukkit.event.EventHandler;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Entity;
import zPublic.Main;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import zEvents.Tab;
import me.confuser.barapi.BarAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Firer implements CommandExecutor, Listener
{
    public static ArrayList<String> Pegos;
    public static ArrayList<Player> cooldownm;
    
    static {
        Firer.Pegos = new ArrayList<String>();
        Firer.cooldownm = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
        final Player p = (Player)sender;
        if (cmd.getLabel().equalsIgnoreCase("firer")) {
            if (!p.hasPermission("kitxc.firer")) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
                return true;
            }
            if (Arrays.used.contains(p.getName())) {
                p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
                return true;
            }
            Arrays.used.add(p.getName());
            Arrays.magma.add(p.getName());
            p.getInventory().clear();
            p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Firer");
            BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lFirer", 10);
            Tab.sendTitle(p, "§cFirer");
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BLAZE_POWDER) });
            KitsManager.darSopas(p);
        }
        return false;
    }
    
    @EventHandler
    public void interact(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && Arrays.magma.contains(p.getName()) && p.getItemInHand().getType() == Material.BLAZE_POWDER) {
            e.setCancelled(true);
            p.updateInventory();
            if (Firer.cooldownm.contains(p)) {
                p.sendMessage(String.valueOf(Main.getPlugin().getConfig().getString("server").replace("&", "§")) + " §l§6>> §eKit em Cooldown!");
                return;
            }
            final List<Entity> Local = (List<Entity>)p.getNearbyEntities(10.0, 10.0, 10.0);
            for (final Entity Inimigos : Local) {
                Inimigos.setFireTicks(100);
                ((LivingEntity)Inimigos).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 170, 2));
                ((LivingEntity)Inimigos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 170, 2));
                ((LivingEntity)Inimigos).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 170, 2));
                ((CommandSender)Inimigos).sendMessage("§cVoc\u00ea foi atingido por 1 firer");
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 170, 2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 170, 2));
                Firer.cooldownm.add(p);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Firer.cooldownm.remove(p);
                        p.sendMessage("§eVoc\u00ea J\u00e1 pode usar seu Kit");
                    }
                }, 750L);
            }
        }
    }
}
