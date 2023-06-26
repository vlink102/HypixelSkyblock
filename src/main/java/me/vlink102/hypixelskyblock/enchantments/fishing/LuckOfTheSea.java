package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class LuckOfTheSea extends SBEnchantment {
    public LuckOfTheSea(int level) {
        super(9, "Luck of the Sea", level);
    }

    public double getFishingTreasureChanceModifier() {
        return getLevel() * Statistic.fromPercentage(1);
    }

    public Integer[] enchantingTableCosts = new Integer[] {-1,15,20,25,30};
    public Integer[] applyCosts = new Integer[] {9,13,18,23,27,45};
    public Integer[] rarities = new Integer[] {1,1,1,1,2,3};
    public int bookshelfPower = 1;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.FISHING_ROD);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Increases the chance of fishing"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7treasure by &a" + Statistic.toPercentage((int) getFishingTreasureChanceModifier()) + "%&7."));
        description.add("");
        if (applyCosts[getLevel() - 1] > 0) {
            description.add(ChatColor.translateAlternateColorCodes('&', "&7Apply Cost: &3" + applyCosts[getLevel() - 1] + " Exp Levels"));
            description.add("");
        }
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Use this on an item in an Anvil"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7to apply it."));
        
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
