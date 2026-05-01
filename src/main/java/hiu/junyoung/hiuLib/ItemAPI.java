package hiu.junyoung.hiuLib;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemAPI {

    public static ItemStack editCustomModelData(ItemStack item, int num) {
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(num);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack editItemStack(ItemStack item, String displayName) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack editItemStack(ItemStack item, String displayName, List<String> lores) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createItemStack(Material type, int amount, String displayName) {
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createItemStack(Material type, int amount, String displayName, List<String> lores) {
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }
}
