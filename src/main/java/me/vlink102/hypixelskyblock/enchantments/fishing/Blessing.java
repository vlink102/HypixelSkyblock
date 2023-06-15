package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Blessing extends SBEnchantment {

    public Blessing(int level) {
        super(2, "Blessing", level);
    }

    public double getDoubleDropChanceModifier() {
        return getLevel() * Statistic.fromPercentage(5);
    }
}
