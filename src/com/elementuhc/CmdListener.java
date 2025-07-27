package com.elementuhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CmdListener implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "/em <subcommand> ");
            return false;
        }

        if (args[0].equalsIgnoreCase("config")) {
            configcommand(sender);
            return true;
        }
        return false;
    }

    private void configcommand(CommandSender sender) {
        Player player = (Player) sender;
        ItemStack config = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta configmeta = config.getItemMeta();
        if (configmeta !=null) {
            configmeta.setDisplayName("Configuration");
            config.setItemMeta(configmeta);
        }
        player.getInventory().addItem(config);
    }

}
