package me.vlink102.hypixelskyblock.potions;

import me.vlink102.hypixelskyblock.util.Statistic;

public class WispsIceFlavoredWater extends SBPotion{
    public WispsIceFlavoredWater(int level) {
        super(45, "Wisp's Ice-Flavored Water", level);
    }

    public double trueDefenseAdditive = 25;
    public double incomingHealingModifier = Statistic.fromPercentage(10);

}
