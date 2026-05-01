package hiu.junyoung.hiuLib;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main ins;

    @Override
    public void onEnable() {
        getLogger().info("\n\n\t히유 라이브러리 활성화! ( •̀ ω •́ )✧\n");
        ins = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
