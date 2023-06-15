package me.vlink102.hypixelskyblock.potions;

import java.util.Arrays;
import java.util.List;

public class Regeneration extends SBPotion {
    public Regeneration(int level) {
        super(5, "Regeneration", level);
    }

    public static final List<Integer> REGENERATION_VALUES = Arrays.asList(5, 10, 15, 20, 25, 30, 40, 50);

    public double getHealthRegeneration() {
        return REGENERATION_VALUES.get(getLevel() - 1);
    }
}
