package org.theglicks.bukkit.BDchat;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.theglicks.bukkit.BDchat.commandListeners.CmdBDchatListener;
import org.theglicks.bukkit.BDchat.commandListeners.CmdccListener;
import org.theglicks.bukkit.BDchat.events.ChatListener;
import org.theglicks.bukkit.BDchat.events.LoginListener;
import org.theglicks.bukkit.BDchat.events.PlayerLeaveListener;

public class BDchat extends JavaPlugin {

	public static JavaPlugin thisPlugin;
	public static ConfigAccessor channelConfig;

	
	public static HashMap<String, BDchatPlayer> BDchatPlayerList = new HashMap<String, BDchatPlayer>();
	public static HashMap<String, Channel> channelList = new HashMap<String, Channel>();

	@Override
	public void onEnable() {
		thisPlugin = (JavaPlugin) Bukkit.getPluginManager().getPlugin("BDchat");
		channelConfig = new ConfigAccessor(thisPlugin, "channelConfig.yml");

		channelConfig.saveDefaultConfig();
		channelConfig.getConfig().options().copyDefaults(true);

		getCommand("cc").setExecutor(new CmdccListener(this));
		getCommand("bdchat").setExecutor(new CmdBDchatListener(this));

		getServer().getPluginManager().registerEvents(new LoginListener(), this);
		getServer().getPluginManager().registerEvents(new ChatListener(), this);
		getServer().getPluginManager().registerEvents(new PlayerLeaveListener(), this);

		//Add the full help msg front he 'mainConfig' to a List Array so it can 
		//Load a different way and not make the Yaml Parser freak out.
		//Also move the 'Default Channel' to the 'channelConfig.yml' file.
		
		
		
		for (String channel : channelConfig.getConfig()
				.getConfigurationSection("channels").getKeys(false)) {
			Channel BDchannel = new Channel(channel);
			channelList.put(channel, BDchannel);
		}
	}

	@Override
	public void onDisable() {

	}
}