package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.items.SBItem;
import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

import java.util.*;

public class SBEnchantment {
    private final long ID;
    private final String displayName;

    private int level;

    private final List<Long> conflictingEnchantments;

    private static final HashMap<Long, SBEnchantment> ENCHANTMENTS = new HashMap<>();

    public String getAppliedToFancy() {
        List<SBItem.ItemType> applied = new ArrayList<>(appliedTo());
        StringJoiner joiner = new StringJoiner(ChatColor.translateAlternateColorCodes('&', "&9, "));

        if (applied.contains(SBItem.ItemType.SWORD) &&
                applied.contains(SBItem.ItemType.LONGSWORD)) {
            joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Melee Weapon"));
            applied.remove(SBItem.ItemType.SWORD);
            applied.remove(SBItem.ItemType.LONGSWORD);
        } else {
            if (applied.contains(SBItem.ItemType.SWORD)) {
                applied.remove(SBItem.ItemType.SWORD);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Sword"));
            }
            if (applied.contains(SBItem.ItemType.LONGSWORD)) {
                applied.remove(SBItem.ItemType.LONGSWORD);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Longsword"));
            }
        }
        if (applied.contains(SBItem.ItemType.HELMET) &&
                applied.contains(SBItem.ItemType.BOOTS) &&
                applied.contains(SBItem.ItemType.LEGGINGS) &&
                applied.contains(SBItem.ItemType.CHESTPLATE)) {
            joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Armor"));
            applied.remove(SBItem.ItemType.HELMET);
            applied.remove(SBItem.ItemType.BOOTS);
            applied.remove(SBItem.ItemType.LEGGINGS);
            applied.remove(SBItem.ItemType.CHESTPLATE);
        } else {
            if (applied.contains(SBItem.ItemType.HELMET)) {
                applied.remove(SBItem.ItemType.HELMET);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Helmets"));
            }
            if (applied.contains(SBItem.ItemType.CHESTPLATE)) {
                applied.remove(SBItem.ItemType.CHESTPLATE);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Chestplates"));
            }
            if (applied.contains(SBItem.ItemType.LEGGINGS)) {
                applied.remove(SBItem.ItemType.LEGGINGS);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Leggings"));
            }
            if (applied.contains(SBItem.ItemType.BOOTS)) {
                applied.remove(SBItem.ItemType.BOOTS);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Boots"));
            }
        }
        if (applied.contains(SBItem.ItemType.NECKLACE) &&
                applied.contains(SBItem.ItemType.BRACELET) &&
                applied.contains(SBItem.ItemType.GLOVES) &&
                applied.contains(SBItem.ItemType.BELT) &&
                applied.contains(SBItem.ItemType.CLOAK)) {
            joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Equipment"));
            applied.remove(SBItem.ItemType.NECKLACE);
            applied.remove(SBItem.ItemType.BRACELET);
            applied.remove(SBItem.ItemType.GLOVES);
            applied.remove(SBItem.ItemType.BELT);
            applied.remove(SBItem.ItemType.CLOAK);
        } else {
            if (applied.contains(SBItem.ItemType.NECKLACE)) {
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Necklaces"));
                applied.remove(SBItem.ItemType.NECKLACE);
            }
            if (applied.contains(SBItem.ItemType.BRACELET)) {
                applied.remove(SBItem.ItemType.BRACELET);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Bracelets"));
            }
            if (applied.contains(SBItem.ItemType.GLOVES)) {
                applied.remove(SBItem.ItemType.GLOVES);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Gloves"));
            }
            if (applied.contains(SBItem.ItemType.BELT)) {
                applied.remove(SBItem.ItemType.BELT);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Belts"));
            }
            if (applied.contains(SBItem.ItemType.CLOAK)) {
                applied.remove(SBItem.ItemType.CLOAK);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Cloaks"));
            }
        }
        if (applied.contains(SBItem.ItemType.PICKAXE) &&
                applied.contains(SBItem.ItemType.AXE) &&
                applied.contains(SBItem.ItemType.DRILL) &&
                applied.contains(SBItem.ItemType.SHEARS) &&
                applied.contains(SBItem.ItemType.SHOVEL) &&
                applied.contains(SBItem.ItemType.HOE)) {
            joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Tools"));
            applied.remove(SBItem.ItemType.PICKAXE);
            applied.remove(SBItem.ItemType.AXE);
            applied.remove(SBItem.ItemType.DRILL);
            applied.remove(SBItem.ItemType.SHEARS);
            applied.remove(SBItem.ItemType.SHOVEL);
            applied.remove(SBItem.ItemType.HOE);
        } else {
            if (applied.contains(SBItem.ItemType.PICKAXE)) {
                applied.remove(SBItem.ItemType.PICKAXE);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Pickaxes"));
            }
            if (applied.contains(SBItem.ItemType.AXE)) {
                applied.remove(SBItem.ItemType.AXE);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Axes"));
            }
            if (applied.contains(SBItem.ItemType.DRILL)) {
                applied.remove(SBItem.ItemType.DRILL);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Drills"));
            }
            if (applied.contains(SBItem.ItemType.SHEARS)) {
                applied.remove(SBItem.ItemType.SHEARS);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Shears"));
            }
            if (applied.contains(SBItem.ItemType.SHOVEL)) {
                applied.remove(SBItem.ItemType.SHOVEL);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Shovels"));
            }
            if (applied.contains(SBItem.ItemType.HOE)) {
                applied.remove(SBItem.ItemType.HOE);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Hoes"));
            }
        }
        if (applied.contains(SBItem.ItemType.PICKAXE) &&
                applied.contains(SBItem.ItemType.DRILL)) {
            joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Mining Tools"));
            applied.remove(SBItem.ItemType.PICKAXE);
            applied.remove(SBItem.ItemType.DRILL);
        } else {
            if (applied.contains(SBItem.ItemType.PICKAXE)) {
                applied.remove(SBItem.ItemType.PICKAXE);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Pickaxes"));
            }
            if (applied.contains(SBItem.ItemType.DRILL)) {
                applied.remove(SBItem.ItemType.DRILL);
                joiner.add(ChatColor.translateAlternateColorCodes('&', "&9Drills"));
            }
        }

        for (SBItem.ItemType itemType : applied) {
            joiner.add(ChatColor.translateAlternateColorCodes('&', "&9" + WordUtils.capitalizeFully(itemType.toString())));
        }
        return joiner.toString();
    }

    public SBEnchantment(long ID, String displayName, int level, Long... conflictingEnchantments) {
        this.ID = ID;
        this.displayName = displayName;
        this.level = level;
        this.conflictingEnchantments = Arrays.asList(conflictingEnchantments);

        ENCHANTMENTS.put(ID, this);
    }

    public static HashMap<Long, SBEnchantment> getENCHANTMENTS() {
        return ENCHANTMENTS;
    }

    public List<SBItem.ItemType> appliedTo() {
        return new ArrayList<>();
    }

    public static SBEnchantment getEnchantByID(long id, int level) {
        SBEnchantment enchantment = ENCHANTMENTS.get(id);
        enchantment.setLevel(level);
        return enchantment;
    }

    public int getLevel() {
        return level;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<String> getFullDescription() {
        return new ArrayList<>();
    }

    public List<String> getBasicDescription() {
        List<String> full = getFullDescription();
        List<String> res = new ArrayList<>();

        for (String s : full) {
            if (s.equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&a&c"))) {
                break;
            }
            res.add(s);
        }
        return res;
    }

    public long getID() {
        return ID;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Long> getConflictingEnchantments() {
        return conflictingEnchantments;
    }

    public boolean doesConflict(SBEnchantment other) {
        return conflictingEnchantments.contains(other.getID());
    }

    public Integer[] getEnchantingTableCosts() {
        return new Integer[] {};
    }

    public Integer[] getApplyCosts() {
        return new Integer[] {};
    }

    public Integer getApplyCost(int level) {
        return getApplyCosts()[level - 1];
    }

    public Integer getApplyCost() {
        return getApplyCost(getLevel());
    }

    public double getBookshelfPower() {
        return 0;
    }

    public double getEnchantingLevelRequired() {
        return 0;
    }
}
