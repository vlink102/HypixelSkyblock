package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Vampirism extends SBEnchantment {
    public Vampirism(int level) {
        super(44, "Vampirism", level);
    }

    public double getHealModifier() {
        return Statistic.fromPercentage(getLevel());
    }
}
