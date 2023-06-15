package me.vlink102.hypixelskyblock.potions;

public class Rabbit extends SBPotion{
    public Rabbit(int level) {
        super(27, "Rabbit", level);
    }

    public double getSpeedAdditive() {
        return getLevel() * 10;
    }

    public double getJumpBoostLevel() {
        int level = getLevel();

        if (level < 3) return 1;
        if (level > 4) return 3;
        return 2;
    }

}
