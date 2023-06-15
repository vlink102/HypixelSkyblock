package me.vlink102.hypixelskyblock.enchantments.tools.turbo;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class TurboWart extends SBEnchantment {
    public TurboWart(int level) {
        super(120, "Turbo-Warts", level);
    }

    public double getFarmingFortuneAdditive() {
        return getLevel() * 5;
    }
}
