package me.vlink102.hypixelskyblock.enchantments.tools.turbo;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class TurboPotato extends SBEnchantment {
    public TurboPotato(int level) {
        super(121, "Turbo-Potato", level);
    }

    public double getFarmingFortuneAdditive() {
        return getLevel() * 5;
    }
}
