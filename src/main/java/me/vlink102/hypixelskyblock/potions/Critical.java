package me.vlink102.hypixelskyblock.potions;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Critical extends SBPotion{
    public Critical(int level) {
        super(21, "Critical", level);
    }

    public double getCritDamageAdditive() {
        return getLevel() * 10;
    }

    public double getCritChanceModifier() {
        return Statistic.fromPercentage(5) + (getLevel() * Statistic.fromPercentage(5));
    }
}
