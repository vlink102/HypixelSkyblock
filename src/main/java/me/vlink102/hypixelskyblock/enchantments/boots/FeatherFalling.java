package me.vlink102.hypixelskyblock.enchantments.boots;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class FeatherFalling extends SBEnchantment {
    public FeatherFalling(int level) {
        super(95, "Feather Falling", level);
    }

    public double getFallDamageReductionModifier() {
        return getLevel() * Statistic.fromPercentage(5);
    }

    public double getFallDamageBlockBuffer() {
        return getLevel();
    }
}
