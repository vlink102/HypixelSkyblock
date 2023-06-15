package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Charm extends SBEnchantment {
    public Charm(int level) {
        super(4, "Charm", level);
    }

    public double getTrophyFishChanceModifier() {
        return getLevel() * Statistic.fromPercentage(2);
    }
}
