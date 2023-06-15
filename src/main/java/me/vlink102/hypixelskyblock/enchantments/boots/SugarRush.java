package me.vlink102.hypixelskyblock.enchantments.boots;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class SugarRush extends SBEnchantment {
    public SugarRush(int level) {
        super(97, "Sugar Rush", level);
    }

    public double getSpeedAdditive() {
        return getLevel() * 2;
    }
}
