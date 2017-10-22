package github.anarchistdev.minigame.Objects;

import github.anarchistdev.minigame.Main;
import org.bukkit.ChatColor;
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
    private Location spawn;
    private ArrayList<Player> players;
    private int maxPlayers;


    Main pl = Main.getInstance();

    FileConfiguration arenas = pl.getArenas();

    ArrayList<Arena> arenaList = Main.getInstance().arenaList;

    public Arena(int id, String name, Location loc1, Location loc2, Location spawn, ArrayList<Player> players, int maxPlayers) {

        this.setId(id);
        this.setName(name);
        this.setLoc1(loc1);
        this.setLoc2(loc2);
        this.setSpawn(spawn);
        this.setPlayers(players);
        this.setMaxPlayers(maxPlayers);

        arenaList.add(this);

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

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public Location getSpawn() {
        return this.spawn;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /*
          Methods
     */

    public void addPlayer(Player p) {

        for (Arena arena : arenaList) {
            if (arena.getPlayers().contains(p)) {
                p.sendMessage(ChatColor.RED + "You are already in an arena!");
                return;
            }
        }

        if (this.getPlayers().size() <= this.getMaxPlayers()) {
            this.getPlayers().add(p);
            p.sendMessage(ChatColor.GREEN + "You have joined: " + ChatColor.WHITE + "Arena " + this.getId() + this.getName());
        }
        else {
            p.sendMessage(ChatColor.RED + "This arena is full!");
        }
    }

}

