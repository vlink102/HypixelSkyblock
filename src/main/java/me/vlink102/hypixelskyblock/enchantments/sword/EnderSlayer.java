package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class EnderSlayer extends SBEnchantment {
    public EnderSlayer(int level) {
        super(21, "Ender Slayer", level);
    }

    public static List<Integer> ENDER_SLAYER_DAMAGE_VALUES = Arrays.asList(15, 30, 45, 60, 80, 100, 130);

    public double getEndDamageModifier() {
        return Statistic.fromPercentage(ENDER_SLAYER_DAMAGE_VALUES.get(getLevel() - 1));
    }
}
