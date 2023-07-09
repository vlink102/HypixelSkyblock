package me.vlink102.hypixelskyblock.enchantments.chestplate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class CounterStrike extends SBEnchantment {
    public CounterStrike(int level) {
        super(91, "Counter-Strike", level);
    }

    public double getDefenseAdditive() {
        return getLevel() * 2;
    }

    public Integer[] applyCosts = new Integer[] {55,79,91};
    
    public int enchantingLevelRequired = 22;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.CHESTPLATE);
        return itemTypes;
    }

    @Override
    public List<String> getFullDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Gain &a+" + (int) getDefenseAdditive() + "❈ Defense &7for &a7s"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7on the first hit from an"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7enemy."));
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
