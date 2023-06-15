package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Lure extends SBEnchantment {
    public Lure(int level) {
        super(10, "Lure", level);
    }

    public double getMaximumCatchTimeDepletionModifier() {
        return getLevel() * Statistic.fromPercentage(5);
    }
}
