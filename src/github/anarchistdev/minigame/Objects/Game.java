package github.anarchistdev.minigame.Objects;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Game {

    // Take arena, then add the players

    Arena arena;
    ArrayList<Player> players;
    boolean isRunning;

    public Game (Arena arena){

        this.arena = arena;

        // Create players array list, add all the players from (lobby?), then set as this.players
        ArrayList<Player> players = new ArrayList<>();
        this.players = players;

    }

    /*
         Getters and Setters
     */

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    /*
         Methods
     */


    public void startGame(){
        this.setRunning(true);

        // Game code:

    }


}
