package org.theglicks.bukkit.BDchat.commandListeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.theglicks.bukkit.BDchat.BDchat;
import org.theglicks.bukkit.BDchat.BDchatPlayer;
import org.theglicks.bukkit.BDchat.Channel;
import org.theglicks.bukkit.BDchat.Messenger;
import org.theglicks.bukkit.BDchat.Permissions;

public class CmdccListener implements CommandExecutor {
	public CmdccListener(BDchat bDchat) {

	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (sender instanceof Player) {
			BDchatPlayer BDplayer = BDchat.BDchatPlayerList.get(sender.getName());
			if (args.length < 1) {
				Messenger.ccError(BDplayer.getPlayer());
			} else {
				if (Permissions.canTalk(BDplayer.getPlayer(), args[0])) {
					if (args.length == 1) {
						BDplayer.setChannel(args[0], true);
					} else if (args.length > 1) {
						String message = "";
						int counter = 0;
						for (String arg : args) {
							counter++;
							if (counter > 1) {
								message = message + arg + ' ';
								message.replace(".", "");
						
							}
						}
						String currentChannel = BDplayer.getChannelAsString();
						if (BDplayer.setChannel(args[0], false)) {
							BDplayer.getPlayer().chat(message);
							BDplayer.setChannel(currentChannel, false);
						}
					}
				} else {
					sender.sendMessage(ChatColor.RED
							+ "You do not have permssion to talk in that channel!");
				}
			}
		} else if (sender instanceof ConsoleCommandSender) {
			if (args.length > 1) {
				Channel BDchannel = BDchat.channelList.get(args[0]);
				if (BDchannel.getType().equals("global")) {
					String message = BDchannel.getPrefix() + ChatColor.RED + " CONSOLE: " + ChatColor.GOLD
							+ BDchannel.getFormat();
					message.replace(".", "");
					
					int counter = 0;
					for (String arg : args) {
						counter++;
						if (counter > 1) {
							ChatColor.translateAlternateColorCodes('&', BDchannel.getFormat() + (message + arg + ' '));
						}
					}
					
					for (BDchatPlayer BDplayer : BDchat.BDchatPlayerList
							.values()) {
						if (Permissions.canView(BDplayer.getPlayer(),
								BDchannel.getName())) {
							BDplayer.getPlayer().sendMessage(message);
						}
					}
				} else {
					Bukkit.getLogger().info(
							"You cannot talk in that type of channel");
				}
			}
		}
		return true;
	}
}
