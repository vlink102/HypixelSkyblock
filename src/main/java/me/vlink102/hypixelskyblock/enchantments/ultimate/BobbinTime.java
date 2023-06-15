package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;

public class BobbinTime extends SBEnchantment implements SBUltimate {
    public BobbinTime(int level) {
        super(108, "Bobbin' Time", level);
    }

    public double getStatBoostModifier(int fishingBobbers) {
        return Math.min(fishingBobbers, 10) * (getLevel() * 0.12);
    }
}
