package com.elementuhc;

import com.elementuhc.mode.FFA;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KillRewardManager implements Listener {

    private final RoleManager roleManager;


    public KillRewardManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    public void handlekill(Player killer, Player killed, int kills) {
        Role KillerRole = roleManager.getRole(killer);
        Role KilledRole = roleManager.getRole(killed);

        if(kills == 1 || kills == 2) {
            giveEffect(killer, KillerRole, KilledRole,kills);
        }

        if(kills == 3) {
            Surfusion(killer, KillerRole);
        }
    }

    private void giveEffect(Player killer, Role KillerRole, Role KilledRole, int kills) {
        if(FFA.getSpeedRoles().contains(KilledRole.getType())) {
            if(FFA.getSpeedRoles().contains(KillerRole.getType()) || killer.hasPotionEffect(PotionEffectType.SPEED)) {
                killer.removePotionEffect(PotionEffectType.SPEED);
                killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, kills, false, false));
            } else {
                killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, false, false));
            }

        } else if(FFA.getResiRoles().contains(KilledRole.getType())) {
            if(FFA.getResiRoles().contains(KillerRole.getType()) || killer.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
                killer.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                killer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, kills, false, false));
            } else {
                killer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0, false, false));
            }
        } else if(FFA.getStrengthRoles().contains(KilledRole.getType())) {
            if(FFA.getStrengthRoles().contains(KillerRole.getType()) || killer.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
                killer.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                killer.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, kills, false, false));
            } else {
                killer.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0, false, false));
            }
        } else if(FFA.getHealthboostRoles().contains(KilledRole.getType())) {
            if(FFA.getHealthboostRoles().contains(KillerRole.getType()) || killer.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) {
                killer.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                killer.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, kills, false, false));
            } else {
                killer.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 0, false, false));
            }
        }
    }

    private void Surfusion(Player killer, Role KillerRole) {
        clearAllPotionEffects(killer);
        if(FFA.getSpeedRoles().contains(KillerRole.getType())) {
            killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 3, false, false));
        } else if(FFA.getResiRoles().contains(KillerRole.getType())) {
            killer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 3, false, false));
        } else if(FFA.getStrengthRoles().contains(KillerRole.getType())) {
            killer.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 3, false, false));
        } else if(FFA.getHealthboostRoles().contains(KillerRole.getType())) {
            killer.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 3, false, false));
        }
    }

    public void clearAllPotionEffects (Player player) {
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
    }

}
