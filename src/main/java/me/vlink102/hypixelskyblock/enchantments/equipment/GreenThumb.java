package me.vlink102.hypixelskyblock.enchantments.equipment;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class GreenThumb extends SBEnchantment {
    public GreenThumb(int level) {
        super(105, "Green Thumb", level);
    }

    public double getFarmingFortuneAdditive(int uniqueVisitorsServed) {
        return uniqueVisitorsServed * (getLevel() * 0.05);
    }
}
