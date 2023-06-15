package me.vlink102.hypixelskyblock.potions;

import java.util.Arrays;
import java.util.List;

public class Speed extends SBPotion{
    public Speed(int level) {
        super(6, "Speed", level);
    }

    public double getSpeedAdditive() {
        return getLevel() * 5;
    }
}
