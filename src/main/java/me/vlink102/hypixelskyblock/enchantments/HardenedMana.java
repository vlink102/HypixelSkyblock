package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.util.Statistic;

public class HardenedMana extends SBEnchantment {
    public HardenedMana(int level) {
        super(74, "HardenedMana", level, 71L, 76L, 82L);
    }

    public double getDefenseModifier(double manaUsed) {
        return Math.min(400, manaUsed * getLevel() * Statistic.fromPercentage(0.1));
    }
}
