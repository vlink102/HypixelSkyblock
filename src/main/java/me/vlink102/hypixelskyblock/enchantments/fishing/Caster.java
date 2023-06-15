package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Caster extends SBEnchantment {
    public Caster(int level) {
        super(3, "Caster", level);
    }

    public double getBaitConsumptionChanceModifier() {
        return getLevel() * Statistic.fromPercentage(0.05);
    }
}
