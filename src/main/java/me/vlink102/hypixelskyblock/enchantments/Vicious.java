package me.vlink102.hypixelskyblock.enchantments;

public class Vicious extends SBEnchantment {
    public Vicious(int level) {
        super(46, "Vicious", level);
    }

    public double getFerocityAdditive() {
        return getLevel() + 2;
    }
}
