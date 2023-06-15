package me.vlink102.hypixelskyblock.potions;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Spirit extends SBPotion{
    public Spirit(int level) {
        super(44, "Spirit", level);
    }

    public double getCritDamageModifier() {
        return getLevel() * Statistic.fromPercentage(10);
    }

    public double getSpeedAdditive() {
        return getLevel() * 10;
    }
}
