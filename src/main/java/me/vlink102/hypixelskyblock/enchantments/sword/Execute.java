package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

import java.util.Arrays;
import java.util.List;

public class Execute extends SBEnchantment {
    public Execute(int level) {
        super(22, "Execute", level, 33L);
    }

    public static List<Double> EXECUTE_DAMAGE_VALUES = Arrays.asList(0.2d, 0.4d, 0.6d, 0.8d, 1d, 1.25d);

    public double getDamageDealtModifier(double health, double maxHealth) {
        return ((maxHealth - health) / maxHealth) * getLevel();
    }
}
