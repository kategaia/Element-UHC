package com.elementuhc.mode;

import com.elementuhc.RoleManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class To2 implements Listener {

    private RoleManager roleManager;

    public To2(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Bienvenue en mode To2 !");
    }
    // Ici tu mets tout le code spécifique au mode To2
}
