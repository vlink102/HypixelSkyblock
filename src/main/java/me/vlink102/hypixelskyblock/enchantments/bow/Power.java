package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Power extends SBEnchantment {
    public Power(int level) {
        super(61, "Power", level);
    }

    public static List<Integer> POWER_DAMAGE_MODIFIER = Arrays.asList(8, 16, 24, 32, 40, 50, 65);

    public double getDamageModifier() {
        return Statistic.fromPercentage(POWER_DAMAGE_MODIFIER.get(getLevel() - 1));
    }

    public Integer[] applyCosts = new Integer[] {0,0,0,36,45,91,179};
    public Integer[] rarities = new Integer[] {1,1,1,1,2,3,4};

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.BOW);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Increases bow damage by &a" + Statistic.toPercentage((int) getDamageModifier()) + "%&7."));
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
