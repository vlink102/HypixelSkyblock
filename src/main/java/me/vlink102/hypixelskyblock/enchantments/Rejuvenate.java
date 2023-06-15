package me.vlink102.hypixelskyblock.enchantments;

public class Rejuvenate extends SBEnchantment {
    public Rejuvenate(int level) {
        super(79, "Rejuvenate", level);
    }

    public double getHealthRegenerationAdditive() {
        return getLevel() * 2;
    }
}
