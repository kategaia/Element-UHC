package com.elementuhc.mode;

import com.elementuhc.Role;
import com.elementuhc.RoleManager;
import com.elementuhc.RoleType;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class FFA implements Listener {

    private RoleManager roleManager;

    public FFA(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Ex: envoyer un message FFA
        event.getPlayer().sendMessage("Bienvenue en mode FFA !");
    }

    @EventHandler
    public void onPlayerUsePower(PlayerInteractEvent event) {
        Role role = roleManager.getRole(event.getPlayer());

        if(role == null){
            event.getPlayer().sendMessage("Vous n'avez pas de rôle !");
            return;
        }

        if (role.getType() == RoleType.Hydrogene) {
            // définir les pouvoirs pour le mode FFA (vas surement être modifier)
        }
    }

    // Ici tu mets tout le code spécifique au mode FFA
}
