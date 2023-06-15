package me.vlink102.hypixelskyblock.enchantments.tools.turbo;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class TurboMushroom extends SBEnchantment {
    public TurboMushroom(int level) {
        super(119, "Turbo-Mushrooms", level);
    }

    public double getFarmingFortuneAdditive() {
        return getLevel() * 5;
    }
}
