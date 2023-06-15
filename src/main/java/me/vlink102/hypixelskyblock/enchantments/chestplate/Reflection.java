package me.vlink102.hypixelskyblock.enchantments.chestplate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

import java.util.Arrays;
import java.util.List;

public class Reflection extends SBEnchantment {
    public Reflection(int level) {
        super(90, "Reflection", level);
    }

    public static final List<Integer> REFLECTED_DAMAGE_VALUES = Arrays.asList(2, 5, 10, 20, 30);

    public double getIntelligenceAdditive() {
        return getLevel() * 2;
    }

    public double getTrueDefenseAdditive() {
        return getLevel();
    }

    public double getReflectedDamageMultiplier() {
        return REFLECTED_DAMAGE_VALUES.get(getLevel() - 1);
    }
}
