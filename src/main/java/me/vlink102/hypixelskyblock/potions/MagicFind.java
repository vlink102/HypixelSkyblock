package me.vlink102.hypixelskyblock.potions;

import java.util.Arrays;
import java.util.List;

public class MagicFind extends SBPotion{
    public MagicFind(int level) {
        super(42, "Magic Find", level);
    }

    public static final List<Integer> MAGIC_FIND_VALUES = Arrays.asList(10, 25, 50, 75);

    public double getMagicFind() {
        return MAGIC_FIND_VALUES.get(getLevel() - 1);
    }
}
