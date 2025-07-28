package com.elementuhc;

import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RoleManager {
    private Map<Player, Role> playerRoles = new HashMap<>();

    public void assignRole(Player player, RoleType type) {
        Role role = new Role(type);
        playerRoles.put(player, role);
        player.sendMessage("§aVotre rôle : §e" + role.getName());
        player.sendMessage("§7" + role.getDescription());
    }

    public Role getRole(Player player) {
        return playerRoles.get(player);
    }

    public boolean hasRole(Player player) {
        return playerRoles.containsKey(player);
    }

    public void clearRoles(){
        playerRoles.clear();
    }
}
