package github.anarchistdev.minigame.Utils;

import github.anarchistdev.minigame.Main;
import github.anarchistdev.minigame.Objects.Arena;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static github.anarchistdev.minigame.Utils.LocationUtils.getLocation;
import static github.anarchistdev.minigame.Utils.LocationUtils.saveLocation;

public class ArenaUtils {

    public static boolean arenaExists(int id){

        return (!(Main.getInstance().getArenas().get("arenas." + String.valueOf(id)) == null));

    }

    public static void createArena(int id, String name, Location loc1, Location loc2, int maxPlayers){

        Main pl = Main.getInstance();
        FileConfiguration arenas = pl.getArenas();

        String path = "arenas." + String.valueOf(id);

        arenas.set(path + ".name", name);

        saveLocation(path + ".loc1", loc1);
        saveLocation(path + ".loc2", loc2);

        arenas.set(path + ".maxplayers", maxPlayers);

        arenas.set(path + ".inuse", false);

        pl.saveArenas();

    }

    public static Arena newArenaObject(int id){

        Main pl = Main.getInstance();
        FileConfiguration arenas = pl.getArenas();

        String path = "arenas." + String.valueOf(id);

        String name = (String) arenas.get(path + ".name");
        Location loc1 = getLocation(1);
        Location loc2 = getLocation(1);
        Location spawn = getLocation(1);
        ArrayList<Player> players = new ArrayList<>();
        int maxPlayers = Integer.parseInt(String.valueOf(arenas.get(path + ".maxplayers")));

        Arena arena = new Arena(id, name, loc1, loc2, spawn, players, maxPlayers);
        return arena;

    }

    public static Arena getArena(int id){

        for (Arena arena : Main.getInstance().arenaList){
            if (arena.getId() == id){
                return arena;
            }
        }

        return null;
    }

    public static void listArenas(Player p){

        Main pl = Main.getInstance();
        FileConfiguration arenas = pl.getArenas();
        ConfigurationSection arenasSection = arenas.getConfigurationSection("arenas");

        ArrayList<Integer> numArenas = new ArrayList();

        // Make sure arena isn't empty
        if (numArenas.size() == 0) p.sendMessage(ChatColor.RED + "No arenas have been created.");

        for (String id : arenasSection.getKeys(false)){
            numArenas.add(Integer.valueOf(id));
            Collections.sort(numArenas);
        }

        p.sendMessage(ChatColor.AQUA + "-----------------------------------------------------");
        p.sendMessage("Arenas: ");

        for (int id : numArenas){
            p.sendMessage("  " + ChatColor.GREEN + id + ChatColor.WHITE + ": " + arenas.get("arenas." + id + ".name"));
        }

        p.sendMessage(ChatColor.AQUA + "-----------------------------------------------------");

    }

    public boolean containsPlayer(Player p){

        /*
             Somehow get all Arena's,
             iterate through their players arraylists,
             if player specified is found, return true
         */

        // if ()

        return false;
    }

}
