package bEssentials;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;

import MySQL.Query;
import MySQL.API.EntrarMySQL;
import MySQL.API.MoneyAPI;
import MySQL.API.PrisionUtil;
import bEssentials.Comandos.*;
import bEssentials.Comandos.AdminCommands.AdminEvents;
import bEssentials.Comandos.AdminCommands.Commandadmin;
import bEssentials.Comandos.ChatCommands.ChatCommand;
import bEssentials.Comandos.ChatCommands.ChatEvent;
import bEssentials.Comandos.HomeCommands.*;
import bEssentials.Comandos.KitCommands.Commandkit;
import bEssentials.Comandos.MoneyCommands.CommandMoney;
import bEssentials.Comandos.MoneyCommands.CommandPay;
import bEssentials.Comandos.MoneyCommands.Commandgive;
import bEssentials.Comandos.MoneyCommands.Commandsetmoney;
import bEssentials.Comandos.WarpCommands.*;
import bEssentials.Configuração.MyConfigManager;
import bEssentials.Eventos.Chat;
import bEssentials.Eventos.Entrar;
import bEssentials.Eventos.Quit;
import bEssentials.RankUp.Comprar;
import bEssentials.RankUp.Quests;
import bEssentials.RankUp.RankUp;
import TEssentials.Utilidades.Blocks;
import TEssentials.Utilidades.ChestManager;
import TEssentials.Utilidades.CommandChest;
import TEssentials.Utilidades.Combatlog.Commandlog;
import TEssentials.Utilidades.Combatlog.DeathEvent;
import TEssentials.Utilidades.Combatlog.EntityAttack;
import TEssentials.Utilidades.Combatlog.KickEvent;
import TEssentials.Utilidades.Combatlog.NoCommandEvent;
import TEssentials.Utilidades.Combatlog.QuitEvent;

public class Main extends JavaPlugin implements Listener {
	
	public static Main plugin;
	public static MyConfigManager manager;
	public ChestManager chestManager;
	public static Server server = Bukkit.getServer();
	static String host = "127.0.0.1"; //164.132.200.218
	static String porta = "3306";
	static String database = "Tatto_Servers";
	static String usuario = "Tatto";
	static String senha = "dred@lindu123";
	static Query MySQL = new Query(plugin, host, database, usuario, senha);
	public static Connection c = null;
	int tempo = 300;
	
	@SuppressWarnings("deprecation")
	public void paao(){
		getServer().getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
			public void run() {
				if(tempo > 0){
					tempo--;
				}
				if(tempo == 299){
				if (Query.conectado){
					System.out.println("Atualizando Money Top");
					String[] top = MoneyAPI.getMoneyTop();
					
					getConfig().set("MoneyTop.1", getMoneyTop(top, 0));
					getConfig().set("MoneyTop.2", getMoneyTop(top, 1));
					getConfig().set("MoneyTop.3", getMoneyTop(top, 2));
					getConfig().set("MoneyTop.4", getMoneyTop(top, 3));
					getConfig().set("MoneyTop.5", getMoneyTop(top, 4));
					getConfig().set("MoneyTop.6", getMoneyTop(top, 5));
					getConfig().set("MoneyTop.7", getMoneyTop(top, 6));
					getConfig().set("MoneyTop.8", getMoneyTop(top, 7));
					getConfig().set("MoneyTop.9", getMoneyTop(top, 8));
					getConfig().set("MoneyTop.10", getMoneyTop(top, 9));
					saveConfig();
				}else{
					System.out.println("Nao foi possivel atualizar o Money Top.");
				}
			}
				if(tempo == 1){
				tempo = 300;
				System.out.println("Atualizando Money Top");
			}
			}
		}, 0L, 20L);
	}
	public static String getMoneyTop(String[] top, int posiçao){
		if (top[posiçao] == null){
			return "§cNinguém";
		}
		return top[posiçao];
	}
	
	public void onEnable(){
		plugin = this;
		manager = new MyConfigManager(this);
		c = MySQL.openConnection();
		paao();
		createsFiles();
		saveDefaultConfig();
		
		File chestfolder = new File(getDataFolder(), "Baus");
		chestManager = new ChestManager(chestfolder);
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Quests(this), this);
		pm.registerEvents(this, this);
		getCommand("pay").setExecutor(new CommandPay());
		getCommand("money").setExecutor(new CommandMoney(this));
		getCommand("setmoney").setExecutor(new Commandsetmoney());
		getCommand("quests").setExecutor(new Quests(this));
		getCommand("givemoney").setExecutor(new Commandgive());
		pm.registerEvents(new CommandsTogle(), this);	
		pm.registerEvents(new Entrar(this), this);
		pm.registerEvents(new CommandHome(), this);
		pm.registerEvents(new Comprar(this), this);
		pm.registerEvents(new CommandWarp(this), this);
		pm.registerEvents(new Commandkit(), this);
		pm.registerEvents(new Chat(), this);
		pm.registerEvents(new Quit(), this);
		pm.registerEvents(new AdminEvents(), this);
		pm.registerEvents(new Blocks(), this);		
		pm.registerEvents(new ChatEvent(), this);	
		
		pm.registerEvents(new EntrarMySQL(), this);
		pm.registerEvents(new DeathEvent(), this);
		pm.registerEvents(new EntityAttack(), this);
		pm.registerEvents(new KickEvent(), this);
		pm.registerEvents(new NoCommandEvent(), this);
		pm.registerEvents(new QuitEvent(), this);
		pm.registerEvents(new PrisionUtil(this), this);
		pm.registerEvents(new RankUp(this), this);

		getCommand("toggle").setExecutor(new CommandsTogle());
		getCommand("combatlog").setExecutor(new Commandlog());
		getCommand("spawnarMN").setExecutor(new RankUp(this));
		getCommand("cela").setExecutor(new Comprar(this));
		getCommand("subir").setExecutor(new RankUp(this));
		getCommand("bolao").setExecutor(new BolaoCommand());
		getCommand("setspawn").setExecutor(new CommandsWarp(this));
		getCommand("chat").setExecutor(new ChatCommand());
		getCommand("g").setExecutor(new ChatCommand());
		getCommand("kit").setExecutor(new Commandkit());
		getCommand("warp").setExecutor(new CommandWarp(this));
		getCommand("setwarp").setExecutor(new CommandsWarp(this));
		getCommand("broadcast").setExecutor(new CommandBroadcast());
		getCommand("clear").setExecutor(new CommandClearInventory());
		getCommand("enderchest").setExecutor(new CommandEnderChest());
		getCommand("delhome").setExecutor(new CommandDelhome());
		getCommand("fly").setExecutor(new CommandFly());
		getCommand("gamemode").setExecutor(new CommandGamemode());
		getCommand("invsee").setExecutor(new CommandInvsee());
		getCommand("home").setExecutor(new CommandHome());
		getCommand("sethome").setExecutor(new CommandSethome());
		getCommand("tpa").setExecutor(new Commandtpa());
		getCommand("tpaccept").setExecutor(new Commandtpa());
		getCommand("tp").setExecutor(new Commandtpa());
		getCommand("chest").setExecutor(new CommandChest(chestManager));
		getCommand("tpall").setExecutor(new Commandtpall());
		getCommand("admin").setExecutor(new Commandadmin());
		getCommand("lag").setExecutor(new Commandlag());
		getCommand("spawn").setExecutor(new Commandspawn());
		
		createTableStatus();
	}
	
	void createsFiles(){
		if (!getDataFolder().exists()){
			getDataFolder().mkdir();
		}
		
		File file = new File(Main.plugin.getDataFolder(), "Configuraçoes.yml");
		if (!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		File cooldown = new File(Main.plugin.getDataFolder(), "Cooldowns.yml");
		if (!cooldown.exists()){
			try {
				cooldown.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static Main getPlugin(){
		return plugin;
	}
	
	public static String HookedServer(){
		return plugin.getConfig().getString("Servidor");
	}

	public void onDisable(){
	chestManager.save();	
		
		File cooldown = new File(Main.plugin.getDataFolder(), "Cooldowns.yml");
		FileConfiguration config = YamlConfiguration.loadConfiguration(cooldown);
		for (Player p : Bukkit.getOnlinePlayers()){
			
			config.set(p.getName()+".comida", Commandkit.cooldownCOMIDA.get(p.getName()));
			config.set(p.getName()+".membro", Commandkit.cooldownMEMBRO.get(p.getName()));
			config.set(p.getName()+".iron", Commandkit.cooldownIRON.get(p.getName()));
			config.set(p.getName()+".gold", Commandkit.cooldownGOLD.get(p.getName()));
			config.set(p.getName()+".diamond", Commandkit.cooldownDIAMOND.get(p.getName()));
			config.set(p.getName()+".emerald", Commandkit.cooldownEMERALD.get(p.getName()));
			config.set(p.getName()+".legendary", Commandkit.cooldownLEGENDARY.get(p.getName()));
			
			p.kickPlayer("§cServidor reiniciando.");
		}
		
		try {
			config.save(cooldown);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Bukkit.getScheduler().cancelAllTasks();
		World world = Bukkit.getWorld("world");
		for (Entity entities : world.getEntities()){
				if(entities.getCustomName() == "§6Corrupto"){
					return;
				}
			entities.remove();
		}
		
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void createTableStatus(){
		try {
			Statement st = Main.c.createStatement();
		    String sql = "CREATE TABLE IF NOT EXISTS `Money_FullPvP` (";
		    sql = sql + "`UUID` VARCHAR(80) NOT NULL,";
		    sql = sql + "`Nick` VARCHAR(80) NOT NULL DEFAULT 'NULL',";
		    sql = sql + "`Money` INT(11) NOT NULL DEFAULT '0');";
			st.execute(sql);
			st.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static boolean emPvP(Player p){
		ApplicableRegionSet region = getWorldGuard().getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation());
		if (region.allows(DefaultFlag.PVP)){
			return true;
		}
		return false;
	}

	public static WorldGuardPlugin getWorldGuard(){
		Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
		if ((plugin == null) || (!(plugin instanceof WorldGuardPlugin))){
			return null;
		}
		
		return (WorldGuardPlugin) plugin;
	}
}
