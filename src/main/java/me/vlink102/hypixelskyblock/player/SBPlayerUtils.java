package me.vlink102.hypixelskyblock.player;

public class SBPlayerUtils {
    public double calculateEffectiveHealth(SBPlayer player) {
        return player.getHealth().getValue() * (player.getDefense().getValue() / 100 + 1);
    }

    public double calculateFinalAbilityDamage(SBPlayer player) {
        double baseAbilityDamage = 0; // TODO
        double intelligence = player.getIntelligence().getValue();
        double abilityScaling = 0; // TODO
        double abilityDamageStat = player.getAbilityDamage().getValue();
        return 0; // TODO
    }
}
