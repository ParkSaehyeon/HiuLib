package hiu.junyoung.hiuLib;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationUtil {
    public static boolean xyzEquals(Location loc1, Location loc2) {
        return loc1.getX() == loc2.getX() && loc1.getY() == loc2.getY() && loc1.getZ() == loc2.getZ();
    }

    public static boolean containsLocationXYZ(List<Location> arr, Location location) {
        for(Location l : arr) {
            if(xyzEquals(l, location)) {
                return true;
            }
        }

        return false;
    }

    public static List<Location> removeBlockLocation(List<Location> arr, Location blockLoc) {
        double x = Math.round(blockLoc.getX() * 100) / 100.0;
        double y = Math.round(blockLoc.getY() * 100) / 100.0;
        double z = Math.round(blockLoc.getZ() * 100) / 100.0;

        List<Location> newArr = new ArrayList<>();

        for(Location l : arr) {
            if(l.getX() == x && l.getY() == y && l.getZ() == z) {
                continue;
            }

            newArr.add(l);
        }

        return newArr;
    }
}
