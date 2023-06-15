package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.util.Statistic;

public class DragonHunter extends SBEnchantment {
    public DragonHunter(int level) {
        super(20, "Dragon Hunter", level);
    }

    public double getEnderDragonDamageModifier() {
        return getLevel() * Statistic.fromPercentage(8);
    }
}
