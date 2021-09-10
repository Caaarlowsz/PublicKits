package zKits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import zEvents.Tab;
import zPublic.Main;

public class Supernova implements CommandExecutor, Listener {
	public static ArrayList<Player> cooldownm;

	static {
		Supernova.cooldownm = new ArrayList<Player>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
		final Player p = (Player) sender;
		if (cmd.getLabel().equalsIgnoreCase("supernova")) {
			if (!p.hasPermission("kitxc.supernova")) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
				return true;
			}
			if (Arrays.used.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
				return true;
			}
			Arrays.used.add(p.getName());
			Arrays.kiwwi.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Supernova");
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lSupernova", 10);
			Tab.sendTitle(p, "§cSupernova");
			final ItemStack bow = new ItemStack(Material.STONE_SWORD);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§9Espada de Pedra");
			bow.setItemMeta(bowmeta);
			p.getInventory().setItem(0, bow);
			final ItemStack nova = new ItemStack(Material.SUGAR);
			final ItemMeta novameta = nova.getItemMeta();
			novameta.setDisplayName("§a Sugar Explosivo");
			nova.setItemMeta(novameta);
			p.getInventory().setItem(1, nova);
			KitsManager.darSopas(p);
		}
		return false;
	}

	@EventHandler
	public void onInteract123455(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.SUGAR) {
			final Player r = (Player) e.getRightClicked();
			if (Supernova.cooldownm.contains(p)) {
				p.sendMessage(String.valueOf(Main.getPlugin().getConfig().getString("server").replace("&", "§"))
						+ " §l§6>> §eKit em Cooldown!");
				return;
			}
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					r.setVelocity(new Vector(0, 1, 0));
				}
			}, 10L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					r.getWorld().createExplosion(r.getLocation(), 0.5f);
					r.getWorld().playEffect(r.getLocation(), Effect.CLOUD, 100, 1);
				}
			}, 20L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 1));
				}
			}, 25L);
			Supernova.cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					Supernova.cooldownm.remove(p);
					p.sendMessage("§eVoce pode usar novamente!");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
				}
			}, 500L);
		}
	}
}
