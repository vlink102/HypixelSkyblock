package me.vlink102.hypixelskyblock.enchantments.tools;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Sunder extends SBEnchantment {
    public Sunder(int level) {
        super(122, "Sunder", level);
    }

    public double getFarmingFortuneAdditive() {
        return getLevel() * 12.5;
    }
}
