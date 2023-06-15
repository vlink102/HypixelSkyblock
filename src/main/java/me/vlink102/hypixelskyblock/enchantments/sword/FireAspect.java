package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;

public class FireAspect extends SBEnchantment {
    public FireAspect(int level) {
        super(24, "Fire Aspect", level);
    }

    public double getFireAspectSeconds() {
        return getLevel();
    }

    public double getDamageAdditive() {
        return getLevel() * Statistic.fromPercentage(3);
    }
}
