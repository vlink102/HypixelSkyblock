package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Frail extends SBEnchantment {
    public Frail(int level) {
        super(7, "Frail", level);
    }

    public double getSeaCreatureHealthDepletionModifier() {
        return getLevel() * Statistic.fromPercentage(5);
    }
}
