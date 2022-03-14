package zEvents;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class Ffeast implements Listener {
	public static void setSimulatorCords1(final Player player) {
		final ConfigurationSection list = PublicPvP.getPlugin().getConfig().getConfigurationSection("MiniFeast");
		final Location loc = player.getLocation();
		list.set("x", (Object) loc.getBlockX());
		list.set("y", (Object) loc.getBlockY());
		list.set("z", (Object) loc.getBlockZ());
		PublicPvP.plugin.saveConfig();
	}

	public static void miniFeast() {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player p1 = onlinePlayers[i];
			final ConfigurationSection list = PublicPvP.getPlugin().getConfig().getConfigurationSection("MiniFeast");
			final int x = (int) list.get("x");
			final int z = (int) list.get("z");
			final Random r = new Random();
			p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1)
					.setType(Material.CHEST);
			p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1)
					.setType(Material.CHEST);
			p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1)
					.setType(Material.CHEST);
			p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1)
					.setType(Material.CHEST);
			p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z)
					.setType(Material.CHEST);
			p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z)
					.setType(Material.CHEST);
			p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z)
					.setType(Material.CHEST);
			p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z)
					.setType(Material.CHEST);
			p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z + 1)
					.setType(Material.CHEST);
			p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z - 1)
					.setType(Material.CHEST);
			p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2)
					.setType(Material.CHEST);
			p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2)
					.setType(Material.CHEST);
			final Chest e2 = (Chest) p1.getLocation().getWorld()
					.getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).getState();
			if (r.nextInt(100) <= 20) {
				e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()),
						new ItemStack(Material.GOLDEN_APPLE));
			}
			if (r.nextInt(100) <= 20) {
				e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16424));
			}
			if (r.nextInt(100) <= 20) {
				e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()),
						new ItemStack(Material.ARROW, 5));
			}
			if (r.nextInt(100) <= 20) {
				e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()),
						new ItemStack(Material.BOW));
			}
			if (r.nextInt(100) <= 20) {
				e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()),
						new ItemStack(Material.IRON_BOOTS));
			}
			e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()),
					new ItemStack(Material.MUSHROOM_SOUP, 3));
			if (r.nextInt(100) <= 20) {
				e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 8201));
			}
			e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()),
					new ItemStack(Material.POTION, 1, (short) 16420));
			if (r.nextInt(100) <= 20) {
				e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16426));
			}
			if (r.nextInt(100) <= 20) {
				e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16428));
			}
			if (r.nextInt(100) <= 20) {
				e2.getBlockInventory().setItem(new Random().nextInt(e2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16418));
			}
			final Chest f2 = (Chest) p1.getLocation().getWorld()
					.getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z).getState();
			if (r.nextInt(100) <= 20) {
				f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()),
						new ItemStack(Material.GOLDEN_APPLE));
			}
			if (r.nextInt(100) <= 20) {
				f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16424));
			}
			if (r.nextInt(100) <= 20) {
				f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()),
						new ItemStack(Material.ARROW, 5));
			}
			if (r.nextInt(100) <= 20) {
				f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()),
						new ItemStack(Material.BOW));
			}
			if (r.nextInt(100) <= 20) {
				f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()),
						new ItemStack(Material.IRON_BOOTS));
			}
			f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()),
					new ItemStack(Material.MUSHROOM_SOUP, 3));
			if (r.nextInt(100) <= 20) {
				f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 8201));
			}
			f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()),
					new ItemStack(Material.POTION, 1, (short) 16420));
			if (r.nextInt(100) <= 20) {
				f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16426));
			}
			if (r.nextInt(100) <= 20) {
				f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16428));
			}
			if (r.nextInt(100) <= 20) {
				f2.getBlockInventory().setItem(new Random().nextInt(f2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16418));
			}
			final Chest d2 = (Chest) p1.getLocation().getWorld()
					.getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).getState();
			if (r.nextInt(100) <= 20) {
				d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()),
						new ItemStack(Material.GOLDEN_APPLE));
			}
			if (r.nextInt(100) <= 20) {
				d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16424));
			}
			if (r.nextInt(100) <= 20) {
				d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()),
						new ItemStack(Material.ARROW, 5));
			}
			if (r.nextInt(100) <= 20) {
				d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()),
						new ItemStack(Material.BOW));
			}
			if (r.nextInt(100) <= 20) {
				d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()),
						new ItemStack(Material.IRON_BOOTS));
			}
			d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()),
					new ItemStack(Material.MUSHROOM_SOUP, 3));
			if (r.nextInt(100) <= 20) {
				d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 8201));
			}
			d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()),
					new ItemStack(Material.POTION, 1, (short) 16420));
			if (r.nextInt(100) <= 20) {
				d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16426));
			}
			if (r.nextInt(100) <= 20) {
				d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16428));
			}
			if (r.nextInt(100) <= 20) {
				d2.getBlockInventory().setItem(new Random().nextInt(d2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16418));
			}
			final Chest b2 = (Chest) p1.getLocation().getWorld()
					.getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1).getState();
			if (r.nextInt(100) <= 20) {
				b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()),
						new ItemStack(Material.GOLDEN_APPLE));
			}
			if (r.nextInt(100) <= 20) {
				b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16424));
			}
			if (r.nextInt(100) <= 20) {
				b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()),
						new ItemStack(Material.ARROW, 5));
			}
			if (r.nextInt(100) <= 20) {
				b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()),
						new ItemStack(Material.BOW));
			}
			if (r.nextInt(100) <= 20) {
				b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()),
						new ItemStack(Material.IRON_BOOTS));
			}
			b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()),
					new ItemStack(Material.MUSHROOM_SOUP, 3));
			if (r.nextInt(100) <= 20) {
				b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 8201));
			}
			b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()),
					new ItemStack(Material.POTION, 1, (short) 16420));
			if (r.nextInt(100) <= 20) {
				b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16426));
			}
			if (r.nextInt(100) <= 20) {
				b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16428));
			}
			if (r.nextInt(100) <= 20) {
				b2.getBlockInventory().setItem(new Random().nextInt(b2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16418));
			}
			final Chest b3 = (Chest) p1.getLocation().getWorld()
					.getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1).getState();
			if (r.nextInt(100) <= 20) {
				b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()),
						new ItemStack(Material.GOLDEN_APPLE));
			}
			if (r.nextInt(100) <= 20) {
				b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16424));
			}
			if (r.nextInt(100) <= 20) {
				b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()),
						new ItemStack(Material.ARROW, 5));
			}
			if (r.nextInt(100) <= 20) {
				b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()),
						new ItemStack(Material.BOW));
			}
			if (r.nextInt(100) <= 20) {
				b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()),
						new ItemStack(Material.IRON_BOOTS));
			}
			b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()),
					new ItemStack(Material.MUSHROOM_SOUP, 3));
			if (r.nextInt(100) <= 20) {
				b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 8201));
			}
			b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()),
					new ItemStack(Material.POTION, 1, (short) 16420));
			if (r.nextInt(100) <= 20) {
				b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16426));
			}
			if (r.nextInt(100) <= 20) {
				b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16428));
			}
			if (r.nextInt(100) <= 20) {
				b3.getBlockInventory().setItem(new Random().nextInt(b3.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16418));
			}
			final Chest c1 = (Chest) p1.getLocation().getWorld()
					.getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z).getState();
			if (r.nextInt(100) <= 20) {
				c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()),
						new ItemStack(Material.GOLDEN_APPLE));
			}
			if (r.nextInt(100) <= 20) {
				c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16424));
			}
			if (r.nextInt(100) <= 20) {
				c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()),
						new ItemStack(Material.ARROW, 5));
			}
			if (r.nextInt(100) <= 20) {
				c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()),
						new ItemStack(Material.BOW));
			}
			if (r.nextInt(100) <= 20) {
				c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()),
						new ItemStack(Material.IRON_BOOTS));
			}
			c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()),
					new ItemStack(Material.MUSHROOM_SOUP, 3));
			if (r.nextInt(100) <= 20) {
				c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 8201));
			}
			c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()),
					new ItemStack(Material.POTION, 1, (short) 16420));
			if (r.nextInt(100) <= 20) {
				c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16426));
			}
			if (r.nextInt(100) <= 20) {
				c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16428));
			}
			if (r.nextInt(100) <= 20) {
				c1.getBlockInventory().setItem(new Random().nextInt(c1.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16418));
			}
			final Chest c2 = (Chest) p1.getLocation().getWorld()
					.getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z).getState();
			if (r.nextInt(100) <= 20) {
				c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()),
						new ItemStack(Material.GOLDEN_APPLE));
			}
			if (r.nextInt(100) <= 20) {
				c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16424));
			}
			if (r.nextInt(100) <= 20) {
				c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()),
						new ItemStack(Material.ARROW, 5));
			}
			if (r.nextInt(100) <= 20) {
				c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()),
						new ItemStack(Material.BOW));
			}
			if (r.nextInt(100) <= 20) {
				c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()),
						new ItemStack(Material.IRON_BOOTS));
			}
			c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()),
					new ItemStack(Material.MUSHROOM_SOUP, 3));
			if (r.nextInt(100) <= 20) {
				c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 8201));
			}
			c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()),
					new ItemStack(Material.POTION, 1, (short) 16420));
			if (r.nextInt(100) <= 20) {
				c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16426));
			}
			if (r.nextInt(100) <= 20) {
				c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16428));
			}
			if (r.nextInt(100) <= 20) {
				c2.getBlockInventory().setItem(new Random().nextInt(c2.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16418));
			}
			final Chest c3 = (Chest) p1.getLocation().getWorld()
					.getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z + 1).getState();
			if (r.nextInt(100) <= 20) {
				c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()),
						new ItemStack(Material.IRON_BOOTS));
			}
			c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()),
					new ItemStack(Material.MUSHROOM_SOUP, 3));
			if (r.nextInt(100) <= 20) {
				c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 8201));
			}
			c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()),
					new ItemStack(Material.POTION, 1, (short) 16420));
			if (r.nextInt(100) <= 20) {
				c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16426));
			}
			if (r.nextInt(100) <= 20) {
				c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16428));
			}
			if (r.nextInt(100) <= 20) {
				c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16418));
			}
			if (r.nextInt(100) <= 20) {
				c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()),
						new ItemStack(Material.GOLDEN_APPLE));
			}
			if (r.nextInt(100) <= 20) {
				c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16424));
			}
			if (r.nextInt(100) <= 20) {
				c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()),
						new ItemStack(Material.ARROW, 5));
			}
			if (r.nextInt(100) <= 20) {
				c3.getBlockInventory().setItem(new Random().nextInt(c3.getBlockInventory().getSize()),
						new ItemStack(Material.BOW));
			}
			final Chest c4 = (Chest) p1.getLocation().getWorld()
					.getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z - 1).getState();
			if (r.nextInt(100) <= 20) {
				c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()),
						new ItemStack(Material.ARROW, 5));
			}
			if (r.nextInt(100) <= 20) {
				c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()),
						new ItemStack(Material.BOW));
			}
			if (r.nextInt(100) <= 20) {
				c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()),
						new ItemStack(Material.GOLDEN_APPLE));
			}
			if (r.nextInt(100) <= 20) {
				c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16424));
			}
			if (r.nextInt(100) <= 20) {
				c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()),
						new ItemStack(Material.IRON_BOOTS));
			}
			c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()),
					new ItemStack(Material.MUSHROOM_SOUP, 3));
			if (r.nextInt(100) <= 20) {
				c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 8201));
			}
			c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()),
					new ItemStack(Material.POTION, 1, (short) 16420));
			if (r.nextInt(100) <= 20) {
				c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16426));
			}
			if (r.nextInt(100) <= 20) {
				c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16428));
			}
			if (r.nextInt(100) <= 20) {
				c4.getBlockInventory().setItem(new Random().nextInt(c4.getBlockInventory().getSize()),
						new ItemStack(Material.POTION, 1, (short) 16418));
			}
		}
	}

	public static void miniFeast1() {
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player p1 = onlinePlayers[i];
			final ConfigurationSection list = PublicPvP.getPlugin().getConfig().getConfigurationSection("MiniFeast");
			final int x = (int) list.get("x");
			final int z = (int) list.get("z");
			p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1)
					.setType(Material.AIR);
			p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1)
					.setType(Material.AIR);
			p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 1)
					.setType(Material.AIR);
			p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 1)
					.setType(Material.AIR);
			p1.getLocation().getWorld().getBlockAt(x + 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z)
					.setType(Material.AIR);
			p1.getLocation().getWorld().getBlockAt(x - 2, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z)
					.setType(Material.AIR);
			p1.getLocation().getWorld().getBlockAt(x + 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z)
					.setType(Material.AIR);
			p1.getLocation().getWorld().getBlockAt(x - 1, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z)
					.setType(Material.AIR);
			p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z + 1)
					.setType(Material.AIR);
			p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z) + 1, z - 1)
					.setType(Material.AIR);
			p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z + 2)
					.setType(Material.AIR);
			p1.getLocation().getWorld().getBlockAt(x, p1.getLocation().getWorld().getHighestBlockYAt(x, z), z - 2)
					.setType(Material.AIR);
		}
	}
}
