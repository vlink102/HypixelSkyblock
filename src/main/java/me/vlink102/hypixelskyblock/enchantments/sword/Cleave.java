package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cleave extends SBEnchantment {
    public Cleave(int level) {
        super(16, "Cleave", level);
    }

    public static final List<Double> CLEAVE_RANGE_VALUES = Arrays.asList(3.3d, 3.6d, 3.9d, 4.2d, 4.5d, 4.8d);
    public static final List<Integer> CLEAVE_DAMAGE_VALUES = Arrays.asList(3,6,9,12,15,20);

    public double getCleaveRangeModifier() {
        return CLEAVE_RANGE_VALUES.get(getLevel() - 1);
    }
    public double getCleaveDamageModifier() {
        return Statistic.fromPercentage(CLEAVE_DAMAGE_VALUES.get(getLevel() - 1));
    }

}
