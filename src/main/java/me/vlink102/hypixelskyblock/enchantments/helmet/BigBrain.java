package me.vlink102.hypixelskyblock.enchantments.helmet;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class BigBrain extends SBEnchantment {
    public BigBrain(int level) {
        super(68, "Big Brain", level);
    }

    public double getIntelligenceAdditive() {
        return 10 + (getLevel() * 5);
    }
}
