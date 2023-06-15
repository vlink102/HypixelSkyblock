package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class SpikedHook extends SBEnchantment {
    public SpikedHook(int level) {
        super(13, "Spiked Hook", level);
    }

    public double getDamageModifier() {
        return getLevel() * Statistic.fromPercentage(5);
    }
}
