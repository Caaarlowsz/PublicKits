package zEvents;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class Loja implements CommandExecutor, Listener {
	public Loja(final PublicPvP main) {
	}

	public Loja() {
	}

	public void Loja1(final PublicPvP main) {
	}

	@EventHandler
	public void InventoryClickEvent(final InventoryClickEvent e) {
		final Player pi = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equals("�e�nLoja de Kits") && e.getCurrentItem() != null
				&& e.getCurrentItem().getItemMeta() != null && e.getCurrentItem().getItemMeta().hasDisplayName()) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�eViking")) {
				if (!PublicPvP.perm.has(pi, "kitxc.viking")) {
					if (PublicPvP.econ.has(pi.getName(), 10000.0)) {
						PublicPvP.econ.withdrawPlayer(pi.getName(), 10000.0);
						PublicPvP.perm.playerAdd(pi, "kitxc.viking");
						pi.sendMessage(
								String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
										+ ">> �6Voc\u00ea comprou o kit viking");
						pi.closeInventory();
					} else {
						pi.closeInventory();
						pi.sendMessage(
								String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
										+ ">> �cVoc\u00ea n\u00e3o tem Coins suficiente");
					}
				} else {
					pi.sendMessage("�cVoc\u00ea j\u00e1 tem este kit");
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�eTerrorista")) {
				if (!PublicPvP.perm.has(pi, "kitxc.terrorista")) {
					if (PublicPvP.econ.has(pi.getName(), 10000.0)) {
						PublicPvP.econ.withdrawPlayer(pi.getName(), 10000.0);
						PublicPvP.perm.playerAdd(pi, "kitxc.terrorista");
						pi.sendMessage(
								String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
										+ ">> �6Voc\u00ea comprou o kit IronMan");
						pi.closeInventory();
					} else {
						pi.closeInventory();
						pi.sendMessage(
								String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
										+ ">> �cVoc\u00ea n\u00e3o tem Coins suficiente");
					}
				} else {
					pi.sendMessage("�cVoc\u00ea j\u00e1 tem este kit");
				}
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�eDeshFire")) {
				if (!PublicPvP.perm.has(pi, "kitxc.deshfire")) {
					if (PublicPvP.econ.has(pi.getName(), 10000.0)) {
						PublicPvP.econ.withdrawPlayer(pi.getName(), 10000.0);
						PublicPvP.perm.playerAdd(pi, "kitxc.deshfire");
						pi.sendMessage(
								String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
										+ ">> �6Voc\u00ea comprou o kit DeshFire");
						pi.closeInventory();
					} else {
						pi.closeInventory();
						pi.sendMessage(
								String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
										+ ">> �cVoc\u00ea n\u00e3o tem Coins suficiente");
					}
				} else {
					pi.sendMessage("�cVoc\u00ea j\u00e1 tem este kit");
				}
			}
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�eSonic")) {
			if (!PublicPvP.perm.has(pi, "kitxc.sonic")) {
				if (PublicPvP.econ.has(pi.getName(), 10000.0)) {
					PublicPvP.econ.withdrawPlayer(pi.getName(), 10000.0);
					PublicPvP.perm.playerAdd(pi, "kitxc.sonic");
					pi.sendMessage(String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
							+ ">> �6Voc\u00ea comprou o kit sonic");
					pi.closeInventory();
				} else {
					pi.closeInventory();
					pi.sendMessage(String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
							+ ">> �cVoc\u00ea n\u00e3o tem Coins suficiente");
				}
			} else {
				pi.sendMessage("�cVoc\u00ea j\u00e1 tem este kit");
			}
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�eNinja")) {
			if (!PublicPvP.perm.has(pi, "kitxc.ninja")) {
				if (PublicPvP.econ.has(pi.getName(), 10000.0)) {
					PublicPvP.econ.withdrawPlayer(pi.getName(), 10000.0);
					PublicPvP.perm.playerAdd(pi, "kitxc.ninja");
					pi.sendMessage(String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
							+ ">> �6Voc\u00ea comprou o kit ninja");
					pi.closeInventory();
				} else {
					pi.closeInventory();
					pi.sendMessage(String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
							+ ">> �cVoc\u00ea n\u00e3o tem Coins suficiente");
				}
			} else {
				pi.sendMessage("�cVoc\u00ea j\u00e1 tem este kit");
			}
		}
		if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�eWoodMan")) {
			if (!PublicPvP.perm.has(pi, "kitxc.woodman")) {
				if (PublicPvP.econ.has(pi.getName(), 10000.0)) {
					PublicPvP.econ.withdrawPlayer(pi.getName(), 10000.0);
					PublicPvP.perm.playerAdd(pi, "kitxc.sonic");
					pi.sendMessage(String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
							+ ">> �6Voc\u00ea comprou o kit woodman");
					pi.closeInventory();
				} else {
					pi.closeInventory();
					pi.sendMessage(String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
							+ ">> �cVoc\u00ea n\u00e3o tem Coins suficiente");
				}
			} else {
				pi.sendMessage("�cVoc\u00ea j\u00e1 tem este kit");
			}
		}
	}

	public static void guiMake(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 27, "�e�nLoja de Kits");
		final ItemStack milkman = new ItemStack(Material.STONE_AXE);
		final ItemMeta milkmanmeta = milkman.getItemMeta();
		milkmanmeta.setDisplayName("�eViking");
		final List<String> loremilkman = new ArrayList<String>();
		loremilkman.add("�e10.000 �6Coins");
		milkmanmeta.setLore(loremilkman);
		milkman.setItemMeta(milkmanmeta);
		final ItemStack sniper = new ItemStack(Material.TNT);
		final ItemMeta snipermeta = sniper.getItemMeta();
		snipermeta.setDisplayName("�eTerrorista");
		final List<String> loresniper = new ArrayList<String>();
		loresniper.add("�e10.000 �6Coins");
		snipermeta.setLore(loresniper);
		sniper.setItemMeta(snipermeta);
		final ItemStack flash = new ItemStack(Material.REDSTONE_BLOCK);
		final ItemMeta flashmeta = flash.getItemMeta();
		flashmeta.setDisplayName("�eDeshFire");
		final List<String> flashlore = new ArrayList<String>();
		flashlore.add("�e10.000 �6Coins");
		flashmeta.setLore(flashlore);
		flash.setItemMeta(flashmeta);
		final ItemStack gp = new ItemStack(Material.LAPIS_BLOCK);
		final ItemMeta gpm = gp.getItemMeta();
		gpm.setDisplayName("�eSonic");
		final List<String> gpl = new ArrayList<String>();
		gpl.add("�e10.000 �6Coins");
		gpm.setLore(gpl);
		gp.setItemMeta(gpm);
		final ItemStack tr = new ItemStack(Material.COAL_BLOCK);
		final ItemMeta trm = tr.getItemMeta();
		trm.setDisplayName("�eNinja");
		final List<String> trl = new ArrayList<String>();
		trl.add("�e10.000 �6Coins");
		trm.setLore(trl);
		tr.setItemMeta(trm);
		final ItemStack fujao = new ItemStack(Material.WOOD);
		final ItemMeta fujaometa = fujao.getItemMeta();
		fujaometa.setDisplayName("�eWoodMan");
		final List<String> fujaolore = new ArrayList<String>();
		fujaolore.add("�e10.000 �6Coins");
		fujaometa.setLore(fujaolore);
		fujao.setItemMeta(fujaometa);
		final ItemStack fujao2 = new ItemStack(Material.CHEST);
		final ItemMeta fujaometa2 = fujao2.getItemMeta();
		fujaometa2.setDisplayName("�eVolte Para Seus Kits");
		final List<String> fujaolore2 = new ArrayList<String>();
		fujaometa2.setLore(fujaolore2);
		fujao2.setItemMeta(fujaometa2);
		inv.setItem(22, fujao2);
		inv.setItem(10, fujao);
		inv.setItem(11, sniper);
		inv.setItem(12, milkman);
		inv.setItem(13, tr);
		inv.setItem(14, flash);
		inv.setItem(15, gp);
		final ItemStack vidro1 = new ItemStack(Material.ENDER_PEARL);
		vidro1.getDurability();
		final ItemMeta metav1 = vidro1.getItemMeta();
		metav1.setDisplayName("�cKits");
		vidro1.setItemMeta(metav1);
		inv.setItem(4, vidro1);
		final ItemStack vidro2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		vidro2.setDurability((short) 14);
		final ItemMeta metav2 = vidro2.getItemMeta();
		metav2.setDisplayName("�eLoja");
		vidro2.setItemMeta(metav2);
		inv.setItem(0, vidro2);
		inv.setItem(1, vidro2);
		inv.setItem(2, vidro2);
		inv.setItem(3, vidro2);
		inv.setItem(5, vidro2);
		inv.setItem(6, vidro2);
		inv.setItem(7, vidro2);
		inv.setItem(8, vidro2);
		inv.setItem(18, vidro2);
		inv.setItem(19, vidro2);
		inv.setItem(20, vidro2);
		inv.setItem(21, vidro2);
		inv.setItem(23, vidro2);
		inv.setItem(24, vidro2);
		inv.setItem(25, vidro2);
		inv.setItem(26, vidro2);
		p.openInventory(inv);
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String label,
			final String[] args) {
		if (label.equalsIgnoreCase("loja")) {
			final Player p = (Player) sender;
			guiMake(p);
		}
		return false;
	}

	@EventHandler
	public void playerCliqueNoBau(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.CHEST) {
			p.closeInventory();
			p.chat("/kits");
		}
	}
}
