package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class Smite extends SBEnchantment {
    public Smite(int level) {
        super(36L, "Smite", level, 35L, 15L);
    }

    public static List<Integer> SMITE_DAMAGE_VALUES = Arrays.asList(10, 20, 30, 40, 60, 80, 100);

    public double getDamageModifier() {
        return Statistic.fromPercentage(SMITE_DAMAGE_VALUES.get(getLevel() - 1));
    }
}
