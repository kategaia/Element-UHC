package com.elementuhc.mode;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class FFA implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Ex: envoyer un message FFA
        event.getPlayer().sendMessage("Bienvenue en mode FFA !");
    }

    // Ici tu mets tout le code spécifique au mode FFA
}
