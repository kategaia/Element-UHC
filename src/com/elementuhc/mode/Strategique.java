package com.elementuhc.mode;

import com.elementuhc.RoleManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Strategique implements Listener {

    private RoleManager roleManager;

    public Strategique(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Ex: envoyer un message FFA
        event.getPlayer().sendMessage("Bienvenue en mode Stratégique !");
    }

    // Ici tu mets tout le code spécifique au mode Stratégique
}
