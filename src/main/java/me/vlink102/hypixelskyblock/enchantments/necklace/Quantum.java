package me.vlink102.hypixelskyblock.enchantments.necklace;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Quantum extends SBEnchantment {
    public Quantum(int level) {
        super(106, "Quantum", level);
    }

    public double getVitalityAdditive() {
        return getLevel() * 0.8;
    }

    public double getWisdomAdditive() {
        return getLevel() * 0.4;
    }

    public Integer[] applyCosts = new Integer[] {-1,-1,45,45,91};
    public Integer[] rarities = new Integer[] {1,1,2};

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.HELMET);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Grants &4+" + getVitalityAdditive() + "♨ Vitality &7on"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7weekdays and &3+" + getWisdomAdditive() + "☯ &7of a"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7random &3Wisdom &7stat on"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7weekends."));
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
