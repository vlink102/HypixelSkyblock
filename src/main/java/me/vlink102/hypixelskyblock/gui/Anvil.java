package me.vlink102.hypixelskyblock.gui;

import mc.obliviate.inventory.Gui;
import mc.obliviate.inventory.GuiIcon;
import mc.obliviate.inventory.Icon;
import me.vlink102.hypixelskyblock.player.SBPlayer;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class Anvil extends Gui {
    public Anvil(SBPlayer player) {
        super(player.getPlayerBind(), "anvil", "Anvil", 6);
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {
        fillGui(new Icon(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15)).setName("§0"));

        addItem(new Icon(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14)).setName("§c"), 45, 46, 47, 48, 50, 51, 52, 53);
        addItem(new Icon(Material.BARRIER).setName("§cClose").onClick(inventoryClickEvent -> inventoryClickEvent.getWhoClicked().closeInventory()), 49);

        addItem(new Icon(Material.ANVIL).setName("§aCombine Items").setLore("§7Combine the items in the slots", "§7to the left and right below.").onClick(inventoryClickEvent -> {

        }), 22);

        addItem(new Icon(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14))
                .setName("§6Item to Upgrade")
                .setLore(
                        "§7The item you want to upgrade",
                        "§7should be placed in the slot on",
                        "§7this side."
                ), 11, 12, 20);
        addItem(new Icon(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14))
                .setName("§6Item to Sacrifice")
                .setLore(
                        "§7The item you are sacrificing in",
                        "§7order to upgrade the item on the",
                        "§7left should be placed in the",
                        "§7slot on this side."
                ), 14, 15, 24);

        addItem(new Icon(Material.BARRIER)
                .setName("§cAnvil")
                .setLore(
                        "§7Place a target item in the left",
                        "§7slot and a sacrifice item in the",
                        "§7right slot to combine them!"
                ), 13);

        addItem(new Icon(Material.AIR).onClick(inventoryClickEvent -> {

                }).onDrag(inventoryDragEvent -> {

                }),
                29, 33);
    }
}
