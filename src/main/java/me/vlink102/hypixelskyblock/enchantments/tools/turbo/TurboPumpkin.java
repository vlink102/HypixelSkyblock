package me.vlink102.hypixelskyblock.enchantments.tools.turbo;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class TurboPumpkin extends SBEnchantment {
    public TurboPumpkin(int level) {
    super(125, "Turbo-Pumpkin", level);
    }

    public double getFarmingFortuneAdditive() {
        return getLevel() * 5;
    }
}
