package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Blessing extends SBEnchantment {

    public Blessing(int level) {
        super(2, "Blessing", level);
    }

    public double getDoubleDropChanceModifier() {
        return getLevel() * Statistic.fromPercentage(5);
    }

    public Integer[] enchantingTableCosts = new Integer[] {10,20,30,40,50};
    public Integer[] applyCosts = new Integer[] {-1,-1,-1,36,45,58};
    public Integer[] rarities = new Integer[] {1,1,1,1,2,3};
    public int enchantingLevelRequired = 9;
    public int bookshelfPower = 6;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.FISHING_ROD);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&a" + Statistic.toPercentage((int) getDoubleDropChanceModifier()) + "% &7chance to get double"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7drops when fishing."));
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
