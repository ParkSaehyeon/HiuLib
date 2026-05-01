package hiu.junyoung.hiuLib;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerAPI {

    /**
     * 플레이어에게 특정 itemstack과 동일한 display name의 아이템을 amount 만큼 가지고 있는지 여부를 반환
     */
    public static boolean hasItemByName(Player player, String displayName, int amount) {
        int count = 0;
        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) continue;
            if (item.getItemMeta().getDisplayName().equals(displayName)) {
                count += item.getAmount();
            }
        }
        return count >= amount;
    }

    /**
     * 플레이어에게 특정 itemstack과 동일한 display name의 아이템을 amount 만큼 가지고 있는지 여부를 반환
     */
    public static boolean hasItemByName(Player player, ItemStack item, int amount) {
        if(!item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
            return false;
        }

        return hasItemByName(player, item.getItemMeta().getDisplayName(), amount);
    }

    public static boolean hasItemByType(Player player, Material type, int amount) {
        int count = 0;
        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null || item.getType() != type) continue;
            count += item.getAmount();
        }
        return count >= amount;
    }

    public static String getDisplayName(ItemStack item) {
        if(!item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
            return "";
        }

        return item.getItemMeta().getDisplayName();
    }

    public static boolean hasItemByType(Player player, ItemStack item, int amount) {
        return hasItemByType(player, item.getType(), amount);
    }

    public static void playSound(Player player, Sound sound, SoundCategory category,  float vol, float pitch) {
        player.playSound(player.getLocation(), sound, category, pitch, vol);
    }

    public static void playSoundByPlayers(List<Player> players, Sound sound, SoundCategory category, float vol, float pitch) {
        players.forEach(p -> {
            p.playSound(p.getLocation(), sound, category, pitch, vol);
        });
    }

    public static void sendTitleByPlayers(List<Player> players, String title, String subtitle) {
        players.forEach(p -> {
            p.sendTitle(title, subtitle);
        });
    }

    public static void sendTitleByPlayers(List<Player> players, String title, String subtitle, int fadein, int stay, int fadeout) {
        players.forEach(p -> {
            p.sendTitle(title, subtitle, fadein, stay, fadeout);
        });
    }

    public static void sendSubtitle(Player player, String subtitle) {
        player.sendTitle("", subtitle);
    }

    public static void sendSubtitle(Player player, String subtitle, int fadein, int stay, int fadeout) {
        player.sendTitle("", subtitle, fadein, stay, fadeout);
    }
}
