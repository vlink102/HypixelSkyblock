package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Piercing extends SBEnchantment {
    public Piercing(int level) {
        super(60, "Piercing", level);
    }

    public double piercedThroughEnemyDamageModifier = Statistic.fromPercentage(25);

    public Integer[] applyCosts = new Integer[] {27};
    public Integer[] rarities = new Integer[] {1};
    public int enchantingLevelRequired = 17;
    public int bookshelfPower = 20;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.BOW);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();
        description.add(ChatColor.translateAlternateColorCodes('&', "&7Arrows travel through enemies."));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7The extra targets hit take &a" + Statistic.toPercentage((int) piercedThroughEnemyDamageModifier)));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7of the damage."));
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
