package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Piscary extends SBEnchantment {
    public Piscary(int level) {
        super(12, "Piscary", level);
    }

    public double getFishingSpeedAdditive() {
        return getLevel();
    }
}
