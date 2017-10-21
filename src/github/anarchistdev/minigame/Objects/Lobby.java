package github.anarchistdev.minigame.Objects;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Lobby {

    private int maxPlayers;
    private ArrayList<Player> players;

    public Lobby(int maxPlayers){



        /*

        boolean notReady = true;

        while (notReady){

            loop through runnable, check every second for players, if enough players, begin game

            check if arena ID is in use, if false, take that arena for object?

        }


         */


    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player p){

        if(players.size() >= maxPlayers){
            p.sendMessage(ChatColor.RED + "This lobby is currently full.");
        }
        else {
            players.add(p);
            p.sendMessage(ChatColor.GREEN + "You have joined the lobby!");
        }

    }

}
