package zMetodos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Seletor2 implements Listener, CommandExecutor {
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 54, ChatColor.GOLD + "Seus Kits");
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
		vidro.setDurability((short) 7);
		final ItemMeta metav = vidro.getItemMeta();
		metav.setDisplayName("§eKits");
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
		inv.setItem(11, vidro);
		inv.setItem(12, vidro);
		inv.setItem(13, vidro);
		inv.setItem(14, vidro);
		inv.setItem(15, vidro);
		inv.setItem(16, vidro);
		inv.setItem(17, vidro);
		inv.setItem(18, vidro);
		inv.setItem(19, vidro);
		inv.setItem(20, vidro);
		inv.setItem(21, vidro);
		inv.setItem(23, vidro);
		inv.setItem(24, vidro);
		inv.setItem(25, vidro);
		inv.setItem(26, vidro);
		inv.setItem(27, vidro);
		inv.setItem(28, vidro);
		inv.setItem(29, vidro);
		inv.setItem(30, vidro);
		inv.setItem(32, vidro);
		inv.setItem(33, vidro);
		inv.setItem(34, vidro);
		inv.setItem(35, vidro);
		inv.setItem(36, vidro);
		inv.setItem(37, vidro);
		inv.setItem(38, vidro);
		inv.setItem(39, vidro);
		inv.setItem(41, vidro);
		inv.setItem(42, vidro);
		inv.setItem(43, vidro);
		inv.setItem(44, vidro);
		inv.setItem(45, vidro);
		inv.setItem(46, vidro);
		inv.setItem(47, vidro);
		inv.setItem(48, vidro);
		inv.setItem(49, vidro);
		inv.setItem(50, vidro);
		inv.setItem(51, vidro);
		inv.setItem(52, vidro);
		inv.setItem(53, vidro);
		final ItemStack kits = new ItemStack(Material.BOWL);
		final ItemMeta kitsmeta = kits.getItemMeta();
		kitsmeta.setDisplayName("§6§oSeus Kits");
		kits.setItemMeta(kitsmeta);
		inv.setItem(22, kits);
		p.openInventory(inv);
		final ItemStack kits2 = new ItemStack(Material.EMERALD);
		final ItemMeta kitsmeta2 = kits2.getItemMeta();
		kitsmeta2.setDisplayName("§6§oLoja de Kits");
		kits2.setItemMeta(kitsmeta2);
		inv.setItem(31, kits2);
		p.openInventory(inv);
		final ItemStack kits3 = new ItemStack(Material.CAKE);
		final ItemMeta kitsmeta3 = kits3.getItemMeta();
		kitsmeta3.setDisplayName("§6§oKit Surpresa");
		kits3.setItemMeta(kitsmeta3);
		inv.setItem(40, kits3);
		p.openInventory(inv);
	}

	@EventHandler
	public void onEnder_ChestClick(final PlayerInteractEvent e) {
		if (e.getItem().getType() == Material.CHEST
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			guiKits(e.getPlayer());
		}
	}

	@EventHandler
	public void onInteract(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase(ChatColor.GOLD + "Seus Kits")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.BOWL) {
				e.setCancelled(true);
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0f, 1.0f);
				p.chat("/kits");
			}
		}
	}

	@EventHandler
	public void onInteract1(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase(ChatColor.GOLD + "Seus Kits")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.EMERALD) {
				e.setCancelled(true);
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.NOTE_PIANO, 1.0f, 1.0f);
				p.chat("/loja");
			}
		}
	}

	@EventHandler
	public void onInteract11111(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase(ChatColor.GOLD + "Seus Kits")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.CAKE) {
				e.setCancelled(true);
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 1.0f, 1.0f);
				p.chat("/surprise");
			}
		}
	}

	public boolean onCommand(final CommandSender arg0, final Command arg1, final String arg2, final String[] arg3) {
		return false;
	}
}
