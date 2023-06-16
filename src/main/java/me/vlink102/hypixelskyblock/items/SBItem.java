package me.vlink102.hypixelskyblock.items;

import de.tr7zw.nbtapi.NBTIntArrayList;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.plugin.NBTAPI;
import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.util.Statistic;
import net.minecraft.server.v1_8_R3.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SBItem {
    private final String itemID;
    private final String itemName;
    private final List<Statistic> baseStats;
    private final List<SBEnchantment> sbEnchantments;
    private final boolean stackable;

    private final org.bukkit.Material material;

    private ItemRarity rarity;

    private final int hotPotatoBooks;
    private final int fumingPotatoBooks;
    private final boolean artOfWar;

    private final boolean recombobulated;

    public SBItem(String itemID, String itemName, Material material, boolean stackable, int hpb, int fpb, boolean aow, boolean recomb, ItemRarity rarity, List<SBEnchantment> sbEnchantments, Statistic... statistics) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.sbEnchantments = sbEnchantments;
        this.baseStats = Arrays.asList(statistics);
        this.stackable = stackable;
        this.material = material;

        this.hotPotatoBooks = hpb;
        this.fumingPotatoBooks = fpb;
        this.artOfWar = aow;
        this.recombobulated = recomb;

        this.rarity = rarity;

        // TODO reforges
    }

    public int getHotPotatoBooks() {
        return hotPotatoBooks;
    }

    public int getFumingPotatoBooks() {
        return fumingPotatoBooks;
    }

    public boolean isArtOfWar() {
        return artOfWar;
    }

    public boolean isRecombobulated() {
        return recombobulated;
    }

    public enum ItemRarity {
        COMMON,
        UNCOMMON,
        RARE,
        EPIC,
        LEGENDARY,
        MYTHIC,
        DIVINE,
        SPECIAL
    }

    public enum ItemType {

    }

    public Material getMaterial() {
        return material;
    }

    public boolean isStackable() {
        return stackable;
    }

    public ItemStack generateItem(int count) {
        ItemStack stack = new ItemStack(material, count);
        NBTItem item = new NBTItem(stack);
        item.setString("sb_enchantments", getJSONEnchants());
        item.setString("sb_base_statistics", getJSONBaseStatistics());
        item.setBoolean("recombobulated", recombobulated);
        item.setInteger("hot_potato_books", hotPotatoBooks);
        item.setInteger("fuming_potato_books", fumingPotatoBooks);
        item.setBoolean("art_of_war", artOfWar);
        item.setEnum("rarity", rarity);

        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', itemName));
        meta.setLore(generateLore());
        return item.getItem();
    }

    public List<String> generateLore() {
        List<String> lore = new ArrayList<>();

        lore.add("");
        return null;
    }

    public String getJSONBaseStatistics() {
        JSONObject o = new JSONObject();
        for (Statistic baseStat : baseStats) {
            o.put(String.valueOf(baseStat.getStatisticID()), baseStat.getValue());
        }
        return o.toString();
    }

    public String getJSONEnchants() {
        JSONObject o = new JSONObject();
        for (SBEnchantment sbEnchantment : sbEnchantments) {
            o.put(String.valueOf(sbEnchantment.getID()), sbEnchantment.getLevel());
        }
        return o.toString();
    }

    public List<SBEnchantment> getSbEnchantments() {
        return sbEnchantments;
    }

    public List<Statistic> getBaseStats() {
        return baseStats;
    }

    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }
}
