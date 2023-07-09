package me.vlink102.hypixelskyblock;

import lombok.Getter;
import mc.obliviate.inventory.InventoryAPI;
import me.vlink102.hypixelskyblock.gui.Anvil;
import me.vlink102.hypixelskyblock.listeners.Damage;
import me.vlink102.hypixelskyblock.listeners.ItemDrop;
import me.vlink102.hypixelskyblock.player.SBPlayer;
import me.vlink102.hypixelskyblock.player.SBPlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class HypixelSkyblock extends JavaPlugin implements CommandExecutor {

    @Getter private SBPlayerManager playerUtils;

    @Override
    public void onEnable() {
        System.out.println("Loading Lowpixel Groundblock...");
        this.playerUtils = new SBPlayerManager(this);
        Bukkit.getServer().getPluginManager().registerEvents(new Damage(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(playerUtils, this);
        Bukkit.getServer().getPluginManager().registerEvents(new ItemDrop(this), this);
        new InventoryAPI(this).init();
        Bukkit.getServer().getPluginCommand("sb").setExecutor(this);
        for (Player player : Bukkit.getOnlinePlayers()) {
            playerUtils.addPlayer(player);
        }
        System.out.println("Plugin Successfully Enabled!");
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            SBPlayer player = playerUtils.getByUUID(((Player) sender).getUniqueId());
            new Anvil(player).open();
            return true;
        }
        return false;
    }
}
