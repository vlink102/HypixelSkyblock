package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Combo extends SBEnchantment implements SBUltimate {
    public Combo(int level) {
        super(48, "Combo", level);
    }

    public double getDamageModifier() {
        return Statistic.fromPercentage(getLevel());
    }
}
