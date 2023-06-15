package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class Critical extends SBEnchantment {
    public Critical(int level) {
        super(17, "Critical", level);
    }

    public static List<Integer> CRITICAL_DAMAGE_VALUES = Arrays.asList(10, 20, 30, 40, 50, 70, 100);

    public double getCriticalDamageModifier() {
        return Statistic.fromPercentage(CRITICAL_DAMAGE_VALUES.get(getLevel() - 1));
    }
}
