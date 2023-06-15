package me.vlink102.hypixelskyblock.enchantments;

import java.util.Arrays;
import java.util.List;

public class SBEnchantment {
    private final long ID;
    private final String displayName;

    private int level;

    private final List<Long> conflictingEnchantments;

    public SBEnchantment(long ID, String displayName, int level, Long... conflictingEnchantments) {
        this.ID = ID;
        this.displayName = displayName;
        this.level = level;
        this.conflictingEnchantments = Arrays.asList(conflictingEnchantments);
    }

    public int getLevel() {
        return level;
    }

    public String getDisplayName() {
        return displayName;
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
}
