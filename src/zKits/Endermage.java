package zKits;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.confuser.barapi.BarAPI;
import zEvents.Tab;
import zPublic.Main;

public class Endermage implements CommandExecutor, Listener {
	String teleport;

	public Endermage() {
		this.teleport = "§aPuxado!\nVoce esta invencivel por 5 segundos.";
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
		final Player p = (Player) sender;
		if (cmd.getLabel().equalsIgnoreCase("endermage")) {
			if (!p.hasPermission("kitxc.endermage")) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
				return true;
			}
			if (Arrays.used.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
				return true;
			}
			Arrays.used.add(p.getName());
			Arrays.endermage.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Endermage");
			Tab.sendTitle(p, "§cEndermage");
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lEndermage", 10);
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.PORTAL) });
			KitsManager.darSopas(p);
		}
		return false;
	}

	private boolean isEnderable(final Location portal, final Location player) {
		return Math.abs(portal.getX() - player.getX()) < 3.0 && Math.abs(portal.getZ() - player.getZ()) < 3.0
				&& Math.abs(portal.getY() - player.getY()) >= 3.5;
	}

	public void TeleportP(final Location portal, final Player p1, final Player p2) {
		p1.teleport(portal.clone().add(0.0, 1.0, 0.0));
		p2.teleport(portal.clone().add(0.0, 1.0, 0.0));
		p1.setNoDamageTicks(100);
		p2.setNoDamageTicks(100);
		p1.sendMessage(this.teleport);
		p2.sendMessage(this.teleport);
		p2.getWorld().playEffect(p2.getLocation(), Effect.ENDER_SIGNAL, 9);
		p1.getWorld().playEffect(portal, Effect.ENDER_SIGNAL, 9);
		((LivingEntity) p1.getWorld()).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 1));
		((LivingEntity) p2.getWorld()).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 1));
		p2.playSound(p2.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.2f);
		p1.playSound(portal, Sound.ENDERMAN_TELEPORT, 1.0f, 1.2f);
	}

	@EventHandler
	public void EndermageInteract(final PlayerInteractEvent e) {
		final Player mage = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && mage.getItemInHand().getType() == Material.PORTAL) {
			e.setCancelled(true);
			mage.updateInventory();
			mage.setItemInHand(new ItemStack(Material.AIR));
			mage.updateInventory();
			final Block b = e.getClickedBlock();
			final Location bLoc = b.getLocation();
			final BlockState bs = b.getState();
			b.setType(Material.ENDER_PORTAL_FRAME);
			Player[] arrayOfPlayer;
			for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
				final Player nearby = arrayOfPlayer[i];
				final Player target = nearby.getPlayer();
				new BukkitRunnable() {
					int time = 5;

					public void run() {
						--this.time;
						if (!target.getInventory().contains(Material.PORTAL)
								&& Endermage.this.isEnderable(bLoc, target.getLocation()) && target != mage
								&& !target.isDead()) {
							b.setType(bs.getType());
							b.setData(bs.getBlock().getData());
							this.cancel();
							Endermage.this.TeleportP(bLoc, mage, target);
							if (!mage.getInventory().contains(new ItemStack(Material.PORTAL))) {
								mage.getInventory().addItem(new ItemStack[] { new ItemStack(Material.PORTAL) });
								mage.updateInventory();
							}
						} else if (this.time == 0) {
							this.cancel();
							b.setType(bs.getType());
							b.setData(bs.getBlock().getData());
							if (!mage.getInventory().contains(new ItemStack(Material.PORTAL))) {
								mage.getInventory().addItem(new ItemStack[] { new ItemStack(Material.PORTAL) });
								mage.updateInventory();
							}
						}
					}
				}.runTaskTimer(Main.plugin, 0L, 20L);
			}
		}
	}
}
