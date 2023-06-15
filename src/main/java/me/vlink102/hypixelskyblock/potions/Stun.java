package me.vlink102.hypixelskyblock.potions;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Stun extends SBPotion{
    public Stun(int level) {
        super(30, "Stun", level);
    }

    public double getStunChance() {
        return getLevel() * Statistic.fromPercentage(10);
    }

    public double getStunTimeSeconds() {
        return 0.75 + (getLevel() * 0.25);
    }
}
