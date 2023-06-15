package me.vlink102.hypixelskyblock.potions.dungeon;

import me.vlink102.hypixelskyblock.potions.SBPotion;

public class DungeonII extends SBPotion {
    public DungeonII(int level) {
        super(36, "Dungeon II", level);
    }

    public double regeneration = 10;
    public double strength = 20;
    public double critChance = 10;
    public double critDamage = 10;
    public double speed = 10;
    public double defense = 5;
}
