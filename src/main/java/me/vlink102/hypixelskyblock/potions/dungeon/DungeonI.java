package me.vlink102.hypixelskyblock.potions.dungeon;

import me.vlink102.hypixelskyblock.potions.SBPotion;

public class DungeonI extends SBPotion {
    public DungeonI(int level) {
        super(35, "Dungeon I", level);
    }

    public double regeneration = 5;
    public double strength = 20;
    public double critChance = 10;
    public double critDamage = 10;
    public double speed = 5;
    public double defense = 5;
}
