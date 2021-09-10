package zKits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;
import zEvents.Tab;
import zPublic.Main;

public class Urano implements Listener, CommandExecutor {
	public static ArrayList<Player> cooldownm;

	static {
		Urano.cooldownm = new ArrayList<Player>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
		final Player p = (Player) sender;
		if (cmd.getLabel().equalsIgnoreCase("urano")) {
			if (!p.hasPermission("kitxc.urano")) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
				return true;
			}
			if (Arrays.used.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
				return true;
			}
			Arrays.used.add(p.getName());
			Arrays.urano.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Urano");
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lUrano", 10);
			Tab.sendTitle(p, "§cUrano");
			final ItemStack bow = new ItemStack(Material.STONE_SWORD);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§9Espada de Pedra");
			bow.setItemMeta(bowmeta);
			p.getInventory().setItem(0, bow);
			final ItemStack b = new ItemStack(Material.SLIME_BALL);
			final ItemMeta bmeta = b.getItemMeta();
			bmeta.setDisplayName("§aUrano");
			b.setItemMeta(bmeta);
			p.getInventory().setItem(1, b);
			KitsManager.darSopas(p);
		}
		return false;
	}

	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.SLIME_BALL
				&& Arrays.urano.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (Urano.cooldownm.contains(p)) {
				p.sendMessage("§eKit em cooldown acabar!");
				return;
			}
			final Location loc = p.getLocation();
			p.getWorld().playSound(loc, Sound.BAT_HURT, 5.0f, -5.0f);
			Urano.cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					Arrays.uran.add(p.getName());
				}
			}, 0L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					Arrays.uran.remove(p.getName());
				}
			}, 100L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					Urano.cooldownm.remove(p);
					p.sendMessage("§eVoce J\u00e1 pode usar seu Kit!");
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
				}
			}, 1000L);
		}
	}

	@EventHandler
	public void fraqueza(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (Arrays.uran.contains(p.getName())) {
			for (final Entity pertos : p.getNearbyEntities(5.0, 5.0, 5.0)) {
				if (!(pertos instanceof Player)) {
					continue;
				}
				p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 100, 1);
				final Player perto = (Player) pertos;
				final Location loc = pertos.getLocation();
				loc.setY(loc.getY() + 3.0);
				final Entity arrow2 = Bukkit.getServer().getWorld(pertos.getLocation().getWorld().getName())
						.spawnEntity(loc, EntityType.BAT);
				((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 150, 1));
				BarAPI.setMessage("Voc\u00ea foi atingido por um urano.");
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						BarAPI.removeBar(perto);
						arrow2.remove();
					}
				}, 10L);
			}
		}
	}
}
