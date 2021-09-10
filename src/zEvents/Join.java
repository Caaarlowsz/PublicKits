package zEvents;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import zPublic.Main;

public class Join implements Listener {
	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		p.sendMessage(" §7-------------------------");
		e.setJoinMessage("");
		p.sendMessage(" §7[§6>§7] Bem Vindo ao  " + Main.getPlugin().getConfig().getString("server").replace("&", "§"));
		p.sendMessage(" §7[§6>§7] Compre Vip e Nos Ajude ");
		p.sendMessage(" §7[§6>§7] D\u00favidas Use /inf ");
		p.sendMessage(" §7-------------------------");
		Main.getPlugin().getServer().getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(),
				(Runnable) new Runnable() {
					@Override
					public void run() {
						ScoreB.setScoreBoard(p);
					}
				}, 0L, 20L);
		p.getInventory().clear();
		p.setExp(0.0f);
		p.setExp(0.0f);
		p.setExhaustion(20.0f);
		p.setMaxHealth(20.0);
		p.setFoodLevel(20);
		p.setGameMode(GameMode.SURVIVAL);
		p.setAllowFlight(false);
		final ItemStack item121 = new ItemStack(Material.DIAMOND);
		final ItemMeta itemmeta121 = item121.getItemMeta();
		itemmeta121.setDisplayName("§a Warps");
		item121.setItemMeta(itemmeta121);
		p.getInventory().setItem(2, item121);
		final ItemStack item122 = new ItemStack(Material.CHEST);
		final ItemMeta itemmeta122 = item122.getItemMeta();
		itemmeta122.setDisplayName("§a Seletor de Kits");
		item122.setItemMeta(itemmeta122);
		p.getInventory().setItem(4, item122);
		final ItemStack item123 = new ItemStack(Material.IRON_INGOT);
		final ItemMeta itemmeta123 = item123.getItemMeta();
		itemmeta123.setDisplayName("§a Extras");
		item123.setItemMeta(itemmeta123);
		p.getInventory().setItem(6, item123);
		for (final PotionEffect effect : p.getActivePotionEffects()) {
			p.removePotionEffect(effect.getType());
		}
		p.teleport(p.getWorld().getSpawnLocation());
		e.setJoinMessage((String) null);
		p.getInventory().setArmorContents((ItemStack[]) null);
	}
}
