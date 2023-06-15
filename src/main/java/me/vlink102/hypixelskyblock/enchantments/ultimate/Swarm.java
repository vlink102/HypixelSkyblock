package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;

public class Swarm extends SBEnchantment implements SBUltimate {
    public Swarm(int level) {
        super(52, "Swarm", level);
    }

    public double getDamageMultiplier() {
        return getLevel() * 2;
    }
}
