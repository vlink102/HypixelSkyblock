package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Magnet extends SBEnchantment {
    public Magnet(int level) {
        super(11, "Magnet", level);
    }

    public int getAdditionalExperienceOrbs() {
        return getLevel();
    }

    public Integer[] enchantingTableCosts = new Integer[] {20,25,30,40,50};
    public Integer[] applyCosts = new Integer[] {-1,-1,-1,36,45,58};
    public Integer[] rarities = new Integer[] {1,1,1,1,2,3};
    public int enchantingLevelRequired = 13;
    public int bookshelfPower = 5;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.FISHING_ROD);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Grants &a" + getAdditionalExperienceOrbs() + " &7additional"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7experience orbs every time you"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7successfully catch a fish."));
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
