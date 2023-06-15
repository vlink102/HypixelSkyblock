package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class FatalTempo extends SBEnchantment implements SBUltimate {
    public FatalTempo(int level) {
        super(49, "Fatal Tempo", level);
    }

    public double getFerocityModifier() {
        return getLevel() * Statistic.fromPercentage(10);
    }
}
