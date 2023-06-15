package me.vlink102.hypixelskyblock.potions;

import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class Absorption extends SBPotion{
    public Absorption(int level) {
        super(16, "Absorption", level);
    }

    public static final List<Integer> ABSORPTION_HEALTH = Arrays.asList(20, 40, 60, 80, 100, 150, 200, 300);

    public double getAbsorptionAmount() {
        return ABSORPTION_HEALTH.get(getLevel() - 1);
    }

    @Override
    public void affect(Player player) {

    }
}
