package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class ThunderBolt extends SBEnchantment {
    public ThunderBolt(int level) {
        super(40, "Thunderbolt", level, 41L);
    }

    public static List<Integer> THUNDERBOLT_DAMAGE_VALUES = Arrays.asList(4, 8, 12, 16, 20, 25);

    public double getDamageModifier() {
        return Statistic.fromPercentage(THUNDERBOLT_DAMAGE_VALUES.get(getLevel() - 1));
    }
}
