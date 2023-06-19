package me.vlink102.hypixelskyblock.items.weaponsmith;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.Material;

import java.util.List;

public class UndeadSword extends SBItem {

    public UndeadSword(String itemID, String itemName, Material material, boolean soulBound, boolean reforgable, boolean stackable, int hpb, int fpb, boolean aow, boolean aop, boolean recomb, ItemType itemType, ItemRarity rarity, List<SBEnchantment> sbEnchantments, Statistic... statistics) {
        super(itemID, itemName, material, soulBound, reforgable, stackable, hpb, fpb, aow, aop, recomb, itemType, rarity, sbEnchantments, statistics);
    }
}
