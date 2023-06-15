package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class Cubism extends SBEnchantment {
    public Cubism(int level) {
        super(18, "Cubism", level);
    }

    public static List<Integer> CUBISM_DAMAGE_VALUES = Arrays.asList(10, 20, 30, 40, 60, 80);

    public double getDamageModifier() {
        return Statistic.fromPercentage(CUBISM_DAMAGE_VALUES.get(getLevel() - 1));
    }
}
