package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class DragonTracer extends SBEnchantment {
    public DragonTracer(int level) {
        super(56, "Dragon Tracer", level);
    }

    public double getHomingBlockRange() {
        return getLevel() * 2;
    }
}
