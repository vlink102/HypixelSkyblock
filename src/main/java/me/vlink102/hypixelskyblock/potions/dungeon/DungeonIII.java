package me.vlink102.hypixelskyblock.potions.dungeon;

import me.vlink102.hypixelskyblock.potions.SBPotion;

public class DungeonIII extends SBPotion {
    public DungeonIII(int level) {
        super(37, "Dungeon III", level);
    }

    public double regeneration = 15;
    public double strength = 20;
    public double critChance = 15;
    public double critDamage = 20;
    public double speed = 10;
    public double defense = 10;
}
