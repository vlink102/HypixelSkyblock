package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class Power extends SBEnchantment {
    public Power(int level) {
        super(61, "Power", level);
    }

    public static List<Integer> POWER_DAMAGE_MODIFIER = Arrays.asList(8, 16, 24, 32, 40, 50, 65);

    public double getDamageModifier() {
        return Statistic.fromPercentage(POWER_DAMAGE_MODIFIER.get(getLevel() - 1));
    }
}
