package me.vlink102.hypixelskyblock.potions;

import java.util.Arrays;
import java.util.List;

public class Weakness extends SBPotion {
    public Weakness(int level) {
        super(15, "Weakness", level);
    }

    public static final List<Integer> DAMAGE_REDUCTION_VALUES = Arrays.asList(5, 10, 15, 20, 25, 30, 40, 50);

    public double getDamageReduction() {
        return DAMAGE_REDUCTION_VALUES.get(getLevel() - 1);
    }
}
