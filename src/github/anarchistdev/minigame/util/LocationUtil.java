package github.anarchistdev.minigame.util;

import github.anarchistdev.minigame.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class LocationUtil {
    public static void saveLocation(String path, Location loc){
        FileConfiguration arenas = Main.getInstance().getArenas();
        Main pl = Main.getInstance();

        arenas.set(path + ".x", loc.getX());
        arenas.set(path + ".y", loc.getY());
        arenas.set(path + ".z", loc.getZ());
        arenas.set(path + ".pitch", loc.getPitch());
        arenas.set(path + ".yaw", loc.getYaw());
        arenas.set(path + ".world", loc.getWorld().getName());
        pl.saveArenas();
    }

    public static Location getLocation(int i){
        String path;
        if (i == 1){

            path = "loc1.";
        } else {

            path = "loc2.";
        }

        FileConfiguration arenas = Main.getInstance().getArenas();

        double x = Double.parseDouble(String.valueOf(arenas.get(path + "x")));
        double y = Double.parseDouble(String.valueOf(arenas.get(path + "y")));
        double z = Double.parseDouble(String.valueOf(arenas.get(path + "z")));
        float pitch = Float.parseFloat(String.valueOf(arenas.get(path + "pitch")));
        float yaw = Float.parseFloat(String.valueOf(arenas.get(path + "yaw")));
        World world = Bukkit.getWorld(String.valueOf(arenas.get(path + "world")));

        return new Location(world, x, y, z, pitch, yaw);

    }



}
