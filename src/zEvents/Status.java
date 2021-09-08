package zEvents;

import org.bukkit.OfflinePlayer;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import zPublic.Main;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

public class Status implements Listener
{
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        if (Main.getPlugin().getConfig().get("status." + p.getName().toLowerCase() + ".kills") == null) {
            Main.getPlugin().getConfig().set("status." + p.getName().toLowerCase() + ".kills", (Object)0);
        }
        if (Main.getPlugin().getConfig().get("status." + p.getName().toLowerCase() + ".mortes") == null) {
            Main.getPlugin().getConfig().set("status." + p.getName().toLowerCase() + ".mortes", (Object)0);
        }
        Main.getPlugin().saveConfig();
    }
    
    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        final Player k = p.getKiller();
        if (!(p instanceof Player)) {
            return;
        }
        if (!(k instanceof Player)) {
            return;
        }
        k.sendMessage("§6>> §e Voc\u00ea Eliminou o Player " + p.getName());
        k.sendMessage("§6>> §e + 75 COINS ");
        k.sendMessage("§6>> §e + 2 LEVEL ");
        Main.cash.put((OfflinePlayer)k, Main.cash.get(k) + 2);
        Main.econ.depositPlayer(k.getName(), 75.0);
        p.sendMessage("§6>> §eVoce morreu eliminado por " + k.getName());
        p.sendMessage("§6>> §e - 20 COINS ");
        p.sendMessage("§6>> §e - 1 LEVEL ");
        Main.cash.put((OfflinePlayer)p, (Main.cash.get(p) < 0) ? 0 : (Main.cash.get(p) - 0));
        Main.cash.put((OfflinePlayer)p, Main.cash.get(p) - 1);
        Main.econ.withdrawPlayer(p.getName(), 20.0);
        if (!(k instanceof Player)) {
            e.setDeathMessage("§6>> §cVoce morreu!");
        }
        final int kills = Main.getPlugin().getConfig().getInt("status." + k.getName().toLowerCase() + ".kills");
        Main.getPlugin().getConfig().set("status." + k.getName().toLowerCase() + ".kills", (Object)(kills + 1));
        final int mortes = Main.getPlugin().getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes");
        Main.getPlugin().getConfig().set("status." + p.getName().toLowerCase() + ".mortes", (Object)(mortes + 1));
        Main.getPlugin().saveConfig();
    }
}
