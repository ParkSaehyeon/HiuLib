package hiu.junyoung.hiuLib;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("HIU API!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
