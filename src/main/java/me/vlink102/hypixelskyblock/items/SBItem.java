package me.vlink102.hypixelskyblock.items;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import me.vlink102.hypixelskyblock.enchantments.*;
import me.vlink102.hypixelskyblock.enchantments.boots.DepthStrider;
import me.vlink102.hypixelskyblock.enchantments.boots.FeatherFalling;
import me.vlink102.hypixelskyblock.enchantments.bow.Flame;
import me.vlink102.hypixelskyblock.enchantments.bow.InfiniteQuiver;
import me.vlink102.hypixelskyblock.enchantments.bow.Power;
import me.vlink102.hypixelskyblock.enchantments.bow.Punch;
import me.vlink102.hypixelskyblock.enchantments.fishing.Lure;
import me.vlink102.hypixelskyblock.enchantments.helmet.AquaAffinity;
import me.vlink102.hypixelskyblock.enchantments.sword.*;
import me.vlink102.hypixelskyblock.enchantments.tools.Efficiency;
import me.vlink102.hypixelskyblock.enchantments.tools.Fortune;
import me.vlink102.hypixelskyblock.enchantments.tools.SilkTouch;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.*;

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
    private final boolean artOfPeace;

    private final boolean recombobulated;

    private final ItemType itemType;

    private final boolean reforgable;
    private boolean coopSoulbound;

    public SBItem(String itemID, String itemName, Material material, boolean soulBound, boolean reforgable, boolean stackable, int hpb, int fpb, boolean aow, boolean aop, boolean recomb, ItemType itemType, ItemRarity rarity, List<SBEnchantment> sbEnchantments, Statistic... statistics) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.sbEnchantments = sbEnchantments;
        this.baseStats = Arrays.asList(statistics);
        this.stackable = stackable;
        this.material = material;

        this.coopSoulbound = soulBound;

        this.hotPotatoBooks = hpb;
        this.fumingPotatoBooks = fpb;
        this.artOfWar = aow;
        this.artOfPeace = aop;
        this.recombobulated = recomb;

        this.reforgable = reforgable;

        this.rarity = rarity;
        this.itemType = itemType;

        // TODO reforges
    }

    public boolean isCoopSoulbound() {
        return coopSoulbound;
    }

    public boolean isReforgable() {
        return reforgable;
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

    public enum ItemType {
        POWER_STONE,
        SWORD,
        BRACELET,
        BOOTS,
        LEGGINGS,
        CHESTPLATE,
        HELMET,
        AXE,
        PICKAXE,
        HOE,
        SHOVEL,
        COSMETIC,
        CLOAK,
        DEPLOYABLE,
        PET_ITEM,
        REFORGE_STONE,
        DUNGEON_ITEM,
        HATCCESSORY,
        BELT,
        GLOVES,
        NECKLACE,
        ACCESSORY,
        ARROW,
        BOW,
        WAND,
        FISHING_ROD,
        DUNGEON_ACCESSORY,
        BAIT,
        TROPHY_FISH,
        DRILL,
        LONGSWORD,
        GAUNTLET,
        SHEARS
    }

    public enum ItemRarity {
        COMMON("f", 1),
        UNCOMMON("a", 2),
        RARE("9", 3),
        EPIC("5", 4),
        LEGENDARY("6", 5),
        MYTHIC("d", 6),
        DIVINE("b", 7),
        SPECIAL("c", 8),
        ADMIN("4", 9);

        private final String color;
        private final int id;

        ItemRarity(String color, int id) {
            this.color = color;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public static ItemRarity getById(int id) {
            for (ItemRarity value : values()) {
                if (id == value.id) {
                    return value;
                }
            }
            return null;
        }

        public String getColor() {
            return color;
        }

        public String getColorFull() {
            return "&" + getColor();
        }
    }

    public Material getMaterial() {
        return material;
    }

    public boolean isStackable() {
        return stackable;
    }

    public static ItemStack fromVanillaItem(ItemStack stack) {
        ItemStack sbItem = new ItemStack(stack);
        ItemMeta metad = sbItem.getItemMeta();
        metad.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metad.addItemFlags(ItemFlag.HIDE_DESTROYS);
        metad.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        metad.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metad.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        metad.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        sbItem.setItemMeta(metad);

        NBTItem item = new NBTItem(sbItem);
        Map<Enchantment, Integer> enchantments = sbItem.getEnchantments();
        List<SBEnchantment> sbEnchantmentList = new ArrayList<>();
        for (Enchantment enchantment : enchantments.keySet()) {
            sbEnchantmentList.add(convert(enchantment, enchantments.get(enchantment)));
        }
        if (sbItem.getType() == Material.ENCHANTED_BOOK) {
            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) sbItem.getItemMeta();
            Map<Enchantment, Integer> enchants = meta.getStoredEnchants();
            for (Enchantment enchantment : enchants.keySet()) {
                SBEnchantment sbEnchantment = convert(enchantment, enchants.get(enchantment));
                sbEnchantmentList.add(sbEnchantment);
            }
        }

        item.setString("sb_enchantments", getJSONEnchants(sbEnchantmentList));
        item.setInteger("rarity", ItemRarity.COMMON.getId());
        List<Statistic> itemStats = new ArrayList<>();

        switch (sbItem.getType()) {
            case BEDROCK:
                item.setInteger("rarity", ItemRarity.LEGENDARY.getId());
                break;
            case ARROW:
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(1));
                break;
            case DIAMOND_BARDING:
            case GOLD_BARDING:
                item.setInteger("rarity", ItemRarity.EPIC.getId());
                break;
            case IRON_BARDING:
                item.setInteger("rarity", ItemRarity.RARE.getId());
                break;
            case GOLDEN_APPLE:
            case COAL_ORE:
            case DIAMOND_ORE:
            case EMERALD_ORE:
            case GLOWING_REDSTONE_ORE:
            case GOLD_ORE:
            case IRON_ORE:
            case LAPIS_ORE:
            case QUARTZ_ORE:
            case DIAMOND_HOE:
            case REDSTONE_ORE:
            case NAME_TAG:
                item.setInteger("rarity", ItemRarity.UNCOMMON.getId());
                break;
            case WOOD_SWORD:
            case GOLD_AXE:
            case GOLD_SPADE:
            case GOLD_SWORD:
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(20));
                break;
            case STONE_SWORD:
            case IRON_AXE:
            case IRON_SPADE:
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(25));
            break;
            case IRON_SWORD:
            case BOW:
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(30));
            break;
            case DIAMOND_SWORD: {
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(35));
                item.setInteger("rarity", ItemRarity.UNCOMMON.getId());
                break;
            }
            case WOOD_PICKAXE: {
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(15));
                itemStats.add(Statistic.Statistics.MINING_SPEED.getStatistic(70));
                itemStats.add(Statistic.Statistics.BREAKING_POWER.getStatistic(1));
                break;
            }
            case STONE_PICKAXE: {
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(20));
                itemStats.add(Statistic.Statistics.MINING_SPEED.getStatistic(110));
                itemStats.add(Statistic.Statistics.BREAKING_POWER.getStatistic(2));
                break;
            }
            case GOLD_PICKAXE: {
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(15));
                itemStats.add(Statistic.Statistics.MINING_SPEED.getStatistic(250));
                itemStats.add(Statistic.Statistics.BREAKING_POWER.getStatistic(1));
                break;
            }
            case IRON_PICKAXE: {
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(25));
                itemStats.add(Statistic.Statistics.MINING_SPEED.getStatistic(160));
                itemStats.add(Statistic.Statistics.BREAKING_POWER.getStatistic(3));
                break;
            }
            case DIAMOND_PICKAXE: {
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(30));
                itemStats.add(Statistic.Statistics.MINING_SPEED.getStatistic(230));
                itemStats.add(Statistic.Statistics.BREAKING_POWER.getStatistic(4));
                item.setInteger("rarity", ItemRarity.UNCOMMON.getId());
                break;
            }
            case WOOD_AXE:
            case WOOD_SPADE:
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(10));
            break;
            case STONE_AXE:
            case STONE_SPADE:
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(15));
            break;
            case DIAMOND_AXE:
            case DIAMOND_SPADE: {
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(30));
                item.setInteger("rarity", ItemRarity.UNCOMMON.getId());
                break;
            }
            case FISHING_ROD: {
                itemStats.add(Statistic.Statistics.DAMAGE.getStatistic(10));
                itemStats.add(Statistic.Statistics.STRENGTH.getStatistic(5));
                break;
            }
        }
        addArmorStats(itemStats, sbItem.getType());

        String material = String.valueOf(sbItem.getType());
        if (material.endsWith("SWORD")) {
            item.setString("item_type", "SWORD");
        }
        if (material.endsWith("AXE")) {
            item.setString("item_type", "AXE");
        }
        if (material.endsWith("PICKAXE")) {
            item.setString("item_type", "PICKAXE");
        }
        if (material.endsWith("HOE")) {
            item.setString("item_type", "HOE");
        }
        if (material.endsWith("SPADE")) {
            item.setString("item_type", "SHOVEL");
        }
        if (material.endsWith("SHEARS")) {
            item.setString("item_type", "SHEARS");
        }
        if (material.endsWith("HELMET")) {
            item.setString("item_type", "HELMET");
        }
        if (material.endsWith("CHESTPLATE")) {
            item.setString("item_type", "CHESTPLATE");
        }
        if (material.endsWith("LEGGINGS")) {
            item.setString("item_type", "LEGGINGS");
        }
        if (material.endsWith("BOOTS")) {
            item.setString("item_type", "BOOTS");
        }
        if (material.endsWith("BOW")) {
            item.setString("item_type", "BOW");
        }
        if (material.endsWith("FISHING_ROD")) {
            item.setString("item_type", "FISHING_ROD");
        }
        if (material.endsWith("ARROW")) {
            item.setString("item_type", "ARROW");
        }

        item.setBoolean("recombobulated", false);
        item.setInteger("hot_potato_books", 0);
        item.setInteger("fuming_potato_books", 0);
        item.setBoolean("art_of_war", false);
        item.setBoolean("art_of_peace", false);

        item.setBoolean("soulbound", false);

        item.setString("sb_base_statistics", getJSONBaseStatistics(itemStats));
        item.setBoolean("reforgable", item.getString("item_type").matches("BOW|SWORD|FISHING_ROD|HELMET|LEGGINGS|CHESTPLATE|BOOTS|AXE|HOE|PICKAXE|SHOVEL"));
        item.setInteger("HideAttributes", 4);

        NBTCompound disp = item.addCompound("display");
        String rawName = capitalise(String.valueOf(sbItem.getType()));
        if (rawName.equalsIgnoreCase("ARROW")) {
            rawName = "Flint Arrow";
        }
        if (rawName.equalsIgnoreCase("BEACON")) {
            rawName = "Beacon Block";
        }
        rawName = rawName.replaceAll("Spade", "Shovel");
        rawName = rawName.replaceAll("Barding", "Horse Armor");
        disp.setString("Name", ChatColor.translateAlternateColorCodes('&', ItemRarity.getById(item.getInteger("rarity")).getColorFull() + rawName));
        List<String> l = disp.getStringList("Lore");
        l.addAll(generateLore(item));

        return item.getItem();
    }

    public static String capitalise(String string) {
        String newString = string.replaceAll("_", " ");
        newString = WordUtils.capitalizeFully(newString);
        return newString;
    }

    private static final List<Material> ARMOR = new ArrayList<Material>() {{
            this.add(Material.LEATHER_BOOTS);
            this.add(Material.LEATHER_CHESTPLATE);
            this.add(Material.LEATHER_LEGGINGS);
            this.add(Material.LEATHER_HELMET);
            this.add(Material.CHAINMAIL_BOOTS);
            this.add(Material.CHAINMAIL_HELMET);
            this.add(Material.CHAINMAIL_CHESTPLATE);
            this.add(Material.CHAINMAIL_LEGGINGS);
            this.add(Material.GOLD_BOOTS);
            this.add(Material.GOLD_HELMET);
            this.add(Material.GOLD_LEGGINGS);
            this.add(Material.GOLD_CHESTPLATE);
            this.add(Material.DIAMOND_BOOTS);
            this.add(Material.DIAMOND_HELMET);
            this.add(Material.DIAMOND_LEGGINGS);
            this.add(Material.DIAMOND_CHESTPLATE);
            this.add(Material.IRON_BOOTS);
            this.add(Material.IRON_HELMET);
            this.add(Material.IRON_LEGGINGS);
            this.add(Material.IRON_CHESTPLATE);
    }};

    public static void addArmorStats(List<Statistic> statistics, Material material) {
        if (!ARMOR.contains(material)) return;
        String materialString = String.valueOf(material);
        int piece = -1;

        if (materialString.endsWith("BOOTS")) {
            piece = 3;
        }
        if (materialString.endsWith("PANTS") || materialString.endsWith("LEGGINGS")) {
            piece = 2;
        }
        if (materialString.endsWith("CHESTPLATE") || materialString.endsWith("TUNIC")) {
            piece = 1;
        }
        if (materialString.endsWith("CAP") || materialString.endsWith("HELMET")) {
            piece = 0;
        }
        if (materialString.startsWith("LEATHER")) {
            statistics.add(Statistic.Statistics.DEFENSE.getStatistic(VANILLA_ARMOR_DEFENSE.get(0)[piece]));
        }
        if (materialString.startsWith("GOLD")) {
            statistics.add(Statistic.Statistics.DEFENSE.getStatistic(VANILLA_ARMOR_DEFENSE.get(1)[piece]));
        }
        if (materialString.startsWith("CHAINMAIL")) {
            statistics.add(Statistic.Statistics.DEFENSE.getStatistic(VANILLA_ARMOR_DEFENSE.get(2)[piece]));
        }
        if (materialString.startsWith("IRON")) {
            statistics.add(Statistic.Statistics.DEFENSE.getStatistic(VANILLA_ARMOR_DEFENSE.get(3)[piece]));
        }
        if (materialString.startsWith("DIAMOND")) {
            statistics.add(Statistic.Statistics.DEFENSE.getStatistic(VANILLA_ARMOR_DEFENSE.get(4)[piece]));
        }
    }

    public static final HashMap<Integer, Integer[]> VANILLA_ARMOR_DEFENSE = new HashMap<Integer, Integer[]>() {{
        this.put(1, new Integer[]{5, 15, 10, 5});
        this.put(2, new Integer[]{10, 25, 15, 5});
        this.put(3, new Integer[]{12, 30, 20, 7});
        this.put(4, new Integer[]{10, 30, 25, 10});
        this.put(5, new Integer[]{15, 40, 30, 15});
    }};

    public static List<String> generateLore(NBTItem nbtItem) {
        List<String> lore = new ArrayList<>();

        Material nbtType = nbtItem.getItem().getType();
        if (nbtType == Material.BOOKSHELF) {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Place near an &9Enchantment"));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&9Table &7to provide Bookshelf"));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Power. The higher the Bookshelf"));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Power, the more enchantments are"));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7available."));
            lore.add("");
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Bookshelf Power: &91"));
            lore.add("");
        }
        if (nbtType == Material.BEACON) {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7A cool cosmetic imitation of the real thing!"));
            lore.add("");
        }
        if (nbtType == Material.NAME_TAG) {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Right-click to apply a name to"));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7this Name Tag. Can be applied to"));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7mobs."));
            lore.add("");
        }
        if (nbtType == Material.BEDROCK) {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&cI guess you have this now."));
            lore.add("");
        }


        try {
            JSONObject stats = (JSONObject) new JSONParser().parse(nbtItem.getString("sb_base_statistics"));
            for (Object o : stats.keySet()) {
                int id = Integer.parseInt((String) o);
                Statistic statistic = Statistic.Statistics.getByID(id, (double) stats.get(o));
                if (id == 30) {
                    lore.add(0, "");
                    lore.add(0, ChatColor.translateAlternateColorCodes('&', statistic.getColorFull() + statistic.getName() + " " + statistic.getRoundedValue()));
                } else {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7" + statistic.getName() + ": " + statistic.getColorFull() + (statistic.getValue()>0 ? "+" : "") + statistic.getValue()));
                }
            }
            if (stats.keySet().size() != 0) {
                lore.add("");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        try {
            JSONObject enchants = (JSONObject) new JSONParser().parse(nbtItem.getString("sb_enchantments"));
            for (Object o : enchants.keySet()) {
                int id = Integer.parseInt((String) o);
                SBEnchantment statistic = SBEnchantment.getEnchantByID(id, ((Long) enchants.get(o)).intValue());
                lore.add(ChatColor.translateAlternateColorCodes('&', "&9" + statistic.getDisplayName() + " " + toRomanNumerals(statistic.getLevel())));
            }
            if (enchants.keySet().size() != 0) {
                lore.add("");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        if (nbtItem.getBoolean("reforgable")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&8This item can be reforged!"));
        }
        if (nbtItem.getString("item_type").equalsIgnoreCase("ARROW")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&8Stats added when shot!"));
        }
        if (nbtItem.getBoolean("soulbound")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', "&8&l*&r &8Co-op Soulbound &l*&r"));
        }

        ItemRarity tier = fromID(nbtItem.getInteger("rarity"));
        String itemType = nbtItem.getString("item_type");
        if (nbtItem.getBoolean("recombobulated")) {
            lore.add(ChatColor.translateAlternateColorCodes('&', tier.getColorFull() + "&l&kM&r &l" + tier + " " + itemType.replaceAll("_", " ") + " &l&b&kM"));
        } else {
            lore.add(ChatColor.translateAlternateColorCodes('&',  tier.getColorFull() + "&l" + tier + " " + itemType.replaceAll("_", " ")));
        }

        return lore;
    }

    public static ItemRarity fromID(int id) {
        switch (id) {
            case 2: return ItemRarity.UNCOMMON;
            case 3: return ItemRarity.RARE;
            case 4: return ItemRarity.EPIC;
            case 5: return ItemRarity.LEGENDARY;
            case 6: return ItemRarity.MYTHIC;
            case 7: return ItemRarity.DIVINE;
            case 8: return ItemRarity.SPECIAL;
            case 9: return ItemRarity.ADMIN;
            default: return ItemRarity.COMMON;
        }
    }

    public static String toRomanNumerals(int num) {
        switch (num) {
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            case 10: return "X";
            default: return "?";
        }
    }

    public static String getJSONBaseStatistics(List<Statistic> baseStats) {
        JSONObject o = new JSONObject();
        for (Statistic baseStat : baseStats) {
            o.put(String.valueOf(baseStat.getStatisticID()), baseStat.getValue());
        }
        return o.toString();
    }

    public static String getJSONEnchants(List<SBEnchantment> sbEnchantments) {
        JSONObject o = new JSONObject();
        for (SBEnchantment sbEnchantment : sbEnchantments) {
            o.put(String.valueOf(sbEnchantment.getID()), sbEnchantment.getLevel());
        }
        return o.toString();
    }

    public static SBEnchantment convert(Enchantment enchantment, int level) {
        switch (enchantment.getId()) {
            case 0: return new Protection(level);
            case 1: return new FireProtection(level);
            case 2: return new FeatherFalling(level);
            case 3: return new BlastProtection(level);
            case 4: return new ProjectileProtection(level);
            case 5: return new Respiration(level);
            case 6: return new AquaAffinity(level);
            case 7: return new Thorns(level);
            case 8: return new DepthStrider(level);
            case 16: return new Sharpness(level);
            case 17: return new Smite(level);
            case 18: return new BaneOfArthropods(level);
            case 19: return new Knockback(level);
            case 20: return new FireAspect(level);
            case 21: return new Looting(level);
            case 32: return new Efficiency(level);
            case 33: return new SilkTouch(level);
            case 35: return new Fortune(level);
            case 48: return new Power(level);
            case 49: return new Punch(level);
            case 50: return new Flame(level);
            case 51: return new InfiniteQuiver(level);
            case 61: return new Luck(level);
            case 62: return new Lure(level);
            default: return null;
        }
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
