package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

import java.util.Arrays;
import java.util.List;

public class Champion extends SBEnchantment {
    public Champion(int level) {
        super(15, "Champion", level);
    }

    public static final List<Double> CHAMPION_COMBAT_WISDOM_TIER_VALUES = Arrays.asList(3d, 3.78d, 4.56d, 5.33d, 6.11d, 6.89d, 7.67d, 8.44d, 9.22d, 10d);
    public static final List<Double> CHAMPION_SECOND_HIT_COINS_VALUES = Arrays.asList(1.4d, 1.8d, 2.2d, 2.6d, 3d, 3.4d, 3.8d, 4.2d, 4.6d, 5d);
    public static final List<Integer> CHAMPION_SECOND_HIT_EXTRA_EXP_ORBS_VALUES = Arrays.asList(7, 9, 11, 13, 15, 17, 19, 21, 23, 25);

    public double getCombatWisdomAdditive() {
        return CHAMPION_COMBAT_WISDOM_TIER_VALUES.get(getLevel() - 1);
    }

    public double getSecondHitCoinsAdditive() {
        return CHAMPION_SECOND_HIT_COINS_VALUES.get(getLevel() - 1);
    }

    public int getSecondHotEXPOrbAdditive() {
        return CHAMPION_SECOND_HIT_EXTRA_EXP_ORBS_VALUES.get(getLevel() - 1);
    }
}
