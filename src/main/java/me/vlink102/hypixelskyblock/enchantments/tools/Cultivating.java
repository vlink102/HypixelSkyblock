package me.vlink102.hypixelskyblock.enchantments.tools;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Cultivating extends SBEnchantment {
    public Cultivating(int level) {
        super(111, "Cultivating", level);
    }

    public double getFarmingWisdomAdditive() {
        return getLevel();
    }

    public double getFarmingFortuneAdditive() {
        return getLevel();
    }
}
