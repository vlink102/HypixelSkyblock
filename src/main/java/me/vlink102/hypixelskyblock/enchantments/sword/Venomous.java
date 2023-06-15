package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Venomous extends SBEnchantment {
    public Venomous(int level) {
        super(45, "Venomous", level);
    }

    public double getTargetSpeedModifier() {
        return getLevel() * Statistic.fromPercentage(5);
    }

    public double getDamageModifier() {
        return getLevel() * Statistic.fromPercentage(0.3);
    }
}
