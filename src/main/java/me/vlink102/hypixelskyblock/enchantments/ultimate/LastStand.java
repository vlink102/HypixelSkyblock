package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class LastStand extends SBEnchantment implements SBUltimate {
    public LastStand(int level) {
        super(86, "Last Stand", level);
    }

    public double getDefenseModifier() {
        return getLevel() * Statistic.fromPercentage(5);
    }
}
