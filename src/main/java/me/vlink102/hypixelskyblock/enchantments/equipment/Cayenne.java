package me.vlink102.hypixelskyblock.enchantments.equipment;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

public class Cayenne extends SBEnchantment {
    public Cayenne(int level) {
        super(104, "Cayenne", level);
    }

    public double getHealthAdditive(int magicalPower) {
        int digits = String.valueOf(magicalPower).length();
        return (getLevel() / 5d) * digits;
    }
}
