package github.anarchistdev.minigame.Utils;

import github.anarchistdev.minigame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import static github.anarchistdev.minigame.Utils.LocationUtils.saveLocation;

public class ArenaUtils {

    public static boolean arenaExists(int id){

        return (!(Main.getInstance().getArenas().get("arenas." + String.valueOf(id)) == null));

    }

    public static void createArena(int id, String name, Location loc1, Location loc2){

        Main pl = Main.getInstance();
        FileConfiguration arenas = pl.getArenas();

        String path = "arenas." + String.valueOf(id);

        arenas.set(path + ".name", name);

        saveLocation(path + ".loc1", loc1);
        saveLocation(path + ".loc2", loc2);

        pl.saveArenas();

    }

    public static void listArenas(Player p){

        Main pl = Main.getInstance();
        FileConfiguration arenas = pl.getArenas();
        ConfigurationSection arenasSection = arenas.getConfigurationSection("arenas");

        ArrayList<Integer> numArenas = new ArrayList();

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

}
