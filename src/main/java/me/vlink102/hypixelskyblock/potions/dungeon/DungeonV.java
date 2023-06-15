package me.vlink102.hypixelskyblock.potions.dungeon;

import me.vlink102.hypixelskyblock.potions.SBPotion;

public class DungeonV extends SBPotion {
    public DungeonV(int level) {
        super(39, "Dungeon V", level);
    }

    public double regeneration = 15;
    public double strength = 30;
    public double critChance = 20;
    public double critDamage = 30;
    public double speed = 10;
    public double defense = 20;
    public double archeryLevel = 2;
}
