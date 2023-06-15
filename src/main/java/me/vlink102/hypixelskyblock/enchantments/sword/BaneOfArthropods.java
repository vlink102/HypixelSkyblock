package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class BaneOfArthropods extends SBEnchantment {
    public BaneOfArthropods(int level) {
        super(15, "Bane of Arthropods", level, 35L, 36L);
    }

    public static final List<Integer> BANE_OF_ARTHROPODS_TIER_VALUES = Arrays.asList(8, 16, 24, 32, 40, 48, 56);

    public double getDamageModifier() {
        return Statistic.fromPercentage(BANE_OF_ARTHROPODS_TIER_VALUES.get(getLevel() - 1));
    }
}
