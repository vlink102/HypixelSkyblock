package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.SBUtils;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerEggThrowEvent;

import java.util.ArrayList;
import java.util.List;

public class Snipe extends SBEnchantment {
    public Snipe(int level) {
        super(63, "Snipe", level);
    }

    public double getDamageModifier(int blocksTravelled) {
        return blocksTravelled * Statistic.fromPercentage(getLevel());
    }

    public double getDamageModifier() {
        return Statistic.fromPercentage(getLevel());
    }

    public Integer[] enchantingTableCosts = new Integer[] {20,25,30};
    public Integer[] applyCosts = new Integer[] {-1,23,27,-1};
    
    public int enchantingLevelRequired = 6;
    public int bookshelfPower = 8;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.BOW);
        return itemTypes;
    }

    @Override
    public List<String> getFullDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Arrows deal &a+" + SBUtils.round(Statistic.toPercentage(getDamageModifier())) + "% &7damage for"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7every &a10 &7blocks travelled."));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7of the damage."));
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
