package me.vlink102.hypixelskyblock.enchantments.sword;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.SBUtils;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sharpness extends SBEnchantment {
    public Sharpness(int level) {
        super(35, "Sharpness", level, 15L, 36L);
    }

    public static List<Integer> SHARPNESS_PERCENTAGE_VALUES = Arrays.asList(5, 10, 15, 20, 30, 45, 65);

    public double getDamageModifier() {
        return Statistic.fromPercentage(SHARPNESS_PERCENTAGE_VALUES.get(getLevel() - 1));
    }

    public Integer[] enchantingTableCosts = new Integer[] {10,15,20,25,30};
    public Integer[] applyCosts = new Integer[] {9,13,18,23,27,91,179};

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.SWORD);
        itemTypes.add(SBItem.ItemType.LONGSWORD);
        return itemTypes;
    }

    @Override
    public List<String> getFullDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Increases melee damage dealt by"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&a" + SBUtils.round(Statistic.toPercentage(getDamageModifier())) + "&a%&7."));
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
