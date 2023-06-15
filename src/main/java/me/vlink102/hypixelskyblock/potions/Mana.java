package me.vlink102.hypixelskyblock.potions;

public class Mana extends SBPotion{
    public Mana(int level) {
        super(25, "Mana", level);
    }

    public double getManaRegeneration() {
        return getLevel();
    }
}
