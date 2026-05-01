package hiu.junyoung.hiuLib;

import org.bukkit.Location;

public class Stringify {
    public static String getLocationString(Location location) {
        double x = Math.round(location.getX() * 100) / 100.0;
        double y = Math.round(location.getY() * 100) / 100.0;
        double z = Math.round(location.getZ() * 100) / 100.0;

        return location.getWorld().getName()+", "+x+", "+y+", "+z;
    }
}
