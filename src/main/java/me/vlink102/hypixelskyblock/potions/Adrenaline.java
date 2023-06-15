package me.vlink102.hypixelskyblock.potions;

import java.util.Arrays;
import java.util.List;

public class Adrenaline extends SBPotion{
    public Adrenaline(int level) {
        super(17, "Adrenaline", level);
    }

    public static final List<Integer> ABSORPTION_HEALTH = Arrays.asList(20, 40, 60, 80, 100, 150, 200, 300);

    public double getAbsorptionAmount() {
        return ABSORPTION_HEALTH.get(getLevel() - 1);
    }

    public double getSpeedAdditive() {
        return getLevel() * 5;
    }
}
