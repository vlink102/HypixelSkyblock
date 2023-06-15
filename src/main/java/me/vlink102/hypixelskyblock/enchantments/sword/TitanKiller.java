package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class TitanKiller extends SBEnchantment {
    public TitanKiller(int level) {
        super(42, "Titan Killer", level, 26L);
    }

    public static List<Integer> TITAN_KILLER_DAMAGE_VALUES = Arrays.asList(2, 4, 6, 8, 12, 16, 20);
    public static List<Integer> TITAN_KILLER_MAX_DEFENSE_VALUES = Arrays.asList(6, 12, 18, 24, 40, 60, 80);

    public double getDamageModifier(double defense) {
        return Math.min((defense / 100) * Statistic.fromPercentage(TITAN_KILLER_DAMAGE_VALUES.get(getLevel() - 1)), Statistic.fromPercentage(TITAN_KILLER_MAX_DEFENSE_VALUES.get(getLevel() - 1)));
    }
}
