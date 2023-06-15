package me.vlink102.hypixelskyblock.enchantments.tools.turbo;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class TurboMelon extends SBEnchantment {
    public TurboMelon(int level) {
        super(124, "Turbo-Melon", level);
    }

    public double getFarmingFortuneAdditive() {
        return getLevel() * 5;
    }
}
