package me.vlink102.hypixelskyblock.enchantments.tools.turbo;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class TurboWheat extends SBEnchantment {
    public TurboWheat(int level) {
        super(116, "Turbo-Wheat", level);
    }

    public double getFarmingFortuneAdditive() {
        return getLevel() * 5;
    }
}
