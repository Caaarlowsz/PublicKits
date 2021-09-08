package zKits;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class KitsManager implements Listener
{
    public static void darSopas(final Player p) {
        for (int x = 0; x < 35; ++x) {
            final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
            final ItemMeta sopameta = sopa.getItemMeta();
            sopameta.setDisplayName("§3 + 3,5  §4\u2764");
            sopa.setItemMeta(sopameta);
            p.getInventory().addItem(new ItemStack[] { new ItemStack(sopa) });
        }
    }
}
