package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Angler extends SBEnchantment {
    public Angler(int level) {
        super(1, "Angler", level);
    }

    /**
     * Enchantment level * 0.01 (1% per level)
     * @return
     */
    public double getSeaCreatureChanceModifier() {
        return getLevel() * Statistic.fromPercentage(1);
    }
}
