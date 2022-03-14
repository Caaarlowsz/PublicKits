package zEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class Click implements Listener, CommandExecutor {
	public static ArrayList<String> Macro;
	public static Map<Player, Integer> macro;

	static {
		Click.Macro = new ArrayList<String>();
		Click.macro = new HashMap<Player, Integer>();
	}

	@EventHandler
	public void attk2(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Click.Macro.contains(p.getName())) {
			if (!(e.getPlayer() instanceof Player)) {
				return;
			}
			if (!e.getAction().name().contains("LEFT") && Click.macro.containsKey(p)) {
				return;
			}
			if (Click.macro.containsKey(p)) {
				Click.macro.put(p, Click.macro.get(p) + 1);
			} else {
				Click.macro.put(p, 1);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("click") && p.hasPermission("kitpvp.click")) {
			Click.macro.put(p, 0);
			Click.macro.put(p, 0);
			Click.macro.put(p, 0);
			Click.macro.put(p, 0);
			p.getInventory().clear();
			final ItemStack bow = new ItemStack(Material.DIAMOND_SWORD);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("�9Espada de Diamante");
			bow.setItemMeta(bowmeta);
			p.getInventory().setItem(0, bow);
			p.getInventory().setItem(4, bow);
			p.getInventory().setItem(8, bow);
			p.sendMessage(" ");
			p.sendMessage(" ");
			p.sendMessage(" ");
			p.sendMessage(" ");
			p.sendMessage("�aContando... ");
			Click.Macro.add(p.getName());
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage("�7�l---------- �6�lClickTeste�7�l ---------- �f");
					p.sendMessage("  ");
					p.sendMessage("�f�lJogador: �6�l�n" + p.getName());
					p.sendMessage("�f�lClicks por Sec: �6�l�n" + Click.macro.get(p) / 2);
					p.sendMessage("�f�lClicks em 10 Seg: �6�l�n" + Click.macro.get(p) * 5);
					p.sendMessage(" ");
					p.sendMessage("�7�l---------- �6�lClickTeste�7�l ---------- �f");
					p.getInventory().clear();
					final ItemStack item12 = new ItemStack(Material.DIAMOND);
					final ItemMeta itemmeta12 = item12.getItemMeta();
					itemmeta12.setDisplayName("�a Warps");
					item12.setItemMeta(itemmeta12);
					p.getInventory().setItem(2, item12);
					final ItemStack item13 = new ItemStack(Material.CHEST);
					final ItemMeta itemmeta13 = item13.getItemMeta();
					itemmeta13.setDisplayName("�a Seletor de Kits");
					item13.setItemMeta(itemmeta13);
					p.getInventory().setItem(4, item13);
					final ItemStack item14 = new ItemStack(Material.IRON_INGOT);
					final ItemMeta itemmeta14 = item14.getItemMeta();
					itemmeta14.setDisplayName("�a Extras");
					item14.setItemMeta(itemmeta14);
					p.getInventory().setItem(6, item14);
					Click.Macro.remove(p.getName());
					Click.macro.put(p, 0);
					Click.macro.put(p, 0);
					Click.macro.put(p, 0);
					Click.macro.put(p, 0);
				}
			}, 40L);
		}
		return false;
	}
}
