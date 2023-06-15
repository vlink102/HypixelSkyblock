package me.vlink102.hypixelskyblock.enchantments.tools.turbo;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class TurboCarrot extends SBEnchantment {
    public TurboCarrot(int level) {
        super(117, "Turbo-Carrot", level);
    }

    public double getFarmingFortuneAdditive() {
        return getLevel() * 5;
    }
}
