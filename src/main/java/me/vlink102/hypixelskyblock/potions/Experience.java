package me.vlink102.hypixelskyblock.potions;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Experience extends SBPotion{
    public Experience(int level) {
        super(23, "Experience", level);
    }

    public double getExperienceOrbModifier() {
        return getLevel() * Statistic.fromPercentage(5);
    }
}
