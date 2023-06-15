package me.vlink102.hypixelskyblock.potions;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Haste extends SBPotion{
    public Haste(int level) {
        super(24, "Haste", level);
    }

    public double getMiningSpeedAdditive() {
        return getLevel() * 50;
    }
}
