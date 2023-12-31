package me.vlink102.hypixelskyblock.items;

import de.tr7zw.nbtapi.NBT;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.iface.ReadWriteNBT;
import me.vlink102.hypixelskyblock.HypixelSkyblock;
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
import me.vlink102.hypixelskyblock.gui.Anvil;
import me.vlink102.hypixelskyblock.util.SBUtils;
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
    private String itemName;
    private List<Statistic> baseStats;
    private List<SBEnchantment> sbEnchantments;
    private final int maxStackSize;

    private final org.bukkit.Material material;

    private String skullTexture;

    private ItemRarity rarity;

    private int hotPotatoBooks;
    private int fumingPotatoBooks;
    private int jalapenoBooks;
    private boolean artOfWar;
    private boolean artOfPeace;

    private boolean recombobulated;

    private final ItemType itemType;

    private final boolean reforgable;
    private boolean coopSoulbound;

    public void registerItem() {
        HypixelSkyblock.getITEMS().put(this.itemID, this);
    }

    public SBItem(String itemID, String itemName, String skullTexture, Material material, boolean soulBound, boolean reforgable, int maxStackSize, int hpb, int fpb, int jpb, boolean aow, boolean aop, boolean recomb, ItemType itemType, ItemRarity rarity, List<SBEnchantment> sbEnchantments, Statistic... statistics) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.sbEnchantments = sbEnchantments;
        this.baseStats = Arrays.asList(statistics);
        this.maxStackSize = maxStackSize;
        this.material = material;

        this.coopSoulbound = soulBound;

        this.skullTexture = skullTexture;

        this.hotPotatoBooks = hpb;
        this.fumingPotatoBooks = fpb;
        this.jalapenoBooks = jpb;
        this.artOfWar = aow;
        this.artOfPeace = aop;
        this.recombobulated = recomb;

        this.reforgable = reforgable;

        this.rarity = rarity;
        this.itemType = itemType;

        // TODO reforges
    }

    public SBItem(String itemID, String itemName, String skullTexture, Material material, boolean soulBound, boolean reforgable, int maxStackSize, int hpb, int fpb, int jpb, boolean aow, boolean aop, boolean recomb, ItemType itemType, ItemRarity rarity, List<SBEnchantment> sbEnchantments, List<Statistic> statistics) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.sbEnchantments = sbEnchantments;
        this.baseStats = statistics;
        this.maxStackSize = maxStackSize;
        this.material = material;

        this.skullTexture = skullTexture;

        this.coopSoulbound = soulBound;

        this.hotPotatoBooks = hpb;
        this.fumingPotatoBooks = fpb;
        this.jalapenoBooks = jpb;
        this.artOfWar = aow;
        this.artOfPeace = aop;
        this.recombobulated = recomb;

        this.reforgable = reforgable;

        this.rarity = rarity;
        this.itemType = itemType;

        // TODO reforges
    }


    public int getJalapenoBooks() {
        return jalapenoBooks;
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

    public boolean isArtOfPeace() {
        return artOfPeace;
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

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public static SBItem fromNBTItem(NBTItem nbtItem) {
        try {
            if (!nbtItem.hasTag("rarity")) {
                return null;
            }
            String itemID = nbtItem.getString("item_id");

            NBTCompound display = nbtItem.getCompound("display");
            String itemName = display.getString("Name");
            List<String> itemLore = display.getStringList("Lore");

            JSONObject sbEnchantmentsObject = (JSONObject) new JSONParser().parse(nbtItem.getString("sb_enchantments"));
            List<SBEnchantment> sbEnchantmentList = new ArrayList<>();
            for (Object o : sbEnchantmentsObject.keySet()) {
                int enchantID = Integer.parseInt((String) o);
                Long enchantLevel = (Long) sbEnchantmentsObject.get(o);
                sbEnchantmentList.add(SBEnchantment.getEnchantByID(enchantID, enchantLevel.intValue()));
            }

            ItemRarity itemRarity = ItemRarity.getById(nbtItem.getInteger("rarity"));

            String itemType = nbtItem.getString("item_type");
            ItemType type = itemType.equalsIgnoreCase("") ? null : ItemType.valueOf(itemType);

            boolean recombobulated = nbtItem.getBoolean("recombobulated");

            int hotPotatoBooks = nbtItem.getInteger("hot_potato_books");
            int fumingPotatoBooks = nbtItem.getInteger("fuming_potato_books");
            int jalapenoBooks = nbtItem.getInteger("jalapeno_books");
            boolean artOfWar = nbtItem.getBoolean("art_of_war");
            boolean artOfPeace = nbtItem.getBoolean("art_of_peace");
            boolean soulbound = nbtItem.getBoolean("soulbound");

            JSONObject baseStatsObject = (JSONObject) new JSONParser().parse(nbtItem.getString("sb_base_statistics"));
            List<Statistic> baseStatistics = new ArrayList<>();
            for (Object o : baseStatsObject.keySet()) {
                long statisticID = Long.parseLong((String) o);
                double value = (double) baseStatsObject.get(o);
                baseStatistics.add(Statistic.Statistics.getByID(statisticID, value));
            }

            boolean reforgable = nbtItem.getBoolean("reforgable");

            Material itemMaterial = nbtItem.getItem().getType();

            int maxStackSize = nbtItem.getInteger("max_stack");

            return new SBItem(itemID, itemName, null, itemMaterial, soulbound, reforgable, maxStackSize, hotPotatoBooks, fumingPotatoBooks, jalapenoBooks, artOfWar, artOfPeace, recombobulated, type, itemRarity, sbEnchantmentList, baseStatistics);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }



    public NBTItem toNBTItem() {
        ItemStack sbItem;
        if (material == Material.SKULL_ITEM) {
            sbItem = new ItemStack(material, 1, (short) 3);
        } else {
            sbItem = new ItemStack(material);
        }
        ItemMeta metad = sbItem.getItemMeta();
        metad.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metad.addItemFlags(ItemFlag.HIDE_DESTROYS);
        metad.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        metad.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metad.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        metad.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        sbItem.setItemMeta(metad);

        NBTItem item = new NBTItem(sbItem);

        item.setString("sb_enchantments", getJSONEnchants(sbEnchantments));
        item.setString("item_id", sbItem.getType().toString());
        int deepRarity = item.getItem().getType() == Material.ENCHANTED_BOOK ? getBookRarity(item).getId() : rarity.getId();
        item.setInteger("rarity", deepRarity);
        item.setString("item_type", itemType == null ? "" : itemType.toString());
        item.setBoolean("recombobulated", recombobulated);

        if (material == Material.SKULL_ITEM && !Objects.equals(skullTexture, "")) {
            NBT.modify(item.getItem(), nbt -> {
                final ReadWriteNBT skullOwnerCompound = nbt.getOrCreateCompound("SkullOwner");
                skullOwnerCompound.setUUID("Id", UUID.randomUUID());
                skullOwnerCompound.getOrCreateCompound("Properties")
                        .getCompoundList("textures")
                        .addCompound()
                        .setString("Value", skullTexture);
            });
        }
        item.setString("skull_texture", skullTexture);

        item.setInteger("hot_potato_books", hotPotatoBooks);
        item.setInteger("fuming_potato_books", fumingPotatoBooks);
        item.setBoolean("art_of_war", artOfWar);
        item.setBoolean("art_of_peace", artOfPeace);

        item.setBoolean("soulbound", coopSoulbound);

        item.setString("sb_base_statistics", getJSONBaseStatistics(baseStats));
        item.setBoolean("reforgable", reforgable);
        item.setInteger("max_stack", maxStackSize);
        item.setInteger("HideAttributes", 4);

        NBTCompound disp = item.addCompound("display");
        disp.setString("Name", ChatColor.translateAlternateColorCodes('&', ItemRarity.getById(deepRarity).getColorFull() + itemName));
        disp.getStringList("Lore").addAll(generateLore(item));

        return item;
    }

    public ItemStack toItemStack() {
        return toNBTItem().getItem();
    }

    public static ItemStack fromVanillaItem(ItemStack stack) {
        return fromVanillaItemNBT(stack).getItem();
    }

    public static NBTItem fromVanillaItemNBT(ItemStack stack) {
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

        item.setString("item_id", stack.getType().toString());

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

        item.setString("item_type", "");
        String material = SBUtils.getItemName(sbItem);
        if (material.endsWith("Sword")) {
            item.setString("item_type", "SWORD");
        }
        if (material.endsWith("Axe")) {
            item.setString("item_type", "AXE");
        }
        if (material.endsWith("Pickaxe")) {
            item.setString("item_type", "PICKAXE");
        }
        if (material.endsWith("Hoe")) {
            item.setString("item_type", "HOE");
        }
        if (material.endsWith("Shovel")) {
            item.setString("item_type", "SHOVEL");
        }
        if (material.endsWith("Shears")) {
            item.setString("item_type", "SHEARS");
        }
        if (material.endsWith("Helmet") || material.endsWith("Cap")) {
            item.setString("item_type", "HELMET");
        }
        if (material.endsWith("Chestplate") || material.endsWith("Tunic")) {
            item.setString("item_type", "CHESTPLATE");
        }
        if (material.endsWith("Leggings") || material.endsWith("Pants")) {
            item.setString("item_type", "LEGGINGS");
        }
        if (material.endsWith("Boots") || material.endsWith("Shoes")) {
            item.setString("item_type", "BOOTS");
        }
        if (material.endsWith("Bow")) {
            item.setString("item_type", "BOW");
        }
        if (material.endsWith("Rod")) {
            item.setString("item_type", "FISHING_ROD");
        }
        if (material.endsWith("Arrow")) {
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
        item.setInteger("max_stack", item.getItem().getMaxStackSize());
        item.setInteger("HideAttributes", 4);

        NBTCompound disp = item.addCompound("display");
        String rawName = capitalise(SBUtils.getItemName(sbItem));
        if (rawName.equalsIgnoreCase("ARROW")) {
            rawName = "Flint Arrow";
        }
        if (rawName.equalsIgnoreCase("BEACON")) {
            rawName = "Beacon Block";
        }
        rawName = rawName.replaceAll("Spade", "Shovel");
        rawName = rawName.replaceAll("Barding", "Horse Armor");
        if (sbItem.getType() == Material.ENCHANTED_BOOK) {
            ItemRarity newRarity = getBookRarity(item);
            item.setInteger("rarity", newRarity.getId());
            disp.setString("Name", ChatColor.translateAlternateColorCodes('&', newRarity.getColorFull() + rawName));
        } else {
            disp.setString("Name", ChatColor.translateAlternateColorCodes('&', ItemRarity.getById(item.getInteger("rarity")).getColorFull() + rawName));
        }
        List<String> l = disp.getStringList("Lore");
        l.addAll(generateLore(item));

        return item;
    }



    public static final HashMap<Integer, Integer> RARITY_MAP = new HashMap<Integer, Integer>() {{
        this.put(1, ItemRarity.COMMON.id);
        this.put(2, ItemRarity.COMMON.id);
        this.put(3, ItemRarity.COMMON.id);
        this.put(4, ItemRarity.COMMON.id);
        this.put(5, ItemRarity.UNCOMMON.id);
        this.put(6, ItemRarity.RARE.id);
        this.put(7, ItemRarity.EPIC.id);
        this.put(8, ItemRarity.LEGENDARY.id);
        this.put(9, ItemRarity.MYTHIC.id);
        this.put(10, ItemRarity.MYTHIC.id);
    }};

    public static ItemRarity getBookRarity(NBTItem nbtItem) {
        int tier = 1;
        try {
            JSONObject enchants = (JSONObject) new JSONParser().parse(nbtItem.getString("sb_enchantments"));

            for (Object o : enchants.keySet()) {
                int id = Integer.parseInt((String) o);
                SBEnchantment statistic = SBEnchantment.getEnchantByID(id, ((Long) enchants.get(o)).intValue());

                tier = Math.max(tier, RARITY_MAP.get(statistic.getLevel()));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return ItemRarity.getById(tier);
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
            statistics.add(Statistic.Statistics.DEFENSE.getStatistic(VANILLA_ARMOR_DEFENSE.get(1)[piece]));
        }
        if (materialString.startsWith("GOLD")) {
            statistics.add(Statistic.Statistics.DEFENSE.getStatistic(VANILLA_ARMOR_DEFENSE.get(2)[piece]));
        }
        if (materialString.startsWith("CHAINMAIL")) {
            statistics.add(Statistic.Statistics.DEFENSE.getStatistic(VANILLA_ARMOR_DEFENSE.get(3)[piece]));
        }
        if (materialString.startsWith("IRON")) {
            statistics.add(Statistic.Statistics.DEFENSE.getStatistic(VANILLA_ARMOR_DEFENSE.get(4)[piece]));
        }
        if (materialString.startsWith("DIAMOND")) {
            statistics.add(Statistic.Statistics.DEFENSE.getStatistic(VANILLA_ARMOR_DEFENSE.get(5)[piece]));
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
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7" + statistic.getName() + ": " + statistic.getColorFull() + (statistic.getValue()>0 ? "+" : "") + SBUtils.round(statistic.getValue())));
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
            int size = enchants.keySet().size();
            if (size == 1) {
                for (Object o : enchants.keySet()) {
                    int id = Integer.parseInt((String) o);
                    SBEnchantment statistic = SBEnchantment.getEnchantByID(id, ((Long) enchants.get(o)).intValue());

                    lore.add(ChatColor.translateAlternateColorCodes('&', "&9" + statistic.getDisplayName() + " " + toRomanNumerals(statistic.getLevel())));
                    if (nbtType == Material.ENCHANTED_BOOK) {
                        lore.addAll(statistic.getFullDescription());
                    } else {
                        lore.addAll(statistic.getBasicDescription());
                    }

                    nbtItem.setInteger("apply_cost", statistic.getApplyCost());
                }
            } else if (size <= 5) {
                double combinedLevel = 0;
                for (Object o : enchants.keySet()) {
                    int id = Integer.parseInt((String) o);
                    SBEnchantment statistic = SBEnchantment.getEnchantByID(id, ((Long) enchants.get(o)).intValue());

                    combinedLevel = SBUtils.getCombinedEnchantLevels(statistic.getApplyCost(), combinedLevel);

                    lore.add(ChatColor.translateAlternateColorCodes('&', "&9" + statistic.getDisplayName() + " " + toRomanNumerals(statistic.getLevel())));

                    lore.addAll(statistic.getBasicDescription());
                }
                if (nbtType == Material.ENCHANTED_BOOK) {
                    lore.add("");
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7Apply Cost: &3" + SBUtils.roundDown(combinedLevel) + " Exp Levels"));
                    lore.add("");
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7Use this on an item in an Anvil"));
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7to apply it."));

                    nbtItem.setInteger("apply_cost", Double.valueOf(combinedLevel).intValue());
                }
            } else if (size <= 9) {
                double combinedLevel = 0;
                for (Object o : enchants.keySet()) {
                    int id = Integer.parseInt((String) o);
                    SBEnchantment statistic = SBEnchantment.getEnchantByID(id, ((Long) enchants.get(o)).intValue());
                    combinedLevel = SBUtils.getCombinedEnchantLevels(statistic.getApplyCost(), combinedLevel);

                    lore.add(ChatColor.translateAlternateColorCodes('&', "&9" + statistic.getDisplayName() + " " + toRomanNumerals(statistic.getLevel())));
                }
                if (nbtType == Material.ENCHANTED_BOOK) {
                    lore.add("");
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7Apply Cost: &3" + SBUtils.roundDown(combinedLevel) + " Exp Levels"));
                    lore.add("");
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7Use this on an item in an Anvil"));
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7to apply it."));

                    nbtItem.setInteger("apply_cost", Double.valueOf(combinedLevel).intValue());
                }
            } else {
                double combinedLevel = 0;
                HashMap<Integer, List<String>> brokenLore = new HashMap<>();
                int c = 0;
                for (Object o : enchants.keySet()) {
                    int id = Integer.parseInt((String) o);
                    SBEnchantment statistic = SBEnchantment.getEnchantByID(id, ((Long) enchants.get(o)).intValue());
                    combinedLevel = SBUtils.getCombinedEnchantLevels(statistic.getApplyCost(), combinedLevel);

                    if (!brokenLore.containsKey(c)) {
                        brokenLore.put(c, new ArrayList<>());
                    }
                    List<String> threeEnchants = brokenLore.get(c);
                    if (threeEnchants.size() < 3) {
                        brokenLore.get(c).add(ChatColor.translateAlternateColorCodes('&', "&9" + statistic.getDisplayName() + " " + toRomanNumerals(statistic.getLevel())));
                    } else {
                        c++;
                        brokenLore.put(c, new ArrayList<>());
                    }
                }
                for (Integer integer : brokenLore.keySet()) {
                    List<String> broken = brokenLore.get(integer);
                    StringJoiner joiner = new StringJoiner(ChatColor.translateAlternateColorCodes('&', "&9, &r"));
                    for (String s : broken) {
                        joiner.add(s);
                    }
                    lore.add(joiner.toString());
                }
                if (nbtType == Material.ENCHANTED_BOOK) {
                    lore.add("");
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7Apply Cost: &3" + SBUtils.roundDown(combinedLevel) + " Exp Levels"));
                    lore.add("");
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7Use this on an item in an Anvil"));
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7to apply it."));

                    nbtItem.setInteger("apply_cost", Double.valueOf(combinedLevel).intValue());
                }
            }

            if (size != 0) {
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

    public boolean containsStatistic(Statistic.Statistics statistic) {
        for (Statistic baseStat : getBaseStats()) {
            if (statistic.getStatistic(0).getStatisticID() == baseStat.getStatisticID()) {
                return true;
            }
        }
        return false;
    }

    public Statistic getStatistic(Statistic.Statistics statistics) {
        for (Statistic baseStat : getBaseStats()) {
            if (statistics.getStatistic(0).getStatisticID() == baseStat.getStatisticID()) {
                return baseStat;
            }
        }
        return null;
    }

    public String getItemID() {
        return itemID;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void addHotPotatoBook() {
        addPotatoBookStat();
        hotPotatoBooks ++;
    }

    public void addPotatoBookStat() {
        SBItem.ItemType type = itemType;
        if (type == SBItem.ItemType.HELMET ||
                type == SBItem.ItemType.CHESTPLATE ||
                type == SBItem.ItemType.LEGGINGS ||
                type == SBItem.ItemType.BOOTS) {
            Anvil.initOrAddStatistic(this, Statistic.Statistics.HEALTH, 4);
            Anvil.initOrAddStatistic(this, Statistic.Statistics.DEFENSE, 2);
        } else {
            Anvil.initOrAddStatistic(this, Statistic.Statistics.DAMAGE, 2);
            Anvil.initOrAddStatistic(this, Statistic.Statistics.STRENGTH, 2);
        }
    }

    public void addFumingPotatoBooks() {
        addPotatoBookStat();
        fumingPotatoBooks ++;
    }

    public void addJalapenoBooks() {
        jalapenoBooks ++;
    }

    public void recombobulate() {
        recombobulated = true;
        rarity = ItemRarity.getById(rarity.id + 1);
    }

    public void setArtOfPeace() {
        this.artOfPeace = true;
        Anvil.initOrAddStatistic(this, Statistic.Statistics.HEALTH, 40);
    }

    public void setArtOfWar() {
        this.artOfWar = true;
        Anvil.initOrAddStatistic(this, Statistic.Statistics.STRENGTH, 5);
    }

    public void setSbEnchantments(List<SBEnchantment> sbEnchantments) {
        this.sbEnchantments = sbEnchantments;
    }
}
