package me.vlink102.hypixelskyblock.enchantments.chestplate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class CounterStrike extends SBEnchantment {
    public CounterStrike(int level) {
        super(91, "Counter-Strike", level);
    }

    public double getDefenseAdditive() {
        return getLevel() * 2;
    }
}
