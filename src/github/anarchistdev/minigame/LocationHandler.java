package github.anarchistdev.minigame;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class LocationHandler {

    Main pl = Main.getInstance();

    FileConfiguration arenas = pl.getArenas();

    public LocationHandler(){
        // Does nothing, used to access methods.
    }

    /*  TO DO:
    public static void saveLocation(Location loc) {
        config.set("path", loc.getX());
  ...
    }
    */

    public void saveLocation(String path, Location loc){

        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        double pitch = loc.getPitch();
        double yaw = loc.getYaw();
        String world = loc.getWorld().getName().toString();

        arenas.addDefault(path + ".x", x);
        arenas.addDefault(path + ".y", y);
        arenas.addDefault(path + ".z", z);
        arenas.addDefault(path + ".pitch", pitch);
        arenas.addDefault(path + ".yaw", yaw);
        arenas.addDefault(path + ".world", world);
        pl.saveArenas();;
    }



}
