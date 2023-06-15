package me.vlink102.hypixelskyblock.potions;

import me.vlink102.hypixelskyblock.util.Statistic;

import java.util.Arrays;
import java.util.List;

public class Agility extends SBPotion{
    public Agility(int level) {
        super(18, "Agility", level);
    }

    public double getDodgeChance() {
        return getLevel() * Statistic.fromPercentage(10);
    }

    public double getSpeedAdditive() {
        return getLevel() * 10;
    }
}
