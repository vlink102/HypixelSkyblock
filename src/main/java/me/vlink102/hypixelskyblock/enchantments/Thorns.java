package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Thorns extends SBEnchantment {
    public Thorns(int level) {
        super(83, "Thorns", level, 90L);
    }

    public double getDamageReboundModifier() {
        return getLevel() * Statistic.fromPercentage(3);
    }
}
