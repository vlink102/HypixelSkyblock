package me.vlink102.hypixelskyblock.potions;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Dodge extends SBPotion{
    public Dodge(int level) {
        super(22, "Dodge", level);
    }

    public double getDodgeChance() {
        return getLevel() * Statistic.fromPercentage(10);
    }
}
