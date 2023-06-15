package me.vlink102.hypixelskyblock.potions.xpboost;

import me.vlink102.hypixelskyblock.potions.SBPotion;

import java.util.Arrays;
import java.util.List;

public class ForagingXPBoost extends SBPotion {
    public ForagingXPBoost(int level) {
        super(51, "Foraging XP Boost", level);
    }

    public static final List<Integer> WISDOM_VALUES = Arrays.asList(5, 10, 20);

    public double getWisdomAdditive() {
        return WISDOM_VALUES.get(getLevel() - 1);
    }
}
