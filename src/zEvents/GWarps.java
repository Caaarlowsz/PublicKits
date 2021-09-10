package zEvents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import zPublic.Main;

public class GWarps implements Listener {
	public Main plugin;

	public GWarps() {
	}

	public static void guiWarp(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 27, ChatColor.GRAY + "Warps");
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 10);
		vidro.setDurability((short) 10);
		final ItemMeta metav = vidro.getItemMeta();
		metav.setDisplayName("§7Warps");
		vidro.setItemMeta(metav);
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
		final ItemStack thor4 = new ItemStack(Material.BLAZE_ROD);
		final ItemMeta metathor4 = thor4.getItemMeta();
		metathor4.setDisplayName("§e1V1");
		thor4.setItemMeta(metathor4);
		inv.setItem(22, thor4);
		final ItemStack sand = new ItemStack(Material.GLASS);
		final ItemMeta metas = sand.getItemMeta();
		metas.setDisplayName("§eFPS");
		sand.setItemMeta(metas);
		inv.setItem(12, sand);
		final ItemStack sand2 = new ItemStack(Material.FIREBALL);
		final ItemMeta metas2 = sand2.getItemMeta();
		metas2.setDisplayName("§eDrag\u00e3o §l§6Lv §a2§l0§c+");
		sand2.setItemMeta(metas2);
		inv.setItem(2, sand2);
		final ItemStack sand3 = new ItemStack(Material.SKULL_ITEM);
		final ItemMeta metas3 = sand3.getItemMeta();
		metas3.setDisplayName("§f[§4BREVE§f]§eHardCore §l§6Lv §a2§l0§c+");
		sand3.setItemMeta(metas3);
		inv.setItem(6, sand3);
		final ItemStack like = new ItemStack(Material.CAKE);
		final ItemMeta metalike = like.getItemMeta();
		metalike.setDisplayName("§eRDM");
		like.setItemMeta(metalike);
		inv.setItem(13, like);
		final ItemStack diamante1111 = new ItemStack(Material.LAVA_BUCKET);
		final ItemMeta metadiamante1111 = diamante1111.getItemMeta();
		metadiamante1111.setDisplayName("§eLavaChallenger §l§6Lv §a1§l5§c+");
		diamante1111.setItemMeta(metadiamante1111);
		inv.setItem(14, diamante1111);
		p.openInventory(inv);
		final ItemStack diamante1112 = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta metadiamante1112 = diamante1112.getItemMeta();
		metadiamante1112.setDisplayName("§eHungerGames §f- §bSimulador");
		diamante1112.setItemMeta(metadiamante1112);
		inv.setItem(4, diamante1112);
		p.openInventory(inv);
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase(ChatColor.GRAY + "Warps") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP) {
				p.closeInventory();
				p.chat("/hg");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
				p.closeInventory();
				p.chat("/hard");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STICK) {
				p.closeInventory();
				p.chat("/knock");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREBALL) {
				p.closeInventory();
				p.chat("/dragon");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GLASS) {
				p.closeInventory();
				p.chat("/fps");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				p.closeInventory();
				p.chat("/1v1");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_SWORD) {
				p.closeInventory();
				p.chat("/main");
				return;
			}
			if (e.getCurrentItem().getType() == Material.CAKE) {
				p.closeInventory();
				p.chat("/rdm");
				return;
			}
			if (e.getCurrentItem().getType() == Material.POTION) {
				p.closeInventory();
				p.chat("/potion");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
				p.closeInventory();
				p.chat("/lava");
			}
		}
	}

	@EventHandler
	public void onPlayerInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.DIAMOND) {
			guiWarp(p);
		}
	}
}
