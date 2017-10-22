package github.anarchistdev.minigame.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GeneralUtils {

    public static boolean isInt(String s) {
        boolean isInt = true;

        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            isInt = false;
        }

        return isInt;
    }

    public static boolean isInt(String s, Player p) {
        boolean isInt = true;

        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            printHelp(p);
            isInt = false;
        }

        return isInt;
    }


    public static void printHelp(Player p) {

        p.sendMessage(ChatColor.RED + "Commands:" + ChatColor.WHITE + "" +
                "\n  /mg create <ID> <name>" +
                "\n  /mg delete <ID>" +
                "\n  /mg list" +
                "\n  /mg pos1" +
                "\n  /mg pos2");

    }

}
