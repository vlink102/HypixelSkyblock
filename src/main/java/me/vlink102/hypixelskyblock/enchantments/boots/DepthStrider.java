package me.vlink102.hypixelskyblock.enchantments.boots;

import jdk.nashorn.internal.runtime.WithObject;
import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class DepthStrider extends SBEnchantment {
    public DepthStrider(int level) {
        super(94, "Depth Strider", level, 96L);
    }

    public double getWaterSpeedReductionModifier() {
        return getLevel() * Statistic.fromPercentage(100d/3d);
    }

    public Integer[] applyCosts = new Integer[] {0,18,27};
    public Integer[] rarities = new Integer[] {1,1,1};
    public double bookshelfPower = 4;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.BOOTS);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Reduces how much you are slowed"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7in the water by &a" + Statistic.toPercentage((int) getWaterSpeedReductionModifier()) + "%&7."));
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
