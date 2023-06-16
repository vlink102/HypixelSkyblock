package me.vlink102.hypixelskyblock.util;

public class Statistic {
    public enum StatisticType {
        PERCENTAGE,
        VALUE,
        BOOLEAN
    }

    private final long statisticID;
    private final StatisticType type;
    private final double value;
    private final double maxValue;

    public Statistic(long statisticID, StatisticType type, double baseValue) {
        this.type = type;
        this.value = baseValue;
        this.maxValue = -1;
        this.statisticID = statisticID;
    }

    public Statistic(long statisticID, StatisticType type, double baseValue, double maxValue) {
        this.type = type;
        this.value = baseValue;
        this.maxValue = maxValue;
        this.statisticID = statisticID;
    }

    public Statistic(long statisticID, double baseValue) {
        this.type = StatisticType.VALUE;
        this.value = baseValue;
        this.maxValue = -1;
        this.statisticID = statisticID;
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

    public int getRoundedValue() {
        return (int) value;
    }

    public static double fromPercentage(double percentage) {
        return percentage / 100D;
    }

    public static double toPercentage(double value) {
        return value * 100D;
    }
}
