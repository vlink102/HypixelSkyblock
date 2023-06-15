package me.vlink102.hypixelskyblock.items;

import javafx.scene.paint.Material;
import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class SBItem {
    private final String itemID;
    private final String itemName;
    private final List<Statistic> statistics;
    private final List<SBEnchantment> sbEnchantments;

    public SBItem(String itemID, String itemName, ItemStack itemStack, boolean stackable, List<SBEnchantment> sbEnchantments, Statistic... statistics) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.sbEnchantments = sbEnchantments;
        this.statistics = Arrays.asList(statistics);

        // TODO
    }

    public List<String> generateLore() {
        return null; // TODO
    }

    public List<SBEnchantment> getSbEnchantments() {
        return sbEnchantments;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }
}
