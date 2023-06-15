package me.vlink102.hypixelskyblock.enchantments;

public class Tabasco extends SBEnchantment {
    public Tabasco(int level) {
        super(39, "Tabasco", level);
    }

    public double getWeaponDamageAdditive() {
        return getLevel();
    }
}
