package me.vlink102.hypixelskyblock;

import lombok.Getter;
import me.vlink102.hypixelskyblock.player.SBPlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class HypixelSkyblock extends JavaPlugin {

    @Getter private SBPlayerManager playerUtils;

    @Override
    public void onEnable() {
        System.out.println("Loading Lowpixel Groundblock...");
        this.playerUtils = new SBPlayerManager();
        Bukkit.getServer().getPluginManager().registerEvents(playerUtils, this);
        for (Player player : Bukkit.getOnlinePlayers()) {
            playerUtils.addPlayer(player);
        }
        System.out.println("Plugin Successfully Enabled!");
    }

    @Override
    public void onDisable() {

    }
}
