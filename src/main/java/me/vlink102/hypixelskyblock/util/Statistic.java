package me.vlink102.hypixelskyblock.util;

import org.apache.commons.lang.WordUtils;

public class Statistic {
    public enum StatisticType {
        PERCENTAGE,
        VALUE,
        BOOLEAN
    }

    private final long statisticID;
    private final StatisticType type;
    private double value;
    private double maxValue;

    private final String color;
    private final String name;

    public Statistic(long statisticID, StatisticType type, double value, String color, String name) {
        this.type = type;
        this.value = value;
        this.maxValue = -1;
        this.statisticID = statisticID;
        this.color = color;
        this.name = name;
    }

    public Statistic(long statisticID, StatisticType type, double value, double maxValue, String color, String name) {
        this.type = type;
        this.value = value;
        this.maxValue = maxValue;
        this.statisticID = statisticID;
        this.color = color;
        this.name = name;
    }

    public Statistic(long statisticID, double value, String color, String name) {
        this.type = StatisticType.VALUE;
        this.value = value;
        this.maxValue = -1;
        this.statisticID = statisticID;
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public String getColorFull() {
        return "&" + getColor();
    }

    public double getMaxValue() {
        return maxValue;
    }

    public long getStatisticID() {
        return statisticID;
    }

    public StatisticType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public int getRoundedValue() {
        return (int) value;
    }

    public int getMaxRoundedValue() {
        return (int) maxValue;
    }

    public static double fromPercentage(double percentage) {
        return percentage / 100D;
    }

    public static double toPercentage(double value) {
        return value * 100D;
    }

    public String getName() {
        return name;
    }

    public static class PlayerStatistic {
        private final Statistics statistic;

        private double value;

        public PlayerStatistic(Statistics statistic) {
            this.statistic = statistic;
            this.value = statistic.statistic.getValue();
        }

        public void setValue(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }

        public int getRoundedValue() {
            return (int) value;
        }

        public Statistics getStatistic() {
            return statistic;
        }
    }

    public enum Statistics {
        MAX_HEALTH(new Statistic(1, StatisticType.VALUE, 100, "a", "Health")),
        DEFENSE(new Statistic(2, Statistic.StatisticType.VALUE, 0, "a", "Defense")),
        STRENGTH(new Statistic(3, Statistic.StatisticType.VALUE, 0, "c", "Strength")),
        INTELLIGENCE(new Statistic(4, Statistic.StatisticType.VALUE, 100, "a", "Intelligence")),
        CRIT_DAMAGE(new Statistic(5, Statistic.StatisticType.PERCENTAGE, 50, "c", "Crit Damage")),
        CRIT_CHANCE(new Statistic(6, Statistic.StatisticType.PERCENTAGE, 30, 100, "c", "Crit Chance")),
        FEROCITY(new Statistic(7, Statistic.StatisticType.VALUE, 0, 500, "a", "Ferocity")),
        BONUS_ATTACK_SPEED(new Statistic(8, Statistic.StatisticType.VALUE, 0, 100, "c", "Bonus Attack Speed")),
        ABILITY_DAMAGE(new Statistic(9, Statistic.StatisticType.VALUE, 0, "c", "Ability Damage")),
        HEALTH_REGENERATION(new Statistic(10, Statistic.StatisticType.VALUE, 100, "a", "Health Regen")),
        VITALITY(new Statistic(11, Statistic.StatisticType.VALUE, 100, "a", "Vitality")),
        MENDING(new Statistic(12, Statistic.StatisticType.VALUE, 100, "a", "Mending")),
        TRUE_DEFENSE(new Statistic(13, Statistic.StatisticType.VALUE, 0, "a", "True Defense")),
        SPEED(new Statistic(14, Statistic.StatisticType.PERCENTAGE, 100, 400, "a", "Speed")),
        SEA_CREATURE_CHANCE(new Statistic(15, Statistic.StatisticType.PERCENTAGE, 20, 100, "c", "Sea Creature Chance")),
        MAGIC_FIND(new Statistic(16, Statistic.StatisticType.PERCENTAGE, 0, "a", "Magic Find")),
        PET_LUCK(new Statistic(17, Statistic.StatisticType.VALUE, 0, "a", "Pet Luck")),
        FISHING_SPEED(new Statistic(18, Statistic.StatisticType.VALUE, 0, 300, "a", "Fishing Speed")),
        COMBAT_WISDOM(new Statistic(19, Statistic.StatisticType.VALUE, 0, "a", "Combat Wisdom")),
        MINING_WISDOM(new Statistic(20, Statistic.StatisticType.VALUE, 0, "3", "Mining Wisdom")),
        FARMING_WISDOM(new Statistic(21, Statistic.StatisticType.VALUE, 0, "a", "Farming Wisdom")),
        FORAGING_WISDOM(new Statistic(22, Statistic.StatisticType.VALUE, 0, "a", "Foraging Wisdom")),
        FISHING_WISDOM(new Statistic(23, Statistic.StatisticType.VALUE, 0, "a", "Fishing Wisdom")),
        ENCHANTING_WISDOM(new Statistic(24, Statistic.StatisticType.VALUE, 0, "a", "Enchanting Wisdom")),
        ALCHEMY_WISDOM(new Statistic(25, Statistic.StatisticType.VALUE, 0, "a", "Alchemy Wisdom")),
        CARPENTRY_WISDOM(new Statistic(26, Statistic.StatisticType.VALUE, 0, "a", "Carpentry Wisdom")),
        RUNECRAFTING_WISDOM(new Statistic(27, Statistic.StatisticType.VALUE, 0, "a", "Runecrafting Wisdom")),
        SOCIAL_WISDOM(new Statistic(28, Statistic.StatisticType.VALUE, 0, "a", "Social Wisdom")),
        MINING_SPEED(new Statistic(29, Statistic.StatisticType.VALUE, 0, "a", "Mining Speed")),
        BREAKING_POWER(new Statistic(30, Statistic.StatisticType.VALUE, 0, 10, "8", "Breaking Power")),
        PRISTINE(new Statistic(31, Statistic.StatisticType.VALUE, 0, 18.63, "5", "Pristine")),
        FORAGING_FORTUNE(new Statistic(32, Statistic.StatisticType.VALUE, 0, "6", "Foraging Fortune")),
        FARMING_FORTUNE(new Statistic(33, Statistic.StatisticType.VALUE, 0, "a", "Farming Fortune")),
        MINING_FORTUNE(new Statistic(34, Statistic.StatisticType.VALUE, 0, "a", "Mining Fortune")),
        MANA(new Statistic(35, Statistic.StatisticType.VALUE, 100, "b", "Mana")),
        FEAR(new Statistic(36, Statistic.StatisticType.BOOLEAN, 0, "a", "Fear")),
        HEAT(new Statistic(37, Statistic.StatisticType.VALUE, 0, "c", "Heat")),
        ABSORPTION(new Statistic(38, Statistic.StatisticType.VALUE, 0, "6", "Absorption")),
        HEALTH(new Statistic(39, Statistic.StatisticType.VALUE, 100, 100, "a", "Health")),
        DAMAGE(new Statistic(40, StatisticType.VALUE, 5, "c", "Damage"));

        private final Statistic statistic;

        Statistics(Statistic statistic) {
            this.statistic = statistic;
        }

        public PlayerStatistic getPlayerStatistic() {
            return new PlayerStatistic(this);
        }

        public Statistic getStatistic(double value, double maxValue) {
            Statistic stat = statistic;
            stat.setValue(value);
            stat.setMaxValue(maxValue);
            return stat;
        }

        public Statistic getStatistic(double value) {
            Statistic stat = statistic;
            stat.setValue(value);
            stat.setMaxValue(-1);
            return stat;
        }

        public static Statistic getByID(int id, double val) {
            for (Statistics value : values()) {
                if (id == value.statistic.statisticID) {
                    return value.getStatistic(val);
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return statistic.getName();
        }
    }
}
