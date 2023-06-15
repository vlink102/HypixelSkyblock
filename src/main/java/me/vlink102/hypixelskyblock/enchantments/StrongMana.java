package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.util.Statistic;

public class StrongMana extends SBEnchantment {
    public StrongMana(int level) {
        super(82, "Strong Mana", level, 74L, 71L, 76L);
    }

    public double getManaToStrengthModifier(double manaUsed) {
        return Math.min(100, manaUsed * getLevel() * Statistic.fromPercentage(0.1));
    }
}
