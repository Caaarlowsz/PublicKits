package zKits;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

public class Arrays implements Listener {
	public static ArrayList<String> used;
	public static ArrayList<String> gelo;
	public static ArrayList<String> urano;
	public static ArrayList<String> uran;
	public static ArrayList<String> pvp;
	public static ArrayList<String> pulo;
	public static ArrayList<String> viper;
	public static ArrayList<String> snail;
	public static ArrayList<String> critical;
	public static ArrayList<String> viking;
	public static ArrayList<String> regenerator;
	public static ArrayList<String> urgal;
	public static ArrayList<String> stomper;
	public static ArrayList<String> reaper;
	public static ArrayList<String> magma;
	public static ArrayList<String> camel;
	public static ArrayList<String> barbarian;
	public static ArrayList<String> resouper;
	public static ArrayList<String> turtle;
	public static ArrayList<String> thor;
	public static ArrayList<String> kangaroo;
	public static ArrayList<String> poseidon;
	public static ArrayList<String> ninja;
	public static ArrayList<String> endermage;
	public static ArrayList<String> DeshFire;
	public static ArrayList<String> sonic;
	public static ArrayList<String> terrorista;
	public static ArrayList<String> rabbit;
	public static ArrayList<String> teste;
	public static ArrayList<String> chestplater;
	public static ArrayList<String> troll;
	public static ArrayList<String> ironman;
	public static ArrayList<String> kriptonita;
	public static ArrayList<String> kiwwi;
	public static ArrayList<String> desh;
	public static ArrayList<String> shadow;
	public static ArrayList<String> avatar;
	public static Plugin plugin;
	public static Object admin;

	static {
		Arrays.used = new ArrayList<String>();
		Arrays.gelo = new ArrayList<String>();
		Arrays.urano = new ArrayList<String>();
		Arrays.uran = new ArrayList<String>();
		Arrays.pvp = new ArrayList<String>();
		Arrays.pulo = new ArrayList<String>();
		Arrays.viper = new ArrayList<String>();
		Arrays.snail = new ArrayList<String>();
		Arrays.critical = new ArrayList<String>();
		Arrays.viking = new ArrayList<String>();
		Arrays.regenerator = new ArrayList<String>();
		Arrays.urgal = new ArrayList<String>();
		Arrays.stomper = new ArrayList<String>();
		Arrays.reaper = new ArrayList<String>();
		Arrays.magma = new ArrayList<String>();
		Arrays.camel = new ArrayList<String>();
		Arrays.barbarian = new ArrayList<String>();
		Arrays.resouper = new ArrayList<String>();
		Arrays.turtle = new ArrayList<String>();
		Arrays.thor = new ArrayList<String>();
		Arrays.kangaroo = new ArrayList<String>();
		Arrays.poseidon = new ArrayList<String>();
		Arrays.ninja = new ArrayList<String>();
		Arrays.endermage = new ArrayList<String>();
		Arrays.DeshFire = new ArrayList<String>();
		Arrays.sonic = new ArrayList<String>();
		Arrays.terrorista = new ArrayList<String>();
		Arrays.rabbit = new ArrayList<String>();
		Arrays.teste = new ArrayList<String>();
		Arrays.chestplater = new ArrayList<String>();
		Arrays.troll = new ArrayList<String>();
		Arrays.ironman = new ArrayList<String>();
		Arrays.kriptonita = new ArrayList<String>();
		Arrays.kiwwi = new ArrayList<String>();
		Arrays.desh = new ArrayList<String>();
		Arrays.shadow = new ArrayList<String>();
		Arrays.avatar = new ArrayList<String>();
	}

	public static void remov(final Player p) {
		Arrays.used.remove(p.getName());
		Arrays.urano.remove(p.getName());
		Arrays.uran.remove(p.getName());
		Arrays.pvp.remove(p.getName());
		Arrays.gelo.remove(p.getName());
		Arrays.pulo.remove(p.getName());
		Arrays.viper.remove(p.getName());
		Arrays.snail.remove(p.getName());
		Arrays.critical.remove(p.getName());
		Arrays.viking.remove(p.getName());
		Arrays.regenerator.remove(p.getName());
		Arrays.urgal.remove(p.getName());
		Arrays.stomper.remove(p.getName());
		Arrays.reaper.remove(p.getName());
		Arrays.magma.remove(p.getName());
		Arrays.camel.remove(p.getName());
		Arrays.barbarian.remove(p.getName());
		Arrays.resouper.remove(p.getName());
		Arrays.turtle.remove(p.getName());
		Arrays.thor.remove(p.getName());
		Arrays.kangaroo.remove(p.getName());
		Arrays.poseidon.remove(p.getName());
		Arrays.ninja.remove(p.getName());
		Arrays.endermage.remove(p.getName());
		Arrays.DeshFire.remove(p.getName());
		Arrays.sonic.remove(p.getName());
		Arrays.terrorista.remove(p.getName());
		Arrays.rabbit.remove(p.getName());
		Arrays.teste.remove(p.getName());
		Arrays.chestplater.remove(p.getName());
		Arrays.troll.remove(p.getName());
		Arrays.ironman.remove(p.getName());
		Arrays.kriptonita.remove(p.getName());
		Arrays.kiwwi.remove(p.getName());
		Arrays.desh.remove(p.getName());
		Arrays.shadow.remove(p.getName());
		Arrays.avatar.remove(p.getName());
	}

	@EventHandler
	public void Death(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		remov(p);
		Arrays.used.remove(p.getName());
		Arrays.pvp.remove(p.getName());
		Arrays.pulo.remove(p.getName());
		Arrays.viper.remove(p.getName());
		Arrays.snail.remove(p.getName());
		Arrays.critical.remove(p.getName());
		Arrays.viking.remove(p.getName());
		Arrays.regenerator.remove(p.getName());
		Arrays.urgal.remove(p.getName());
		Arrays.stomper.remove(p.getName());
		Arrays.reaper.remove(p.getName());
		Arrays.magma.remove(p.getName());
		Arrays.camel.remove(p.getName());
		Arrays.barbarian.remove(p.getName());
		Arrays.resouper.remove(p.getName());
		Arrays.turtle.remove(p.getName());
		Arrays.thor.remove(p.getName());
		Arrays.kangaroo.remove(p.getName());
		Arrays.poseidon.remove(p.getName());
		Arrays.ninja.remove(p.getName());
		Arrays.endermage.remove(p.getName());
		Arrays.DeshFire.remove(p.getName());
		Arrays.sonic.remove(p.getName());
		Arrays.terrorista.remove(p.getName());
		Arrays.rabbit.remove(p.getName());
		Arrays.teste.remove(p.getName());
		Arrays.chestplater.remove(p.getName());
		Arrays.troll.remove(p.getName());
		Arrays.ironman.remove(p.getName());
		Arrays.kriptonita.remove(p.getName());
		Arrays.kiwwi.remove(p.getName());
		Arrays.desh.remove(p.getName());
		Arrays.shadow.remove(p.getName());
	}

	public static String getAbility(final Player p2) {
		return null;
	}

	public static boolean contains(final String name) {
		return false;
	}

	public static void removeAbility(final Player p) {
	}

	public static int size() {
		return 0;
	}
}
