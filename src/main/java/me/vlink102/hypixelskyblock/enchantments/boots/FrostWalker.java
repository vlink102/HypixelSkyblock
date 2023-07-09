package me.vlink102.hypixelskyblock.enchantments.boots;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class FrostWalker extends SBEnchantment {
    public FrostWalker(int level) {
        super(96, "Frost Walker", level, 94L);
    }

    public double getBlockFreezeRadius() {
        return getLevel();
    }

    public Integer[] enchantingTableCosts = new Integer[] {10,20};
    public Integer[] applyCosts = new Integer[] {9,18};
    
    public double bookshelfPower = 3;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.BOOTS);
        return itemTypes;
    }

    @Override
    public List<String> getFullDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Ice blocks will be created below"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7you when you walk above water in"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7a radius of &a" + (int)getBlockFreezeRadius() + " &7blocks."));
        description.add(ChatColor.translateAlternateColorCodes('&', "&a&c"));
        if (applyCosts[getLevel() - 1] > 0) {
            description.add(ChatColor.translateAlternateColorCodes('&', "&7Apply Cost: &3" + applyCosts[getLevel() - 1] + " Exp Levels"));
            description.add("");
        }
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Applicable on: " + getAppliedToFancy()));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Use this on an item in an Anvil"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7to apply it."));
        
        return description;
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
