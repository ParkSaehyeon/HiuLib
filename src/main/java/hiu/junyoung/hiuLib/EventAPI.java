package hiu.junyoung.hiuLib;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;

public class EventAPI {
    private static ArrayList<Player> rightClickCool = new ArrayList<>();

    public static boolean isRightClickEvent(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if(e.getHand() != EquipmentSlot.OFF_HAND) {

                if(!rightClickCool.contains(e.getPlayer())) {

                    rightClickCool.add(e.getPlayer());

                    Bukkit.getScheduler().runTaskLater(Main.ins, () -> {
                        if(rightClickCool.contains(e.getPlayer())) {
                            rightClickCool.remove(e.getPlayer());
                        }
                    }, 2L);

                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    public static String getInventoryTitle(InventoryCloseEvent e) {
        return e.getView().getTitle();
    }

    public static String getInventoryTitle(InventoryOpenEvent e) {
        return e.getView().getTitle();
    }

    public static String getInventoryTitle(InventoryClickEvent e) {
        return e.getView().getTitle();
    }
}
