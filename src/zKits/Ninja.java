package zKits;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;

import me.confuser.barapi.BarAPI;
import zEvents.Tab;
import zPublic.Main;

public class Ninja implements Listener, CommandExecutor {
	public static HashMap<Player, Player> a;
	public static HashMap<Player, Long> b;
	public static List<Player> cooldownbk;
	public static Main plugin;
	private Main main;

	static {
		Ninja.a = new HashMap<Player, Player>();
		Ninja.b = new HashMap<Player, Long>();
		Ninja.cooldownbk = new ArrayList<Player>();
	}

	public Ninja() {
		Ninja.plugin = this.main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("ninja")) {
			if (!Arrays.used.contains(p.getName())) {
				if (p.hasPermission("kitxc.ninja")) {
					p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Ninja");
					Tab.sendTitle(p, "§cNinja");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
					Arrays.used.add(p.getName());
					Arrays.ninja.add(sender.getName());
					p.getInventory().clear();
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
					BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lNinja", 10);
					KitsManager.darSopas(p);
				} else {
					p.sendMessage(ChatColor.RED + "Sem permiss\u00e3o");
				}
			} else {
				p.sendMessage(ChatColor.RED + "Um kit por vida");
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void a(final EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
		if (paramEntityDamageByEntityEvent.getDamager() instanceof Player
				&& paramEntityDamageByEntityEvent.getEntity() instanceof Player) {
			final Player localPlayer1 = (Player) paramEntityDamageByEntityEvent.getDamager();
			final Player localPlayer2 = (Player) paramEntityDamageByEntityEvent.getEntity();
			if (Arrays.ninja.contains(localPlayer1.getName())) {
				Ninja.a.put(localPlayer1, localPlayer2);
			}
		}
	}

	@EventHandler
	public void a(final PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
		final Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
		if (paramPlayerToggleSneakEvent.isSneaking() && Arrays.ninja.contains(localPlayer1.getName())
				&& Ninja.a.containsKey(localPlayer1)) {
			final Player localPlayer2 = Ninja.a.get(localPlayer1);
			if (localPlayer2 != null && !localPlayer2.isDead()) {
				String str = null;
				if (Ninja.b.get(localPlayer1) != null) {
					final long l = Ninja.b.get(localPlayer1) - System.currentTimeMillis();
					final DecimalFormat localDecimalFormat = new DecimalFormat("##");
					final int i = (int) l / 1000;
					str = localDecimalFormat.format(i);
				}
				if (Ninja.b.get(localPlayer1) == null || Ninja.b.get(localPlayer1) < System.currentTimeMillis()) {
					if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0) {
						localPlayer1.teleport(localPlayer2.getLocation());
						Ninja.b.put(localPlayer1, System.currentTimeMillis() + 10000L);
					} else {
						localPlayer1.sendMessage(ChatColor.RED + "O Ultimo jogador hitado esta muito longe!");
					}
				} else {
					localPlayer1.sendMessage(
							String.valueOf(Main.getPlugin().getConfig().getString("server").replace("&", "§"))
									+ " §eKit em Cooldown §f> §6" + str + " segundos!");
				}
			}
		}
	}
}
