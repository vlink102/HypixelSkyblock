package me.vlink102.hypixelskyblock.potions;

import java.util.Arrays;
import java.util.List;

public class Poison extends SBPotion{
    public Poison(int level) {
        super(10, "Poison", level);
    }

    public static final List<Integer> DAMAGE_VALUES = Arrays.asList(10, 20, 40, 60);

    public double getDamage() {
        return DAMAGE_VALUES.get(getLevel() - 1);
    }
}
