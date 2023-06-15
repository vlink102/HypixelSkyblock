package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Impaling extends SBEnchantment {
    public Impaling(int level) {
        super(27, "Impaling", level);
    }

    public double getDamageDealtModifier() {
        return getLevel() * Statistic.fromPercentage(25);
    }
}
