package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.util.Statistic;

public class NoPainNoGain extends SBEnchantment implements SBUltimate {
    public NoPainNoGain(int level) {
        super(88, "No Pain No Gain", level);
    }

    public double getExperienceOrbChance() {
        return getLevel() * Statistic.fromPercentage(20);
    }
}
