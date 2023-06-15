package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.util.Statistic;

public class ManaVampire extends SBEnchantment {
    public ManaVampire(int level) {
        super(76, "Mana Vampire", level, 74L, 82L, 71L);
    }

    public double getHealAdditive(int manaUsed) {
        return manaUsed * (getLevel() * Statistic.fromPercentage(0.5));
    }
}
