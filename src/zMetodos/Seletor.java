package zMetodos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

public class Seletor implements Listener, CommandExecutor {
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 54, ChatColor.GOLD + "Seus Kits");
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		vidro.setDurability((short) 5);
		final ItemMeta metav = vidro.getItemMeta();
		metav.setDisplayName("§eKits");
		vidro.setItemMeta(metav);
		inv.setItem(45, vidro);
		inv.setItem(46, vidro);
		inv.setItem(47, vidro);
		inv.setItem(48, vidro);
		inv.setItem(49, vidro);
		inv.setItem(50, vidro);
		inv.setItem(51, vidro);
		inv.setItem(52, vidro);
		inv.setItem(53, vidro);
		final ItemStack vidro2 = new ItemStack(Material.ENDER_PEARL, 1);
		vidro2.getDurability();
		final ItemMeta metav2 = vidro2.getItemMeta();
		metav2.setDisplayName("§3PVP");
		vidro2.setItemMeta(metav2);
		inv.setItem(4, vidro2);
		final ItemStack vidro3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		vidro3.setDurability((short) 5);
		final ItemMeta metav3 = vidro3.getItemMeta();
		metav3.setDisplayName("§3PVP");
		vidro3.setItemMeta(metav3);
		inv.setItem(0, vidro3);
		inv.setItem(1, vidro3);
		inv.setItem(2, vidro3);
		inv.setItem(3, vidro3);
		inv.setItem(5, vidro3);
		inv.setItem(6, vidro3);
		inv.setItem(7, vidro3);
		inv.setItem(8, vidro3);
		if (p.hasPermission("kitxc.pvp")) {
			final ItemStack pyro = new ItemStack(Material.STONE_SWORD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §ePvP");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - ");
			descpyro.add(ChatColor.GRAY + " - ");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.kangaroo")) {
			final ItemStack pyro = new ItemStack(Material.FIREWORK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eKangaroo");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Com seu Firework");
			descpyro.add(ChatColor.GRAY + " - Se mova rapidamente");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.thor")) {
			final ItemStack pyro = new ItemStack(Material.WOOD_AXE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eThor");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Lance Poderosos Raios");
			descpyro.add(ChatColor.GRAY + " - e de Dano em seu rival");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.supernova")) {
			final ItemStack pyro = new ItemStack(Material.SUGAR);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eSupernova");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Ao clicar com a a\u00e7ucar");
			descpyro.add(ChatColor.GRAY + " - jogue o inimigo pra cima e o exploda");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.velotrol")) {
			final ItemStack pyro = new ItemStack(Material.MINECART);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eVelotrol");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Com seu MineCart Plante");
			descpyro.add(ChatColor.GRAY + " - Uma Bomba");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.viking")) {
			final ItemStack pyro = new ItemStack(Material.IRON_AXE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eViking");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Tenha um dano");
			descpyro.add(ChatColor.GRAY + " - Mais fortes que espadas!");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.ninja")) {
			final ItemStack pyro = new ItemStack(Material.COAL_BLOCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eNinja");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Ao Hitar um jogador");
			descpyro.add(ChatColor.GRAY + " - Teleporte-se a posicao dele");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.stomper")) {
			final ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eStomper");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Esmague seus oponente");
			descpyro.add(ChatColor.GRAY + " - Bom para torres");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.viper")) {
			final ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eViper");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Ao hitar um jogador tenha 33% de");
			descpyro.add(ChatColor.GRAY + " - Dar efeito de Poison no oponente");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.deshfire")) {
			final ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eDeshFire");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Ao Usar Sua RedstoneBlock");
			descpyro.add(ChatColor.GRAY + " - D\u00ea fogo em Seus inimigos a volta");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.iceman")) {
			final ItemStack pyro = new ItemStack(Material.ICE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eIceman");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Surfe em sua prancha de gelo");
			descpyro.add(ChatColor.GRAY + " -  e congele seus inimigos");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.sonic")) {
			final ItemStack pyro = new ItemStack(Material.LAPIS_BLOCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eSonic");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Ao Usar Sua LapisBlock");
			descpyro.add(ChatColor.GRAY + " - D\u00ea Veneno em Seus inimigos a volta");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.woodman")) {
			final ItemStack pyro = new ItemStack(Material.WOOD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eWoodMan");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Use Espada de Madeira e");
			descpyro.add(ChatColor.GRAY + " - D\u00ea Mais danos com ela");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.terrorista")) {
			final ItemStack pyro = new ItemStack(Material.TNT);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eTerrorista");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Ao Usar Sua Magma Cream");
			descpyro.add(ChatColor.GRAY + " - D\u00ea um Super pulo e exploda todos");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.urano")) {
			final ItemStack pyro = new ItemStack(Material.SLIME_BALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eUrano");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Ao Usar Sua Slime Ball");
			descpyro.add(ChatColor.GRAY + " - D\u00ea Efeito de Poison nos players a volta com morcegos");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.turtle")) {
			final ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eTurtle");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Ao Pressionar Shift");
			descpyro.add(ChatColor.GRAY + " - N\u00e3o Leve e Nem d\u00ea dano");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.fisherman")) {
			final ItemStack pyro = new ItemStack(Material.FISHING_ROD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eFisherman");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Use sua vara e");
			descpyro.add(ChatColor.GRAY + " - puxe os player para voc\u00ea");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.mago")) {
			final ItemStack pyro = new ItemStack(Material.POTION);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eMago");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Use seu pote ");
			descpyro.add(ChatColor.GRAY + " -  e Ganhe efeitos aleatorios");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.firer")) {
			final ItemStack pyro = new ItemStack(Material.BLAZE_POWDER);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eFirer");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Use seu blaze powder ");
			descpyro.add(ChatColor.GRAY + " -  e deixe os inimigos a volta com fogo e cegueira");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.zeus")) {
			final ItemStack pyro = new ItemStack(Material.ARROW);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eRain V2");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Possui mesma habilidade do rain ");
			descpyro.add(ChatColor.GRAY + " - porem atinge todos a sua volta quando clicar em um player");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.tornado")) {
			final ItemStack pyro = new ItemStack(Material.HOPPER);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eTornado");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Ao clicar com seu funil ");
			descpyro.add(ChatColor.GRAY + " - lance para longe todos os players a volta");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kitxc.endermage")) {
			final ItemStack pyro = new ItemStack(Material.ENDER_PORTAL_FRAME);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§6§lKit: §eEndermage");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add(ChatColor.AQUA + "Habilidades:");
			descpyro.add(ChatColor.GRAY + " - Use seu Portal e");
			descpyro.add(ChatColor.GRAY + " - puxe os player para sua localidade");
			metapyro.setLore((List<String>) descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		ItemStack[] arrayOfItemStack;
		for (int descpyro2 = (arrayOfItemStack = inv.getContents()).length,
				metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
			final ItemStack item = arrayOfItemStack[metapyro2];
			if (item == null) {
				inv.setItem(inv.firstEmpty(), vidro);
			}
		}
		p.openInventory(inv);
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("kits")) {
			final Player p = (Player) sender;
			guiKits(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Seus Kits") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.FIREWORK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kangaroo");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SLIME_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/urano");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/pvp");
				return;
			}
			if (e.getCurrentItem().getType() == Material.HOPPER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/tornado");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ICE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/gon");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SUGAR) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/supernova");
				return;
			}
			if (e.getCurrentItem().getType() == Material.POTION) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/mago");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_POWDER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/firer");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ARROW) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/zeus");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/thor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MINECART) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/velotrol");
				return;
			}
			if (e.getCurrentItem().getType() == Material.COAL_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/ninja");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/viking");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ENDER_PORTAL_FRAME) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/endermage");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/viper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_BOOTS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/stomper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/deshfire");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LAPIS_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/sonic");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/turtle");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/woodman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.TNT) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/terrorista");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ENDER_PORTAL_FRAME) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/endermage");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/fisherman");
			}
		}
	}
}
