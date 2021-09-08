package zEvents;

import java.util.Iterator;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.GameMode;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import zKits.Wither;
import zKits.Flyer;
import zKits.Tornado;
import zKits.Supernova;
import zKits.Firer;
import zKits.Ninja;
import zKits.DeshFire;
import zKits.Terrorista;
import zKits.Sonic;
import zKits.Arrays;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.Listener;

public class Respawn implements Listener
{
    @EventHandler
    public void Morrer(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        e.setDeathMessage((String)null);
        e.getDrops().clear();
        Arrays.removeAbility(p);
        Sonic.cooldownm.remove(p);
        Terrorista.cooldownm.remove(p);
        DeshFire.cooldownm.remove(p);
        Ninja.cooldownbk.remove(p);
        Firer.cooldownm.remove(p);
        Supernova.cooldownm.remove(p);
        Tornado.cooldownm.remove(p);
        Flyer.cooldownm.remove(p);
        Wither.cooldown.remove(p);
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
    public void onDeathPlayer(final PlayerRespawnEvent e) {
        final Player p = e.getPlayer();
        p.getInventory().clear();
        p.setExp(0.0f);
        p.setExhaustion(20.0f);
        p.setMaxHealth(20.0);
        p.setFoodLevel(20);
        p.setGameMode(GameMode.ADVENTURE);
        final ItemStack item12 = new ItemStack(Material.DIAMOND);
        final ItemMeta itemmeta12 = item12.getItemMeta();
        itemmeta12.setDisplayName("§a Warps");
        item12.setItemMeta(itemmeta12);
        p.getInventory().setItem(2, item12);
        final ItemStack item13 = new ItemStack(Material.CHEST);
        final ItemMeta itemmeta13 = item13.getItemMeta();
        itemmeta13.setDisplayName("§a Seletor de Kits");
        item13.setItemMeta(itemmeta13);
        p.getInventory().setItem(4, item13);
        final ItemStack item14 = new ItemStack(Material.IRON_INGOT);
        final ItemMeta itemmeta14 = item14.getItemMeta();
        itemmeta14.setDisplayName("§a Extras");
        item14.setItemMeta(itemmeta14);
        p.getInventory().setItem(6, item14);
        for (final PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
        p.teleport(p.getWorld().getSpawnLocation());
        p.getInventory().setArmorContents((ItemStack[])null);
    }
}
