package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Chimera extends SBEnchantment implements SBUltimate {
    public Chimera(int level) {
        super(47, "Chimera", level);
    }

    public double getStatCopyModifier() {
        return getLevel() * Statistic.fromPercentage(20);
    }
}
