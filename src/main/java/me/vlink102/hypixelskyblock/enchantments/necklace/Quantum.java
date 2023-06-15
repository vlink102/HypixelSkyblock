package me.vlink102.hypixelskyblock.enchantments.necklace;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Quantum extends SBEnchantment {
    public Quantum(int level) {
        super(106, "Quantum", level);
    }

    public double getVitalityAdditive() {
        return getLevel() * 0.8;
    }

    public double getWisdomAdditive() {
        return getLevel() * 0.4;
    }
}
