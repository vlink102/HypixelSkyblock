package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Syphon extends SBEnchantment {
    public Syphon(int level) {
        super(38, "Syphon", level, 30L, 32L);
    }

    public double getHealModifier() {
        return Statistic.fromPercentage(0.1) + (getLevel() * Statistic.fromPercentage(0.1));
    }
}
