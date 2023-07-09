package me.vlink102.hypixelskyblock.enchantments.boots;

import jdk.nashorn.internal.runtime.WithObject;
import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.SBUtils;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class DepthStrider extends SBEnchantment {
    public DepthStrider(int level) {
        super(94, "Depth Strider", level, 96L);
    }

    public double getWaterSpeedReductionModifier() {
        return getLevel() * Statistic.fromPercentage(100d/3d);
    }

    public Integer[] enchantingTableCosts = new Integer[] {10,20,30};
    public Integer[] applyCosts = new Integer[] {-1,18,27};
    
    public double bookshelfPower = 4;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.BOOTS);
        return itemTypes;
    }

    @Override
    public List<String> getFullDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Reduces how much you are slowed"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7in the water by &a" + SBUtils.round(Statistic.toPercentage(getWaterSpeedReductionModifier())) + "%&7."));
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
