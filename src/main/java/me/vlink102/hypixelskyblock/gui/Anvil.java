package me.vlink102.hypixelskyblock.gui;

import de.tr7zw.nbtapi.NBTItem;
import mc.obliviate.inventory.Gui;
import mc.obliviate.inventory.Icon;
import me.vlink102.hypixelskyblock.enchantments.SBEnchantment;
import me.vlink102.hypixelskyblock.items.Recombobulator;
import me.vlink102.hypixelskyblock.items.ReforgeStone;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.items.bookmodifiers.books.*;
import me.vlink102.hypixelskyblock.player.SBPlayer;
import me.vlink102.hypixelskyblock.util.Statistic;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Anvil extends Gui {
    public Anvil(SBPlayer player) {
        super(player.getPlayerBind(), "anvil", "Anvil", 6);
    }

    public Integer combineCost(SBItem item, SBItem sacrifice) {
        ItemStack upgradedItem = item.toItemStack();
        ItemStack sacrificeItem = sacrifice.toItemStack();
        if (upgradedItem.getType() == Material.ENCHANTED_BOOK && sacrificeItem.getType() == Material.ENCHANTED_BOOK) {
            return 0;
        }
        if (upgradedItem.getType() != Material.ENCHANTED_BOOK && sacrificeItem.getType() == Material.ENCHANTED_BOOK) {
            NBTItem sacrificeNBT = new NBTItem(sacrificeItem);
            return sacrificeNBT.getInteger("apply_cost");
        }
        return null;
    }

    @Override
    public void onClose(InventoryCloseEvent event) {
        ItemStack firstSlot = getInventory().getItem(29);
        ItemStack secondSlot = getInventory().getItem(33);
        if (firstSlot != null) {
            if (firstSlot.getType() != Material.AIR && firstSlot.getAmount() != 0) {
                event.getPlayer().getInventory().addItem(firstSlot);
            }
        }
        if (secondSlot != null) {
            if (secondSlot.getType() != Material.AIR && secondSlot.getAmount() != 0) {
                event.getPlayer().getInventory().addItem(secondSlot);
            }
        }
    }

    public boolean canBeCombined(SBItem item, SBItem sacrifice) {
        if (item.isReforgable() && sacrifice instanceof ReforgeStone) return true;
        if (sacrifice instanceof HotPotato && item.getHotPotatoBooks() < 10) {
            SBItem.ItemType type = item.getItemType();
            if (type.equals(SBItem.ItemType.FISHING_ROD) ||
                    type.equals(SBItem.ItemType.SWORD) ||
                    type.equals(SBItem.ItemType.LONGSWORD) ||
                    type.equals(SBItem.ItemType.BOW)) {
                return true;
            }
        }
        if (sacrifice instanceof FumingPotato && item.getFumingPotatoBooks() < 5) {
            SBItem.ItemType type = item.getItemType();
            if (type.equals(SBItem.ItemType.FISHING_ROD) ||
                    type.equals(SBItem.ItemType.SWORD) ||
                    type.equals(SBItem.ItemType.LONGSWORD) ||
                    type.equals(SBItem.ItemType.BOW)) {
                return true;
            }
        }
        if (sacrifice instanceof ArtOfWar && !item.isArtOfWar()) {
            SBItem.ItemType type = item.getItemType();
            if (type.equals(SBItem.ItemType.SWORD) ||
                    type.equals(SBItem.ItemType.LONGSWORD) ||
                    type.equals(SBItem.ItemType.BOW)) {
                return true;
            }
        }
        if (sacrifice instanceof ArtOfPeace && !item.isArtOfPeace()) {
            SBItem.ItemType type = item.getItemType();
            if (type.equals(SBItem.ItemType.HELMET) ||
                    type.equals(SBItem.ItemType.CHESTPLATE) ||
                    type.equals(SBItem.ItemType.LEGGINGS) ||
                    type.equals(SBItem.ItemType.BOOTS)) {
                return true;
            }
        }
        if (sacrifice instanceof JalapenoBook && item.getJalapenoBooks() < 1) return (item.getItemType() == SBItem.ItemType.DEPLOYABLE);
        if (!item.isRecombobulated() && sacrifice instanceof Recombobulator) return true;

        ItemStack upgradeItem = item.toItemStack();
        ItemStack sacrificeItem = sacrifice.toItemStack();
        if (upgradeItem.getType() == Material.ENCHANTED_BOOK) {
            return sacrificeItem.getType() == Material.ENCHANTED_BOOK;
        } else {
            if (sacrificeItem.getType() == Material.ENCHANTED_BOOK) {
                List<SBEnchantment> sacrificeEnchants = sacrifice.getSbEnchantments();
                boolean canBeApplied = false;
                for (SBEnchantment sacrificeEnchant : sacrificeEnchants) {
                    if (sacrificeEnchant.appliedTo().contains(item.getItemType())) {
                        canBeApplied = true;
                    }
                }
                return canBeApplied;
            } else {
                return false;
            }
        }
    }

    public SBItem getCombinedResult(SBItem item, SBItem sacrifice) {
        ItemStack sacrificeItem = sacrifice.toItemStack();

        if (sacrificeItem.getType() == Material.ENCHANTED_BOOK) {
            item.setSbEnchantments(getResultingEnchantments(item.getSbEnchantments(), sacrifice.getSbEnchantments()));
        } else {
            if (sacrifice instanceof HotPotato) {
                item.addHotPotatoBook();
            }
            if (sacrifice instanceof FumingPotato) {
                item.addFumingPotatoBooks();
            }
            if (sacrifice instanceof JalapenoBook) {
                item.addJalapenoBooks();
            }
            if (sacrifice instanceof Recombobulator) {
                item.recombobulate();
            }
            if (sacrifice instanceof ArtOfPeace) {
                item.setArtOfWar();
            }
            if (sacrifice instanceof ArtOfWar) {
                item.setArtOfPeace();
            }
        }
        return item;
    }

    public static void initOrAddStatistic(SBItem item, Statistic.Statistics statistics, int value) {
        if (item.containsStatistic(statistics)) {
            item.getStatistic(statistics).addValue(value);
        } else {
            item.getBaseStats().add(statistics.getStatistic(value));
        }
    }

    public List<SBEnchantment> getResultingEnchantments(List<SBEnchantment> itemEnchants, List<SBEnchantment> sacrificeEnchants) {
        List<SBEnchantment> finalEnchants = new ArrayList<>();
        finalEnchants.addAll(itemEnchants);
        finalEnchants.addAll(sacrificeEnchants);
        for (SBEnchantment sacrificeEnchant : sacrificeEnchants) {
            for (SBEnchantment itemEnchant : itemEnchants) {
                if (sacrificeEnchant.doesConflict(itemEnchant)) {
                    finalEnchants.remove(sacrificeEnchant);
                }
            }
        }
        return finalEnchants;
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {
        fillGui(new Icon(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15)).setName("§0"));

        addItem(new Icon(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14)).setName("§c"), 45, 46, 47, 48, 50, 51, 52, 53);
        addItem(new Icon(Material.BARRIER).setName("§cClose").onClick(inventoryClickEvent -> {
            inventoryClickEvent.getWhoClicked().closeInventory();
        }), 49);

        updateTask(0, 1, update -> {
            ItemStack firstSlot = getInventory().getItem(29);
            ItemStack secondSlot = getInventory().getItem(33);
            if (firstSlot == null && secondSlot == null) {
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
                addItem(new Icon(Material.ANVIL)
                        .setName("§aCombine Items")
                        .setLore(
                                "§7Combine the items in the slots",
                                "§7to the left and right below."
                        ).onClick(inventoryClickEvent -> {
                    System.out.println("e");
                }), 22);
            }

            if (firstSlot == null && secondSlot != null) {
                addItem(new Icon(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14))
                        .setName("§6Item to Upgrade")
                        .setLore(
                                "§7The item you want to upgrade",
                                "§7should be placed in the slot on",
                                "§7this side."
                        ), 11, 12, 20);
                addItem(new Icon(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5))
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
                addItem(new Icon(Material.ANVIL)
                        .setName("§aCombine Items")
                        .setLore(
                                "§7Combine the items in the slots",
                                "§7to the left and right below."
                        ).onClick(inventoryClickEvent -> {
                            System.out.println("e");
                        }), 22);
            }
            if (firstSlot != null && secondSlot == null) {
                addItem(new Icon(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5))
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
                addItem(new Icon(Material.ANVIL)
                        .setName("§aCombine Items")
                        .setLore(
                                "§7Combine the items in the slots",
                                "§7to the left and right below."
                        ).onClick(inventoryClickEvent -> {
                            System.out.println("e");
                        }), 22);
            }

            if (firstSlot != null && secondSlot != null) {
                SBItem upgrade = SBItem.fromNBTItem(new NBTItem(firstSlot));
                SBItem sacrifice = SBItem.fromNBTItem(new NBTItem(secondSlot));

                if (canBeCombined(upgrade, sacrifice)) {
                    addItem(new Icon(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5))
                            .setName("§6Item to Upgrade")
                            .setLore(
                                    "§7The item you want to upgrade",
                                    "§7should be placed in the slot on",
                                    "§7this side."
                            ), 11, 12, 20);
                    addItem(new Icon(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5))
                            .setName("§6Item to Sacrifice")
                            .setLore(
                                    "§7The item you are sacrificing in",
                                    "§7order to upgrade the item on the",
                                    "§7left should be placed in the",
                                    "§7slot on this side."
                            ), 14, 15, 24);
                    Integer combineCost = combineCost(upgrade, sacrifice);
                    if (combineCost == null) {
                        addItem(new Icon(Material.ANVIL)
                                .setName("§aCombine Items")
                                .setLore(
                                        "§7Combine the items in the slots",
                                        "§7to the left and right below.",
                                        "",
                                        "§eClick to combine!"
                                ).onClick(inventoryClickEvent -> {
                                    System.out.println("e");
                                }), 22);
                    } else {
                        addItem(new Icon(Material.ANVIL)
                                .setName("§aCombine Items")
                                .setLore(
                                        "§7Combine the items in the slots",
                                        "§7to the left and right below.",
                                        "",
                                        "§7Cost",
                                        "§3" + combineCost + " §3Exp Levels",
                                        "",
                                        "§eClick to combine!"
                                ).onClick(inventoryClickEvent -> {
                                    System.out.println("e");
                                }), 22);
                    }
                    if (firstSlot.getType() == Material.ENCHANTED_BOOK && secondSlot.getType() == Material.ENCHANTED_BOOK) {
                        upgrade.setSbEnchantments(getResultingEnchantments(upgrade.getSbEnchantments(), sacrifice.getSbEnchantments()));
                        addItem(new Icon(upgrade.toItemStack()), 13);
                    } else {
                        ItemStack result = getCombinedResult(upgrade, sacrifice).toItemStack();
                        addItem(new Icon(result), 13);
                    }
                } else {
                    addItem(new Icon(Material.BARRIER)
                            .setName("§cError!")
                            .setLore("§7You cannot combine those items!")
                            .onClick(inventoryClickEvent -> {
                        System.out.println("e");
                    }), 13);
                    addItem(new Icon(Material.ANVIL)
                            .setName("§aCombine Items")
                            .setLore(
                                    "§7Combine the items in the slots",
                                    "§7to the left and right below."
                            ).onClick(inventoryClickEvent -> {
                        System.out.println("e");
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
                }
            }
        });

        addItem(new Icon(Material.AIR).onClick(inventoryClickEvent -> {
            ItemStack cursorStack = inventoryClickEvent.getCursor();
            ItemStack itemInSlot = inventoryClickEvent.getCurrentItem();
            if (cursorStack == null) return;
            if (cursorStack.getAmount() == 0 || cursorStack.getType() == Material.AIR) {
                if (itemInSlot == null) return;
                if (itemInSlot.getType() == Material.AIR || itemInSlot.getAmount() == 0) {
                    return;
                }
                inventoryClickEvent.setCursor(itemInSlot);
                inventoryClickEvent.setCurrentItem(new ItemStack(Material.AIR));
            } else {
                SBItem sbItem = SBItem.fromNBTItem(new NBTItem(inventoryClickEvent.getCursor()));

                if (itemInSlot.getType() != Material.AIR || itemInSlot.getAmount() != 0) {
                    inventoryClickEvent.setCursor(itemInSlot);
                    inventoryClickEvent.setCurrentItem(sbItem.toItemStack());
                } else {
                    inventoryClickEvent.setCurrentItem(sbItem.toItemStack());
                    inventoryClickEvent.setCursor(null);
                }
            }

        }).onDrag(inventoryDragEvent -> {
            System.out.println("yeah");
        }), 29, 33);



    }
}
