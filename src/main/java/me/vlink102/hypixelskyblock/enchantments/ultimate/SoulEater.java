package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;

public class SoulEater extends SBEnchantment implements SBUltimate {
    public SoulEater(int level) {
        super(66, "Soul Eater", level);
    }

    public double getDamageMultiplier() {
        return getLevel() * 2;
    }
}
