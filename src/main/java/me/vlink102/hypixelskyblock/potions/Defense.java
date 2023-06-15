package me.vlink102.hypixelskyblock.potions;

import java.util.Arrays;
import java.util.List;

public class Defense extends SBPotion{
    public Defense(int level) {
        super(28, "Defense", level);
    }

    public static final List<Integer> DEFENSE_AMOUNTS = Arrays.asList(5, 10, 15, 20, 30, 40, 50, 60);

    public double getDefenseAdditive() {
        return DEFENSE_AMOUNTS.get(getLevel() - 1);
    }
}
