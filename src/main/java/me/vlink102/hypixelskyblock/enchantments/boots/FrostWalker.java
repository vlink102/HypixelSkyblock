package me.vlink102.hypixelskyblock.enchantments.boots;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class FrostWalker extends SBEnchantment {
    public FrostWalker(int level) {
        super(96, "Frost Walker", level, 94L);
    }

    public double getBlockFreezeRadius() {
        return getLevel();
    }
}
