package me.vlink102.hypixelskyblock.enchantments.tools;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.SBUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fortune extends SBEnchantment {
    public Fortune(int level) {
        super(100, "Fortune", level, 102L);
    }

    public static final List<Integer> FORTUNE_MINING_VALUES = Arrays.asList(10, 20, 30, 45);

    public double getMiningFortuneAdditive() {
        return FORTUNE_MINING_VALUES.get(getLevel() - 1);
    }

    public Integer[] enchantingTableCosts = new Integer[] {15,30,45};
    public Integer[] applyCosts = new Integer[] {-1,27,41,-1};
    
    public int bookshelfPower = 2;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.PICKAXE);
        itemTypes.add(SBItem.ItemType.DRILL);
        itemTypes.add(SBItem.ItemType.GAUNTLET);
        return itemTypes;
    }

    @Override
    public List<String> getFullDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Grants &6+" + SBUtils.round(getMiningFortuneAdditive()) + "☘ Mining Fortune&7,"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7which increases your chance for"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7multiple drops."));
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
