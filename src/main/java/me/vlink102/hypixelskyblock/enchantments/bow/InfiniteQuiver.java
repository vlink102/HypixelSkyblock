package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class InfiniteQuiver extends SBEnchantment {
    public InfiniteQuiver(int level) {
        super(58, "Infinite Quiver", level);
    }

    public double getArrowSaveModifier() {
        return getLevel() * Statistic.fromPercentage(3);
    }
}
