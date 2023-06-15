package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class TripleStrike extends SBEnchantment {
    public TripleStrike(int level) {
        super(43, "Triple-Strike", level, 25L);
    }

    public double getDamageModifier() {
        return getLevel() * Statistic.fromPercentage(10);
    }
}
