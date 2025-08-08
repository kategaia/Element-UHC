package com.elementuhc.mode;

import com.elementuhc.RoleEffectModifier;
import com.elementuhc.RoleManager;
import com.elementuhc.RoleType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.management.relation.Role;
import java.util.EnumSet;
import java.util.Set;

import static com.elementuhc.RoleType.Azote;

public class FFA implements Listener, RoleEffectModifier {

    private final RoleManager roleManager;

    public FFA(RoleManager roleManager) {
        this.roleManager = roleManager;
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

    @Override
    public void applyEffects(Player player, RoleType type) {



        switch (type) {

        }

    }

    // Ici tu mets tout le code spécifique au mode FFA
}
