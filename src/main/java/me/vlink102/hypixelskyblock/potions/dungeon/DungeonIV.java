package me.vlink102.hypixelskyblock.potions.dungeon;

import me.vlink102.hypixelskyblock.potions.SBPotion;

public class DungeonIV extends SBPotion {
    public DungeonIV(int level) {
        super(38, "Dungeon IV", level);
    }

    public double regeneration = 15;
    public double strength = 30;
    public double critChance = 15;
    public double critDamage = 20;
    public double speed = 10;
    public double defense = 15;
    public double archeryLevel = 1;
}
