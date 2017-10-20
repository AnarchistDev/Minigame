package github.anarchistdev.minigame.objects;

import github.anarchistdev.minigame.Main;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Arena {
    private Main pl = Main.getInstance();

    private int id;
    private String name;
    private Location loc1;
    private Location loc2;
    private List<Player> players = new ArrayList<>();


    FileConfiguration arenas = pl.getArenas();

    public Arena (int id, String name, Location loc1, Location loc2, ArrayList<Player> players){
        this.id = id;
        this.name = name;
        this.loc1 = loc1;
        this.loc2 = loc2;
    }

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

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addPlayers(Player... players) {
        this.players.addAll(Arrays.asList(players));
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void removePlayers(Player... players) {
        this.players.removeAll(Arrays.asList(players));
    }
}

