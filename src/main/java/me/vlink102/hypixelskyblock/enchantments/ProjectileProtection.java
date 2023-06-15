package me.vlink102.hypixelskyblock.enchantments;

public class ProjectileProtection extends SBEnchantment {
    public ProjectileProtection(int level) {
        super(77, "Projectile Protection", level, 70L, 78L, 72L);
    }

    public double getProjectileDefenseAdditive() {
        return getLevel() * 7;
    }
}
