package me.vlink102.hypixelskyblock.potions;

import java.util.Arrays;
import java.util.List;

public class Stamina extends SBPotion{
    public Stamina(int level) {
        super(13, "Stamina", level);
    }

    public static final List<Integer> HEALING_AMOUNTS = Arrays.asList(150, 215, 315, 515);

    public double getHealAmount() {
        return HEALING_AMOUNTS.get(getLevel() - 1);
    }

    public double getManaAdditive() {
        return getLevel() * 50;
    }
}
