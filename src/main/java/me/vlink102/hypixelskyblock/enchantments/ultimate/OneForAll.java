package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class OneForAll extends SBEnchantment implements SBUltimate {
    public OneForAll(int level) {
        super(51, "One for All", level);
    }

    public static double damageIncrease = Statistic.fromPercentage(500);
}
