package github.anarchistdev.minigame;

import github.anarchistdev.minigame.Events.SignInteract;
import github.anarchistdev.minigame.Objects.Arena;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends JavaPlugin {

    private static Main instance;

    public Main() {
        instance = this;
    }

    public static Main getInstance() {
        return instance;
    }
    public final ArrayList<Arena> arenaList = new ArrayList<>();

    private File configFile, arenasFile;
    private FileConfiguration config, arenas;

    @Override
    public void onEnable(){
        instance = this;

        this.getServer().getPluginManager().registerEvents(new SignInteract(), this);

        createFiles();
        this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n#\n#    Minigame 1.0.0 has been enabled.\n#");
        this.getCommand("mg").setExecutor(new Commands());

    }

    @Override
    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n#\n#    Minigame 1.0.0 has been disabled.\n#");

        instance = null;
    }

    public FileConfiguration getArenas() {
        return this.arenas;
    }

    public void saveArenas() {
        try {
            arenas.save(arenasFile);
        } catch (IOException e){
            e.printStackTrace();
        }
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
