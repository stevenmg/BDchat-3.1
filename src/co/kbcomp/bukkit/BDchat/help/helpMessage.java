package co.kbcomp.bukkit.BDchat.help;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.theglicks.bukkit.BDchat.BDchat;
public class helpMessage {

	public static List<String> helpMessage = new ArrayList<String>();
	public static String[] helpMsg = {(ChatColor.GRAY + "----------" + ChatColor.RED +  "[" + ChatColor.GREEN + "BDchat" + ChatColor.RED + "]" + ChatColor.GRAY +"----------"),
			(ChatColor.RED + "Author - " + ChatColor.GRAY + "StevenMG and Addicted_24_7"),
			(ChatColor.RED + "Version - "+ ChatColor.GRAY + BDchat.thisPlugin.getDescription().getVersion()),
			(ChatColor.GRAY + "Look us up on BukkitDev! " + BDchat.thisPlugin.getDescription().getWebsite()),
			(ChatColor.GRAY + "Change channels using /cc (Channel Name)"),
			(ChatColor.GRAY + "For a list of channels do /BDchat list")
		};
	

}
