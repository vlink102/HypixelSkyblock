package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Chance extends SBEnchantment {
    public Chance(int level) {
        super(55, "Chance", level);
    }

    public double getItemDropChanceModifier() {
        return getLevel() * Statistic.fromPercentage(15);
    }
}
