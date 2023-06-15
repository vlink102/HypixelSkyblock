package me.vlink102.hypixelskyblock.enchantments.tools;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Harvesting extends SBEnchantment {
    public Harvesting(int level) {
        super(113, "Harvesting", level);
    }

    public double getFarmingFortuneAdditive() {
        return getLevel() * 12.5d;
    }
}
