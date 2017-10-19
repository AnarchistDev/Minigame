package github.anarchistdev.minigame;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class ArenaUtils {

    Main pl = Main.getInstance();

    FileConfiguration arenas = pl.getArenas();

    public ArenaUtils(){
        // Does nothing, used to access methods.
    }

    public boolean arenaExists(int id){

        return (!(Main.getInstance().getArenas().get("arenas." + String.valueOf(id)) == null));

    }

    public void createArena(int id, String name, Location loc1, Location loc2){

        LocationHandler locHandler = new LocationHandler();

        String path = "arenas." + String.valueOf(id);

        arenas.addDefault(path + ".name", name);

        locHandler.saveLocation(path + ".loc1", loc1);
        locHandler.saveLocation(path + ".loc2", loc2);

        pl.saveArenas();

    }

}
