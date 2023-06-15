package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Knockback extends SBEnchantment {
    public Knockback(int level) {
        super(28, "Knockback", level);
    }

    public double getKnockbackBlocks() {
        return getLevel() * 3;
    }
}
