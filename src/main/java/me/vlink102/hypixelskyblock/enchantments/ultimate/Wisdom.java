package me.vlink102.hypixelskyblock.enchantments.ultimate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.enchantments.SBUltimate;
import me.vlink102.hypixelskyblock.player.SBPlayer;

public class Wisdom extends SBEnchantment implements SBUltimate {
    public Wisdom(int level) {
        super(89, "Wisdom", level);
    }

    public double getIntelligenceAdditive(SBPlayer player) {
        return Math.min(getLevel() * 20, (getLevel()) * (player.getPlayerBind().getLevel() / 5f));
    }
}