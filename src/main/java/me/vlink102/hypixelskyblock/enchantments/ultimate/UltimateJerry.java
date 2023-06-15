package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class UltimateJerry extends SBEnchantment implements SBUltimate {
    public UltimateJerry(int level) {
        super(53, "Ultimate Jerry", level);
    }

    public double getBaseDamageModifier() {
        return getLevel() * Statistic.fromPercentage(1000);
    }
}
