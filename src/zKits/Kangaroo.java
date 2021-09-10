package zKits;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import zEvents.Tab;
import zPublic.Main;

public class Kangaroo implements CommandExecutor, Listener {
	public Main plugin;
	ArrayList<String> tempo;
	ArrayList<String> naofugir;

	public Kangaroo() {
		this.tempo = new ArrayList<String>();
		this.naofugir = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
		final Player p = (Player) sender;
		if (cmd.getLabel().equalsIgnoreCase("kangaroo")) {
			if (!p.hasPermission("kitxc.kangaroo")) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
				return true;
			}
			if (Arrays.used.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
				return true;
			}
			Arrays.used.add(p.getName());
			Arrays.kangaroo.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Kangaroo");
			Tab.sendTitle(p, "§cKangaroo");
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.FIREWORK) });
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lKangaroo", 10);
			KitsManager.darSopas(p);
		}
		return false;
	}

	@EventHandler
	public void pular(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (p.getItemInHand().getType() == Material.FIREWORK) {
			event.setCancelled(true);
			final Vector vector = p.getEyeLocation().getDirection();
			if (!this.naofugir.contains(p.getName())) {
				if (!this.tempo.contains(p.getName())) {
					this.tempo.add(p.getName());
					if (!p.isSneaking()) {
						p.setFallDistance(-1.0f);
						vector.multiply(0.5f);
						vector.setY(1.0);
						p.setVelocity(vector);
					} else {
						p.setFallDistance(-1.0f);
						vector.multiply(1.5f);
						vector.setY(0.5);
						p.setVelocity(vector);
					}
				}
			} else if (!this.tempo.contains(p.getName())) {
				this.tempo.add(p.getName());
				p.setFallDistance(-1.0f);
				vector.multiply(1.5f);
				vector.setY(0.5);
				p.setVelocity(vector);
			}
		}
	}

	@EventHandler
	public void removertempo(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (this.tempo.contains(p.getName())) {
			final Block b = p.getLocation().getBlock();
			if (b.getType() != Material.AIR || b.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
				this.tempo.remove(p.getName());
			}
		}
	}

	@EventHandler
	public void adicionartempo(final EntityDamageByEntityEvent event) {
		final Player kangaroo = (Player) event.getEntity();
		final Player p = (Player) event.getDamager();
		if (kangaroo instanceof Player && p instanceof Player && kangaroo.getInventory().contains(Material.FIREWORK)) {
			this.naofugir.add(kangaroo.getName());
		}
	}

	@EventHandler
	public void onTomarDano(final EntityDamageEvent event) {
		final Entity e = event.getEntity();
		if (e instanceof Player) {
			final Player player = (Player) e;
			if (event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL
					&& player.getInventory().contains(Material.FIREWORK) && event.getDamage() >= 2.0) {
				event.setDamage(2.0);
			}
		}
	}
}
