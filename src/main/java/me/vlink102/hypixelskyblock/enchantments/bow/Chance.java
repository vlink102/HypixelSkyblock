package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Chance extends SBEnchantment {
    public Chance(int level) {
        super(55, "Chance", level);
    }

    public double getItemDropChanceModifier() {
        return getLevel() * Statistic.fromPercentage(15);
    }

    public Integer[] enchantingTableCosts = new Integer[] {15,30,45};
    public Integer[] applyCosts = new Integer[] {-1,27,41,91,179};
    public Integer[] rarities = new Integer[] {1,1,1,1,2};
    public int enchantingLevelRequired = 11;
    public int bookshelfPower = 4;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.BOW);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Increases the chance of a"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Monster dropping an item by"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&a" + Statistic.toPercentage((int)getItemDropChanceModifier()) + "%&7."));
        description.add("");
        if (applyCosts[getLevel() - 1] > 0) {
            description.add(ChatColor.translateAlternateColorCodes('&', "&7Apply Cost: &3" + applyCosts[getLevel() - 1] + " Exp Levels"));
            description.add("");
        }
        if (getLevel() == 4) {
            description.add(ChatColor.translateAlternateColorCodes('&', "&7Use this on an item in an Anvil"));
            description.add(ChatColor.translateAlternateColorCodes('&', "&7to apply it."));
        }
        
        return description;
    }

    @Override
    public Integer[] getRarities() {
        return rarities;
    }

    @Override
    public Integer[] getApplyCosts() {
        return applyCosts;
    }

    @Override
    public Integer[] getEnchantingTableCosts() {
        return enchantingTableCosts;
    }

    @Override
    public double getBookshelfPower() {
        return bookshelfPower;
    }
}
