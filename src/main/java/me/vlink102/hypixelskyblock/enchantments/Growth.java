package me.vlink102.hypixelskyblock.enchantments;

public class Growth extends SBEnchantment {
    public Growth(int level) {
        super(73, "Growth", level);
    }

    public double getHealthAdditive() {
        return getLevel() * 15;
    }
}
