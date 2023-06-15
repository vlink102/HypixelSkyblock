package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Looting extends SBEnchantment {
    public Looting(int level) {
        super(8, "Looting", level);
    }

    public double getItemDropChanceModifier() {
        return getLevel() * Statistic.fromPercentage(15);
    }
}
