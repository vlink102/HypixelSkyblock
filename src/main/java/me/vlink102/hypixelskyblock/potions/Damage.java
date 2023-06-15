package me.vlink102.hypixelskyblock.potions;

import java.util.Arrays;
import java.util.List;

public class Damage extends SBPotion{
    public Damage(int level) {
        super(9, "Damage", level);
    }

    public static final List<Integer> DAMAGE_VALUES = Arrays.asList(20, 50, 100, 150, 200, 300, 400, 500);

    public double getDamage() {
        return DAMAGE_VALUES.get(getLevel() - 1);
    }
}
