package me.vlink102.hypixelskyblock.enchantments;

public class DivineGift extends SBEnchantment {
    public DivineGift(int level) {
        super(19, "Divine Gift", level);
    }

    public double getMagicFindAdditive() {
        return getLevel() * 2;
    }
}
