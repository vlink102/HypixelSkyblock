package me.vlink102.hypixelskyblock.potions;

public class PetLuck extends SBPotion{
    public PetLuck(int level) {
        super(26, "Pet Luck", level);
    }

    public double getPetLuckAdditive() {
        return getLevel() * 5;
    }
}
