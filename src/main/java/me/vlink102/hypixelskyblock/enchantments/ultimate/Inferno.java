package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;

public class Inferno extends SBEnchantment implements SBUltimate {
    public Inferno(int level) {
        super(50, "Inferno", level);
    }

    public double getDamageMultiplier() {
        return 1 + (getLevel() * 0.25);
    }
}
