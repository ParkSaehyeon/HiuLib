package hiu.junyoung.hiuLib;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
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

    public static ItemStack removeDefaultLores(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_PLACED_ON);
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

    public static String getDisplayName(ItemStack item) {
        if(!item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) {
            return "";
        }

        return item.getItemMeta().getDisplayName();
    }

    public static List<String> getLores(ItemStack item) {
        if(!item.hasItemMeta() || !item.getItemMeta().hasLore()) {
            return Arrays.asList();
        }

        return item.getItemMeta().getLore();
    }
}
