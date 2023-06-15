package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class Lethality extends SBEnchantment {
    public Lethality(int level) {
        super(29, "Lethality", level);
    }

    public static List<Double> LETHALITY_DEFENSE_DEPLETION_VALUES = Arrays.asList(1.2d, 2.4d, 3.6d, 4.8d, 6d, 9d);

    public double getDefenseReductionModifier() {
        return Statistic.fromPercentage(LETHALITY_DEFENSE_DEPLETION_VALUES.get(getLevel() - 1));
    }
}
