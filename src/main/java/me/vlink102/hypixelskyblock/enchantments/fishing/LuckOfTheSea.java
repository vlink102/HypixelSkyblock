package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class LuckOfTheSea extends SBEnchantment {
    public LuckOfTheSea(int level) {
        super(9, "Luck of the Sea", level);
    }

    public double getFishingTreasureChanceModifier() {
        return getLevel() * Statistic.fromPercentage(1);
    }
}
