package me.vlink102.hypixelskyblock.enchantments.helmet;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.SBUtils;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Hecatomb extends SBEnchantment {
    public Hecatomb(int level) {
        super(75, "Hecatomb", level);
    }

    public double getCatacombsXPModifier() {
        return Statistic.fromPercentage(0.2) + (getLevel() * Statistic.fromPercentage(0.08));
    }

    public double getClassXPModifier() {
        return Statistic.fromPercentage(0.4) + (getLevel() * Statistic.fromPercentage(0.16));
    }

    public double getHealthAdditive() {
        return 2 + (getLevel() * 0.6);
    }

    public Integer[] sRunsTierUp = new Integer[] {2,5,10,20,30,40,60,80,100};

    public Integer[] applyCosts = new Integer[] {23};
    

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.HELMET);
        return itemTypes;
    }

    @Override
    public List<String> getFullDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Gain &a+" + SBUtils.round(Statistic.toPercentage(getCatacombsXPModifier())) + "% &cCatacombs &7XP &"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&a+" + SBUtils.round(Statistic.toPercentage(getClassXPModifier())) + "% &3Class &7XP, doubled on &bS+ &7runs."));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Grants &c+" + SBUtils.round(getHealthAdditive()) + "❤ &7per &610 &cCatacombs &7levels."));
        description.add("");
        description.add("&a" + sRunsTierUp[getLevel() - 1] + " &bS &7runs to tier up!");
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
