package com.elementuhc;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CmdStart implements CommandExecutor {

    private final Main plugin;

    public CmdStart(Main plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        switch (plugin.getCurrentMode()) {
            case FFA:
                sender.sendMessage(ChatColor.GREEN + "Lancement du mode FFA...");
                plugin.loadFFA();
                break;
            case TO2:
                sender.sendMessage(ChatColor.GREEN + "Lancement du mode To2...");
                plugin.loadTo2();
                break;
            case STRATEGIQUE:
                sender.sendMessage(ChatColor.GREEN + "Lancement du mode Stratégique...");
                plugin.loadStrategique();
                break;
            case NONE:
            default:
                sender.sendMessage(ChatColor.RED + "Aucun mode de jeu sélectionner !");
                break;
        }
        return true;
    }
}
