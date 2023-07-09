package me.vlink102.hypixelskyblock.enchantments.boots;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.SBUtils;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class FeatherFalling extends SBEnchantment {
    public FeatherFalling(int level) {
        super(95, "Feather Falling", level);
    }

    public double getFallDamageReductionModifier() {
        return getLevel() * Statistic.fromPercentage(5);
    }

    public double getFallDamageBlockBuffer() {
        return getLevel();
    }

    public Integer[] enchantingTableCosts = new Integer[] {10,15,20,25,30};
    public Integer[] applyCosts = new Integer[] {-1,-1,-1,23,27,55,79,91,109,127};
    
    public double bookshelfPower = 2;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.BOOTS);
        return itemTypes;
    }

    @Override
    public List<String> getFullDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Increases how high you can fall"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7before taking fall damage by "));
        description.add(ChatColor.translateAlternateColorCodes('&', "&a" + (int)getFallDamageBlockBuffer() + " &7and reduces fall damage by"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&a" + SBUtils.round(Statistic.toPercentage(getFallDamageReductionModifier())) + "%&7."));
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
