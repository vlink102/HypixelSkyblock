package me.vlink102.hypixelskyblock.enchantments.tools;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Pristine extends SBEnchantment {
    public Pristine(int level) {
        super(101, "Pristine", level);
    }

    public double getPristineAdditive() {
        return getLevel();
    }
}
