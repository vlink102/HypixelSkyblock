package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class Prosecute extends SBEnchantment {
    public Prosecute(int level) {
        super(33, "Prosecute", level, 22L);
    }

    public static List<Double> PROSECUTE_DAMAGE_DEALT_VALUES = Arrays.asList(0.1d, 0.2d, 0.3d, 0.4d, 0.7d, 1d);

    public double getDamageDealtModifier(double health, double maxHealth) {
        return (health / maxHealth) * Statistic.fromPercentage(PROSECUTE_DAMAGE_DEALT_VALUES.get(getLevel() - 1));
    }
}
