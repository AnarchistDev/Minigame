package github.anarchistdev.minigame.Events;

import github.anarchistdev.minigame.Main;
import github.anarchistdev.minigame.Objects.Arena;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;


import java.util.ArrayList;

import static github.anarchistdev.minigame.Utils.ArenaUtils.getArena;
import static github.anarchistdev.minigame.Utils.ArenaUtils.newArenaObject;
import static github.anarchistdev.minigame.Utils.GeneralUtils.isInt;

public class SignInteract implements Listener {

    Main pl = Main.getInstance();
    FileConfiguration arenas = pl.getArenas();
    ArrayList<Arena> arenaList = pl.arenaList;

    @EventHandler
    public void signClickEvent(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        EquipmentSlot slot = e.getHand();

        if (slot.equals(EquipmentSlot.HAND)) {

            p.sendMessage("PlayerInteractEvent");

            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {

                p.sendMessage("RIGHT_CLICK_BLOCK");

                if (e.getClickedBlock().getType() == Material.SIGN_POST) {

                    p.sendMessage(ChatColor.GOLD + "Material.SIGN");

                    Sign sign = (Sign) (e.getClickedBlock().getState());

                    if (sign.getLine(0).equalsIgnoreCase(ChatColor.AQUA + "" + ChatColor.BOLD + "Join Arena")) {
                        p.sendMessage(ChatColor.AQUA + "Join Arena sign");
                        if (isInt(sign.getLine(1))) {
                            int arenaSignID = Integer.parseInt(sign.getLine(1));

                            p.sendMessage(String.valueOf(arenaSignID));

                            if (arenaList.isEmpty()) {

                                // Check if list is empty, if true, create and add Arena

                                p.sendMessage("list empty, arena created...");
                                Arena newArena = newArenaObject(arenaSignID);
                                newArena.addPlayer(p);
                                arenaList.add(newArena);
                            } else {

                                // Else iterate through Arena's on list
                                int arenaObjectID = 0;

                                for (Arena arena : arenaList) {
                                    arenaObjectID = arena.getId();

                                    // If Sign ID and Arena iteration ID match, add player
                                }

                                if (arenaSignID == arenaObjectID) {
                                    getArena(arenaObjectID).addPlayer(p);
                                    p.sendMessage("'added' to arena");
                                }

                                // If Sign ID is not found in Arena list, check config and create Arena object

                                else if (arenas.get("arenas." + String.valueOf(arenaSignID)) != null) {
                                    p.sendMessage("arena created...");
                                    Arena newArena = newArenaObject(arenaSignID);
                                    newArena.addPlayer(p);
                                    arenaList.add(newArena);
                                }

                                // Else, cancel

                                else p.sendMessage(ChatColor.RED + "No arena with this ID exists.");
                            }
                        }

                        // In future, check arena state and maxPlayers

                    }
                }
            }

        }
    }
}

}
