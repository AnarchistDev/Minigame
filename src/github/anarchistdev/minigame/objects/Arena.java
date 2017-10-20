package github.anarchistdev.minigame.objects;

import github.anarchistdev.minigame.Main;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Arena {

    private int id;
    private String name;
    private Location loc1;
    private Location loc2;
    private ArrayList<Player> players;

    Main pl = Main.getInstance();

    FileConfiguration arenas = pl.getArenas();

    public Arena (int id, String name, Location loc1, Location loc2, ArrayList<Player> players){

        this.setId(id);
        this.setName(name);
        this.setLoc1(loc1);
        this.setLoc2(loc2);

    }

    /*
          Getters & Setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLoc1() {
        return loc1;
    }

    public void setLoc1(Location loc1) {
        this.loc1 = loc1;
    }

    public Location getLoc2() {
        return loc2;
    }

    public void setLoc2(Location loc2) {
        this.loc2 = loc2;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    /*
          Methods
     */

}

