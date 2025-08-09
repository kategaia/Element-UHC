package com.elementuhc.mode;

import com.elementuhc.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

import static com.elementuhc.RoleType.Azote;

public class FFA implements Listener, RoleEffectModifier {

    private final RoleManager roleManager;

    private final Map<UUID, Integer> killerKillCount = new HashMap<>();

    private final KillRewardManager killRewardManager;

    public FFA(RoleManager roleManager, KillRewardManager killRewardManager) {
        this.roleManager = roleManager;
        this.killRewardManager = killRewardManager;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Ex: envoyer un message FFA
        event.getPlayer().sendMessage("Bienvenue en mode FFA !");
    }

    private static final Set<RoleType> SPEED_ROLES = EnumSet.of(
      RoleType.Hydrogene,
      RoleType.Helium,
      RoleType.Azote,
      RoleType.Oxygene,
      RoleType.Fluor,
      RoleType.Neon,
      RoleType.Chlore,
      RoleType.Argon,
      RoleType.Krypton,
      RoleType.Xenon,
      RoleType.Radon,
      RoleType.Carbone,
      RoleType.Phosphore,
      RoleType.Soufre,
      RoleType.Selenium,
      RoleType.Iode,
      RoleType.Brome,
      RoleType.Astate,
      RoleType.Bore,
      RoleType.Silicium,
      RoleType.Germanium,
      RoleType.Arsenic,
      RoleType.Antimoine,
      RoleType.Tellure,
      RoleType.Polonium,
      RoleType.Oganesson
    );

    private static final Set<RoleType> RESI_ROLES = EnumSet.of(
     RoleType.Lithium,
     RoleType.Beryllium,
     RoleType.Sodium,
     RoleType.Magnesium,
     RoleType.Aluminium,
     RoleType.Potassium,
     RoleType.Calcium,
     RoleType.Scandium,
     RoleType.Titane,
     RoleType.Vanadium,
     RoleType.Chrome,
     RoleType.Manganese,
     RoleType.Zinc,
     RoleType.Galium,
     RoleType.Strontium,
     RoleType.Yttrium,
     RoleType.Zirconium,
     RoleType.Niobium,
     RoleType.Molybdene,
     RoleType.Ruthenium,
     RoleType.Rhodium,
     RoleType.Palladium,
     RoleType.Cadium,
     RoleType.Indium,
     RoleType.Etain,
     RoleType.Thallium,
     RoleType.Baryum
    );

    private static final Set<RoleType> STRENGTH_ROLES = EnumSet.of(
     RoleType.Fer,
     RoleType.Cobalt,
     RoleType.Nickel,
     RoleType.Cuivre,
     RoleType.Argent,
     RoleType.Or,
     RoleType.Mercure,
     RoleType.Plomb,
     RoleType.Bismuth,
     RoleType.Tungstene,
     RoleType.Platine,
     RoleType.Iridium,
     RoleType.Osmium,
     RoleType.Rhenium,
     RoleType.Tantale,
     RoleType.Hafnium,
     RoleType.Rutherfordium,
     RoleType.Dubnium,
     RoleType.Seaborgium,
     RoleType.Bohrium,
     RoleType.Hassium,
     RoleType.Meitnerium,
     RoleType.Darmstadtium,
     RoleType.Roentgenium,
     RoleType.Copernicium,
     RoleType.Nihonium,
     RoleType.Flerovium,
     RoleType.Moscovium,
     RoleType.Livermorium,
     RoleType.Tennesse
    );

    private static final Set<RoleType> HEALTHBOOST_ROLES = EnumSet.of(
      RoleType.Lanthane,
      RoleType.Cerium,
      RoleType.Praseodyme,
      RoleType.Neodyme,
      RoleType.Promethium,
      RoleType.Samarium,
      RoleType.Europium,
      RoleType.Gadolinium,
      RoleType.Terbium,
      RoleType.Dysprosium,
      RoleType.Holmium,
      RoleType.Erbium,
      RoleType.Thulium,
      RoleType.Ytterbium,
      RoleType.Lutecium,
      RoleType.Thorium,
      RoleType.Protactinium,
      RoleType.Uranium,
      RoleType.Neptunium,
      RoleType.Plutonium,
      RoleType.Americium,
      RoleType.Curium,
      RoleType.Berkelium,
      RoleType.Californium,
      RoleType.Einsteinium,
      RoleType.Fermium,
      RoleType.Mendelevium,
      RoleType.Nobelium,
      RoleType.Lawrencium,
      RoleType.Francium,
      RoleType.Radium,
      RoleType.Actinium,
      RoleType.Technetium
      );


    public static Set<RoleType> getSpeedRoles() {
        return SPEED_ROLES;
    }

    public static Set<RoleType> getResiRoles() {
        return RESI_ROLES;
    }

    public static Set<RoleType> getStrengthRoles() {
        return STRENGTH_ROLES;
    }

    public static Set<RoleType> getHealthboostRoles() {
        return HEALTHBOOST_ROLES;
    }

    @Override
    public void applyEffects(Player player, RoleType role ) {

        if(SPEED_ROLES.contains(role)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0));
        }
        if(RESI_ROLES.contains(role)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0));
        }
        if(STRENGTH_ROLES.contains(role)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
        }
        if(HEALTHBOOST_ROLES.contains(role)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 0));
        }

    }

    public void StartGame() {
        roleManager.prepareRoles();
        for (Player player : org.bukkit.Bukkit.getOnlinePlayers()) {
            roleManager.assignNextRole(player);
            Role role = roleManager.getRole(player);
            applyEffects(player, role.getType());
        }
    }

    @EventHandler
    public void OnPlayerKill(PlayerDeathEvent event) {
        Player killed = event.getEntity();
        Player killer = killed.getKiller();

        if (killer == null) return;

        int kills = killerKillCount.getOrDefault(killer.getUniqueId(),0) +1;
        killerKillCount.put(killer.getUniqueId(), kills);

        killRewardManager.handlekill(killer, killed, kills);
    }



    // Ici tu mets tout le code spécifique au mode FFA
}
