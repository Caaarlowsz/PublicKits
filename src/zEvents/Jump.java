package zEvents;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import zPublic.Main;

public class Jump implements Listener {
	Main main;
	public static ArrayList<String> jump;
	ArrayList<String> nofalldamagec;
	ArrayList<String> nofalldamagewaitsd;
	ArrayList<String> nofalldamage;
	ArrayList<String> nofalldamagewait;

	static {
		Jump.jump = new ArrayList<String>();
	}

	public Jump(Main plugin) {
		this.nofalldamagec = new ArrayList<String>();
		this.nofalldamagewaitsd = new ArrayList<String>();
		this.nofalldamage = new ArrayList<String>();
		this.nofalldamagewait = new ArrayList<String>();
		plugin = this.main;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJump(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BEACON) {
			Jump.jump.remove(p.getName());
			final Vector sponge = p.getLocation().getDirection().multiply(0).setY(4);
			p.setVelocity(sponge);
			p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 1);
			p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 999));
			p.getWorld().playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			Jump.jump.add(p.getName());
			Jump.jump.remove(p.getName());
			Jump.jump.add(p.getName());
		}
	}

	@EventHandler
	public void onPlayerDamageSponge(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (Jump.jump.contains(p.getName())) {
			Jump.jump.remove(p.getName());
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageSponge(final EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		final Player player = (Player) event.getEntity();
		final Location loc = player.getLocation();
		final Location below = loc.subtract(0.0, 1.0, 0.0);
		final Block blockBelow = below.getBlock();
		if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (blockBelow.getType() == Material.BEACON) {
			Jump.jump.add(player.getName());
			event.setDamage(0.0);
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerSpongeDamage(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (Jump.jump.contains(p.getName())) {
			Jump.jump.remove(p.getName());
			e.setDamage(0.0);
		}
	}

	@EventHandler
	public void onPlayerFrentes(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE) {
			final Vector sponge = p.getLocation().getDirection().multiply(0.1).setY(9.0);
			p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
			p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
			p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
			p.getWorld().playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
			p.getWorld().playSound(p.getLocation(), Sound.STEP_GRASS, 1.0f, 1.0f);
			p.getWorld().playSound(p.getLocation(), Sound.STEP_GRASS, 1.0f, 1.0f);
			p.getWorld().playSound(p.getLocation(), Sound.STEP_GRASS, 1.0f, 1.0f);
			p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 999));
			p.getWorld().playSound(p.getLocation(), Sound.STEP_GRASS, 1.0f, 1.0f);
			p.setVelocity(sponge);
			if (!this.nofalldamagec.contains(p.getName())) {
				this.nofalldamagec.add(p.getName());
			}
		}
	}

	@EventHandler
	public void onEntityDamages(final EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			final Player player = (Player) event.getEntity();
			if (this.nofalldamagec.contains(player.getName())
					&& event.getCause().equals((Object) EntityDamageEvent.DamageCause.FALL)) {
				event.setCancelled(true);
				this.nofalldamagec.remove(player.getName());
			}
		}
	}

	@EventHandler
	public void onPlayerFrente(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.DIAMOND_BLOCK) {
			final Vector sponge = p.getLocation().getDirection().multiply(4.5).setY(0.5);
			p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 1);
			p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 999));
			p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 1.0f, 1.0f);
			p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 1.0f, 1.0f);
			p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 1.0f, 1.0f);
			p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 1.0f, 1.0f);
			p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 1.0f, 1.0f);
			p.getWorld().playSound(p.getLocation(), Sound.HORSE_SOFT, 1.0f, 1.0f);
			p.setVelocity(sponge);
			if (!this.nofalldamage.contains(p.getName())) {
				this.nofalldamage.add(p.getName());
			}
		}
	}

	@EventHandler
	public void onEntityDamage(final EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			final Player player = (Player) event.getEntity();
			if (this.nofalldamage.contains(player.getName())
					&& event.getCause().equals((Object) EntityDamageEvent.DamageCause.FALL)) {
				event.setCancelled(true);
				this.nofalldamage.remove(player.getName());
			}
		}
	}
}
