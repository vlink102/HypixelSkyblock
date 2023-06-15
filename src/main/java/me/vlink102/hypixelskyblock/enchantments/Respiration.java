package me.vlink102.hypixelskyblock.enchantments;

public class Respiration extends SBEnchantment {
    public Respiration(int level) {
        super(80, "Respiration", level);
    }

    public double getUnderwaterSeconds() {
        return getLevel() * 15;
    }
}
