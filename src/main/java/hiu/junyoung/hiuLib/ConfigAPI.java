package hiu.junyoung.hiuLib;

import it.unimi.dsi.fastutil.Hash;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class ConfigAPI {

    private static HashMap<Plugin, HashMap<String, YamlConfiguration>> loadedConfigFiles = new HashMap<>();

    private static YamlConfiguration getConfig(Plugin plugin, String configFileName) {
        if(!loadedConfigFiles.containsKey(plugin)) {
            return new YamlConfiguration();
        }

        if(!loadedConfigFiles.get(plugin).containsKey(configFileName)) {
            return loadConfig(plugin, configFileName);
        }

        return loadedConfigFiles.get(plugin).get(configFileName);
    }

    private static File getPluginConfigDir(Plugin plugin) {
        return Paths.get(Main.ins.getDataFolder().getAbsolutePath(), "..", plugin.getName()).toFile();
    }

    private static boolean setupConfigDir(Plugin plugin) {
        if(!getPluginConfigDir(plugin).exists()) {
            if( getPluginConfigDir(plugin).mkdir() ) {
                Main.ins.getLogger().info(plugin.getName()+" 플러그인 설정 폴더를 생성했습니다.");
            } else {
                Main.ins.getLogger().warning(plugin.getName()+" 플러그인 설정 폴더를 생성하지 못했습니다. 작업이 취소되었습니다.");
                return false;
            }
        }

        return true;
    }

    public static File getConfigFile(Plugin plugin, String fileName) {
        return new File(getPluginConfigDir(plugin), fileName);
    }

    public static YamlConfiguration saveConfig(Plugin plugin, String fileName) {

        if(!setupConfigDir(plugin)) {
            return null;
        }

        if(getConfig(plugin, fileName) == null) {
            Main.ins.getLogger().warning(plugin.getName()+"(이)라는 플러그인의 설정 파일 \""+fileName+"\"(은)는 존재하지 않습니다. 설정 저장을 건너뜁니다.");
            return null;
        }

        YamlConfiguration yml = getConfig(plugin, fileName);

        try {
            yml.save(getConfigFile(plugin, fileName));
            return yml;
        } catch (Exception e) {
            Main.ins.getLogger().warning(plugin.getName()+"(이)라는 플러그인의 설정 파일 \""+fileName+"\"(을)를 저장하지 못했습니다.");
            e.printStackTrace();
            return null;
        }
    }

    public static void setObject(Plugin plugin, String fileName, String key, Object value) {
        getConfig(plugin, fileName).set(key, value);
    }

    public static Object getObject(Plugin plugin, String fileName, String key) {
        return getConfig(plugin, fileName).get(key);
    }

    public static Object getObject(Plugin plugin, String fileName, String key, Object def) {
        return getConfig(plugin, fileName).get(key, def);
    }

    //////////////////////  문자열

    public static void setString(Plugin plugin, String fileName, String key, String value) {
        getConfig(plugin, fileName).set(key, value);
    }

    public static String getString(Plugin plugin, String fileName, String key) {
        return getConfig(plugin, fileName).getString(key);
    }

    public static String getString(Plugin plugin, String fileName, String key, String def) {
        if(getConfig(plugin, fileName) == null) {
            return def;
        }

        return getConfig(plugin, fileName).getString(key, def);
    }

    //////////////////////  정수

    public static void setInteger(Plugin plugin, String fileName, String key, int value) {
        getConfig(plugin, fileName).set(key, value);
    }

    public static int getInteger(Plugin plugin, String fileName, String key) {
        return getConfig(plugin, fileName).getInt(key);
    }

    public static int getInteger(Plugin plugin, String fileName, String key, int def) {
        if(getConfig(plugin, fileName) == null) {
            return def;
        }

        return getConfig(plugin, fileName).getInt(key, def);
    }

    //////////////////////  Boolean

    public static void setBoolean(Plugin plugin, String fileName, String key, boolean value) {
        getConfig(plugin, fileName).set(key, value);
    }

    public static boolean getBoolean(Plugin plugin, String fileName, String key) {
        return getConfig(plugin, fileName).getBoolean(key);
    }

    public static boolean getBoolean(Plugin plugin, String fileName, String key, boolean def) {
        if(getConfig(plugin, fileName) == null) {
            return def;
        }

        return getConfig(plugin, fileName).getBoolean(key, def);
    }

    //////////////////////  Location

    public static void setLocation(Plugin plugin, String fileName, String key, Location value) {
        getConfig(plugin, fileName).set(key, value);
    }

    public static Location getLocation(Plugin plugin, String fileName, String key) {
        return getConfig(plugin, fileName).getLocation(key);
    }

    public static Location getLocation(Plugin plugin, String fileName, String key, Location def) {
        if(getConfig(plugin, fileName) == null) {
            return def;
        }

        return getConfig(plugin, fileName).getLocation(key, def);
    }



    public static YamlConfiguration loadConfig(Plugin plugin, String fileName) {

        if(!setupConfigDir(plugin)) {
            return null;
        }

        YamlConfiguration yml = new YamlConfiguration();

        try {
            if(!getConfigFile(plugin, fileName).exists()) {
                if(!getConfigFile(plugin, fileName).createNewFile()) {
                    Main.ins.getLogger().warning(plugin.getName()+"(이)라는 플러그인의 설정 파일 \""+fileName+"\" 생성에 실패하였습니다.");
                    return null;
                }
            }

            yml.load(getConfigFile(plugin, fileName));

            loadedConfigFiles.putIfAbsent(plugin, new HashMap<>());
            loadedConfigFiles.get(plugin).put(fileName, yml);

            return yml;
        } catch (Exception e) {
            Main.ins.getLogger().warning(plugin.getName()+"(이)라는 플러그인의 설정 파일 \""+fileName+"\"(을)를 로드하지 못했습니다.");
            e.printStackTrace();
            return null;
        }
    }

}
