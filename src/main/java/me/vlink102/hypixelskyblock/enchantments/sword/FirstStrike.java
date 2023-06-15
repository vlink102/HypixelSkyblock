package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class FirstStrike extends SBEnchantment {
    public FirstStrike(int level) {
        super(25, "First Strike", level, 43L);
    }

    public double getFirstStrikeDamageModifier() {
        return getLevel() * Statistic.fromPercentage(25);
    }
}
