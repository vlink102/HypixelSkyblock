package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Luck extends SBEnchantment {
    public Luck(int level) {
        super(31, "Luck", level);
    }

    public double getArmorDropModifier() {
        return getLevel() * Statistic.fromPercentage(5);
    }
}
