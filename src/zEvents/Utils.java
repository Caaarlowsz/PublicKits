package zEvents;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import zKits.Arrays;
import zKits.DeshFire;
import zKits.Firer;
import zKits.Flyer;
import zKits.Ninja;
import zKits.Sonic;
import zKits.Supernova;
import zKits.Terrorista;
import zKits.Tornado;
import zKits.Wither;
import zPublic.Main;

public class Utils implements Listener {
	ArrayList<String> mecheu;

	public Utils() {
		this.mecheu = new ArrayList<String>();
	}

	@EventHandler
	public void cancelarExplosao(final EntityExplodeEvent evento) {
		evento.setCancelled(true);
	}

	@EventHandler
	public void Quit(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		e.setQuitMessage("§c>> - " + ChatColor.GRAY + p.getName() + " §c-  <<");
		p.getInventory().clear();
		p.teleport(p.getWorld().getSpawnLocation());
		Arrays.removeAbility(p);
		Sonic.cooldownm.remove(p);
		Terrorista.cooldownm.remove(p);
		DeshFire.cooldownm.remove(p);
		Ninja.cooldownbk.remove(p);
		Firer.cooldownm.remove(p);
		Supernova.cooldownm.remove(p);
		Tornado.cooldownm.remove(p);
		Flyer.cooldownm.remove(p);
		Wither.cooldown.remove(p.getName());
		Sonic.cooldownm.remove(p);
		Arrays.used.remove(p.getName());
		Arrays.pvp.remove(p.getName());
		Arrays.magma.remove(p.getName());
		Arrays.desh.remove(p.getName());
		Arrays.ninja.remove(p.getName());
		Arrays.troll.remove(p.getName());
		Arrays.shadow.remove(p.getName());
		Arrays.gelo.remove(p.getName());
		Arrays.avatar.remove(p.getName());
		Arrays.stomper.remove(p.getName());
		Arrays.viper.remove(p.getName());
		Arrays.urgal.remove(p.getName());
		Arrays.turtle.remove(p.getName());
		Arrays.terrorista.remove(p.getName());
		Arrays.endermage.remove(p.getName());
		Arrays.pulo.remove(p.getName());
		Arrays.ironman.remove(p.getName());
		Arrays.kriptonita.remove(p.getName());
		Arrays.reaper.remove(p.getName());
	}

	@EventHandler
	public void antiPluginView(final PlayerCommandPreprocessEvent evento) {
		final Player p = evento.getPlayer();
		if (evento.getMessage().equalsIgnoreCase("/pl") || evento.getMessage().equalsIgnoreCase("/plugins")
				|| evento.getMessage().equalsIgnoreCase("/plugin") || evento.getMessage().equalsIgnoreCase("/help")
				|| evento.getMessage().equalsIgnoreCase("/bukkit") || evento.getMessage().equalsIgnoreCase("/?")) {
			p.sendMessage("§7Plugin Criado Por:");
			p.sendMessage("§6>> §fKiwwi_ (skype:victor.fernades)");
			evento.setCancelled(true);
		}
	}

	@EventHandler
	public void nuncaChover(final WeatherChangeEvent evento) {
		evento.setCancelled(true);
	}

	@EventHandler
	public void nuncaFome(final FoodLevelChangeEvent evento) {
		evento.setFoodLevel(20);
	}

	public static void onDia() {
		Main.getPlugin().getServer().getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(),
				(Runnable) new Runnable() {
					@Override
					public void run() {
						Main.getWorld().setTime(0L);
					}
				}, 0L, 20L);
	}

	@EventHandler
	public void onEntityDamageByEntity1(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			final Player d = (Player) e.getDamager();
			if (d.getItemInHand().getType() == Material.DIAMOND_SWORD
					|| d.getItemInHand().getType() == Material.WOOD_SWORD
					|| d.getItemInHand().getType() == Material.STONE_SWORD
					|| d.getItemInHand().getType() == Material.IRON_SWORD
					|| d.getItemInHand().getType() == Material.WOOD_AXE) {
				d.getItemInHand().setDurability((short) 0);
			}
		}
	}

	@EventHandler
	public void onEntityDamage(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (p.getInventory().getChestplate() != null) {
				p.getInventory().getChestplate().setDurability((short) 0);
			}
			if (p.getInventory().getBoots() != null) {
				p.getInventory().getBoots().setDurability((short) 0);
			}
			if (p.getInventory().getLeggings() != null) {
				p.getInventory().getLeggings().setDurability((short) 0);
			}
			if (p.getInventory().getHelmet() != null) {
				p.getInventory().getHelmet().setDurability((short) 0);
			}
		}
	}

	@EventHandler
	public void NerfsDanos(final EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player) {
			final Player player = (Player) event.getDamager();
			if (event.getDamage() > 1.0) {
				event.setDamage(event.getDamage() - 1.0);
			}
			if (event.getDamager() instanceof Player) {
				final int NewDamage = (int) (event.getDamage() * 1.5) - (int) event.getDamage();
				if (event.getDamage() > 1.0) {
					event.setDamage(event.getDamage() - NewDamage);
				}
				if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
					event.setDamage(0.5);
				}
				if (player.getItemInHand().getType() == Material.STONE_SWORD) {
					event.setDamage(0.5);
				}
				if (player.getItemInHand().getType() == Material.IRON_SWORD) {
					event.setDamage(1.0);
				}
				if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					event.setDamage(3.0);
				}
				if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
					event.setDamage(event.getDamage() + 0.5);
				}
				if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
					event.setDamage(event.getDamage() + 1.0);
				}
				if (player.getItemInHand().getType() == Material.STONE_SWORD) {
					event.setDamage(event.getDamage() + 1.0);
				}
				if (player.getItemInHand().getType() == Material.IRON_SWORD) {
					event.setDamage(event.getDamage() + 1.0);
				}
				if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					event.setDamage(event.getDamage() + 1.0);
				}
				if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
					event.setDamage(event.getDamage() + 1.5);
				}
				if (player.getItemInHand().getType() == Material.STONE_SWORD) {
					event.setDamage(event.getDamage() + 1.5);
				}
				if (player.getItemInHand().getType() == Material.IRON_SWORD) {
					event.setDamage(event.getDamage() + 1.5);
				}
				if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					event.setDamage(event.getDamage() + 1.5);
				}
				if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
					event.setDamage(event.getDamage() + 0.5);
				}
				if (player.getItemInHand().getType() == Material.STONE_SWORD) {
					event.setDamage(event.getDamage() + 0.5);
				}
				if (player.getItemInHand().getType() == Material.IRON_SWORD) {
					event.setDamage(event.getDamage() + 0.5);
				}
				if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					event.setDamage(event.getDamage() + 0.5);
				}
			}
		}
	}

	@EventHandler
	public void placaColorida(final SignChangeEvent sign) {
		final Player player = sign.getPlayer();
		if (player.hasPermission("kitpvp.sign")) {
			if (sign.getLine(0).contains("&1") || sign.getLine(0).contains("&2") || sign.getLine(0).contains("&3")
					|| sign.getLine(0).contains("&4") || sign.getLine(0).contains("&5")
					|| sign.getLine(0).contains("&6") || sign.getLine(0).contains("&7")
					|| sign.getLine(0).contains("&8") || sign.getLine(0).contains("&9")
					|| sign.getLine(0).contains("&0") || sign.getLine(0).contains("&a")
					|| sign.getLine(0).contains("&b") || sign.getLine(0).contains("&c")
					|| sign.getLine(0).contains("&d") || sign.getLine(0).contains("&e")
					|| sign.getLine(0).contains("&f") || sign.getLine(0).contains("&o")
					|| sign.getLine(0).contains("&l") || sign.getLine(0).contains("&k")
					|| sign.getLine(0).contains("&n") || sign.getLine(0).contains("&m")
					|| sign.getLine(0).contains("&r")) {
				sign.setLine(0, sign.getLine(0).replace("&", "§"));
			}
			if (sign.getLine(1).contains("&1") || sign.getLine(1).contains("&2") || sign.getLine(1).contains("&3")
					|| sign.getLine(1).contains("&4") || sign.getLine(1).contains("&5")
					|| sign.getLine(1).contains("&6") || sign.getLine(1).contains("&7")
					|| sign.getLine(1).contains("&8") || sign.getLine(1).contains("&9")
					|| sign.getLine(1).contains("&0") || sign.getLine(1).contains("&a")
					|| sign.getLine(1).contains("&b") || sign.getLine(1).contains("&c")
					|| sign.getLine(1).contains("&d") || sign.getLine(1).contains("&e")
					|| sign.getLine(1).contains("&f") || sign.getLine(1).contains("&o")
					|| sign.getLine(1).contains("&l") || sign.getLine(1).contains("&k")
					|| sign.getLine(1).contains("&n") || sign.getLine(1).contains("&m")
					|| sign.getLine(1).contains("&r")) {
				sign.setLine(1, sign.getLine(1).replace("&", "§"));
			}
			if (sign.getLine(2).contains("&1") || sign.getLine(2).contains("&2") || sign.getLine(2).contains("&3")
					|| sign.getLine(2).contains("&4") || sign.getLine(2).contains("&5")
					|| sign.getLine(2).contains("&6") || sign.getLine(2).contains("&7")
					|| sign.getLine(2).contains("&8") || sign.getLine(2).contains("&9")
					|| sign.getLine(2).contains("&0") || sign.getLine(2).contains("&a")
					|| sign.getLine(2).contains("&b") || sign.getLine(2).contains("&c")
					|| sign.getLine(2).contains("&d") || sign.getLine(2).contains("&e")
					|| sign.getLine(2).contains("&f") || sign.getLine(2).contains("&o")
					|| sign.getLine(2).contains("&l") || sign.getLine(2).contains("&k")
					|| sign.getLine(2).contains("&n") || sign.getLine(2).contains("&m")
					|| sign.getLine(2).contains("&r")) {
				sign.setLine(2, sign.getLine(2).replace("&", "§"));
			}
			if (sign.getLine(3).contains("&1") || sign.getLine(3).contains("&2") || sign.getLine(3).contains("&3")
					|| sign.getLine(3).contains("&4") || sign.getLine(3).contains("&5")
					|| sign.getLine(3).contains("&6") || sign.getLine(3).contains("&7")
					|| sign.getLine(3).contains("&8") || sign.getLine(3).contains("&9")
					|| sign.getLine(3).contains("&0") || sign.getLine(3).contains("&a")
					|| sign.getLine(3).contains("&b") || sign.getLine(3).contains("&c")
					|| sign.getLine(3).contains("&d") || sign.getLine(3).contains("&e")
					|| sign.getLine(3).contains("&f") || sign.getLine(3).contains("&o")
					|| sign.getLine(3).contains("&l") || sign.getLine(3).contains("&k")
					|| sign.getLine(3).contains("&n") || sign.getLine(3).contains("&m")
					|| sign.getLine(3).contains("&r")) {
				sign.setLine(3, sign.getLine(3).replace("&", "§"));
			}
		}
	}

	@EventHandler
	public void DropItems(final PlayerDeathEvent e) {
		e.setDeathMessage((String) null);
		e.setDroppedExp(0);
		e.getDrops().clear();
	}

	@EventHandler
	public void onSoup(final PlayerInteractEvent e) {
		final ItemStack pote = new ItemStack(Material.BOWL, 1);
		final ItemMeta kpote = pote.getItemMeta();
		kpote.setDisplayName(ChatColor.GRAY + "Pote");
		pote.setItemMeta(kpote);
		final Damageable hp;
		final Player p = (Player) (hp = (Damageable) e.getPlayer());
		if (hp.getHealth() != 20.0) {
			final int sopa = 7;
			if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
					&& p.getItemInHand().getTypeId() == 282) {
				p.setHealth((hp.getHealth() + sopa > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + sopa));
				p.getItemInHand().setType(Material.BOWL);
				p.getItemInHand().setItemMeta(kpote);
				p.getItemInHand().setType(Material.BOWL);
			}
		}
	}

	@EventHandler
	public void onItemDrop(final ItemSpawnEvent e) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				e.getEntity().remove();
				e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 10);
			}
		}, 20L);
	}

	@EventHandler
	public void onPlayerChatRank1(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		e.setFormat(String.valueOf(p.getDisplayName()) + " §e§l>§e§l> " + ChatColor.GRAY + e.getMessage());
	}

	@EventHandler
	public void onPlayer(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (!this.mecheu.contains(p.getName())
				&& e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.JUKEBOX) {
			final ItemStack cute1 = new ItemStack(Material.CHEST);
			final ItemStack cute2 = new ItemStack(Material.DIAMOND);
			final ItemStack cute3 = new ItemStack(Material.IRON_INGOT);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1.0f, 1.0f);
			p.getInventory().clear();
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().setItem(2, cute2);
			p.getInventory().setItem(4, cute1);
			p.getInventory().setItem(6, cute3);
			p.setGameMode(GameMode.ADVENTURE);
			p.sendMessage(
					" §l§6>> §eParabens Voc\u00ea Concluiu o N\u00edvel Facil do LavaChallenger e Por isso Recebeu §6100 §eCOINS !");
			p.teleport(p.getWorld().getSpawnLocation());
			Main.econ.depositPlayer(p.getName(), 100.0);
		}
	}

	@EventHandler
	public void onPlayer1(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (!this.mecheu.contains(p.getName())
				&& e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.LAPIS_BLOCK) {
			final ItemStack cute1 = new ItemStack(Material.CHEST);
			final ItemStack cute2 = new ItemStack(Material.DIAMOND);
			final ItemStack cute3 = new ItemStack(Material.IRON_INGOT);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1.0f, 1.0f);
			p.getInventory().clear();
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().setItem(2, cute2);
			p.getInventory().setItem(4, cute1);
			p.getInventory().setItem(6, cute3);
			p.teleport(p.getWorld().getSpawnLocation());
			p.setGameMode(GameMode.ADVENTURE);
			Main.econ.depositPlayer(p.getName(), 100.0);
			p.sendMessage(
					" §l§6>> §eParabens Voc\u00ea Concluiu o N\u00edvel Medio do LavaChallenger e Por isso Recebeu §6150 §eCOINS !");
		}
	}

	@EventHandler
	public void onPlayer11(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (!this.mecheu.contains(p.getName())
				&& e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.COAL_BLOCK) {
			final ItemStack cute1 = new ItemStack(Material.CHEST);
			final ItemStack cute2 = new ItemStack(Material.DIAMOND);
			final ItemStack cute3 = new ItemStack(Material.IRON_INGOT);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1.0f, 1.0f);
			p.getInventory().clear();
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().setItem(2, cute2);
			p.teleport(p.getWorld().getSpawnLocation());
			p.getInventory().setItem(4, cute1);
			p.getInventory().setItem(6, cute3);
			p.setGameMode(GameMode.ADVENTURE);
			Main.econ.depositPlayer(p.getName(), 200.0);
			p.sendMessage(
					" §l§6>> §eParabens Voc\u00ea Concluiu o N\u00edvel Dif\u00edcil do LavaChallenger e Por isso Recebeu §6200 §eCOINS !");
		}
	}

	@EventHandler
	public void onPlayer111(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (!this.mecheu.contains(p.getName())
				&& e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.QUARTZ_BLOCK) {
			final ItemStack cute1 = new ItemStack(Material.CHEST);
			final ItemStack cute2 = new ItemStack(Material.DIAMOND);
			final ItemStack cute3 = new ItemStack(Material.IRON_INGOT);
			p.getInventory().clear();
			p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1.0f, 1.0f);
			p.getInventory().clear();
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().setItem(2, cute2);
			p.teleport(p.getWorld().getSpawnLocation());
			p.getInventory().setItem(4, cute1);
			p.getInventory().setItem(6, cute3);
			p.setGameMode(GameMode.ADVENTURE);
			Main.econ.depositPlayer(p.getName(), 300.0);
			p.sendMessage(
					" §l§6>> §eParabens Voc\u00ea Concluiu o N\u00edvel Extreme do LavaChallenger e Por isso Recebeu §6300 §eCOINS + Kit ->");
			final Random random = new Random();
			final int i = random.nextInt(3);
			if (i == 0) {
				Main.perm.playerAdd(p, "kitxc.turtle");
				p.sendMessage("§6Turtle");
			}
			if (i == 1) {
				Main.perm.playerAdd(p, "kitxc.ninja");
				p.sendMessage("§6Ninja");
			}
			if (i == 2) {
				Main.perm.playerAdd(p, "kitxc.thor");
				p.sendMessage("§6Thor");
			}
		}
	}

	@EventHandler
	public void onPlayer1111(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (!this.mecheu.contains(p.getName())
				&& e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.DIAMOND_BLOCK) {
			p.setGameMode(GameMode.SURVIVAL);
			p.chat("/pvp");
		}
	}

	@EventHandler
	public void onInteractpyro(final PlayerInteractEvent event) {
		final Player player = event.getPlayer();
		final ItemStack item = event.getItem();
		if (event.getAction() == Action.RIGHT_CLICK_AIR && item != null && item.getType() == Material.FIREBALL) {
			item.setAmount(item.getAmount() - 1);
			if (item.getAmount() == 0) {
				event.getPlayer().setItemInHand(new ItemStack(0));
			}
			final Fireball ball = (Fireball) event.getPlayer().launchProjectile(Fireball.class);
			ball.setIsIncendiary(true);
			ball.setYield(ball.getYield() * 1.5f);
			final ItemStack item2 = new ItemStack(Material.FIREBALL);
			final ItemMeta itemmeta15 = item2.getItemMeta();
			itemmeta15.setDisplayName("§c Drag\u00e3o");
			item2.setItemMeta(itemmeta15);
			player.getInventory().setItem(1, item2);
		}
	}

	@EventHandler
	public void onPlayerDropItemKit1(final BlockPlaceEvent event) {
		final Block block = event.getBlockPlaced();
		if (block.getType().equals((Object) Material.FIREBALL)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onInteractpyro1(final PlayerInteractEvent event) {
		final Player player = event.getPlayer();
		final ItemStack item = event.getItem();
		if (event.getAction() == Action.LEFT_CLICK_AIR && item != null && item.getType() == Material.FIREBALL) {
			item.setAmount(item.getAmount() - 1);
			if (item.getAmount() == 0) {
				event.getPlayer().setItemInHand(new ItemStack(0));
			}
			final Snowball ball = (Snowball) event.getPlayer().launchProjectile(Snowball.class);
			ball.setFireTicks(100);
			ball.getWorld().playEffect(ball.getLocation(), Effect.MOBSPAWNER_FLAMES, 50, 50);
			ball.getWorld().playEffect(ball.getLocation(), Effect.MOBSPAWNER_FLAMES, 40, 40);
			ball.getWorld().playEffect(ball.getLocation(), Effect.MOBSPAWNER_FLAMES, 60, 60);
			ball.getWorld().playEffect(ball.getLocation(), Effect.MOBSPAWNER_FLAMES, 30, 30);
			player.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 300, 4));
			player.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300, 0));
			final ItemStack item2 = new ItemStack(Material.FIREBALL);
			final ItemMeta itemmeta15 = item2.getItemMeta();
			itemmeta15.setDisplayName("§c Drag\u00e3o");
			item2.setItemMeta(itemmeta15);
			player.getInventory().setItem(1, item2);
		}
	}
}
