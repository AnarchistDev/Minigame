package github.anarchistdev.minigame;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
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

        arenas.set(path + ".x", x);
        arenas.set(path + ".y", y);
        arenas.set(path + ".z", z);
        arenas.set(path + ".pitch", pitch);
        arenas.set(path + ".yaw", yaw);
        arenas.set(path + ".world", world);
        pl.saveArenas();;
    }

    public Location getLocation(int i){

        String path;

        if (i == 1){

            path = "loc1.";
        }
        else {

            path = "loc2.";
        }

        double x = Double.parseDouble(String.valueOf(arenas.get(path + "x")));
        double y = Double.parseDouble(String.valueOf(arenas.get(path + "y")));
        double z = Double.parseDouble(String.valueOf(arenas.get(path + "z")));
        float pitch = Float.parseFloat(String.valueOf(arenas.get(path + "pitch")));
        float yaw = Float.parseFloat(String.valueOf(arenas.get(path + "yaw")));
        World world = Bukkit.getWorld(String.valueOf(arenas.get(path + "world")));

        Location location = new Location(world, x, y, z, pitch, yaw);

        return location;

    }



}
