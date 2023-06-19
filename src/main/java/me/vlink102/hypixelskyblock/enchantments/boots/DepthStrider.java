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
        description.add(ChatColor.translateAlternateColorCodes('&', "&7in the water by &a" + getWaterSpeedReductionModifier() + "%&7."));
        description.add("");
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Use this on an item in an Anvil"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7to apply it."));
        description.add("");
        description.add(ChatColor.translateAlternateColorCodes('&', "&6Source:"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&aI-III: &7Enchantment Table,"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Pufferfish Collection"));
        description.add("");
        description.add(ChatColor.translateAlternateColorCodes('&', "&6Applied To:"));
        for (SBItem.ItemType itemType : appliedTo()) {
            description.add(ChatColor.translateAlternateColorCodes('&', "&7- &f" + WordUtils.capitalizeFully(itemType.toString())));
        }
        if (getConflictingEnchantments().size() != 0) {
            description.add("");
            description.add(ChatColor.translateAlternateColorCodes('&', "Conflicts:"));
            for (Long conflictingEnchantment : getConflictingEnchantments()) {
                SBEnchantment enchantment = SBEnchantment.getEnchantByID(conflictingEnchantment, 1);
                description.add(ChatColor.translateAlternateColorCodes('&', "&7- &c" + enchantment.getDisplayName()));
            }
        }
        return description;
    }
}
