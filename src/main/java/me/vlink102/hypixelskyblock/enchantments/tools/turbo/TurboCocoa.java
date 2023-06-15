package me.vlink102.hypixelskyblock.enchantments.tools.turbo;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class TurboCocoa extends SBEnchantment {
    public TurboCocoa(int level) {
        super(123, "Turbo-Cocoa", level);
    }

    public double getFarmingFortuneAdditive() {
        return getLevel() * 5;
    }
}
