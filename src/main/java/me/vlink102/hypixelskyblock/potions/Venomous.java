package me.vlink102.hypixelskyblock.potions;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Venomous extends SBPotion{
    public Venomous(int level) {
        super(33, "Venomous", level);
    }

    public double getDamageAdditive() {
        return getLevel() * 5;
    }

    public double getSpeedReduced() {
        return getLevel() * 5;
    }
}
