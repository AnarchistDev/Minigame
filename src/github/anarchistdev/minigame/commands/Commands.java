package github.anarchistdev.minigame.commands;

import github.anarchistdev.minigame.Main;
import github.anarchistdev.minigame.util.ArenaUtils;
import github.anarchistdev.minigame.util.LocationUtil;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    private Main pl = Main.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (!(p.isOp())) {
                p.sendMessage(ChatColor.RED + "Error: You must be opped to do this!");
                return false;
            }

            if (args.length >= 1) {
                switch (args[0]) {
                    case "create": {
                        if (args.length == 3) {
                            if (!(this.isInt(args[1], p))) break;

                            if (ArenaUtils.arenaExists(Integer.valueOf(args[1]))) {
                                p.sendMessage(ChatColor.RED + "This arena already exists!");
                            } else {
                                Location loc1 = LocationUtil.getLocation(1);
                                Location loc2 = LocationUtil.getLocation(2);

                                ArenaUtils.createArena(Integer.valueOf(args[1]), args[2], loc1, loc2);
                                pl.saveArenas();
                                p.sendMessage(ChatColor.GREEN + "Created arena: " + ChatColor.WHITE + String.valueOf(args[1]));
                            }
                        } else {
                            printHelp(p);
                        }

                        break;
                    }

                    case "pos1": {
                        LocationUtil.saveLocation("loc1", p.getLocation());
                        break;
                    }

                    case "pos2": {
                        LocationUtil.saveLocation("loc2", p.getLocation());
                        break;
                    }

                    default: {
                        printHelp(p);
                    }
                }

            } else printHelp(p);
        }
        return true;
    }

    public void printHelp(Player p) {
        p.sendMessage(ChatColor.RED + "Usage: /mg create <ID> <name> <pos1> <pos2>");
    }

    public boolean isInt(String s, Player p) {
        boolean isInt = true;

        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            printHelp(p);
            isInt = false;
        }

        return isInt;
    }

}
