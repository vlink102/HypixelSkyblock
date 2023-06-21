package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Flame extends SBEnchantment {
    public Flame(int level) {
        super(57, "Flame", level);
    }

    public double getIgnitedSeconds() {
        return 3 + (getLevel() * 0.5);
    }

    public double getDamageModifier() {
        return getLevel() * Statistic.fromPercentage(3);
    }

    public Integer[] applyCosts = new Integer[] {23,0};
    public Integer[] rarities = new Integer[] {1,1};
    public int bookshelfPower = 3;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.BOW);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Arrows ignite your enemies for"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&a" + (int) getIgnitedSeconds() + "s&7."));
        description.add("");
        if (applyCosts[getLevel() - 1] > 0) {
            description.add(ChatColor.translateAlternateColorCodes('&', "&7Apply Cost: &3" + applyCosts[getLevel() - 1] + " Exp Levels"));
            description.add("");
        }
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Use this on an item in an Anvil"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7to apply it."));
        description.add("");
        return description;
    }
}
