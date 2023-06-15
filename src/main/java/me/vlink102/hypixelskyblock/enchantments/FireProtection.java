package me.vlink102.hypixelskyblock.enchantments;

public class FireProtection extends SBEnchantment {
    public FireProtection(int level) {
        super(72, "Fire Protection", level, 70L, 78L, 77L);
    }

    public double getTrueDefenseAdditive() {
        return getLevel() * 2;
    }
}
