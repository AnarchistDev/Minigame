package github.anarchistdev.minigame;

import github.anarchistdev.minigame.Objects.Arena;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import static github.anarchistdev.minigame.Utils.ArenaUtils.arenaExists;
import static github.anarchistdev.minigame.Utils.ArenaUtils.createArena;
import static github.anarchistdev.minigame.Utils.ArenaUtils.listArenas;
import static github.anarchistdev.minigame.Utils.GeneralUtils.isInt;
import static github.anarchistdev.minigame.Utils.GeneralUtils.printHelp;
import static github.anarchistdev.minigame.Utils.LocationUtils.getLocation;
import static github.anarchistdev.minigame.Utils.LocationUtils.saveLocation;

public class Commands implements CommandExecutor {

    Main pl = Main.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        FileConfiguration arenas = pl.getArenas();

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (!(p.isOp())) {
                p.sendMessage(ChatColor.RED + "Error: You must be opped to do this!");
                return false;
            }

            if (args.length >= 1) {

                switch (args[0]) {

                    case "create":

                        if (args.length == 4) {

                            // Check to see if String appropriate args are an int
                            // Kill if false
                            if (!(isInt(args[1], p))) {
                                break;
                            }
                            if (!(isInt(args[3], p))) {
                                break;
                            }

                            if (arenaExists(Integer.valueOf(args[1]))) {
                                p.sendMessage(ChatColor.RED + "This arena already exists!");
                            } else {

                                /* Grab players location twice, TODO:
                                      /mg pos1
                                      /mg pos2
                                      store Locations, pass to createArena()
                                 */

                                Location loc1 = getLocation(1);
                                Location loc2 = getLocation(2);

                                createArena(Integer.valueOf(args[1]), args[2], loc1, loc2, Integer.valueOf(args[3]));
                                pl.saveArenas();
                                p.sendMessage(ChatColor.GREEN + "Created arena: " + ChatColor.WHITE + String.valueOf(args[1]));
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + "Usage: /mg create <ID> <name> <pos1> <pos2> <maxPlayers>");
                        }

                        break;

                    case "delete":

                        if (args.length >= 2) {

                            if (!(isInt(args[1], p))) {
                                break;
                            }

                            if (args.length == 2) {

                                arenas.set("arenas." + args[1], null);
                                p.sendMessage(ChatColor.GREEN + "Sucesfully delete: " + ChatColor.WHITE + "Arena " + args[1]);

                            }
                        } else printHelp(p);
                        pl.saveArenas();
                        break;

                    case "deleteall":

                        ConfigurationSection arenasSection = arenas.getConfigurationSection("arenas");

                        for (String id : arenasSection.getKeys(false)){
                            arenas.set("arenas." + id, null);
                        }

                        break;

                    case "pos1":

                        /*
                             NOT yet linked to createArena ^^^
                         */

                        saveLocation("loc1", p.getLocation());

                        // Store location in a variable, maybe need new object?
                        break;

                    case "pos2":

                        saveLocation("loc2", p.getLocation());

                        // ^^^
                        break;

                    case "list":
                        listArenas(p);
                }

            } else printHelp(p);

        }


        return true;
    }

}
