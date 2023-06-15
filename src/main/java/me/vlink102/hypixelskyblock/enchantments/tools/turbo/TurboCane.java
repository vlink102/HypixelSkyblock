package me.vlink102.hypixelskyblock.enchantments.tools.turbo;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class TurboCane extends SBEnchantment {
    public TurboCane(int level) {
        super(118, "Turbo-Cane", level);
    }

    public double getFarmingFortuneAdditive() {
        return getLevel() * 5;
    }
}
