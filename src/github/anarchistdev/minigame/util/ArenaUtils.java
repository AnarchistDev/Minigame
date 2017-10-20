package github.anarchistdev.minigame.util;

import github.anarchistdev.minigame.Main;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class ArenaUtils {
    public static boolean arenaExists(int id){
        return !(Main.getInstance().getArenas().get("arenas." + String.valueOf(id)) == null);
    }

    public static void createArena(int id, String name, Location loc1, Location loc2){
        LocationUtil locHandler = new LocationUtil();

        String path = "arenas." + String.valueOf(id);

        Main.getInstance().getArenas().set(path + ".name", name);

        locHandler.saveLocation(path + ".loc1", loc1);
        locHandler.saveLocation(path + ".loc2", loc2);

        Main.getInstance().saveArenas();

    }

}
