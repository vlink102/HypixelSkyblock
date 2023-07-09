package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.SBUtils;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Protection extends SBEnchantment {
    public Protection(int level) {
        super(78, "Protection", level, 70L, 77L, 72L);
    }

    public static List<Integer> PROTECTION_DEFENSE_VALUES = Arrays.asList(4, 8, 12, 16, 20, 25, 30);

    public double getDefenseAdditive() {
        return PROTECTION_DEFENSE_VALUES.get(getLevel() - 1);
    }

    public Integer[] enchantingTableCosts = new Integer[] {10,15,20,25,30};
    public Integer[] applyCosts = new Integer[] {9,13,18,23,27,91,179};

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.HELMET);
        itemTypes.add(SBItem.ItemType.BOOTS);
        itemTypes.add(SBItem.ItemType.CHESTPLATE);
        itemTypes.add(SBItem.ItemType.LEGGINGS);
        return itemTypes;
    }

    @Override
    public List<String> getFullDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Grants &a+" + SBUtils.round(getDefenseAdditive()) + " &a❈ Defense&7."));
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
}
