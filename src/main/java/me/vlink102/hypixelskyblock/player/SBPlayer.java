package me.vlink102.hypixelskyblock.player;

import lombok.Getter;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.entity.Player;

public class SBPlayer {
    @Getter private final Player playerBind;

    @Getter private final Statistic maxHealth;
    @Getter private final Statistic defense;
    @Getter private final Statistic trueDefense;
    @Getter private final Statistic strength;
    @Getter private final Statistic intelligence;

    @Getter private final Statistic critDamage;
    @Getter private final Statistic critChance;

    @Getter private final Statistic ferocity;
    @Getter private final Statistic bonusAttackSpeed;

    @Getter private final Statistic abilityDamage;

    @Getter private final Statistic healthRegeneration;
    @Getter private final Statistic vitality;
    @Getter private final Statistic mending;

    @Getter private final Statistic speed;
    @Getter private final Statistic seaCreatureChance;
    @Getter private final Statistic magicFind;
    @Getter private final Statistic petLuck;
    @Getter private final Statistic fishingSpeed;

    @Getter private final Statistic combatWisdom;
    @Getter private final Statistic miningWisdom;
    @Getter private final Statistic farmingWisdom;
    @Getter private final Statistic foragingWisdom;
    @Getter private final Statistic fishingWisdom;
    @Getter private final Statistic enchantingWisdom;
    @Getter private final Statistic alchemyWisdom;
    @Getter private final Statistic carpentryWisdom;
    @Getter private final Statistic runecraftingWisdom;
    @Getter private final Statistic socialWisdom;

    @Getter private final Statistic miningSpeed;
    @Getter private final Statistic breakingPower;
    @Getter private final Statistic pristine;
    @Getter private final Statistic foragingFortune;
    @Getter private final Statistic farmingFortune;
    @Getter private final Statistic miningFortune;

    @Getter private final Statistic fear;
    @Getter private final Statistic heat;
    @Getter private final Statistic absorption;
    @Getter private final Statistic mana;
    @Getter private final Statistic health;

    public SBPlayer(Player playerBind) {
        this.playerBind = playerBind;

        this.maxHealth = new Statistic(1, Statistic.StatisticType.VALUE, 100);
        this.defense = new Statistic(2, Statistic.StatisticType.VALUE, 0);
        this.strength = new Statistic(3, Statistic.StatisticType.VALUE, 0);
        this.intelligence = new Statistic(4, Statistic.StatisticType.VALUE, 100);
        this.critDamage = new Statistic(5, Statistic.StatisticType.PERCENTAGE, 50);
        this.critChance = new Statistic(6, Statistic.StatisticType.PERCENTAGE, 30, 100);
        this.ferocity = new Statistic(7, Statistic.StatisticType.VALUE, 0, 500);
        this.bonusAttackSpeed = new Statistic(8, Statistic.StatisticType.VALUE, 0, 100);
        this.abilityDamage = new Statistic(9, Statistic.StatisticType.VALUE, 0);
        this.healthRegeneration = new Statistic(10, Statistic.StatisticType.VALUE, 100);
        this.vitality = new Statistic(11, Statistic.StatisticType.VALUE, 100);
        this.mending = new Statistic(12, Statistic.StatisticType.VALUE, 100);
        this.trueDefense = new Statistic(13, Statistic.StatisticType.VALUE, 0);
        this.speed = new Statistic(14, Statistic.StatisticType.PERCENTAGE, 100, 400); // BLACK CAT + YOUNG DRAG 500% MAX
        this.seaCreatureChance = new Statistic(15, Statistic.StatisticType.PERCENTAGE, 20, 100);
        this.magicFind = new Statistic(16, Statistic.StatisticType.PERCENTAGE, 0);
        this.petLuck = new Statistic(17, Statistic.StatisticType.VALUE, 0);
        this.fishingSpeed = new Statistic(18, Statistic.StatisticType.VALUE, 0, 300); // CRIMSON ISLE 350 MAX
        this.combatWisdom = new Statistic(19, Statistic.StatisticType.VALUE, 0);
        this.miningWisdom = new Statistic(20, Statistic.StatisticType.VALUE, 0);
        this.farmingWisdom = new Statistic(21, Statistic.StatisticType.VALUE, 0);
        this.foragingWisdom = new Statistic(22, Statistic.StatisticType.VALUE, 0);
        this.fishingWisdom = new Statistic(23, Statistic.StatisticType.VALUE, 0);
        this.enchantingWisdom = new Statistic(24, Statistic.StatisticType.VALUE, 0);
        this.alchemyWisdom = new Statistic(25, Statistic.StatisticType.VALUE, 0);
        this.carpentryWisdom = new Statistic(26, Statistic.StatisticType.VALUE, 0);
        this.runecraftingWisdom = new Statistic(27, Statistic.StatisticType.VALUE, 0);
        this.socialWisdom = new Statistic(28, Statistic.StatisticType.VALUE, 0);
        this.miningSpeed = new Statistic(29, Statistic.StatisticType.VALUE, 0);
        this.breakingPower = new Statistic(30, Statistic.StatisticType.VALUE, 0, 10);
        this.pristine = new Statistic(31, Statistic.StatisticType.VALUE, 0, 18.63);
        this.foragingFortune = new Statistic(32, Statistic.StatisticType.VALUE, 0);
        this.farmingFortune = new Statistic(33, Statistic.StatisticType.VALUE, 0);
        this.miningFortune = new Statistic(34, Statistic.StatisticType.VALUE, 0);
        this.mana = new Statistic(35, Statistic.StatisticType.VALUE, 100);
        this.fear = new Statistic(36, Statistic.StatisticType.BOOLEAN, 0); // FALSE
        this.heat = new Statistic(37, Statistic.StatisticType.VALUE, 0);
        this.absorption = new Statistic(38, Statistic.StatisticType.VALUE, 0);
        this.health = new Statistic(39, Statistic.StatisticType.VALUE, 100);
    }


}
