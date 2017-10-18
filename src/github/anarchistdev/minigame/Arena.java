package github.anarchistdev.minigame;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Arena {

    private int id;
    private String name;
    private int pos1;
    private int pos2;

    Main pl = Main.getInstance();

    FileConfiguration arenas = pl.getArenas();

    public Arena (int id, String name, int pos1, int pos2){

        this.setId(id);
        this.setName(name);
        this.setPos1(pos1);
        this.setPos2(pos2);

        FileConfiguration arenas = pl.getArenas();
        arenas.set("arenas." + String.valueOf(id) + ".name", name);
        arenas.set("arenas." + String.valueOf(id) + ".pos1", String.valueOf(pos1));
        arenas.set("arenas." + String.valueOf(id) + ".pos2", String.valueOf(pos2));
        pl.saveArenas();

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

    public int getPos1() {
        return pos1;
    }

    public void setPos1(int pos1) {
        this.pos1 = pos1;
    }

    public int getPos2() {
        return pos2;
    }

    public void setPos2(int pos2) {
        this.pos2 = pos2;
    }

    /*
          Methods
     */

    public void createArena(){

    }

    public static boolean arenaExists(int id){

        if (Main.getInstance().getArenas().get("arenas." + String.valueOf(id)) == null) {
            return false;
        }
        else return true;
    }

}

