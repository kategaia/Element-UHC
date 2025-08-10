package com.elementuhc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdMdj implements CommandExecutor {

    private final Mdjselect mdjselect;

    public CmdMdj(Mdjselect mdjselect) {
        this.mdjselect = mdjselect;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Cette commande doit être éxécuter par un joueur");
            return true;
        }

        Player player = (Player) sender;
        mdjselect.openPlayerInventory(player);
        return true;
    }
}
