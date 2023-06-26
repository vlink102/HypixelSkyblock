package me.vlink102.hypixelskyblock.enchantments;

import me.vlink102.hypixelskyblock.items.SBItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SBEnchantment {
    private final long ID;
    private final String displayName;

    private int level;

    private final List<Long> conflictingEnchantments;

    private static final HashMap<Long, SBEnchantment> ENCHANTMENTS = new HashMap<>();

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

    public List<String> getDescription() {
        return new ArrayList<>();
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

    public double getBookshelfPower() {
        return 0;
    }

    public double getEnchantingLevelRequired() {
        return 0;
    }

    public Integer[] getRarities() {
        return new Integer[] {};
    }
}
