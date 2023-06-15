package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Legion extends SBEnchantment implements SBUltimate {
    public Legion(int level) {
        super(87, "Legion", level);
    }

    public double getPlayerStatModifier(int nearbyPlayers) {
        return Math.min(20, nearbyPlayers) * (getLevel() * Statistic.fromPercentage(0.07));
    }
}
