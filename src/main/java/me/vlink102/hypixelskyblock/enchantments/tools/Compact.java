package me.vlink102.hypixelskyblock.enchantments.tools;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class Compact extends SBEnchantment {
    public Compact(int level) {
        super(98, "Compact", level);
    }

    public double getMiningWisdomAdditive() {
        return getLevel();
    }

    public static final List<Double> COMPACT_ENCHANTED_CHANCE = Arrays.asList(0.2d, 0.3d, 0.3d, 0.3d, 0.3d, 0.4d, 0.4d, 0.4d, 0.5d, 0.6d);

    public double getEnchantedItemChance() {
        return Statistic.fromPercentage(COMPACT_ENCHANTED_CHANCE.get(getLevel() - 1));
    }
}
