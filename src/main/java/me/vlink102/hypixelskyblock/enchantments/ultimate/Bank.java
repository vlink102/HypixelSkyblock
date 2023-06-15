package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Bank extends SBEnchantment implements SBUltimate {
    public Bank(int level) {
        super(84, "Bank", level);
    }

    public double getSavedCoinsModifier() {
        return getLevel() * Statistic.fromPercentage(10);
    }

    public double getExtraCoinsOnKill() {
        return getLevel() * 0.5;
    }
}
