package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.player.SBPlayer;
import me.vlink102.hypixelskyblock.util.Statistic;

public class Overload extends SBEnchantment {
    public Overload(int level) {
        super(59, "Overload", level);
    }

    public double getMegaCriticalHitModifier() {
        return getLevel() * Statistic.fromPercentage(10);
    }

    public double getCritDamageModifier() {
        return Statistic.fromPercentage(getLevel());
    }

    public double getCritChanceModifier() {
        return Statistic.fromPercentage(getLevel());
    }

    public double getMegaCriticalHitChanceModifier(SBPlayer player) {
        return Statistic.fromPercentage(player.getCritChance().getValue() - 100);
    }
}
