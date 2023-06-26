package me.vlink102.hypixelskyblock.enchantments.bow;

import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.player.SBPlayer;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Overload extends SBEnchantment {
    public Overload(int level) {
        super(59, "Overload", level);
    }

    public double getMegaCriticalHitModifier() {
        return getLevel() * Statistic.fromPercentage(10);
    }

    public double getCritDamageModifier() {
        return Statistic.fromPercentage(getLevel());
    }

    public double getCritChanceModifier() {
        return Statistic.fromPercentage(getLevel());
    }

    public double getMegaCriticalHitChanceModifier(SBPlayer player) {
        return Statistic.fromPercentage(player.getCritChance().getValue() - 100);
    }

    public Integer[] applyCosts = new Integer[] {45,91,136,179,223};
    public Integer[] rarities = new Integer[] {1,1,1,1,2};
    public int enchantingLevelRequired = 33;

    @Override
    public List<SBItem.ItemType> appliedTo() {
        List<SBItem.ItemType> itemTypes = new ArrayList<>();
        itemTypes.add(SBItem.ItemType.BOW);
        return itemTypes;
    }

    @Override
    public List<String> getDescription() {
        List<String> description = new ArrayList<>();

        description.add(ChatColor.translateAlternateColorCodes('&', "&7Increases &9☠ Crit Damage &7by"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&a" + Statistic.toPercentage((int) getCritDamageModifier()) + "% &7and &9☣ Crit Chance &7by"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&a" + Statistic.toPercentage((int) getCritChanceModifier()) + "%&7. Having a Critical chance"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7above &9100% &7grants a chance"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7to perform a Mega Critical Hit"));
        description.add(ChatColor.translateAlternateColorCodes('&', "&7dealing &9" + Statistic.toPercentage((int) getMegaCriticalHitModifier()) + "&7 extra damage."));
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
