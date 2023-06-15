package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Flame extends SBEnchantment {
    public Flame(int level) {
        super(57, "Flame", level);
    }

    public double getIgnitedSeconds() {
        return 3 + (getLevel() * 0.5);
    }

    public double getDamageModifier() {
        return getLevel() * Statistic.fromPercentage(3);
    }
}
