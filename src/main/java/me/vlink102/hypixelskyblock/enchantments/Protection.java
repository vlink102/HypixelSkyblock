package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class Protection extends SBEnchantment {
    public Protection(int level) {
        super(78, "Protection", level, 70L, 77L, 72L);
    }

    public static List<Integer> PROTECTION_DEFENSE_VALUES = Arrays.asList(4, 8, 12, 16, 20, 25, 30);

    public double getDefenseAdditive() {
        return Statistic.fromPercentage(PROTECTION_DEFENSE_VALUES.get(getLevel() - 1));
    }
}
