package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;

public class TheOne extends SBEnchantment implements SBUltimate {
    public TheOne(int level) {
        super(107, "The One", level);
    }

    public double getHealthAdditive(int maxedOutCollections) {
        return maxedOutCollections * (getLevel() == 4 ? 0.5 : 1);
    }

    public double getStrengthAdditive(int maxedOutCollections) {
        return maxedOutCollections * (getLevel() == 4 ? 0.1 : 0.2);
    }
}
