package zKits;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;
import zEvents.Tab;
import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class Mago implements CommandExecutor, Listener {
	public static ArrayList<Player> cooldownm;

	static {
		Mago.cooldownm = new ArrayList<Player>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] arg3) {
		final Player p = (Player) sender;
		if (cmd.getLabel().equalsIgnoreCase("mago")) {
			if (!p.hasPermission("kitxc.mago")) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea n\u00e3o Possui este Kit");
				return true;
			}
			if (Arrays.used.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Voc\u00ea ja esta Utilizando um Kit");
				return true;
			}
			Arrays.used.add(p.getName());
			Arrays.ironman.add(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.WHITE + "Voc\u00ea Escolheu o Kit �6 >> " + ChatColor.GRAY + " Mago");
			BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lMago", 10);
			Tab.sendTitle(p, "�cMago");
			final ItemStack bow = new ItemStack(Material.STONE_SWORD);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("�9Espada de Pedra");
			bow.setItemMeta(bowmeta);
			p.getInventory().setItem(0, bow);
			final ItemStack nova = new ItemStack(Material.POTION);
			final ItemMeta novameta = nova.getItemMeta();
			novameta.setDisplayName("�a Efeito Random");
			nova.setItemMeta(novameta);
			p.getInventory().setItem(1, nova);
			KitsManager.darSopas(p);
		}
		return false;
	}

	@EventHandler
	public void interact(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& Arrays.ironman.contains(p.getName()) && p.getItemInHand().getType() == Material.POTION) {
			e.setCancelled(true);
			p.updateInventory();
			if (Mago.cooldownm.contains(p)) {
				p.sendMessage("�6>> �eKit em Cooldown!");
				return;
			}
			final Random random = new Random();
			final int i = random.nextInt(5);
			if (i == 0) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 300, 0));
				p.sendMessage("�7Voce recebeu o efeito �aFor\u00e7a");
			}
			if (i == 1) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 300, 0));
				p.sendMessage("�7Voce recebeu o efeito �aFraqueza");
			}
			if (i == 2) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 0));
				p.sendMessage("�7Voce recebeu o efeito �aCegueira");
			}
			if (i == 3) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 0));
				p.sendMessage("�7Voce recebeu o efeito �aVelocidade");
			}
			if (i == 3) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300, 0));
				p.sendMessage("�7Voce recebeu o efeito �aRegenera\u00e7\u00e3o");
			}
			if (i == 4) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 300, 0));
				p.sendMessage("�7Voce recebeu o efeito �aVeneno");
			}
			Mago.cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(PublicPvP.getPlugin(), (Runnable) new Runnable() {
				@Override
				public void run() {
					Mago.cooldownm.remove(p);
					p.sendMessage("�6>> �eVoce pode usar novamente!");
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
					p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
				}
			}, 600L);
		}
	}
}
