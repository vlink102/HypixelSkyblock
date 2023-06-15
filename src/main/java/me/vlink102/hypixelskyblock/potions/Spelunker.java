package me.vlink102.hypixelskyblock.potions;

public class Spelunker extends SBPotion{
    public Spelunker(int level) {
        super(29, "Spelunker", level);
    }

    public double getMiningFortuneAdditive() {
        return getLevel() * 5;
    }
}
