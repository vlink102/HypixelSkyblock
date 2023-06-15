package me.vlink102.hypixelskyblock.potions;

import java.util.Arrays;
import java.util.List;

public class Wounded extends SBPotion {
    public Wounded(int level) {
        super(34, "Wounded", level);
    }

    public double getHealthRegenerationReduction() {
        return getLevel() * 25;
    }
}
