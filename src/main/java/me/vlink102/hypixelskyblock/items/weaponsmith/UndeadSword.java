package me.vlink102.hypixelskyblock.items.weaponsmith;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.Material;

import java.util.List;

public class UndeadSword extends SBItem {

    public UndeadSword(String itemID, String itemName, String skullTexture, Material material, boolean soulBound, boolean reforgable, int maxStackSize, int hpb, int fpb, int jpb, boolean aow, boolean aop, boolean recomb, ItemType itemType, ItemRarity rarity, List<SBEnchantment> sbEnchantments, Statistic... statistics) {
        super("UNDEAD_SWORD", itemName, skullTexture, material, soulBound, reforgable, maxStackSize, hpb, fpb, jpb, aow, aop, recomb, itemType, rarity, sbEnchantments, statistics);
    }
}
