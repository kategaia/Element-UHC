package com.elementuhc;

import org.bukkit.entity.Player;

public interface RoleEffectModifier {
    void applyEffects(Player player, RoleType type);
}
