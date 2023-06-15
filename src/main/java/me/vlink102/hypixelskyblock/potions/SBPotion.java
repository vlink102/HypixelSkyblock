package me.vlink102.hypixelskyblock.potions;

import javafx.application.Platform;
import org.bukkit.entity.Player;

public class SBPotion {
    private final long ID;
    private final String name;
    private int level;

    public SBPotion(long ID, String name, int level) {
        this.ID = ID;
        this.name = name;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public long getID() {
        return ID;
    }

    public void affect(Player player) {

    }

    public void clean(Player player) {

    }
}
