package me.vlink102.hypixelskyblock.enchantments.tools.turbo;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class TurboCacti extends SBEnchantment {
    public TurboCacti(int level) {
        super(115, "Turbo-Cacti", level);
    }

    public double getFarmingFortuneAdditive() {
        return getLevel() * 5;
    }
}
