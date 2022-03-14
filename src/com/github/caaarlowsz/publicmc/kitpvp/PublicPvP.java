package com.github.caaarlowsz.publicmc.kitpvp;

import java.util.ArrayList;
import java.util.HashMap;

import com.github.caaarlowsz.kitpvpapi.KitPvP;
import com.github.caaarlowsz.kitpvpapi.KitPvPAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import zEvents.Admin;
import zEvents.Admin2;
import zEvents.Bc;
import zEvents.Build;
import zEvents.Click;
import zEvents.CombatLog;
import zEvents.Drop;
import zEvents.Ffeast;
import zEvents.GWarps;
import zEvents.Gm;
import zEvents.GuiX;
import zEvents.Holograms;
import zEvents.Inf;
import zEvents.Invsee;
import zEvents.Join;
import zEvents.Jump;
import zEvents.Loja;
import zEvents.RdmA;
import zEvents.Recraft;
import zEvents.RemoveR;
import zEvents.Report;
import zEvents.Respawn;
import zEvents.SFeast;
import zEvents.SetFeast;
import zEvents.Sopa;
import zEvents.Status;
import zEvents.Tab;
import zEvents.Tag;
import zEvents.Title;
import zEvents.Troll;
import zEvents.Utils;
import zEvents.VerCash;
import zKits.BarKit;
import zKits.DeshFire;
import zKits.Endermage;
import zKits.Evolucionist;
import zKits.Firer;
import zKits.Fisherman;
import zKits.Flyer;
import zKits.Kangaroo;
import zKits.KitsManager;
import zKits.Mago;
import zKits.Ninja;
import zKits.Pvp;
import zKits.Sonic;
import zKits.Stomper;
import zKits.Supernova;
import zKits.Surprise;
import zKits.Terrorista;
import zKits.Tornado;
import zKits.Turtle;
import zKits.Urano;
import zKits.Velotrol;
import zKits.Viking;
import zKits.Viper;
import zKits.Wither;
import zKits.WoodMan;
import zKits.Zeus;
import zMetodos.Seletor;
import zMetodos.Seletor2;

public class PublicPvP extends JavaPlugin implements KitPvP, CommandExecutor {

	@Override
	public void onEnable() {
		super.onEnable();
		KitPvPAPI.setInstance(this);

		// TODO: Remover quando melhorar a classe principal
		this.enable();
	}

	@Override
	public void onDisable() {
		super.onDisable();
		KitPvPAPI.setInstance(null);

		// TODO: Remover quando melhorar a classe principal
		this.disable();
	}

	// TODO: Melhorar a classe principal

	public static Plugin plugin;
	private static PublicPvP instance;
	public static Economy econ;
	public static Permission perm;
	public static Permission perms;
	public static ArrayList<Player> Na1v1;
	public static ArrayList<Player> EmPvP;
	public static ArrayList<Player> parado;
	public static ArrayList<Player> protegido;
	public static ArrayList<String> cooldown;
	public static HashMap<OfflinePlayer, Integer> cash;

	static {
		PublicPvP.econ = null;
		PublicPvP.perm = null;
		PublicPvP.perms = null;
		PublicPvP.Na1v1 = new ArrayList<Player>();
		PublicPvP.EmPvP = new ArrayList<Player>();
		PublicPvP.parado = new ArrayList<Player>();
		PublicPvP.protegido = new ArrayList<Player>();
		PublicPvP.cooldown = new ArrayList<String>();
		PublicPvP.cash = new HashMap<OfflinePlayer, Integer>();
	}

	public void enable() {
		final RegisteredServiceProvider<Economy> economyProvider = this.getServer().getServicesManager()
				.getRegistration(Economy.class);
		if (economyProvider != null) {
			PublicPvP.econ = (Economy) economyProvider.getProvider();
			final RegisteredServiceProvider<Permission> permissionprovider = this.getServer().getServicesManager()
					.getRegistration(Permission.class);
			if (permissionprovider != null) {
				PublicPvP.perm = (Permission) permissionprovider.getProvider();
				this.getServer().getConsoleSender()
						.sendMessage("�7-------- �ePlugin Desenvolvido Por Kiwwi_ �7--------");
				this.saveInicial();
				this.putMoney();
				super.onEnable();
				this.onRegistro();
				((PublicPvP) (PublicPvP.plugin = (Plugin) this)).saveDefaultConfig();
				this.saveCash();
				SFeast.start();
				SFeast.start1();
				Utils.onDia();
			}
		}
	}

	public void disable() {
		this.saveCash();
	}

	public void onRegistro() {
		final PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents((Listener) new Join(), (Plugin) this);
		pm.registerEvents((Listener) new Tab(), (Plugin) this);
		pm.registerEvents((Listener) new Title(), (Plugin) this);
		pm.registerEvents((Listener) new Status(), (Plugin) this);
		pm.registerEvents((Listener) new Pvp(), (Plugin) this);
		pm.registerEvents((Listener) new Loja(), (Plugin) this);
		pm.registerEvents((Listener) new Utils(), (Plugin) this);
		pm.registerEvents((Listener) new Admin2(), (Plugin) this);
		pm.registerEvents((Listener) new Troll(), (Plugin) this);
		pm.registerEvents((Listener) new Kangaroo(), (Plugin) this);
		pm.registerEvents((Listener) new Ninja(), (Plugin) this);
		pm.registerEvents((Listener) new Sonic(), (Plugin) this);
		pm.registerEvents((Listener) new DeshFire(), (Plugin) this);
		pm.registerEvents((Listener) new Stomper(null), (Plugin) this);
		pm.registerEvents((Listener) new WoodMan(), (Plugin) this);
		pm.registerEvents((Listener) new Viking(), (Plugin) this);
		pm.registerEvents((Listener) new Terrorista(), (Plugin) this);
		pm.registerEvents((Listener) new Turtle(), (Plugin) this);
		pm.registerEvents((Listener) new Viper(), (Plugin) this);
		pm.registerEvents((Listener) new Fisherman(), (Plugin) this);
		pm.registerEvents((Listener) new Endermage(), (Plugin) this);
		pm.registerEvents((Listener) new Seletor(), (Plugin) this);
		pm.registerEvents((Listener) new Seletor2(), (Plugin) this);
		pm.registerEvents((Listener) new Surprise(), (Plugin) this);
		pm.registerEvents((Listener) new BarKit(), (Plugin) this);
		pm.registerEvents((Listener) new Respawn(), (Plugin) this);
		pm.registerEvents((Listener) new Velotrol(), (Plugin) this);
		pm.registerEvents((Listener) new Wither(), (Plugin) this);
		pm.registerEvents((Listener) new Tag(), (Plugin) this);
		pm.registerEvents((Listener) new GWarps(), (Plugin) this);
		pm.registerEvents((Listener) new Firer(), (Plugin) this);
		pm.registerEvents((Listener) new Evolucionist(), (Plugin) this);
		pm.registerEvents((Listener) new Gm(), (Plugin) this);
		pm.registerEvents((Listener) new Bc(), (Plugin) this);
		pm.registerEvents((Listener) new Report(), (Plugin) this);
		pm.registerEvents((Listener) new Supernova(), (Plugin) this);
		pm.registerEvents((Listener) new Mago(), (Plugin) this);
		pm.registerEvents((Listener) new Tornado(), (Plugin) this);
		pm.registerEvents((Listener) new Zeus(), (Plugin) this);
		pm.registerEvents((Listener) new Sopa(), (Plugin) this);
		pm.registerEvents((Listener) new Flyer(), (Plugin) this);
		pm.registerEvents((Listener) new Holograms(), (Plugin) this);
		pm.registerEvents((Listener) new Build(), (Plugin) this);
		pm.registerEvents((Listener) new Recraft(), (Plugin) this);
		pm.registerEvents((Listener) new CombatLog(null), (Plugin) this);
		pm.registerEvents((Listener) new Jump(null), (Plugin) this);
		pm.registerEvents((Listener) new Drop(), (Plugin) this);
		pm.registerEvents((Listener) new Ffeast(), (Plugin) this);
		pm.registerEvents((Listener) new VerCash(), (Plugin) this);
		pm.registerEvents((Listener) new Click(), (Plugin) this);
		pm.registerEvents((Listener) new GuiX(), (Plugin) this);
		pm.registerEvents((Listener) new Urano(), (Plugin) this);
		pm.registerEvents((Listener) new Invsee(), (Plugin) this);
		this.getCommand("urano").setExecutor((CommandExecutor) new Urano());
		this.getCommand("rfeast").setExecutor((CommandExecutor) new SetFeast());
		this.getCommand("ffeast").setExecutor((CommandExecutor) new SetFeast());
		this.getCommand("setffeast").setExecutor((CommandExecutor) new SetFeast());
		this.getCommand("dragon").setExecutor((CommandExecutor) new Inf());
		this.getCommand("resetkit").setExecutor((CommandExecutor) new Inf());
		this.getCommand("cc").setExecutor((CommandExecutor) new Inf());
		this.getCommand("click").setExecutor((CommandExecutor) new Click());
		this.getCommand("inf").setExecutor((CommandExecutor) new Inf());
		this.getCommand("cash").setExecutor((CommandExecutor) new VerCash());
		this.getCommand("sopinha").setExecutor((CommandExecutor) new Recraft());
		this.getCommand("build").setExecutor((CommandExecutor) new Holograms());
		this.getCommand("recraft").setExecutor((CommandExecutor) new Sopa());
		this.getCommand("gon").setExecutor((CommandExecutor) new Flyer());
		this.getCommand("evolucionist").setExecutor((CommandExecutor) new Evolucionist());
		this.getCommand("zeus").setExecutor((CommandExecutor) new Zeus());
		this.getCommand("tornado").setExecutor((CommandExecutor) new Tornado());
		this.getCommand("mago").setExecutor((CommandExecutor) new Mago());
		this.getCommand("supernova").setExecutor((CommandExecutor) new Supernova());
		this.getCommand("bc").setExecutor((CommandExecutor) new Bc());
		this.getCommand("report").setExecutor((CommandExecutor) new Report());
		this.getCommand("gm").setExecutor((CommandExecutor) new Gm());
		this.getCommand("firer").setExecutor((CommandExecutor) new Firer());
		this.getCommand("tag").setExecutor((CommandExecutor) new Tag());
		this.getCommand("thor").setExecutor((CommandExecutor) new Wither());
		this.getCommand("velotrol").setExecutor((CommandExecutor) new Velotrol());
		this.getCommand("surprise").setExecutor((CommandExecutor) new Surprise());
		this.getCommand("kits").setExecutor((CommandExecutor) new Seletor());
		this.getCommand("endermage").setExecutor((CommandExecutor) new Endermage());
		this.getCommand("fisherman").setExecutor((CommandExecutor) new Fisherman());
		this.getCommand("boxer").setExecutor((CommandExecutor) new Viper());
		this.getCommand("turtle").setExecutor((CommandExecutor) new Turtle());
		this.getCommand("terrorista").setExecutor((CommandExecutor) new Terrorista());
		this.getCommand("viking").setExecutor((CommandExecutor) new Viking());
		this.getCommand("woodman").setExecutor((CommandExecutor) new WoodMan());
		this.getCommand("stomper").setExecutor((CommandExecutor) new Stomper(null));
		this.getCommand("deshfire").setExecutor((CommandExecutor) new DeshFire());
		this.getCommand("sonic").setExecutor((CommandExecutor) new Sonic());
		this.getCommand("ninja").setExecutor((CommandExecutor) new Ninja());
		this.getCommand("Kangaroo").setExecutor((CommandExecutor) new Kangaroo());
		this.getCommand("admin").setExecutor((CommandExecutor) new Admin());
		this.getCommand("fecharrdm").setExecutor((CommandExecutor) new RemoveR());
		this.getCommand("abrirrdm").setExecutor((CommandExecutor) new RdmA());
		this.getCommand("pvp").setExecutor((CommandExecutor) new Pvp());
		this.getCommand("loja").setExecutor((CommandExecutor) new Loja());
		this.getCommand("invsee").setExecutor((CommandExecutor) new Invsee());
	}

	public static PublicPvP getInstance() {
		return PublicPvP.instance;
	}

	public static Plugin getPlugin() {
		return PublicPvP.plugin;
	}

	public void putMoney() {
		OfflinePlayer[] offlinePlayers;
		for (int length = (offlinePlayers = Bukkit.getOfflinePlayers()).length, i = 0; i < length; ++i) {
			final OfflinePlayer p = offlinePlayers[i];
			if (this.getConfig().contains("Cash." + p.getName())) {
				PublicPvP.cash.put(p, this.getConfig().getInt("Cash." + p.getName()));
			} else {
				PublicPvP.cash.put(p, this.getInicial());
			}
		}
	}

	public void saveCash() {
		OfflinePlayer[] offlinePlayers;
		for (int length = (offlinePlayers = Bukkit.getOfflinePlayers()).length, i = 0; i < length; ++i) {
			final OfflinePlayer p = offlinePlayers[i];
			this.getConfig().set("Cash." + p.getName(), (Object) PublicPvP.cash.get(p));
			this.saveConfig();
		}
	}

	public void saveInicial() {
		this.getConfig().addDefault("Inicial", (Object) 1);
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}

	public int getInicial() {
		return this.getConfig().getInt("Inicial");
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("kreload") && p.hasPermission("admin.reload")) {
			p.sendMessage("�aConfiguracoes recarregadas!");
			this.reloadConfig();
		}
		if (cmd.getName().equalsIgnoreCase("setfps") && p.hasPermission("admin.setar")) {
			this.getConfig().set("fps.world", (Object) p.getLocation().getWorld().getName());
			this.getConfig().set("fps.x", (Object) p.getLocation().getX());
			this.getConfig().set("fps.y", (Object) p.getLocation().getY());
			this.getConfig().set("fps.z", (Object) p.getLocation().getZ());
			this.saveConfig();
			p.sendMessage(String.valueOf(getPlugin().getConfig().getString("server").replace("&", "�"))
					+ " �4>> �7Warp Setada Com Sucessoo");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("setdragon") && p.hasPermission("admin.setar")) {
			this.getConfig().set("dragon.world", (Object) p.getLocation().getWorld().getName());
			this.getConfig().set("dragon.x", (Object) p.getLocation().getX());
			this.getConfig().set("dragon.y", (Object) p.getLocation().getY());
			this.getConfig().set("dragon.z", (Object) p.getLocation().getZ());
			this.saveConfig();
			p.sendMessage(String.valueOf(getPlugin().getConfig().getString("server").replace("&", "�"))
					+ " �4>> �7Warp Setada Com Sucessoo");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("sethard") && p.hasPermission("admin.setar")) {
			this.getConfig().set("hard.world", (Object) p.getLocation().getWorld().getName());
			this.getConfig().set("hard.x", (Object) p.getLocation().getX());
			this.getConfig().set("hard.y", (Object) p.getLocation().getY());
			this.getConfig().set("hard.z", (Object) p.getLocation().getZ());
			this.saveConfig();
			p.sendMessage(String.valueOf(getPlugin().getConfig().getString("server").replace("&", "�"))
					+ " �4>> �7Warp Setada Com Sucessoo");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("setlava") && p.hasPermission("admin.setar")) {
			this.getConfig().set("lava.world", (Object) p.getLocation().getWorld().getName());
			this.getConfig().set("lava.x", (Object) p.getLocation().getX());
			this.getConfig().set("lava.y", (Object) p.getLocation().getY());
			this.getConfig().set("lava.z", (Object) p.getLocation().getZ());
			this.saveConfig();
			p.sendMessage(String.valueOf(getPlugin().getConfig().getString("server").replace("&", "�"))
					+ " �4>> �7Warp Setada Com Sucessoo");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("setRDM") && p.hasPermission("admin.setar")) {
			this.getConfig().set("rdm.world", (Object) p.getLocation().getWorld().getName());
			this.getConfig().set("rdm.x", (Object) p.getLocation().getX());
			this.getConfig().set("rdm.y", (Object) p.getLocation().getY());
			this.getConfig().set("rdm.z", (Object) p.getLocation().getZ());
			this.saveConfig();
			p.sendMessage(String.valueOf(getPlugin().getConfig().getString("server").replace("&", "�"))
					+ " �4>> �7Warp Setada Com Sucesso");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("setSpawn") && p.hasPermission("admin.setar")) {
			this.getConfig().set("spawn.world", (Object) p.getLocation().getWorld().getName());
			this.getConfig().set("spawn.x", (Object) p.getLocation().getX());
			this.getConfig().set("spawn.y", (Object) p.getLocation().getY());
			this.getConfig().set("spawn.z", (Object) p.getLocation().getZ());
			p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(),
					p.getLocation().getBlockZ());
			this.saveConfig();
			p.sendMessage(String.valueOf(getPlugin().getConfig().getString("server").replace("&", "�"))
					+ " �4>> �7Warp Setada Com Sucesso");
			return true;
		}
		if (cmd.getName().equalsIgnoreCase("fps")) {
			if (this.getConfig().getConfigurationSection("fps") == null) {
				p.sendMessage("�cFps Nao Setado!");
				return true;
			}
			final World w = Bukkit.getServer().getWorld(this.getConfig().getString("fps.world"));
			final double x = this.getConfig().getDouble("fps.x");
			final double y = this.getConfig().getDouble("fps.y");
			final double z = this.getConfig().getDouble("fps.z");
			p.teleport(new Location(w, x, y, z));
			final ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
			espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			final ItemStack capacete = new ItemStack(Material.IRON_HELMET);
			final ItemStack peitoral = new ItemStack(Material.IRON_CHESTPLATE);
			final ItemStack calca = new ItemStack(Material.IRON_LEGGINGS);
			final ItemStack bota = new ItemStack(Material.IRON_BOOTS);
			p.getInventory().clear();
			p.getInventory().setItem(0, espada);
			p.getInventory().setHelmet(capacete);
			p.getInventory().setChestplate(peitoral);
			p.getInventory().setLeggings(calca);
			p.getInventory().setBoots(bota);
			KitsManager.darSopas(p);
			p.setAllowFlight(false);
			p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			p.removePotionEffect(PotionEffectType.SPEED);
		}
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			if (this.getConfig().getConfigurationSection("spawn") == null) {
				p.sendMessage("�cSPAWN Nao Setado!");
				return true;
			}
			final World w = Bukkit.getServer().getWorld(this.getConfig().getString("spawn.world"));
			final double x = this.getConfig().getDouble("spawn.x");
			final double y = this.getConfig().getDouble("spawn.y");
			final double z = this.getConfig().getDouble("spawn.z");
			p.teleport(new Location(w, x, y, z));
			p.getInventory().clear();
			final ItemStack item12 = new ItemStack(Material.DIAMOND);
			final ItemMeta itemmeta12 = item12.getItemMeta();
			itemmeta12.setDisplayName("�a Warps");
			item12.setItemMeta(itemmeta12);
			p.getInventory().setItem(2, item12);
			final ItemStack item13 = new ItemStack(Material.CHEST);
			final ItemMeta itemmeta13 = item13.getItemMeta();
			itemmeta13.setDisplayName("�a Seletor de Kits");
			item13.setItemMeta(itemmeta13);
			p.getInventory().setItem(4, item13);
			final ItemStack item14 = new ItemStack(Material.IRON_INGOT);
			final ItemMeta itemmeta14 = item14.getItemMeta();
			itemmeta14.setDisplayName("�a Extras");
			item14.setItemMeta(itemmeta14);
			p.getInventory().setItem(6, item14);
			p.setAllowFlight(false);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			p.removePotionEffect(PotionEffectType.SPEED);
		}
		if (!cmd.getName().equalsIgnoreCase("lava")) {
			return false;
		}
		if (PublicPvP.cash.get(p) >= 15) {
			if (this.getConfig().getConfigurationSection("lava") == null) {
				p.sendMessage("�cLava Nao Setado!");
				return true;
			}
			final World w = Bukkit.getServer().getWorld(this.getConfig().getString("lava.world"));
			final double x = this.getConfig().getDouble("lava.x");
			final double y = this.getConfig().getDouble("lava.y");
			final double z = this.getConfig().getDouble("lava.z");
			p.teleport(new Location(w, x, y, z));
			p.getInventory().clear();
			KitsManager.darSopas(p);
			p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			p.removePotionEffect(PotionEffectType.SPEED);
			p.setAllowFlight(false);
			p.getInventory().setArmorContents((ItemStack[]) null);
		}
		if (cmd.getName().equalsIgnoreCase("rdm")) {
			if (p.hasPermission("kitpvp.rdmabrir")) {
				if (this.getConfig().getConfigurationSection("rdm") == null) {
					p.sendMessage("�cRDM Nao Setado!");
					return true;
				}
				final World w = Bukkit.getServer().getWorld(this.getConfig().getString("rdm.world"));
				final double x = this.getConfig().getDouble("rdm.x");
				final double y = this.getConfig().getDouble("rdm.y");
				final double z = this.getConfig().getDouble("rdm.z");
				p.teleport(new Location(w, x, y, z));
				final ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
				espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				final ItemStack capacete = new ItemStack(Material.IRON_HELMET);
				final ItemStack peitoral = new ItemStack(Material.IRON_CHESTPLATE);
				final ItemStack calca = new ItemStack(Material.IRON_LEGGINGS);
				final ItemStack bota = new ItemStack(Material.IRON_BOOTS);
				p.getInventory().clear();
				p.getInventory().setItem(0, espada);
				p.getInventory().setHelmet(capacete);
				p.getInventory().setChestplate(peitoral);
				p.getInventory().setLeggings(calca);
				p.getInventory().setBoots(bota);
				KitsManager.darSopas(p);
				p.setAllowFlight(false);
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.removePotionEffect(PotionEffectType.SPEED);
			}
			if (cmd.getName().equalsIgnoreCase("feast")) {
				if (this.getConfig().getConfigurationSection("feast") == null) {
					p.sendMessage("�cFeast Nao Setado!");
					return true;
				}
				final World w = Bukkit.getServer().getWorld(this.getConfig().getString("feast.world"));
				final double x = this.getConfig().getDouble("feast.x");
				final double y = this.getConfig().getDouble("faest.y");
				final double z = this.getConfig().getDouble("feast.z");
				p.teleport(new Location(w, x, y, z));
				final ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
				espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
				p.getInventory().clear();
				p.getInventory().setItem(0, espada);
				KitsManager.darSopas(p);
				p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.removePotionEffect(PotionEffectType.SPEED);
			}
			return false;
		}
		return false;
	}

	public static World getWorld() {
		return null;
	}
}
