package me.vlink102.hypixelskyblock.potions.dungeon;

import me.vlink102.hypixelskyblock.potions.SBPotion;

public class DungeonVI extends SBPotion {
    public DungeonVI(int level) {
        super(40, "Dungeon VI", level);
    }

    public double regeneration = 20;
    public double strength = 30;
    public double critChance = 20;
    public double critDamage = 30;
    public double speed = 15;
    public double defense = 20;
    public double archeryLevel = 3;
}
