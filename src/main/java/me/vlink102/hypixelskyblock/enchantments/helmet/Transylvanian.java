package me.vlink102.hypixelskyblock.enchantments.helmet;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Transylvanian extends SBEnchantment {
    public Transylvanian(int level) {
        super(69, "Transylvanian", level);
    }

    public double getHealAdditive(int nearby) {
        return Math.min(getLevel() * 10, (getLevel() - 2) * nearby);
    }
}
