package zEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.Listener;

public class Drop implements Listener
{
    @EventHandler
    public void onDrop1(final PlayerDropItemEvent e) {
        if (e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD) {
            e.setCancelled(true);
            e.getPlayer();
        }
    }
}
