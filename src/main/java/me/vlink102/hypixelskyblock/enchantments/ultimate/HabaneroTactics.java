package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class HabaneroTactics extends SBEnchantment implements SBUltimate {
    public HabaneroTactics(int level) {
        super(85, "Habanero Tactics", level);
    }

    public double getWandHealingModifier() {
        return Statistic.fromPercentage(4.5) + (getLevel() * Statistic.fromPercentage(1.5));
    }

    public double getDamageModifier() {
        return Statistic.fromPercentage(3) + (getLevel() * Statistic.fromPercentage(1));
    }
}
