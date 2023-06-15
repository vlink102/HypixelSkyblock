package me.vlink102.hypixelskyblock.enchantments.tools;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

import java.util.Arrays;
import java.util.List;

public class Fortune extends SBEnchantment {
    public Fortune(int level) {
        super(100, "Fortune", level, 102L);
    }

    public static final List<Integer> FORTUNE_MINING_VALUES = Arrays.asList(10, 20, 30, 45);

    public double getMiningFortuneAdditive() {
        return FORTUNE_MINING_VALUES.get(getLevel() - 1);
    }
}
