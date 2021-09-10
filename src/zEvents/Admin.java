package zEvents;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import zKits.Arrays;
import zKits.DeshFire;
import zKits.Firer;
import zKits.Flyer;
import zKits.Ninja;
import zKits.Sonic;
import zKits.Supernova;
import zKits.Terrorista;
import zKits.Tornado;
import zKits.Wither;

public class Admin implements CommandExecutor, Listener {
	ArrayList<Player> vanished;
	ArrayList<Player> admin;

	public Admin() {
		this.vanished = new ArrayList<Player>();
		this.admin = new ArrayList<Player>();
	}

	@EventHandler
	public void InventorySee(final PlayerInteractEntityEvent e) {
		final Player r = (Player) e.getRightClicked();
		final Player p = e.getPlayer();
		final Player user = p.getServer().getPlayer(r.getName());
		if (this.admin.contains(p)) {
			p.openInventory((Inventory) user.getInventory());
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("admin") && p.hasPermission("kitpvp.admin")) {
			if (!this.vanished.contains(p)) {
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length,
						i = 0; i < length; ++i) {
					final Player all = onlinePlayers[i];
					all.hidePlayer(p);
				}
				p.sendMessage("§cVoce entrou no modo Admin!");
				p.setGameMode(GameMode.CREATIVE);
				this.vanished.add(p);
				p.getInventory().clear();
				p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 0));
				final ItemStack item15 = new ItemStack(Material.FEATHER);
				final ItemMeta itemmeta15 = item15.getItemMeta();
				itemmeta15.setDisplayName("§6§l Players");
				item15.setItemMeta(itemmeta15);
				final ItemStack bow = new ItemStack(Material.STICK);
				final ItemMeta bowmeta = bow.getItemMeta();
				bowmeta.addEnchant(Enchantment.KNOCKBACK, 5, true);
				bowmeta.setDisplayName("§6Teste KnockBack");
				bow.setItemMeta(bowmeta);
				final ItemStack item16 = new ItemStack(Material.EYE_OF_ENDER);
				final ItemMeta itemmeta16 = item16.getItemMeta();
				itemmeta16.setDisplayName("§6§l Teste FF");
				item16.setItemMeta(itemmeta16);
				p.getInventory().setItem(0, bow);
				p.getInventory().setItem(4, item15);
				p.getInventory().setItem(8, item16);
			} else {
				Player[] onlinePlayers2;
				for (int length2 = (onlinePlayers2 = Bukkit.getServer().getOnlinePlayers()).length,
						j = 0; j < length2; ++j) {
					final Player all = onlinePlayers2[j];
					all.showPlayer(p);
				}
				p.removePotionEffect(PotionEffectType.INVISIBILITY);
				p.sendMessage("§cVoce saiu do modo Admin!");
				p.setGameMode(GameMode.SURVIVAL);
				p.getInventory().clear();
				p.teleport(p.getWorld().getSpawnLocation());
				Arrays.removeAbility(p);
				Sonic.cooldownm.remove(p);
				Terrorista.cooldownm.remove(p);
				DeshFire.cooldownm.remove(p);
				Ninja.cooldownbk.remove(p);
				Firer.cooldownm.remove(p);
				Supernova.cooldownm.remove(p);
				Tornado.cooldownm.remove(p);
				Flyer.cooldownm.remove(p);
				Wither.cooldown.remove(p.getName());
				Sonic.cooldownm.remove(p);
				Arrays.used.remove(p.getName());
				Arrays.pvp.remove(p.getName());
				Arrays.magma.remove(p.getName());
				Arrays.desh.remove(p.getName());
				Arrays.ninja.remove(p.getName());
				Arrays.troll.remove(p.getName());
				Arrays.shadow.remove(p.getName());
				Arrays.gelo.remove(p.getName());
				Arrays.avatar.remove(p.getName());
				Arrays.stomper.remove(p.getName());
				Arrays.viper.remove(p.getName());
				Arrays.urgal.remove(p.getName());
				Arrays.turtle.remove(p.getName());
				Arrays.terrorista.remove(p.getName());
				Arrays.endermage.remove(p.getName());
				Arrays.pulo.remove(p.getName());
				Arrays.ironman.remove(p.getName());
				Arrays.kriptonita.remove(p.getName());
				Arrays.reaper.remove(p.getName());
				p.getInventory().clear();
				final ItemStack item17 = new ItemStack(Material.DIAMOND);
				final ItemMeta itemmeta17 = item17.getItemMeta();
				itemmeta17.setDisplayName("§a Warps");
				item17.setItemMeta(itemmeta17);
				p.getInventory().setItem(2, item17);
				final ItemStack item18 = new ItemStack(Material.CHEST);
				final ItemMeta itemmeta18 = item18.getItemMeta();
				itemmeta18.setDisplayName("§a Seletor de Kits");
				item18.setItemMeta(itemmeta18);
				p.getInventory().setItem(4, item18);
				final ItemStack item19 = new ItemStack(Material.IRON_INGOT);
				final ItemMeta itemmeta19 = item19.getItemMeta();
				itemmeta19.setDisplayName("§a Extras");
				item19.setItemMeta(itemmeta19);
				p.getInventory().setItem(6, item19);
				this.vanished.remove(p);
			}
			Player[] onlinePlayers3;
			for (int length3 = (onlinePlayers3 = Bukkit.getServer().getOnlinePlayers()).length,
					k = 0; k < length3; ++k) {
				final Player all = onlinePlayers3[k];
				if (all.isOp() && !this.vanished.contains(p) && all.getName() != p.getName()) {
					all.sendMessage("");
				} else if (all.isOp() && this.vanished.contains(p)) {
					if (all.getName() != p.getName()) {
						all.sendMessage("");
						all.showPlayer(p);
					}
				}
			}
		}
		return true;
	}

	@EventHandler
	public void EntrouEscondeu(final PlayerJoinEvent e) {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player todos = onlinePlayers[i];
			if (this.vanished.contains(todos)) {
				e.getPlayer().hidePlayer(todos);
			}
		}
	}

	@EventHandler
	public void onAdminAbririnv(final PlayerInteractEntityEvent event) {
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p1 = event.getPlayer();
		final Player r = (Player) event.getRightClicked();
		if (this.admin.contains(p1) && p1.getItemInHand().getType() == Material.AIR) {
			p1.openInventory((Inventory) r.getInventory());
		}
	}
}
