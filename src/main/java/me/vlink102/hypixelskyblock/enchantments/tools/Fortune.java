package me.vlink102.hypixelskyblock.enchantments.tools;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
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
    public Integer[] rarities = new Integer[] {1,1,1,1,2,3,4,5,6,6};
    public int bookshelfPower = 2;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.HELMET);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Grants &6+" + getMiningFortuneAdditive() + "☘ Mining Fortune&7,"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7which increases your chance for"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7multiple drops."));
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
