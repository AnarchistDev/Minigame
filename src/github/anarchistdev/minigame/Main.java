package github.anarchistdev.minigame;

import github.anarchistdev.minigame.commands.Commands;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {
    private static Main instance;

    private File configFile, arenasFile;
    private static FileConfiguration config, arenas;

    @Override
    public void onEnable(){
        instance = this;

        createFiles();
        this.getCommand("mg").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void createFiles(){
        configFile = new File(this.getDataFolder(), "config.yml");
        arenasFile = new File(this.getDataFolder(), "arenas.yml");

        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        if(!arenasFile.exists()) {
            arenasFile.getParentFile().mkdirs();
            saveResource("arenas.yml", false);
        }

        config = new YamlConfiguration();
        arenas = new YamlConfiguration();

        try {
            config.load(configFile);
            arenas.load(arenasFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void saveArenas() {
        try {
            arenas.save(arenasFile);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public FileConfiguration getArenas() {
        return arenas;
    }

    public static Main getInstance() {
        return instance;
    }
}
