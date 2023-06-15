package me.vlink102.hypixelskyblock.potions;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;

import java.util.Arrays;
import java.util.List;

public class WaterBreathing extends SBPotion {
    public WaterBreathing(int level) {
        super(7, "Water Breathing", level);
    }

    public static final List<Integer> WATER_BREATHING_CHANCE = Arrays.asList(15, 30, 45, 60, 80, 100);

    public double getAntiDrownChance() {
        return WATER_BREATHING_CHANCE.get(getLevel() - 1);
    }
}
