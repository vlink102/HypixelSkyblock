package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Punch extends SBEnchantment {
    public Punch(int level) {
        super(62, "Punch", level);
    }

    public double getKnockbackBlocks() {
        return getLevel() * 3;
    }
}
