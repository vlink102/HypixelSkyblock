package me.vlink102.hypixelskyblock.util;

import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

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

    public static String getItemName(ItemStack bukkitItemStack) {
        net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(bukkitItemStack);
        return nmsStack.getItem().a(nmsStack);
    }

    public static int getTotalExp(double level) {
        if (level <= 16) {
            return (int) (Math.pow(level, 2) + (6 * level));
        } else if (level <= 31) {
            return (int) ((2.5 * Math.pow(level, 2)) - (40.5 * level) + 360);
        } else {
            return (int) ((4.5 * Math.pow(level, 2)) - (162.5 * level) + 2220);
        }
    }

    public static double getCombinedEnchantLevels(double one, double two) {
        int oneXp = getTotalExp(one);
        int twoXp = getTotalExp(two);
        return getTotalLevels(oneXp + twoXp);
    }

    public static int roundDown(double x) {
        return (int) Math.floor(x);
    }

    public static String round(Double x, int precision) {
        BigDecimal bd = new BigDecimal(x);
        bd = bd.round(new MathContext(precision));
        return bd.toString();
    }

    public static String round(Double x) {
        BigDecimal bd = new BigDecimal(x);
        bd = bd.round(new MathContext(3));
        return bd.toString().replaceAll("\\.0+", "");
    }

    public static int getRoundedCombinedEnchantLevels(double one, double two) {
        return (int) Math.floor(getCombinedEnchantLevels(one, two));
    }

    public static double getTotalLevels(double total) {
        if (total <= 352) {
            return Math.sqrt(total + 9) - 3;
        } else if (total <= 1507) {
            return (81d / 10d) + Math.sqrt((2d / 5d) * (total - (7839d / 40d)));
        } else {
            return (325d / 18d) + Math.sqrt((2d / 9d) * (total - (54215d / 72d)));
        }
    }
}
