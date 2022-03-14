package zEvents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class Tag implements CommandExecutor, Listener {
	public static String normal;
	public static String vip;
	public static String mvp;
	public static String pro;
	public static String yt;
	public static String mod;
	public static String modplus;
	public static String admin;
	public static String dono;
	public static String msg;

	static {
		Tag.normal = "�7";
		Tag.vip = "�a";
		Tag.mvp = "�9";
		Tag.pro = "�6";
		Tag.yt = "�b";
		Tag.mod = "�5";
		Tag.modplus = String.valueOf(Tag.mod) + "�o";
		Tag.admin = "�c";
		Tag.dono = "�4�o";
		Tag.msg = "�aVoc\u00ea est\u00e1 usando a tag: %s";
	}

	public static String getShortStr(final String name) {
		if (name.length() == 16) {
			final String shorts = name.substring(0, name.length() - 4);
			return shorts;
		}
		if (name.length() == 15) {
			final String shorts = name.substring(0, name.length() - 3);
			return shorts;
		}
		if (name.length() == 14) {
			final String shorts = name.substring(0, name.length() - 2);
			return shorts;
		}
		if (name.length() == 13) {
			final String shorts = name.substring(0, name.length() - 1);
			return shorts;
		}
		return name;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Commando para jogadores!");
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("tag")) {
			if (args.length > 0 && p.hasPermission("tag.dono")) {
				if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
					p.sendMessage(Tag.msg.replace("%s", "�7Normal"));
					p.setPlayerListName(
							String.valueOf(Tag.normal) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.normal) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("lifetime")) {
					p.sendMessage(Tag.msg.replace("%s", "�6�oLIFEITME"));
					p.setPlayerListName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("pro")) {
					p.sendMessage(Tag.msg.replace("%s", "�6PRO"));
					p.setPlayerListName(
							String.valueOf(Tag.pro) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.pro) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("modplus")) {
					p.sendMessage(Tag.msg.replace("%s", "�5�oMOD PLUS"));
					p.setPlayerListName(String.valueOf(Tag.mod) + ChatColor.ITALIC.toString()
							+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.modplus) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("admin")) {
					p.sendMessage(Tag.msg.replace("%s", "�cADMIN"));
					p.setPlayerListName(
							String.valueOf(Tag.admin) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.admin) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("youtuber")) {
					p.sendMessage(Tag.msg.replace("%s", "�bYouTuber"));
					p.setPlayerListName(String.valueOf(Tag.yt) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.yt) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("mod")) {
					p.sendMessage(Tag.msg.replace("%s", "�5MOD"));
					p.setPlayerListName(
							String.valueOf(Tag.mod) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.mod) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("adminplus")) {
					p.sendMessage(Tag.msg.replace("%s", "�c�oADMIN PLUS"));
					p.setPlayerListName(ChatColor.RED + ChatColor.ITALIC.toString()
							+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(ChatColor.RED + ChatColor.ITALIC.toString()
							+ ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("dono")) {
					p.sendMessage(Tag.msg.replace("%s", "�4�oDONO"));
					p.setPlayerListName(
							String.valueOf(Tag.dono) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.dono) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else {
					p.sendMessage(String.valueOf(Tag.admin)
							+ "Use: (Normal | Pro | Lifetime | Youtuber | Mod | ModPlus | Admin | AdminPlus | Dono)");
				}
			} else if (args.length > 0 && p.hasPermission("tag.admin")) {
				if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
					p.sendMessage(Tag.msg.replace("%s", "�7Normal"));
					p.setPlayerListName(
							String.valueOf(Tag.normal) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.normal) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("lifetime")) {
					p.sendMessage(Tag.msg.replace("%s", "�6�oLIFEITME"));
					p.setPlayerListName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("pro")) {
					p.sendMessage(Tag.msg.replace("%s", "�6PRO"));
					p.setPlayerListName(
							String.valueOf(Tag.pro) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.pro) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("modplus")) {
					p.sendMessage(Tag.msg.replace("%s", "�5�oMOD PLUS"));
					p.setPlayerListName(String.valueOf(Tag.mod) + ChatColor.ITALIC.toString()
							+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.modplus) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("admin")) {
					p.sendMessage(Tag.msg.replace("%s", "�cADMIN"));
					p.setPlayerListName(
							String.valueOf(Tag.admin) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.admin) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("youtuber")) {
					p.sendMessage(Tag.msg.replace("%s", "�bYouTuber"));
					p.setPlayerListName(String.valueOf(Tag.yt) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.yt) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("mod")) {
					p.sendMessage(Tag.msg.replace("%s", "�5MOD"));
					p.setPlayerListName(
							String.valueOf(Tag.mod) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.mod) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else {
					p.sendMessage(String.valueOf(Tag.admin)
							+ "Use: (Normal | Pro | Lifetime | Youtuber | Mod | ModPlus | Admin)");
				}
			} else if (args.length > 0 && p.hasPermission("tag.adminplus")) {
				if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
					p.sendMessage(Tag.msg.replace("%s", "�7Normal"));
					p.setPlayerListName(
							String.valueOf(Tag.normal) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.normal) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("lifetime")) {
					p.sendMessage(Tag.msg.replace("%s", "�6�oLIFEITME"));
					p.setPlayerListName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("pro")) {
					p.sendMessage(Tag.msg.replace("%s", "�6PRO"));
					p.setPlayerListName(
							String.valueOf(Tag.pro) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.pro) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("modplus")) {
					p.sendMessage(Tag.msg.replace("%s", "�5�oMOD PLUS"));
					p.setPlayerListName(String.valueOf(Tag.mod) + ChatColor.ITALIC.toString()
							+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.modplus) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("admin")) {
					p.sendMessage(Tag.msg.replace("%s", "�cADMIN"));
					p.setPlayerListName(
							String.valueOf(Tag.admin) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.admin) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("adminplus")) {
					p.sendMessage(Tag.msg.replace("%s", "�c�oADMINPLUS"));
					p.setPlayerListName(ChatColor.RED + ChatColor.ITALIC.toString()
							+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(ChatColor.RED + ChatColor.ITALIC.toString()
							+ ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("youtuber")) {
					p.sendMessage(Tag.msg.replace("%s", "�bYouTuber"));
					p.setPlayerListName(String.valueOf(Tag.yt) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.yt) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("mod")) {
					p.sendMessage(Tag.msg.replace("%s", "�5MOD"));
					p.setPlayerListName(
							String.valueOf(Tag.mod) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.mod) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else {
					p.sendMessage(String.valueOf(Tag.admin)
							+ "Use: (Normal | Pro | Lifetime | Youtuber | Mod | ModPlus | Admin | AdminPlus)");
				}
			} else if (args.length > 0 && p.hasPermission("tag.mod")) {
				if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
					p.sendMessage(Tag.msg.replace("%s", "�7Normal"));
					p.setPlayerListName(
							String.valueOf(Tag.normal) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.normal) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("lifetime")) {
					p.sendMessage(Tag.msg.replace("%s", "�6�oLIFEITME"));
					p.setPlayerListName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("pro")) {
					p.sendMessage(Tag.msg.replace("%s", "PRO"));
					p.setPlayerListName(
							String.valueOf(Tag.pro) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.pro) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("mod")) {
					p.sendMessage(Tag.msg.replace("%s", "�5MOD"));
					p.setPlayerListName(
							String.valueOf(Tag.mod) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(String.valueOf(Tag.mod.toString()) + ChatColor.stripColor(p.getDisplayName())
							+ ChatColor.RESET);
				} else {
					p.sendMessage(
							String.valueOf(Tag.admin) + "Use: (Normal | Pro | Lifetime | Youtuber | Trial | Mod)");
				}
			} else if (args.length > 0 && p.hasPermission("tag.modplus")) {
				if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
					p.sendMessage(Tag.msg.replace("%s", "�7Normal"));
					p.setPlayerListName(
							String.valueOf(Tag.normal) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.normal) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("lifetime")) {
					p.sendMessage(Tag.msg.replace("%s", "�6�oLIFEITME"));
					p.setPlayerListName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("pro")) {
					p.sendMessage(Tag.msg.replace("%s", "PRO"));
					p.setPlayerListName(
							String.valueOf(Tag.pro) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.pro) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("mod")) {
					p.sendMessage(Tag.msg.replace("%s", "�5MOD"));
					p.setPlayerListName(
							String.valueOf(Tag.mod) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(String.valueOf(Tag.mod.toString()) + ChatColor.stripColor(p.getDisplayName())
							+ ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("modplus")) {
					p.sendMessage(Tag.msg.replace("%s", "�5�oMOD PLUS"));
					p.setPlayerListName(String.valueOf(Tag.mod) + ChatColor.ITALIC.toString()
							+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.modplus) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else {
					p.sendMessage(String.valueOf(Tag.admin)
							+ "Use: (Normal | Pro | Lifetime | Youtuber | Trial | Mod | ModPlus)");
				}
			} else if (args.length > 0 && p.hasPermission("tag.youtuber")) {
				if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
					p.sendMessage(Tag.msg.replace("%s", "�7Normal"));
					p.setPlayerListName(
							String.valueOf(Tag.normal) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.normal) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("pro")) {
					p.sendMessage(Tag.msg.replace("%s", "�6PRO"));
					p.setPlayerListName(
							String.valueOf(Tag.pro) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.pro) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("lifetime")) {
					p.sendMessage(Tag.msg.replace("%s", "�6�oLIFEITME"));
					p.setPlayerListName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("youtuber")) {
					p.sendMessage(Tag.msg.replace("%s", "�bYouTuber"));
					p.setPlayerListName(String.valueOf(Tag.yt) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.yt) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else {
					p.sendMessage(String.valueOf(Tag.admin) + "Use: (Normal | Pro | Lifetime | Youtuber)");
				}
			} else if (args.length > 0 && p.hasPermission("tag.lifetime")) {
				if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
					p.sendMessage(Tag.msg.replace("%s", "�7Normal"));
					p.setPlayerListName(
							String.valueOf(Tag.normal) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.normal) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("pro")) {
					p.sendMessage(Tag.msg.replace("%s", "�6PRO"));
					p.setPlayerListName(
							String.valueOf(Tag.pro) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.pro) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("lifetime")) {
					p.sendMessage(Tag.msg.replace("%s", "�6�oLIFEITME"));
					p.setPlayerListName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(ChatColor.GOLD + ChatColor.ITALIC.toString()
							+ ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else {
					p.sendMessage(String.valueOf(Tag.admin) + "Use: (Normal | Pro | Lifetime)");
				}
			} else if (args.length > 0 && p.hasPermission("tag.pro")) {
				if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
					p.sendMessage(Tag.msg.replace("%s", "�7Normal"));
					p.setPlayerListName(
							String.valueOf(Tag.normal) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.normal) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else if (args[0].toLowerCase().equalsIgnoreCase("pro")) {
					p.sendMessage(Tag.msg.replace("%s", "PRO"));
					p.setPlayerListName(
							String.valueOf(Tag.pro) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
					p.setDisplayName(
							String.valueOf(Tag.pro) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
				} else {
					p.sendMessage(String.valueOf(Tag.admin) + "Use: (Normal | Pro)");
				}
			} else if (args.length > 0 && args[0].toLowerCase().equalsIgnoreCase("normal")) {
				p.sendMessage(Tag.msg.replace("%s", "�7Normal"));
				p.setPlayerListName(String.valueOf(Tag.normal) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
				p.setDisplayName(
						String.valueOf(Tag.normal) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
			} else if (p.hasPermission("tag.dono")) {
				p.sendMessage(String.valueOf(Tag.admin)
						+ "Use: (Normal | Pro | Lifetime | Youtuber | Trial | Mod | ModPlus | Admin | AdminPlus | Dono)");
			} else if (p.hasPermission("tag.adminplus")) {
				p.sendMessage(String.valueOf(Tag.admin)
						+ "Use: (Normal | Pro | Lifetime | Youtuber | Trial | Mod | ModPlus | Admin | AdminPlus)");
			} else if (p.hasPermission("tag.admin")) {
				p.sendMessage(String.valueOf(Tag.admin)
						+ "Use: (Normal | Pro | Lifetime | Youtuber | Trial | Mod | ModPlus | Admin)");
			} else if (p.hasPermission("tag.mod")) {
				p.sendMessage(String.valueOf(Tag.admin) + "Use: (Normal | Pro | Lifetime | Youtuber | Trial | Mod)");
			} else if (p.hasPermission("tag.modplus")) {
				p.sendMessage(String.valueOf(Tag.admin)
						+ "Use: (Normal | Pro | Lifetime | Youtuber | Trial | Mod | ModPlus)");
			} else if (p.hasPermission("tag.trial")) {
				p.sendMessage(String.valueOf(Tag.admin) + "Use: (Normal | Pro | Lifetime | Youtuber | Trial)");
			} else if (p.hasPermission("tag.youtuber")) {
				p.sendMessage(String.valueOf(Tag.admin) + "Use: (Normal | Pro | Lifetime | Youtuber)");
			} else if (p.hasPermission("tag.lifetime")) {
				p.sendMessage(String.valueOf(Tag.admin) + "Use: (Normal | Pro | Lifetime)");
			} else if (p.hasPermission("tag.pro")) {
				p.sendMessage(String.valueOf(Tag.admin) + "Use: (Normal | Pro)");
			} else {
				p.sendMessage(String.valueOf(Tag.admin) + "Use: (Normal)");
			}
			return true;
		}
		return false;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(final PlayerJoinEvent event) {
		final Player p = event.getPlayer();
		Bukkit.getScheduler().scheduleAsyncDelayedTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
			@Override
			public void run() {
				Tag.setTag(p);
			}
		}, 5L);
	}

	public static void setTag(final Player p) {
		if (p.hasPermission("tag.dono")) {
			p.setPlayerListName(String.valueOf(Tag.dono) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
			p.setDisplayName(String.valueOf(Tag.dono) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
		} else if (p.hasPermission("tag.adminplus")) {
			p.setPlayerListName(ChatColor.RED + ChatColor.ITALIC.toString()
					+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
			p.setDisplayName(ChatColor.RED + ChatColor.ITALIC.toString() + ChatColor.stripColor(p.getDisplayName())
					+ ChatColor.RESET);
		} else if (p.hasPermission("tag.admin")) {
			p.setPlayerListName(String.valueOf(Tag.admin) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
			p.setDisplayName(String.valueOf(Tag.admin) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
		} else if (p.hasPermission("tag.trial")) {
			p.setPlayerListName(ChatColor.LIGHT_PURPLE + getShortStr(ChatColor.stripColor(p.getDisplayName())));
			p.setDisplayName(ChatColor.LIGHT_PURPLE + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
		} else if (p.hasPermission("tag.youtuber")) {
			p.setPlayerListName(String.valueOf(Tag.yt) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
			p.setDisplayName(String.valueOf(Tag.yt) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
		} else if (p.hasPermission("tag.modplus")) {
			p.setPlayerListName(String.valueOf(Tag.modplus) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
			p.setDisplayName(String.valueOf(Tag.modplus) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
		} else if (p.hasPermission("tag.mod")) {
			p.setPlayerListName(String.valueOf(Tag.mod) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
			p.setDisplayName(String.valueOf(Tag.mod) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
		} else if (p.hasPermission("tag.pro")) {
			p.setPlayerListName(String.valueOf(Tag.pro) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
			p.setDisplayName(String.valueOf(Tag.pro) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
		} else if (p.hasPermission("tag.lifetime")) {
			p.setPlayerListName(ChatColor.GOLD + ChatColor.ITALIC.toString()
					+ getShortStr(ChatColor.stripColor(p.getDisplayName())));
			p.setDisplayName(ChatColor.GOLD + ChatColor.ITALIC.toString() + ChatColor.stripColor(p.getDisplayName())
					+ ChatColor.RESET);
		} else {
			p.setPlayerListName(String.valueOf(Tag.normal) + getShortStr(ChatColor.stripColor(p.getDisplayName())));
			p.setDisplayName(String.valueOf(Tag.normal) + ChatColor.stripColor(p.getDisplayName()) + ChatColor.RESET);
		}
	}
}
