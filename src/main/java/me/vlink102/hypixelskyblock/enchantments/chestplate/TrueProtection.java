package me.vlink102.hypixelskyblock.enchantments.chestplate;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class TrueProtection extends SBEnchantment {
    public TrueProtection(int level) {
        super(92, "True Protection", level);
    }

    public final double trueDefenseAdditive = 5;

    public Integer[] applyCosts = new Integer[] {36};
    public Integer[] rarities = new Integer[] {1};
    public int enchantingLevelRequired = 15;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.CHESTPLATE);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Grants &f+" + (int) trueDefenseAdditive + "❂ True Defense&7."));
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

}
