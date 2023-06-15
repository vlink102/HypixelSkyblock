package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Scavenger extends SBEnchantment {
    public Scavenger(int level) {
        super(34, "Scavenger", level);
    }

    public double getCoinsAdditive() {
        return getLevel() * 0.3;
    }
}
