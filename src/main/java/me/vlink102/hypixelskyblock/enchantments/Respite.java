package me.vlink102.hypixelskyblock.enchantments;

public class Respite extends SBEnchantment {
    public Respite(int level) {
        super(81, "Respite", level);
    }

    public double getHealthRegenerationAdditive() {
        return getLevel() * 5;
    }
}
