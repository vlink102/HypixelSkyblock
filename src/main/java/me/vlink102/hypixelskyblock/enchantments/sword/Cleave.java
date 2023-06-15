package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class Cleave extends SBEnchantment {
    public Cleave(int level) {
        super(16, "Cleave", level);
    }

    public static final List<Double> CLEAVE_RANGE_VALUES = Arrays.asList(3.5d, 4d, 4.5d, 5d, 5.5d, 5d);

    public double getCleaveRangeModifier() {
        return Statistic.fromPercentage(CLEAVE_RANGE_VALUES.get(getLevel() - 1));
    }

    //FIXME https://hypixel-skyblock.fandom.com/wiki/Enchantments#Cleave
}
