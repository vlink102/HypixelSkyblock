package me.vlink102.hypixelskyblock.enchantments.equipment;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.SBUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class GreenThumb extends SBEnchantment {
    public GreenThumb(int level) {
        super(105, "Green Thumb", level);
    }

    public double getFarmingFortuneAdditive(int uniqueVisitorsServed) {
        return uniqueVisitorsServed * (getLevel() * 0.05);
    }

    public double getFarmingFortuneAdditive() {
        return (getLevel() * 0.05);
    }

    public Integer[] applyCosts = new Integer[] {45,91,136,179,223};
    
    public int enchantingLevelRequired = 24;

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
    public List<String> getFullDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Grants &6" + SBUtils.round(getFarmingFortuneAdditive()) + "☘ Farming Fortune"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7per unique visitor served."));
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
}
