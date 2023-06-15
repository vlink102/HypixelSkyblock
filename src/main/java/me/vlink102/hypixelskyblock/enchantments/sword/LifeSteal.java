package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class LifeSteal extends SBEnchantment {
    public LifeSteal(int level) {
        super(30, "Life Steal", level, 38L, 32L);
    }

    public double getHealModifier() {
        return getLevel() * Statistic.fromPercentage(0.5);
    }
}
