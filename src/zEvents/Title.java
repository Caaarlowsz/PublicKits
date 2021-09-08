package zEvents;

import org.bukkit.event.EventHandler;
import net.minecraft.server.v1_7_R4.IChatBaseComponent;
import net.minecraft.server.v1_7_R4.PlayerConnection;
import org.bukkit.entity.Player;
import net.minecraft.server.v1_7_R4.Packet;
import org.spigotmc.ProtocolInjector;
import net.minecraft.server.v1_7_R4.ChatSerializer;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

public class Title implements Listener
{
    private static int VERSION;
    
    static {
        Title.VERSION = 47;
    }
    
    @EventHandler
    public void onPlayerConnect(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        final PlayerConnection connect = ((CraftPlayer)p).getHandle().playerConnection;
        final IChatBaseComponent top = ChatSerializer.a("{'extra': [{text: ' §7- §6Servidor de KitPvP §61.8§b!', color: 'aqua'}],'color': gold, 'text': 'Divirta-se'}");
        final IChatBaseComponent bottom = ChatSerializer.a("{'extra': [{'color': 'aqua', 'text': 'Compre Vip e Ajude o Server', 'underline': 'true'}], 'color': 'gold', 'text': 'Visite nossa Loja e '}");
        if (((CraftPlayer)p).getHandle().playerConnection.networkManager.getVersion() < Title.VERSION) {
            return;
        }
        connect.sendPacket((Packet)new ProtocolInjector.PacketTabHeader(top, bottom));
    }
}
