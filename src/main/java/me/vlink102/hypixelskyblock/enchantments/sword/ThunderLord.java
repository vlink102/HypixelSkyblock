package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class ThunderLord extends SBEnchantment {
    public ThunderLord(int level) {
        super(41, "Thunderlord", level, 40L);
    }

    public static List<Integer> THUNDERLORD_DAMAGE_VALUES = Arrays.asList(8, 16, 24, 32, 40, 50, 60);

    public double getDamageModifier() {
        return Statistic.fromPercentage(THUNDERLORD_DAMAGE_VALUES.get(getLevel() - 1));
    }
}
