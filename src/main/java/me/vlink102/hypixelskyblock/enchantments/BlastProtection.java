package me.vlink102.hypixelskyblock.enchantments;

public class BlastProtection extends SBEnchantment {
    public BlastProtection(int level) {
        super(70, "Blast Protection", level, 78L, 72L, 77L);
    }

    public double getDefenseAdditive() {
        return getLevel() * 30;
    }
}
