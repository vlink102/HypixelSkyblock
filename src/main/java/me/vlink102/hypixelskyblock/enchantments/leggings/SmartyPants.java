package me.vlink102.hypixelskyblock.enchantments.leggings;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class SmartyPants extends SBEnchantment {
    public SmartyPants(int level) {
        super(93, "Smarty Pants", level);
    }

    public double getIntelligenceAdditive() {
        return getLevel() * 5;
    }
}
