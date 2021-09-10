package zKits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import zPublic.Main;

public class Flyer implements CommandExecutor, Listener {
	public ArrayList<String> congelado;
	public ArrayList<String> cooldownFlyer;
	public static ArrayList<Player> cooldownm;
	public int id11;

	static {
		Flyer.cooldownm = new ArrayList<Player>();
	}

	public Flyer() {
		this.congelado = new ArrayList<String>();
		this.cooldownFlyer = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
		final Player p = (Player) sender;
		if (cmd.getLabel().equalsIgnoreCase("gon")) {
			if (!p.hasPermission("kitxc.iceman")) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
				return true;
			}
			if (Arrays.used.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
				return true;
			}
			Arrays.used.add(p.getName());
			Arrays.avatar.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Iceman");
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lIceman", 10);
			final ItemStack bow = new ItemStack(Material.STONE_SWORD);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§9Espada de Pedra");
			bow.setItemMeta(bowmeta);
			p.getInventory().setItem(0, bow);
			final ItemStack bow2 = new ItemStack(Material.ICE);
			final ItemMeta bowmeta2 = bow2.getItemMeta();
			bowmeta2.setDisplayName("§bRei do Gelo");
			bow2.setItemMeta(bowmeta2);
			p.getInventory().setItem(1, bow2);
			KitsManager.darSopas(p);
		}
		return false;
	}

	@EventHandler
	public void clicouvoou(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		e.getAction();
		if (Action.RIGHT_CLICK_BLOCK != null && p.getItemInHand().getType() == Material.ICE) {
			if (Flyer.cooldownm.contains(p)) {
				p.sendMessage(String.valueOf(Main.getPlugin().getConfig().getString("server").replace("&", "§"))
						+ " §l§6>> §eKit em Cooldown!");
				return;
			}
			Arrays.gelo.add(p.getName());
			final FallingBlock tapete = p.getWorld().spawnFallingBlock(p.getLocation().clone().add(0.0, 1.0, 0.0),
					Material.ICE.getId(), (byte) 0);
			tapete.setDropItem(false);
			tapete.setVelocity(new Vector(0, 0, 0));
			tapete.setPassenger((Entity) p);
			final Location loc = p.getLocation().clone();
			loc.setPitch(0.0f);
			Flyer.cooldownm.add(p);
			final Vector vec = p.getVelocity().clone();
			final int forca = 7;
			final Vector pular = vec.multiply(0.1).setY(0.17 * forca);
			final Vector olhar = loc.getDirection().normalize().multiply(1.5);
			tapete.setVelocity(pular.add(olhar));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					tapete.remove();
					Arrays.gelo.remove(p.getName());
				}
			}, 50L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					Flyer.cooldownm.remove(p);
					p.sendMessage("§eJ\u00e1 pode Usar Seu Kit");
				}
			}, 400L);
		}
	}

	@EventHandler
	public void fraqueza(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (Arrays.gelo.contains(p.getName())) {
			for (final Entity en : p.getNearbyEntities(20.0, 20.0, 20.0)) {
				if (en instanceof Player) {
					final Player nearby = (Player) en;
					if (this.congelado.contains(nearby.getName())) {
						continue;
					}
					this.congelado.add(nearby.getName());
					nearby.sendMessage("§c Um IceMan passou por voc\u00ea por isso esta congelado");
					p.getWorld().playEffect(p.getLocation(), Effect.CLOUD, 20);
					p.getWorld().playEffect(p.getLocation(), Effect.WATERDRIP, 15);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(),
							(Runnable) new Runnable() {
								@Override
								public void run() {
									Flyer.this.congelado.remove(nearby.getName());
								}
							}, 100L);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(),
							(Runnable) new Runnable() {
								@Override
								public void run() {
									Flyer.this.cooldownFlyer.remove(p.getName());
								}
							}, 1000L);
				}
			}
		}
	}

	@EventHandler
	public void cancelMove(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (this.congelado.contains(p.getName())) {
			e.setTo(p.getLocation());
		}
	}

	@EventHandler
	public void deathFlyer(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		this.cooldownFlyer.remove(p.getName());
		this.congelado.remove(p.getName());
	}

	@EventHandler
	public void QuebrarItem(final BlockPlaceEvent e) {
		final Player p = e.getPlayer();
		if (Arrays.avatar.contains(p.getName())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void QuebrarItem1(final PlayerDropItemEvent e) {
		if (e.getItemDrop().hasMetadata("§bRei do Gelo")) {
			e.setCancelled(true);
		}
	}
}
