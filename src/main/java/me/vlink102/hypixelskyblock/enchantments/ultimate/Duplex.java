package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Duplex extends SBEnchantment implements SBUltimate {
    public Duplex(int level) {
        super(64, "Duplex", level);
    }

    public double getDamageModifier() {
        return getLevel() * Statistic.fromPercentage(4);
    }

    public double getFireDamageMultiplier() {
        return 1 + (getLevel() * 0.1);
    }
}
