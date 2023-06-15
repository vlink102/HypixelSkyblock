package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Piercing extends SBEnchantment {
    public Piercing(int level) {
        super(60, "Piercing", level);
    }

    public double piercedThroughEnemyDamageModifier = Statistic.fromPercentage(25);
}
