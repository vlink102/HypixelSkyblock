package me.vlink102.hypixelskyblock.potions;

import java.util.Arrays;
import java.util.List;

public class Healing extends SBPotion{
    public Healing(int level) {
        super(8, "Healing", level);
    }

    public static final List<Integer> HEALING_AMOUNTS = Arrays.asList(20, 50, 100, 150, 200, 300, 400, 500);

    public double getHealAmount() {
        return HEALING_AMOUNTS.get(getLevel() - 1);
    }
}
