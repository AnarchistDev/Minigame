package github.anarchistdev.minigame.Utils;

import github.anarchistdev.minigame.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class LocationUtils {

    public static void saveLocation(String path, Location loc){

        FileConfiguration arenas = Main.getInstance().getArenas();
        Main pl = Main.getInstance();

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

    public static Location getLocation(int i){

        FileConfiguration arenas = Main.getInstance().getArenas();
        Main pl = Main.getInstance();

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
