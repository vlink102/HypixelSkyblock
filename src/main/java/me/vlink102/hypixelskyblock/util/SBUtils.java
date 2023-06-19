package me.vlink102.hypixelskyblock.util;

public class SBUtils {
    public static class Damage {
        private final DamageType damageType;
        private final double value;

        public Damage(DamageType damageType, double value) {
            this.damageType = damageType;
            this.value = value;
        }

        public DamageType getDamageType() {
            return damageType;
        }

        public double getValue() {
            return value;
        }
    }

    public enum DamageType {
        NORMAL,
        MAGIC,
        TRUE,
        FALL,
        FIRE,
        POISON,
        WITHER
    }
}
