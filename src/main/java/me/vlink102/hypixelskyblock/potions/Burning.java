package me.vlink102.hypixelskyblock.potions;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Burning extends SBPotion{
    public Burning(int level) {
        super(20, "Burning", level);
    }

    public double getBurningTimeIncreaseModifier() {
        return getLevel() * Statistic.fromPercentage(5);
    }
}
