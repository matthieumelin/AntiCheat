package fr.geeklegend.ac.utilities;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerUtils {
    public static int getPotionLevel(Player player, PotionEffectType potionEffectType) {
        for (PotionEffect potionEffect : player.getActivePotionEffects()) {
            if (potionEffect.getType().getName().equalsIgnoreCase(potionEffectType.getName())) {
                return potionEffect.getAmplifier() + 1;
            }
        }
        return 0;
    }
}
