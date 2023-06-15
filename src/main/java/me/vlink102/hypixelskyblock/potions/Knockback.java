package me.vlink102.hypixelskyblock.potions;

import me.vlink102.hypixelskyblock.util.Statistic;

public class Knockback extends SBPotion{
    public Knockback(int level) {
        super(32, "Knockback", level);
    }

    public double getKnockbackIncreaseModifier() {
        return getLevel() * Statistic.fromPercentage(20);
    }
}
