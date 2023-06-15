package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Smoldering extends SBEnchantment {
    public Smoldering(int level) {
        super(37, "Smoldering", level);
    }

    public double getBlazeDamageModifier() {
        return getLevel() * Statistic.fromPercentage(3);
    }
}
