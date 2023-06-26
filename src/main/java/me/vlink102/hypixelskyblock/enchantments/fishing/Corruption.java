package me.vlink102.hypixelskyblock.enchantments.fishing;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Corruption extends SBEnchantment {
    public Corruption(int level) {
        super(5, "Corruption", level);
    }

    public double getCorruptedSeaCreatureChanceModifier() {
        return getLevel() * Statistic.fromPercentage(1);
    }

    public Integer[] applyCosts = new Integer[] {18,23,27,36,45};
    public Integer[] rarities = new Integer[] {1,1,1,1,2};
    public int enchantingLevelRequired = 25;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.FISHING_ROD);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Gain a &a" + Statistic.toPercentage((int) getCorruptedSeaCreatureChanceModifier()) + "% &7to spawn a"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Corrupted Sea Creature."));
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
