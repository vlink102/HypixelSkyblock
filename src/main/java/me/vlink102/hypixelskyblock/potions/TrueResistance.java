package me.vlink102.hypixelskyblock.potions;

public class TrueResistance extends SBPotion{
    public TrueResistance(int level) {
        super(14, "True Resistance", level);
    }

    public double getResistance() {
        return getLevel() * 5;
    }
}
