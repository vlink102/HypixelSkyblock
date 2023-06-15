package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Experience extends SBEnchantment {
    public Experience(int level) {
        super(23, "Experience", level);
    }

    public double getDoubleExperienceDropChanceModifier() {
        return getLevel() * Statistic.fromPercentage(12.5);
    }
}
