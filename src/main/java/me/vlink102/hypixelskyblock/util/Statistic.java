package me.vlink102.hypixelskyblock.util;

public class Statistic {
    public enum StatisticType {
        PERCENTAGE,
        VALUE
    }

    private final StatisticType type;
    private final double value;

    public Statistic(StatisticType type, double baseValue) {
        this.type = type;
        this.value = baseValue;
    }

    public Statistic(double baseValue) {
        this.type = StatisticType.VALUE;
        this.value = baseValue;
    }

    public StatisticType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }
}
