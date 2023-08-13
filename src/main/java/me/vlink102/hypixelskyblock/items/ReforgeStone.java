package me.vlink102.hypixelskyblock.items;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class ReforgeStone extends SBItem {
    public ReforgeStone(String itemID, String itemName, String skullTexture, Material material, int maxStackSize, ItemRarity rarity) {
        super(itemID, itemName, skullTexture, material, false, false, maxStackSize, 0, 0, 0, false, false, false, ItemType.REFORGE_STONE, rarity, new ArrayList<>());
    }
}
