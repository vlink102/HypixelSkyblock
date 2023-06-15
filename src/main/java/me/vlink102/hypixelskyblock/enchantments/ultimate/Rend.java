package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Rend extends SBEnchantment implements SBUltimate {
    public Rend(int level) {
        super(65, "Rend", level);
    }

    public double getDamageModifier() {
        return getLevel() * Statistic.fromPercentage(5);
    }
}
