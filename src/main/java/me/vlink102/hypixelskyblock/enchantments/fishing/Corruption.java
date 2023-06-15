package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Corruption extends SBEnchantment {
    public Corruption(int level) {
        super(5, "Corruption", level);
    }

    public double getCorruptedSeaCreatureChanceModifier() {
        return getLevel() * Statistic.fromPercentage(1);
    }
}
