package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Flash extends SBEnchantment implements SBUltimate {
    public Flash(int level) {
        super(109, "Flash", level);
    }

    public double getInstantCatchChance() {
        return Statistic.fromPercentage(getLevel());
    }
}
