package zKits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import me.confuser.barapi.BarAPI;
import zEvents.Tab;

public class Fisherman implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
		final Player p = (Player) sender;
		if (cmd.getLabel().equalsIgnoreCase("fisherman")) {
			if (!p.hasPermission("kitxc.fisherman")) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
				return true;
			}
			if (Arrays.used.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
				return true;
			}
			Arrays.used.add(p.getName());
			Arrays.pulo.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit §6 >> " + ChatColor.GRAY + " Fisherman");
			Tab.sendTitle(p, "§cFisherman");
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.FISHING_ROD) });
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lFisherman", 10);
			KitsManager.darSopas(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerFish(final PlayerFishEvent event) {
		final Entity caught = event.getCaught();
		final Block block = event.getHook().getLocation().getBlock();
		if (caught != null && caught != block) {
			caught.teleport(event.getPlayer().getLocation());
		}
	}
}
