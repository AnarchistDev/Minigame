package github.anarchistdev.minigame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {

    private File configFile, arenasFile;
    private FileConfiguration config, arenas;

    @Override
    public void onEnable(){
        createFiles();
        this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n#\n#    Minigame 1.0.0 has been enabled.\n#");
    }

    @Override
    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n#\n#    Minigame 1.0.0 has been disabled.\n#");
    }

    public FileConfiguration getArenas() {
        return this.arenas;
    }

    /*
          Config Manager for multiple configs:
     */

    public void createFiles(){

        // Creating config locations on server
        configFile = new File(this.getDataFolder(), "config.yml");
        arenasFile = new File(this.getDataFolder(), "arenas.yml");

        // Check for configs, create if doesn't exist

        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        if(!arenasFile.exists()) {
            arenasFile.getParentFile().mkdirs();
            saveResource("arenas.yml", false);
        }

        // Make the actual .yml files (and other witchcraft)

        config = new YamlConfiguration();
        arenas = new YamlConfiguration();

        try {
            config.load(configFile);
            arenas.load(arenasFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }

}
