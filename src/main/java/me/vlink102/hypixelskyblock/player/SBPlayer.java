package me.vlink102.hypixelskyblock.player;

import lombok.Getter;
import lombok.Setter;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SBPlayer {
    @Getter private final Player playerBind;

    @Getter private final Statistic.PlayerStatistic maxHealth;
    @Getter private final Statistic.PlayerStatistic defense;
    @Getter private final Statistic.PlayerStatistic trueDefense;
    @Getter private final Statistic.PlayerStatistic strength;
    @Getter private final Statistic.PlayerStatistic intelligence;

    @Getter private final Statistic.PlayerStatistic critDamage;
    @Getter private final Statistic.PlayerStatistic critChance;

    @Getter private final Statistic.PlayerStatistic ferocity;
    @Getter private final Statistic.PlayerStatistic bonusAttackSpeed;

    @Getter private final Statistic.PlayerStatistic abilityDamage;

    @Getter private final Statistic.PlayerStatistic healthRegeneration;
    @Getter private final Statistic.PlayerStatistic vitality;
    @Getter private final Statistic.PlayerStatistic mending;

    @Getter private final Statistic.PlayerStatistic speed;
    @Getter private final Statistic.PlayerStatistic seaCreatureChance;
    @Getter private final Statistic.PlayerStatistic magicFind;
    @Getter private final Statistic.PlayerStatistic petLuck;
    @Getter private final Statistic.PlayerStatistic fishingSpeed;

    @Getter private final Statistic.PlayerStatistic combatWisdom;
    @Getter private final Statistic.PlayerStatistic miningWisdom;
    @Getter private final Statistic.PlayerStatistic farmingWisdom;
    @Getter private final Statistic.PlayerStatistic foragingWisdom;
    @Getter private final Statistic.PlayerStatistic fishingWisdom;
    @Getter private final Statistic.PlayerStatistic enchantingWisdom;
    @Getter private final Statistic.PlayerStatistic alchemyWisdom;
    @Getter private final Statistic.PlayerStatistic carpentryWisdom;
    @Getter private final Statistic.PlayerStatistic runecraftingWisdom;
    @Getter private final Statistic.PlayerStatistic socialWisdom;

    @Getter private final Statistic.PlayerStatistic miningSpeed;
    @Getter private final Statistic.PlayerStatistic breakingPower;
    @Getter private final Statistic.PlayerStatistic pristine;
    @Getter private final Statistic.PlayerStatistic foragingFortune;
    @Getter private final Statistic.PlayerStatistic farmingFortune;
    @Getter private final Statistic.PlayerStatistic miningFortune;

    @Getter private final Statistic.PlayerStatistic fear;
    @Getter private final Statistic.PlayerStatistic heat;
    @Getter private final Statistic.PlayerStatistic absorption;
    @Getter private final Statistic.PlayerStatistic mana;
    @Getter private final Statistic.PlayerStatistic health;

    @Getter private final List<SBItem> inventory;

    public SBPlayer(Player playerBind) {
        this.playerBind = playerBind;

        this.inventory = new ArrayList<>();

        this.maxHealth = Statistic.Statistics.MAX_HEALTH.getPlayerStatistic();
        this.defense = Statistic.Statistics.DEFENSE.getPlayerStatistic();
        this.strength = Statistic.Statistics.STRENGTH.getPlayerStatistic();
        this.intelligence = Statistic.Statistics.INTELLIGENCE.getPlayerStatistic();
        this.critDamage = Statistic.Statistics.CRIT_DAMAGE.getPlayerStatistic();
        this.critChance = Statistic.Statistics.CRIT_CHANCE.getPlayerStatistic();
        this.ferocity = Statistic.Statistics.FEROCITY.getPlayerStatistic();
        this.bonusAttackSpeed = Statistic.Statistics.BONUS_ATTACK_SPEED.getPlayerStatistic();
        this.abilityDamage = Statistic.Statistics.ABILITY_DAMAGE.getPlayerStatistic();
        this.healthRegeneration = Statistic.Statistics.HEALTH_REGENERATION.getPlayerStatistic();
        this.vitality = Statistic.Statistics.VITALITY.getPlayerStatistic();
        this.mending = Statistic.Statistics.MENDING.getPlayerStatistic();
        this.trueDefense = Statistic.Statistics.TRUE_DEFENSE.getPlayerStatistic();
        this.speed = Statistic.Statistics.SPEED.getPlayerStatistic();
        this.seaCreatureChance = Statistic.Statistics.SEA_CREATURE_CHANCE.getPlayerStatistic();
        this.magicFind = Statistic.Statistics.MAGIC_FIND.getPlayerStatistic();
        this.petLuck = Statistic.Statistics.PET_LUCK.getPlayerStatistic();
        this.fishingSpeed = Statistic.Statistics.FISHING_SPEED.getPlayerStatistic();
        this.combatWisdom = Statistic.Statistics.COMBAT_WISDOM.getPlayerStatistic();
        this.miningWisdom = Statistic.Statistics.MINING_WISDOM.getPlayerStatistic();
        this.farmingWisdom = Statistic.Statistics.FARMING_WISDOM.getPlayerStatistic();
        this.foragingWisdom = Statistic.Statistics.FORAGING_WISDOM.getPlayerStatistic();
        this.fishingWisdom = Statistic.Statistics.FISHING_WISDOM.getPlayerStatistic();
        this.enchantingWisdom = Statistic.Statistics.ENCHANTING_WISDOM.getPlayerStatistic();
        this.alchemyWisdom = Statistic.Statistics.ALCHEMY_WISDOM.getPlayerStatistic();
        this.carpentryWisdom = Statistic.Statistics.CARPENTRY_WISDOM.getPlayerStatistic();
        this.runecraftingWisdom = Statistic.Statistics.RUNECRAFTING_WISDOM.getPlayerStatistic();
        this.socialWisdom = Statistic.Statistics.SOCIAL_WISDOM.getPlayerStatistic();
        this.miningSpeed = Statistic.Statistics.MINING_SPEED.getPlayerStatistic();
        this.breakingPower = Statistic.Statistics.BREAKING_POWER.getPlayerStatistic();
        this.pristine = Statistic.Statistics.PRISTINE.getPlayerStatistic();
        this.foragingFortune = Statistic.Statistics.FORAGING_FORTUNE.getPlayerStatistic();
        this.farmingFortune = Statistic.Statistics.FARMING_FORTUNE.getPlayerStatistic();
        this.miningFortune = Statistic.Statistics.MINING_FORTUNE.getPlayerStatistic();
        this.mana = Statistic.Statistics.MANA.getPlayerStatistic();
        this.fear = Statistic.Statistics.FEAR.getPlayerStatistic();
        this.heat = Statistic.Statistics.HEAT.getPlayerStatistic();
        this.absorption = Statistic.Statistics.ABSORPTION.getPlayerStatistic();
        this.health = Statistic.Statistics.HEALTH.getPlayerStatistic();
    }

    public void setHealth(double value) {
        health.setValue(value);
    }

    public void setMaxHealth(double value) {
        maxHealth.setValue(value);
    }
}
