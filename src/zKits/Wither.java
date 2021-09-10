package zKits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;
import zEvents.Tab;
import zPublic.Main;

public class Wither implements CommandExecutor, Listener {
	public static ArrayList<String> cooldown;

	static {
		Wither.cooldown = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
		final Player p = (Player) sender;
		if (cmd.getLabel().equalsIgnoreCase("thor")) {
			if (!p.hasPermission("kitxc.thor")) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
				return true;
			}
			if (Arrays.used.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
				return true;
			}
			Arrays.used.add(p.getName());
			Arrays.thor.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Thor");
			Tab.sendTitle(p, "§cThor");
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lThor", 10);
			final ItemStack bow = new ItemStack(Material.STONE_SWORD);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§9Espada de Pedra");
			bow.setItemMeta(bowmeta);
			final ItemStack Velotrol = new ItemStack(Material.WOOD_AXE);
			final ItemMeta kVelotrol = Velotrol.getItemMeta();
			kVelotrol.setDisplayName("§aThor");
			Velotrol.setItemMeta(kVelotrol);
			p.getInventory().setItem(0, bow);
			p.getInventory().setItem(1, Velotrol);
			KitsManager.darSopas(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerThor(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		if (p.getItemInHand().getType() == Material.WOOD_AXE && Arrays.thor.contains(p.getName())) {
			if (Wither.cooldown.contains(p.getName())) {
				e.setCancelled(true);
				p.sendMessage(String.valueOf(Main.getPlugin().getConfig().getString("server").replace("&", "§"))
						+ " §l§6>> §eKit em Cooldown!");
				return;
			}
			e.setCancelled(true);
			final Block b = e.getClickedBlock();
			final World w = p.getWorld();
			w.spawnEntity(w.getHighestBlockAt(b.getLocation()).getLocation(), EntityType.LIGHTNING);
			p.getWorld().strikeLightning(p.getWorld().getHighestBlockAt(e.getClickedBlock().getLocation()).getLocation()
					.clone().add(0.0, 0.0, 0.0));
			Wither.cooldown.add(p.getName());
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					Wither.cooldown.remove(p.getName());
					p.sendMessage("§eVoc\u00ea J\u00e1 Pode usar Seu Kit");
				}
			}, 100L);
		}
	}

	@EventHandler
	public void idknow(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (e.getCause() != EntityDamageEvent.DamageCause.LIGHTNING) {
				return;
			}
			if (Arrays.thor.contains(p.getName())) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void idknow1(final PlayerDropItemEvent e) {
		final Player p = e.getPlayer();
		if (e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD) {
			return;
		}
		if (Arrays.thor.contains(p.getName())) {
			e.setCancelled(true);
		}
	}
}
