package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Magnet extends SBEnchantment {
    public Magnet(int level) {
        super(11, "Magnet", level);
    }

    public int getAdditionalExperienceOrbs() {
        return getLevel();
    }
}
