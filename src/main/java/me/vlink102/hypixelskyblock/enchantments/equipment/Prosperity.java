package me.vlink102.hypixelskyblock.enchantments.equipment;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Prosperity extends SBEnchantment {
    public Prosperity(int level) {
        super(126, "Prosperity", level);
    }

    public double getHealthAdditive() {
        return getLevel() * 3;
    }
}
