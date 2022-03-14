package zEvents;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.spigotmc.ProtocolInjector;

import net.minecraft.server.v1_7_R4.ChatSerializer;
import net.minecraft.server.v1_7_R4.Packet;
import com.github.caaarlowsz.publicmc.kitpvp.PublicPvP;

public class Tab implements Listener, CommandExecutor {
	private static int VERSION;

	static {
		Tab.VERSION = 47;
	}

	@EventHandler
	public boolean onPlayerConnect(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		sendTitle(p, new StringBuilder().append(PublicPvP.getPlugin().getConfig().getString("server").replace("&", "�"))
				.toString());
		sendSubTitle(p, "�f�lDivirta-se ");
		return false;
	}

	public static void sendTitle(final Player p, final String title) {
		if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < Tab.VERSION) {
			return;
		}
		((CraftPlayer) p).getHandle().playerConnection
				.sendPacket((Packet) new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.TITLE,
						ChatSerializer.a("{\"text\": \"\"}").a(title)));
	}

	public static void sendSubTitle(final Player p, final String subtitle) {
		if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < Tab.VERSION) {
			return;
		}
		((CraftPlayer) p).getHandle().playerConnection
				.sendPacket((Packet) new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.SUBTITLE,
						ChatSerializer.a("{\"text\": \"\"}").a(subtitle)));
	}

	public static void sendTimings(final Player p, final int fadeIn, final int stay, final int fadeOut) {
		if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < Tab.VERSION) {
			return;
		}
		try {
			final Object handle = getHandle(p);
			final Object connection = getField(handle.getClass(), "playerConnection").get(handle);
			final Object packet = ProtocolInjector.PacketTitle.class
					.getConstructor(ProtocolInjector.PacketTitle.Action.class, Integer.TYPE, Integer.TYPE, Integer.TYPE)
					.newInstance(ProtocolInjector.PacketTitle.Action.TIMES, fadeIn, stay, fadeOut);
			getMethod(connection.getClass(), "sendPacket", new Class[0]).invoke(connection, packet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean ClassListEqual(final Class<?>[] l1, final Class<?>[] l2) {
		boolean equal = true;
		if (l1.length != l2.length) {
			return false;
		}
		for (int i = 0; i < l1.length; ++i) {
			if (l1[i] != l2[i]) {
				equal = false;
				break;
			}
		}
		return equal;
	}

	private static Field getField(final Class<?> clazz, final String name) {
		try {
			final Field field = clazz.getDeclaredField(name);
			field.setAccessible(true);
			return field;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static Method getMethod(final Class<?> clazz, final String name, final Class<?>[] args) {
		Method[] methods;
		for (int length = (methods = clazz.getMethods()).length, i = 0; i < length; ++i) {
			final Method m = methods[i];
			if (m.getName().equals(name) && (args.length == 0 || ClassListEqual(args, m.getParameterTypes()))) {
				m.setAccessible(true);
				return m;
			}
		}
		return null;
	}

	private static Object getHandle(final Object obj) {
		try {
			return getMethod(obj.getClass(), "getHandle", new Class[0]).invoke(obj, new Object[0]);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void reset(final Player p) {
		if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < Tab.VERSION) {
			return;
		}
		((CraftPlayer) p).getHandle().playerConnection
				.sendPacket((Packet) new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.RESET));
	}

	public static void clear(final Player p) {
		if (((CraftPlayer) p).getHandle().playerConnection.networkManager.getVersion() < Tab.VERSION) {
			return;
		}
		((CraftPlayer) p).getHandle().playerConnection
				.sendPacket((Packet) new ProtocolInjector.PacketTitle(ProtocolInjector.PacketTitle.Action.CLEAR));
	}

	public boolean onCommand(final CommandSender arg0, final Command arg1, final String arg2, final String[] arg3) {
		return false;
	}
}
