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

import co.kbcomp.bukkit.BDchat.help.helpMessage;

public class CmdBDchatListener implements CommandExecutor {
	
	public CmdBDchatListener(BDchat bDchat) {

	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		BDchatPlayer BDplayer = BDchat.BDchatPlayerList.get(sender.getName());
		if (sender instanceof Player) {
			if(cmd.getName().equalsIgnoreCase("bdchat")){
					if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(helpMessage.helpMsg[0]);
						sender.sendMessage(helpMessage.helpMsg[1]);
						sender.sendMessage(helpMessage.helpMsg[2]);
						sender.sendMessage(helpMessage.helpMsg[3]);
						sender.sendMessage(helpMessage.helpMsg[4]);
						sender.sendMessage(helpMessage.helpMsg[5]);
					
					} else if (args[0].equalsIgnoreCase("list")) {
						BDplayer.getPlayer().sendMessage(
								ChatColor.GRAY + "----------" + ChatColor.RED +  "[" + ChatColor.GREEN + "BDchat" + ChatColor.RED + "]" + ChatColor.GRAY +"----------");
						for (Channel currentChannel1 : BDchat.channelList.values()) {
							BDplayer.getPlayer().sendMessage(
									ChatColor.DARK_GREEN + currentChannel1.getName() + ": " + ChatColor.YELLOW
									+ currentChannel1.getDescription());
					}
				}return true;
			}
			 return true;
			/*else if (sender instanceof ConsoleCommandSender) {
				if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
					for (String currentLine : helpMessage.helpMessage) {
						Bukkit.getLogger().info(currentLine);
				}
					//Since this one goes to the console you dont want to use color
				} else if (args[0].equalsIgnoreCase("list")) {
					Bukkit.getLogger.info("----------[BDchat]----------");
					
					for (Channel currentChannel1 : BDchat.channelList.values()) {
						Bukkit.getLogger.info(currentChannel1.getName() + ": " + currentChannel1.getDescription());
					}
				}
				return true;
			}*/
		}
		return true;
	}
}
