package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.SBUtils;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class InfiniteQuiver extends SBEnchantment {
    public InfiniteQuiver(int level) {
        super(58, "Infinite Quiver", level);
    }

    public double getArrowSaveModifier() {
        return getLevel() * Statistic.fromPercentage(3);
    }

    public Integer[] enchantingTableCosts = new Integer[] {10,15,20,25,30};
    public Integer[] applyCosts = new Integer[] {-1,-1,-1,23,27,55,79,91,109,127};
    
    public int enchantingLevelRequired = 2;
    public int bookshelfPower = 3;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.BOW);
        return itemTypes;
    }

    @Override
    public List<String> getFullDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Saves arrows &a" + SBUtils.round(Statistic.toPercentage(getArrowSaveModifier())) + "% &7of the time"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7when you fire your bow. Disabled"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7while sneaking."));
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
