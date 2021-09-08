package zEvents;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Sopa implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("recraft") && p.hasPermission("kitpvp.recraft")) {
            final Villager vill = (Villager)p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
            vill.setCustomName(ChatColor.GOLD + "Recraft");
            vill.setCustomNameVisible(true);
            vill.setProfession(Villager.Profession.LIBRARIAN);
            vill.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 5));
        }
        return false;
    }
    
    @EventHandler
    public void onQuest(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Villager) {
            final Player p = e.getPlayer();
            final Villager vil = (Villager)e.getRightClicked();
            if (vil.getCustomName().equals(ChatColor.GOLD + "Recraft")) {
                e.setCancelled(true);
                final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 36, "§6§lRecraft");
                final ItemStack sopas = new ItemStack(Material.BOWL, 64);
                final ItemMeta sopameta = sopas.getItemMeta();
                sopameta.setDisplayName("§6 Pote");
                sopas.setItemMeta(sopameta);
                final ItemStack recraft1 = new ItemStack(Material.BROWN_MUSHROOM, 64);
                final ItemMeta recraft1meta = recraft1.getItemMeta();
                recraft1meta.setDisplayName("§e Cogu.Marrom");
                recraft1.setItemMeta(recraft1meta);
                final ItemStack recraft2 = new ItemStack(Material.RED_MUSHROOM, 64);
                final ItemMeta recraftmeta = recraft2.getItemMeta();
                recraftmeta.setDisplayName("§c Cogu.Vermelho");
                recraft2.setItemMeta(recraftmeta);
                inv.setItem(0, sopas);
                inv.setItem(1, recraft2);
                inv.setItem(2, recraft1);
                inv.setItem(3, sopas);
                inv.setItem(4, recraft2);
                inv.setItem(5, recraft1);
                inv.setItem(6, sopas);
                inv.setItem(7, recraft2);
                inv.setItem(8, recraft1);
                inv.setItem(9, sopas);
                inv.setItem(10, recraft2);
                inv.setItem(11, recraft1);
                inv.setItem(12, sopas);
                inv.setItem(13, recraft2);
                inv.setItem(14, recraft1);
                inv.setItem(15, sopas);
                inv.setItem(16, recraft2);
                inv.setItem(17, recraft1);
                inv.setItem(18, sopas);
                inv.setItem(19, recraft2);
                inv.setItem(20, recraft1);
                inv.setItem(21, sopas);
                inv.setItem(22, recraft2);
                inv.setItem(23, recraft1);
                inv.setItem(24, sopas);
                inv.setItem(25, recraft2);
                inv.setItem(26, recraft1);
                inv.setItem(27, sopas);
                inv.setItem(28, recraft2);
                inv.setItem(29, recraft1);
                inv.setItem(30, sopas);
                inv.setItem(31, recraft2);
                inv.setItem(32, recraft1);
                inv.setItem(33, sopas);
                inv.setItem(34, recraft2);
                inv.setItem(35, recraft1);
                p.openInventory(inv);
            }
        }
    }
    
    @EventHandler
    public void onQuest2(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Villager && e.getDamager() instanceof Player) {
            final Villager vil = (Villager)e.getEntity();
            if (vil.getCustomName().equals(ChatColor.GOLD + "Recraft")) {
                e.setCancelled(true);
            }
        }
    }
}
