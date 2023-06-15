package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class GiantKiller extends SBEnchantment {
    public GiantKiller(int level) {
        super(26, "Giant Killer", level, 42L);
    }

    public static List<Double> GIANT_KILLER_DAMAGE_VALUES = Arrays.asList(0.1D, 0.2D, 0.3D, 0.4D, 0.6D, 0.9D, 1.2D);
    public static List<Double> GIANT_KILLER_TARGET_HEALTH_PERCENTAGES = Arrays.asList(5d, 10d, 15d, 20d, 30d, 45d, 65d);

    public double getGiantKillerDamageDealtModifier(double health, double maxHealth, double playerHealth) {
        return Math.min(((health - playerHealth) / playerHealth) * Statistic.fromPercentage(GIANT_KILLER_DAMAGE_VALUES.get(getLevel() - 1)), Statistic.fromPercentage(GIANT_KILLER_TARGET_HEALTH_PERCENTAGES.get(getLevel() - 1)));
    }
}
