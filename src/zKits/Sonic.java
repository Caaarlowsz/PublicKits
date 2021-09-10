package zKits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import zEvents.Tab;
import zPublic.Main;

public class Sonic implements Listener, CommandExecutor {
	public static ArrayList<Player> Cooldown;
	public static HashMap<String, ItemStack[]> Armadura;
	public static ArrayList<Player> cooldownm;

	static {
		Sonic.Cooldown = new ArrayList<Player>();
		Sonic.Armadura = new HashMap<String, ItemStack[]>();
		Sonic.cooldownm = new ArrayList<Player>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
		final Player p = (Player) sender;
		if (cmd.getLabel().equalsIgnoreCase("sonic")) {
			if (!p.hasPermission("kitxc.sonic")) {
				p.sendMessage(ChatColor.BLUE + "Voc\u00ea n\u00e3o Possui este Kit");
				return true;
			}
			if (Arrays.used.contains(p.getName())) {
				p.sendMessage(ChatColor.BLUE + "Voc\u00ea ja esta Utilizando um Kit");
				return true;
			}
			Arrays.used.add(p.getName());
			Arrays.shadow.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " DeshFire");
			Tab.sendTitle(p, "§cSonic");
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.LAPIS_BLOCK) });
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lSonic", 10);
			KitsManager.darSopas(p);
		}
		return false;
	}

	@EventHandler
	public void interact(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& Arrays.shadow.contains(p.getName()) && p.getItemInHand().getType() == Material.LAPIS_BLOCK) {
			e.setCancelled(true);
			p.updateInventory();
			if (Sonic.cooldownm.contains(p)) {
				p.sendMessage(String.valueOf(Main.getPlugin().getConfig().getString("server").replace("&", "§"))
						+ " §l§6>> §eKit em Cooldown!");
				return;
			}
			Sonic.Armadura.put(p.getName(), p.getInventory().getArmorContents());
			final ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
			final LeatherArmorMeta kPeitoral = (LeatherArmorMeta) Peitoral.getItemMeta();
			kPeitoral.setColor(Color.BLUE);
			Peitoral.setItemMeta((ItemMeta) kPeitoral);
			p.getInventory().setChestplate(Peitoral);
			final ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
			final LeatherArmorMeta kCapacete = (LeatherArmorMeta) Capacete.getItemMeta();
			kCapacete.setColor(Color.BLUE);
			Capacete.setItemMeta((ItemMeta) kCapacete);
			final ItemStack Calca = new ItemStack(Material.LEATHER_LEGGINGS);
			final LeatherArmorMeta kCalca = (LeatherArmorMeta) Calca.getItemMeta();
			kCalca.setColor(Color.BLUE);
			Calca.setItemMeta((ItemMeta) kCalca);
			final ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
			final LeatherArmorMeta kBota = (LeatherArmorMeta) Bota.getItemMeta();
			kBota.setColor(Color.BLUE);
			Bota.setItemMeta((ItemMeta) kBota);
			p.getInventory().setHelmet(Capacete);
			p.getInventory().setLeggings(Calca);
			p.getInventory().setBoots(Bota);
			p.sendMessage(String.valueOf(Main.getPlugin().getConfig().getString("server").replace("&", "§"))
					+ " >>  §eSonic Usado!");
			p.playSound(p.getLocation(), Sound.ANVIL_USE, 1.0f, 1.0f);
			p.updateInventory();
			final Vector Vector = p.getEyeLocation().getDirection();
			Vector.multiply(5);
			p.setVelocity(Vector);
			final List<Entity> Local = (List<Entity>) p.getNearbyEntities(10.0, 10.0, 10.0);
			for (final Entity Inimigos : Local) {
				((LivingEntity) Inimigos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 150, 1));
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.setVelocity(Vector);
						p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 100, 1);
					}
				}, 20L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 100, 1);
					}
				}, 30L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 100, 1);
					}
				}, 40L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
					@Override
					public void run() {
						p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 100, 1);
					}
				}, 50L);
			}
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 100, 1);
					p.getInventory().setArmorContents((ItemStack[]) Sonic.Armadura.get(p.getName()));
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0));
				}
			}, 60L);
			Sonic.cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					Sonic.cooldownm.remove(p);
					p.sendMessage("§eVoce pode usar novamente!");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
				}
			}, 500L);
		}
	}
}
