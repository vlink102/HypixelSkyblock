package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class ManaSteal extends SBEnchantment {
    public ManaSteal(int level) {
        super(32, "Mana Steal", level, 38L, 30L);
    }

    public double getManaRegainModifier() {
        return getLevel() * Statistic.fromPercentage(0.25);
    }
}
