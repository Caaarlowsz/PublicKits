package zKits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import zEvents.Tab;
import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class Velotrol implements CommandExecutor, Listener {
	public static ArrayList<Player> Cooldown;
	HashMap<String, Location> Bloco;

	static {
		Velotrol.Cooldown = new ArrayList<Player>();
	}

	public Velotrol() {
		this.Bloco = new HashMap<String, Location>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
		final Player p = (Player) sender;
		if (cmd.getLabel().equalsIgnoreCase("velotrol")) {
			if (!p.hasPermission("kitxc.velotrol")) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
				return true;
			}
			if (Arrays.used.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
				return true;
			}
			Arrays.used.add(p.getName());
			Arrays.urgal.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit �6 >> " + ChatColor.GRAY + " Velotrol");
			Tab.sendTitle(p, "�cVelotrol");
			BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lVelotrol", 10);
			final ItemStack bow = new ItemStack(Material.STONE_SWORD);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("�9Espada de Pedra");
			bow.setItemMeta(bowmeta);
			final ItemStack Velotrol = new ItemStack(Material.MINECART);
			final ItemMeta kVelotrol = Velotrol.getItemMeta();
			kVelotrol.setDisplayName("�aVelotrol");
			Velotrol.setItemMeta(kVelotrol);
			p.getInventory().setItem(0, bow);
			p.getInventory().setItem(1, Velotrol);
			KitsManager.darSopas(p);
		}
		return false;
	}

	@EventHandler
	public void InteractVelotrol(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack velotrol = new ItemStack(Material.MINECART);
		final ItemMeta kVelotrol = velotrol.getItemMeta();
		kVelotrol.setDisplayName("�aVelotrol");
		velotrol.setItemMeta(kVelotrol);
		if (p.getItemInHand().equals((Object) velotrol)) {
			if (zKits.Velotrol.Cooldown.contains(p)) {
				p.sendMessage(String.valueOf(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
						+ " �l�6>> �eKit em Cooldown!");
				return;
			}
			zKits.Velotrol.Cooldown.add(p);
			final Item VelotrolItem = p.getWorld().dropItemNaturally(p.getLocation(),
					new ItemStack(Material.SOUL_SAND));
			VelotrolItem.setMetadata("Velotrol",
					(MetadataValue) new FixedMetadataValue(PublicPvP.getPlugin(), (Object) p.getName()));
			final Vector Vector = p.getEyeLocation().getDirection();
			Vector.multiply(0.8);
			Vector.setY(0.3);
			p.setVelocity(Vector);
			VelotrolItem.setVelocity(Vector);
			VelotrolItem.setPassenger((Entity) p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					VelotrolItem.teleport(p.getLocation());
					VelotrolItem.teleport(p.getLocation());
					VelotrolItem.remove();
				}
			}, 20L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					Velotrol.this.Bloco.put(p.getName(), p.getLocation());
					final Location Localiza\u00e7\u00e3o = new Location(p.getWorld(),
							Velotrol.this.Bloco.get(p.getName()).getX(),
							Velotrol.this.Bloco.get(p.getName()).getY() + 1.0,
							Velotrol.this.Bloco.get(p.getName()).getZ());
					final Location Localiza\u00e7\u00e3oz = new Location(p.getWorld(),
							Velotrol.this.Bloco.get(p.getName()).getX(),
							Velotrol.this.Bloco.get(p.getName()).getY() + 2.0,
							Velotrol.this.Bloco.get(p.getName()).getZ());
					final Block Bloco = Localiza\u00e7\u00e3o.getBlock();
					Bloco.setType(Material.SKULL);
					p.teleport(Localiza\u00e7\u00e3oz);
				}
			}, 30L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					VelotrolItem.removeMetadata("Velotrol", PublicPvP.getPlugin());
				}
			}, 40L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					final Location Explosao = Velotrol.this.Bloco.get(p.getName());
					p.getWorld().createExplosion(Explosao, 5.0f);
					final Location Localiza\u00e7\u00e3o = new Location(p.getWorld(),
							Velotrol.this.Bloco.get(p.getName()).getX(),
							Velotrol.this.Bloco.get(p.getName()).getY() + 1.0,
							Velotrol.this.Bloco.get(p.getName()).getZ());
					final Block Bloco = Localiza\u00e7\u00e3o.getBlock();
					Bloco.setType(Material.AIR);
				}
			}, 60L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					Velotrol.Cooldown.remove(p);
					p.sendMessage("�eVoce pode usar novamente!");
					Velotrol.this.Bloco.remove(p.getName());
				}
			}, 600L);
		}
	}

	@EventHandler
	public void PickupVelotrol(final PlayerPickupItemEvent e) {
		if (e.getItem().hasMetadata("Velotrol")) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void idknow(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (e.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
				return;
			}
			if (Arrays.urgal.contains(p.getName())) {
				e.setCancelled(true);
			}
		}
	}
}
