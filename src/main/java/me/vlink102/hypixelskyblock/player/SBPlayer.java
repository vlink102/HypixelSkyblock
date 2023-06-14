package me.vlink102.hypixelskyblock.player;

import me.vlink102.hypixelskyblock.util.Statistic;

public class SBPlayer {
    private final Statistic health;
    private final Statistic defense;
    private final Statistic trueDefense;
    private final Statistic strength;
    private final Statistic intelligence;

    private final Statistic critDamage;
    private final Statistic critChance;

    private final Statistic ferocity;
    private final Statistic bonusAttackSpeed;

    private final Statistic abilityDamage;

    private final Statistic healthRegeneration;
    private final Statistic vitality;
    private final Statistic mending;

    private final Statistic speed;
    private final Statistic seaCreatureChance;
    private final Statistic magicFind;
    private final Statistic petLuck;
    private final Statistic fishingSpeed;

    private final Statistic combatWisdom;
    private final Statistic miningWisdom;
    private final Statistic farmingWisdom;
    private final Statistic foragingWisdom;
    private final Statistic fishingWisdom;
    private final Statistic enchantingWisdom;
    private final Statistic alchemyWisdom;
    private final Statistic carpentryWisdom;
    private final Statistic runecraftingWisdom;
    private final Statistic socialWisdom;

    private final Statistic miningSpeed;
    private final Statistic breakingPower;
    private final Statistic pristine;
    private final Statistic foragingFortune;
    private final Statistic farmingFortune;
    private final Statistic miningFortune;

    private final Statistic fear;
    private final Statistic heat;
    private final Statistic absorption;
    private final Statistic mana;

    public SBPlayer() {
        this.health = new Statistic(Statistic.StatisticType.VALUE, 100);
        this.defense = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.strength = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.intelligence = new Statistic(Statistic.StatisticType.VALUE, 100);
        this.critDamage = new Statistic(Statistic.StatisticType.PERCENTAGE, 50);
        this.critChance = new Statistic(Statistic.StatisticType.PERCENTAGE, 30);
        this.ferocity = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.bonusAttackSpeed = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.abilityDamage = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.healthRegeneration = new Statistic(Statistic.StatisticType.VALUE, 100);
        this.vitality = new Statistic(Statistic.StatisticType.VALUE, 100);
        this.mending = new Statistic(Statistic.StatisticType.VALUE, 100);
        this.trueDefense = new Statistic(Statistic.StatisticType.VALUE, 0);

        this.speed = new Statistic(Statistic.StatisticType.PERCENTAGE, 100);
        this.seaCreatureChance = new Statistic(Statistic.StatisticType.PERCENTAGE, 20);
        this.magicFind = new Statistic(Statistic.StatisticType.PERCENTAGE, 0);
        this.petLuck = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.fishingSpeed = new Statistic(Statistic.StatisticType.VALUE, 0);

        this.combatWisdom = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.miningWisdom = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.farmingWisdom = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.foragingWisdom = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.fishingWisdom = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.enchantingWisdom = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.alchemyWisdom = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.carpentryWisdom = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.runecraftingWisdom = new Statistic(Statistic.StatisticType.VALUE, 0);
        this.socialWisdom = new Statistic(Statistic.StatisticType.VALUE, 0);

    }
}
