package me.vlink102.hypixelskyblock.enchantments.helmet;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Hecatomb extends SBEnchantment {
    public Hecatomb(int level) {
        super(75, "Hecatomb", level);
    }

    public double getCatacombsXPModifier() {
        return Statistic.fromPercentage(0.2) + (getLevel() * Statistic.fromPercentage(0.08));
    }

    public double getClassXPModifier() {
        return Statistic.fromPercentage(0.4) + (getLevel() * Statistic.fromPercentage(0.16));
    }

    public double getHealthAdditive() {
        return 2 + (getLevel() * 0.6);
    }
}
