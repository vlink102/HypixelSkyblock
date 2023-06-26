package me.vlink102.hypixelskyblock.listeners;

import de.tr7zw.nbtapi.NBTItem;
import me.vlink102.hypixelskyblock.HypixelSkyblock;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.player.SBPlayer;
import me.vlink102.hypixelskyblock.player.SBPlayerManager;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class ItemDrop implements Listener {
    private final HypixelSkyblock plugin;

    public ItemDrop(HypixelSkyblock plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent event) {
        Item entity = event.getEntity();
        ItemStack dropped = entity.getItemStack();

        NBTItem nbtItem = new NBTItem(dropped);
        if (!nbtItem.hasTag("rarity")) {
            entity.setItemStack(SBItem.fromVanillaItem(dropped));
        }
    }
}
