package me.vlink102.hypixelskyblock.enchantments.equipment;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Prosperity extends SBEnchantment {
    public Prosperity(int level) {
        super(126, "Prosperity", level);
    }

    public double getHealthAdditive() {
        return getLevel() * 3;
    }

    public Integer[] applyCosts = new Integer[] {91,91,91,91,179};
    public Integer[] rarities = new Integer[] {1,1,1,1,2};

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.HELMET);
        itemTypes.add(SBItem.ItemType.GLOVES);
        itemTypes.add(SBItem.ItemType.BELT);
        itemTypes.add(SBItem.ItemType.NECKLACE);
        itemTypes.add(SBItem.ItemType.BRACELET);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Grants &a+" + (int) getHealthAdditive() + " &c❤Health"));
        description.add("");
        if (applyCosts[getLevel() - 1] > 0) {
            description.add(ChatColor.translateAlternateColorCodes('&', "&7Apply Cost: &3" + applyCosts[getLevel() - 1] + " Exp Levels"));
            description.add("");
        }
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Use this on an item in an Anvil"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7to apply it."));
        description.add("");
        return description;
    }
}
