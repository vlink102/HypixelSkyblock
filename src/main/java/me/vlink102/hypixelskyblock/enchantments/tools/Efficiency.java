package me.vlink102.hypixelskyblock.enchantments.tools;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Efficiency extends SBEnchantment {
    public Efficiency(int level) {
        super(99, "Efficiency", level);
    }

    public double getMiningSpeedAdditive() {
        return 10 + (getLevel() * 20);
    }
}
