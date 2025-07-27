package com.elementuhc.mode;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class To2 implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Bienvenue en mode To2 !");
    }

    // Ici tu mets tout le code spécifique au mode To2
}
