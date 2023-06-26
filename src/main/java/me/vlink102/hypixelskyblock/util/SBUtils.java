package me.vlink102.hypixelskyblock.util;

import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

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
}
