package me.vlink102.hypixelskyblock.items.bookmodifiers;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class BookModifier extends SBItem {
    public BookModifier(String itemID, String itemName, Material material, int maxStackSize, ItemType itemType, ItemRarity rarity) {
        super(itemID, itemName, null, material, false, false, maxStackSize, 0, 0, 0, false, false, false, itemType, rarity, new ArrayList<>());
    }
}
