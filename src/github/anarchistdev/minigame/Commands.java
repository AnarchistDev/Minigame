package github.anarchistdev.minigame;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor{

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (args.length == 5){

                switch (args[0]){

                    case "create":
                        Arena arena = new Arena(Integer.valueOf(args[1]), args[2], Integer.valueOf(args[3]), Integer.valueOf(args[4]));
                        p.sendMessage("Created arena: " + ChatColor.RED + String.valueOf(args[1]));
                }

            }

        }


        return true;
    }

    public void printHelp(Player p){

        p.sendMessage(ChatColor.RED + "Usage: /mg create <ID> <name> <pos1> <pos2>");

    }

}
