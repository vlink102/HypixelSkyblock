package me.vlink102.hypixelskyblock.potions;

public class Slowness extends SBPotion{
    public Slowness(int level) {
        super(12, "Slowness", level);
    }

    public double getSpeedReduction() {
        return getLevel() * 5;
    }
}
