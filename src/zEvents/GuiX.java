package zEvents;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import zPublic.Main;
import org.bukkit.event.Listener;

public class GuiX implements Listener
{
    public Main plugin;
    private Main main;
    
    public GuiX() {
        this.main = this.plugin;
    }
    
    public static void guiWarp(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, ChatColor.GRAY + "X");
        final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)10);
        vidro.setDurability((short)10);
        final ItemMeta metav = vidro.getItemMeta();
        metav.setDisplayName("§7Extras");
        vidro.setItemMeta(metav);
        inv.setItem(0, vidro);
        inv.setItem(1, vidro);
        inv.setItem(2, vidro);
        inv.setItem(3, vidro);
        inv.setItem(4, vidro);
        inv.setItem(5, vidro);
        inv.setItem(6, vidro);
        inv.setItem(7, vidro);
        inv.setItem(8, vidro);
        inv.setItem(9, vidro);
        inv.setItem(10, vidro);
        inv.setItem(15, vidro);
        inv.setItem(14, vidro);
        inv.setItem(17, vidro);
        inv.setItem(18, vidro);
        inv.setItem(16, vidro);
        inv.setItem(11, vidro);
        inv.setItem(19, vidro);
        inv.setItem(20, vidro);
        inv.setItem(21, vidro);
        inv.setItem(22, vidro);
        inv.setItem(23, vidro);
        inv.setItem(24, vidro);
        inv.setItem(25, vidro);
        final ItemStack thora = new ItemStack(Material.IRON_FENCE);
        final ItemMeta metathora = thora.getItemMeta();
        metathora.setDisplayName("§e-");
        thora.setItemMeta(metathora);
        inv.setItem(17, thora);
        final ItemStack thora2 = new ItemStack(Material.IRON_FENCE);
        final ItemMeta metathora2 = thora2.getItemMeta();
        metathora2.setDisplayName("§e-");
        thora2.setItemMeta(metathora2);
        inv.setItem(8, thora2);
        final ItemStack thora3 = new ItemStack(Material.IRON_FENCE);
        final ItemMeta metathora3 = thora3.getItemMeta();
        metathora3.setDisplayName("§e-");
        thora3.setItemMeta(metathora3);
        inv.setItem(26, thora3);
        final ItemStack thor = new ItemStack(Material.IRON_FENCE);
        final ItemMeta metathor = thor.getItemMeta();
        metathor.setDisplayName("§e-");
        thor.setItemMeta(metathor);
        inv.setItem(0, thor);
        final ItemStack thor2 = new ItemStack(Material.IRON_FENCE);
        final ItemMeta metathor2 = thor2.getItemMeta();
        metathor2.setDisplayName("§e-");
        thor2.setItemMeta(metathor2);
        inv.setItem(9, thor2);
        final ItemStack thor3 = new ItemStack(Material.IRON_FENCE);
        final ItemMeta metathor3 = thor3.getItemMeta();
        metathor3.setDisplayName("§e-");
        thor3.setItemMeta(metathor3);
        inv.setItem(18, thor3);
        final ItemStack thor4 = new ItemStack(Material.BROWN_MUSHROOM);
        final ItemMeta metathor4 = thor4.getItemMeta();
        metathor4.setDisplayName("§e-");
        thor4.setItemMeta(metathor4);
        inv.setItem(22, thor4);
        final ItemStack thor5 = new ItemStack(Material.RED_MUSHROOM);
        final ItemMeta metathor5 = thor5.getItemMeta();
        metathor5.setDisplayName("§e-");
        thor5.setItemMeta(metathor5);
        inv.setItem(4, thor5);
        final ItemStack sand = new ItemStack(Material.NETHER_STAR);
        final ItemMeta metas = sand.getItemMeta();
        metas.setDisplayName("§2§lClick-Test");
        final ArrayList descpyro1 = new ArrayList();
        descpyro1.add(ChatColor.GRAY + "§6=§7-=-=-=-=-=-=-=-=-=-§6=-");
        descpyro1.add(ChatColor.GRAY + "  §7Teste Seus Clicks");
        descpyro1.add(ChatColor.GRAY + "  §7Veja Quantos consegue em 5 seg.");
        descpyro1.add(ChatColor.GRAY + "§6=§7-=-=-=-=-=-=-=-=-=-§6=-");
        sand.setItemMeta(metas);
        inv.setItem(13, sand);
        final ItemStack like = new ItemStack(Material.BROWN_MUSHROOM);
        final ItemMeta metalike = like.getItemMeta();
        metalike.setDisplayName("§6§lx");
        like.setItemMeta(metalike);
        inv.setItem(12, like);
        final ItemStack like2 = new ItemStack(Material.RED_MUSHROOM);
        final ItemMeta metalike2 = like2.getItemMeta();
        metalike2.setDisplayName("§6§lx");
        like2.setItemMeta(metalike2);
        inv.setItem(14, like2);
        p.openInventory(inv);
    }
    
    @EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase(ChatColor.GRAY + "X") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
                p.closeInventory();
                p.chat("/click");
            }
        }
    }
    
    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.IRON_INGOT) {
            guiWarp(p);
        }
    }
}
