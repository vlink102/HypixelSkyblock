package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class UltimateWise extends SBEnchantment implements SBUltimate {
    public UltimateWise(int level) {
        super(54, "Ultimate Wise", level);
    }

    public double getAbilityManaCostReductionModifier() {
        return getLevel() * Statistic.fromPercentage(10);
    }
}
