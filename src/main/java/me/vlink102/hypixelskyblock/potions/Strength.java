package me.vlink102.hypixelskyblock.potions;

import java.util.Arrays;
import java.util.List;

public class Strength extends SBPotion{
    public Strength(int level) {
        super(11, "Speed", level);
    }

    public static final List<Double> STRENGTH_VALUES = Arrays.asList(5d, 12.5d, 20d, 30d, 40d, 50d, 60d, 75d);

    public double getStrengthAdditive() {
        return STRENGTH_VALUES.get(getLevel() - 1);
    }
}
