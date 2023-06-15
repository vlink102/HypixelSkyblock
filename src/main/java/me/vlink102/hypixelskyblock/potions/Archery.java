package me.vlink102.hypixelskyblock.potions;

import java.util.Arrays;
import java.util.List;

public class Archery extends SBPotion{
    public Archery(int level) {
        super(19, "Archery", level);
    }

    public static final List<Double> BOW_DAMAGE_MODIFIERS = Arrays.asList(12.5d, 25d, 50d, 75d);

    public double getBowDamageModifiers() {
        return BOW_DAMAGE_MODIFIERS.get(getLevel() - 1);
    }
}
