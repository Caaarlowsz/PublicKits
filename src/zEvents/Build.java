package zEvents;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.Listener;

public class Build implements Listener
{
    @EventHandler
    public void Break(final BlockBreakEvent e) {
        final Player p = e.getPlayer();
        if (Holograms.Build.contains(p)) {
            e.setCancelled(false);
            return;
        }
        e.setCancelled(true);
    }
    
    @EventHandler
    public void Place(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        if (Holograms.Build.contains(p)) {
            e.setCancelled(false);
            return;
        }
        e.setCancelled(true);
    }
}
