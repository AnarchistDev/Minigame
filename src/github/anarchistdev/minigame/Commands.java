package github.anarchistdev.minigame;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor{

    Main pl = Main.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player){
            Player p = (Player) sender;

            if (args.length == 5){

                switch (args[0]){

                    case "create":

                        // Check to see if String appropriate args are an int
                        // Kill if false
                        if(!(this.isInt(args[1], p))){
                            break;
                        }
                        if(!(this.isInt(args[3], p))){
                            break;
                        }
                        if(!(this.isInt(args[4], p))){
                            break;
                        }

                        if(Arena.arenaExists(Integer.valueOf(args[1]))){
                            p.sendMessage(ChatColor.RED + "This arena already exists!");
                        } else {
                            Arena arena = new Arena(Integer.valueOf(args[1]), args[2], Integer.valueOf(args[3]), Integer.valueOf(args[4]));
                            p.sendMessage(ChatColor.GREEN + "Created arena: " + ChatColor.WHITE + String.valueOf(args[1]));
                        }
                        break;

                    case "pos1":

                        // Store location in a variable, maybe need new object?
                        break;

                    case "pos2":

                        // ^^^
                        break;
                }

            }
            else printHelp(p);

        }


        return true;
    }

    public void printHelp(Player p){

        p.sendMessage(ChatColor.RED + "Usage: /mg create <ID> <name> <pos1> <pos2>");

    }

    public boolean isInt(String s, Player p){
        boolean isInt = true;

        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e){
            printHelp(p);
            isInt = false;
        }

        return isInt;
    }

}
