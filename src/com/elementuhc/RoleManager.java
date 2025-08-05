package com.elementuhc;

import org.bukkit.entity.Player;

import java.util.*;

public class RoleManager {
    private final Map<Player, Role> playerRoles = new HashMap<>();
    private final Queue<RoleType> shuffledRoles = new LinkedList<>();

    public void prepareRoles() {
        List<RoleType> roles = new ArrayList<>(List.of(RoleType.values()));
        Collections.shuffle(roles);
        shuffledRoles.clear();
        shuffledRoles.addAll(roles);
    }

    public void assignNextRole(Player player) {
        if(shuffledRoles.isEmpty()) {
            return;
        }

        RoleType type = shuffledRoles.poll();
        Role role = new Role(type);
        playerRoles.put(player, role);
        player.sendMessage("§a Votre rôle : §e" + role.getName());
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
