package zEvents;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class Admin2 implements Listener {
	public static ArrayList<Player> DamageMobs;

	static {
		Admin2.DamageMobs = new ArrayList<Player>();
	}

	@EventHandler
	public void interact(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.EYE_OF_ENDER) {
			e.setCancelled(true);
			p.sendMessage("�cTestando...");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.setGameMode(GameMode.SURVIVAL);
				}
			}, 10L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.setGameMode(GameMode.CREATIVE);
				}
			}, 20L);
		}
	}

	@EventHandler
	public void DamageMobs(final EntityDamageByEntityEvent e) {
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getDamager();
		if (Admin2.DamageMobs.contains(p) && e.getEntity() instanceof Entity) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void VerPlayers(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.FEATHER
				&& (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)) {
			final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 54, "�0�nPlayer - Online");
			Player[] onlinePlayers;
			for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
				final Player players = onlinePlayers[i];
				if (!players.getName().equals(p.getName())) {
					final ItemStack skull = new ItemStack(Material.getMaterial(397));
					final SkullMeta sm = (SkullMeta) skull.getItemMeta();
					skull.setDurability((short) 3);
					sm.hasOwner();
					sm.setOwner(players.getName());
					sm.setDisplayName(players.getName());
					skull.setItemMeta((ItemMeta) sm);
					inv.addItem(new ItemStack[] { skull });
				}
				p.openInventory(inv);
			}
		}
	}

	@EventHandler
	public void onPlayerChallenge(final InventoryClickEvent evt) {
		if (evt.getCurrentItem() != null && evt.getCurrentItem().getItemMeta() != null) {
			final ItemStack item = evt.getCurrentItem();
			final Player p = (Player) evt.getWhoClicked();
			if (item.getType().equals((Object) Material.SKULL_ITEM)) {
				evt.setCancelled(true);
				p.closeInventory();
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
					final Player players = onlinePlayers[i];
					final ItemMeta im = item.getItemMeta();
					if (players.getName().equals(im.getDisplayName())) {
						p.teleport((Entity) players);
					}
				}
			}
		}
	}
}
