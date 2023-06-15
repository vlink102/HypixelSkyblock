package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class Sharpness extends SBEnchantment {
    public Sharpness(int level) {
        super(35, "Sharpness", level, 15L, 36L);
    }

    public static List<Integer> SHARPNESS_PERCENTAGE_VALUES = Arrays.asList(5, 10, 15, 20, 30, 45, 65);

    public double getDamageModifier() {
        return Statistic.fromPercentage(SHARPNESS_PERCENTAGE_VALUES.get(getLevel() - 1));
    }
}
