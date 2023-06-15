package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Snipe extends SBEnchantment {
    public Snipe(int level) {
        super(63, "Snipe", level);
    }

    public double getDamageModifier(int blocksTravelled) {
        return blocksTravelled * Statistic.fromPercentage(getLevel());
    }
}
