package me.vlink102.hypixelskyblock.enchantments.boots;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class DepthStrider extends SBEnchantment {
    public DepthStrider(int level) {
        super(94, "Depth Strider", level, 96L);
    }

    public double getWaterSpeedReductionModifier() {
        return getLevel() * Statistic.fromPercentage(100d/3d);
    }
}
