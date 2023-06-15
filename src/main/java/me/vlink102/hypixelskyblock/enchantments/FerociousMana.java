package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.util.Statistic;

public class FerociousMana extends SBEnchantment {
    public FerociousMana(int level) {
        super(71, "Ferocious Mana", level, 74L, 82L, 76L);
    }

    public double getManaToFerocityModifier(double manaUsed) {
        return Math.min(50, manaUsed * getLevel() * Statistic.fromPercentage(0.05));
    }
}
