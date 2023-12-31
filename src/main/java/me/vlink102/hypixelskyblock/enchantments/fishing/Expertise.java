package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.SBUtils;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Expertise extends SBEnchantment {
    public Expertise(int level) {
        super(6, "Expertise", level);
    }

    public double getFishingWisdomAdditive() {
        return getLevel() * 2;
    }

    public double getSeaCreatureChanceModifier() {
        return getLevel() * Statistic.fromPercentage(0.6);
    }

    public Integer[] killsToTier = new Integer[] {50,100,250,500,1000,2500,5500,10000,15000};

    public Integer[] applyCosts = new Integer[] {23,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    
    public int enchantingLevelRequired = 15;
    public int bookshelfPower = 18;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.FISHING_ROD);
        return itemTypes;
    }

    @Override
    public List<String> getFullDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Grants &3+" + SBUtils.round(Statistic.toPercentage(getSeaCreatureChanceModifier())) + " αSea Creature"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&3Chance &7and &3+" + getFishingWisdomAdditive() + " ☯Fishing Wisdom &7when killing sea"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Creatures."));
        description.add("");
        description.add("&8" + killsToTier[getLevel() - 1] + " kills to tier up!");
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

    public double getBookshelfPower() {
        return bookshelfPower;
    }
}
