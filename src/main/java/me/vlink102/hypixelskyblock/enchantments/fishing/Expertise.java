package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Expertise extends SBEnchantment {
    public Expertise(int level) {
        super(6, "Expertise", level);
    }

    public double getFishingWisdomAdditive() {
        return getLevel() * 2;
    }

    public double getSeaCreatureChanceModifier() {
        return getLevel() * Statistic.fromPercentage(0.6);
    }
}
