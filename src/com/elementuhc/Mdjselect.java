package com.elementuhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Mdjselect {





    private void openPlayerInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.YELLOW + "Choisissez le mode de jeu");
        ItemStack ffa = new ItemStack(Material.DIAMOND_SWORD,1);
        ItemMeta ffameta = ffa.getItemMeta();
        if (ffameta !=null) {
            ffameta.setDisplayName("Element UHC FFA");
            ffa.setItemMeta(ffameta);
        }
        inventory.setItem(3,ffa);

        ItemStack To2 = new ItemStack(Material.BANNER, 1);
        ItemMeta to2meta = To2.getItemMeta();
        if (to2meta != null) {
            to2meta.setDisplayName("Element UHC To2");
            To2.setItemMeta(to2meta);
        }
        inventory.setItem(5,To2);

        ItemStack strat = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta stratmeta = strat.getItemMeta();
        if (stratmeta != null) {
            stratmeta.setDisplayName("Element UHC Stratégique");
            strat.setItemMeta(stratmeta);
        }
        inventory.setItem(7,strat);

        player.openInventory(inventory);
    }
}
