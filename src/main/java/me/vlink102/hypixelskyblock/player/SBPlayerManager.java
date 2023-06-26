package me.vlink102.hypixelskyblock.player;

import de.Herbystar.TTA.TTA_Methods;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTType;
import me.vlink102.hypixelskyblock.HypixelSkyblock;
import me.vlink102.hypixelskyblock.items.SBItem;
import me.vlink102.hypixelskyblock.util.SBUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.StringJoiner;
import java.util.UUID;

public class SBPlayerManager implements Listener {
    private final HashMap<UUID, SBPlayer> PLAYER_MAP;

    public SBPlayerManager(HypixelSkyblock plugin) {
        this.PLAYER_MAP = new HashMap<>();
        new BukkitRunnable() {
            @Override
            public void run() {
                updatePlayers();
            }
        }.runTaskTimer(plugin, 0, 1);
    }

    public void updatePlayers() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (PLAYER_MAP.containsKey(player.getUniqueId())) {
                updatePlayer(PLAYER_MAP.get(player.getUniqueId()));
            } else {
                System.out.println("Tried to update unregistered player: " + player.getUniqueId());
            }
        }
    }

    public HashMap<UUID, SBPlayer> getPlayerMap() {
        return PLAYER_MAP;
    }

    public void addPlayer(Player player) {
        if (PLAYER_MAP.containsKey(player.getUniqueId())) {
            System.out.println("Already registered player: " + player.getUniqueId());
            return;
        }
        PLAYER_MAP.put(player.getUniqueId(), new SBPlayer(player));
    }

    public void resetPlayer(Player player) {
        PLAYER_MAP.put(player.getUniqueId(), new SBPlayer(player));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!PLAYER_MAP.containsKey(player.getUniqueId())) {
            PLAYER_MAP.put(player.getUniqueId(), new SBPlayer(player));
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&aWelcome! &b" + player.getName() + "&e to Lowpixel Groundblock"));
        }
    }

    public double calculateEffectiveHealth(SBPlayer player) {
        return player.getHealth().getValue() * (player.getDefense().getValue() / 100 + 1);
    }

    public double calculateFinalAbilityDamage(SBPlayer player) {
        double baseAbilityDamage = 0; // TODO
        double intelligence = player.getIntelligence().getValue();
        double abilityScaling = 0; // TODO
        double abilityDamageStat = player.getAbilityDamage().getValue();
        return 0; // TODO
    }

    public double calculateFinalDamage(SBPlayer player) {
        double initialDamage = 0;
        return 0; // TODO
    }

    public double calculateHearts(double playerHealth) {
        if (playerHealth < 5) {
            return 0.5;
        }
        if (playerHealth < 10) {
            return 1;
        }
        if (playerHealth < 15) {
            return 1.5;
        }
        if (playerHealth < 20) {
            return 2;
        }
        if (playerHealth < 25) {
            return 2.5;
        }
        if (playerHealth < 30) {
            return 3;
        }
        if (playerHealth < 35) {
            return 3.5;
        }
        if (playerHealth < 40) {
            return 4;
        }
        if (playerHealth < 45) {
            return 4.5;
        }
        if (playerHealth < 50) {
            return 5;
        }
        if (playerHealth < 55) {
            return 5.5;
        }
        if (playerHealth < 60) {
            return 6;
        }
        if (playerHealth < 65) {
            return 6.5;
        }
        if (playerHealth < 70) {
            return 7;
        }
        if (playerHealth < 75) {
            return 7.5;
        }
        if (playerHealth < 80) {
            return 8;
        }
        if (playerHealth < 85) {
            return 8.5;
        }
        if (playerHealth < 90) {
            return 9;
        }
        if (playerHealth < 95) {
            return 9.5;
        }
        if (playerHealth < 125) {
            return 10;
        }
        if (playerHealth < 145) {
            return 10.5;
        }
        if (playerHealth < 165) {
            return 11;
        }
        if (playerHealth < 197.5) {
            return 11.5;
        }
        if (playerHealth < 230) {
            return 12;
        }
        if (playerHealth < 265) {
            return 12.5;
        }
        if (playerHealth < 300) {
            return 13;
        }
        if (playerHealth < 350) {
            return 13.5;
        }
        if (playerHealth < 400) {
            return 14;
        }
        if (playerHealth < 475) {
            return 15;
        }
        if (playerHealth < 650) {
            return 16;
        }
        if (playerHealth < 725) {
            return 16.5;
        }
        if (playerHealth < 800) {
            return 17;
        }
        if (playerHealth < 900) {
            return 17.5;
        }
        if (playerHealth < 1000) {
            return 18;
        }
        if (playerHealth < 1125) {
            return 18.5;
        }
        if (playerHealth < 1250) {
            return 19;
        }
        return 20;
    }

    public void sendActionBar(SBPlayer player, String text) {
        TTA_Methods.sendActionBar(player.getPlayerBind(), ChatColor.translateAlternateColorCodes('&', text));
    }

    public void manageActionBar(SBPlayer player) {
        StringJoiner actionBarContent = new StringJoiner("      ");
        actionBarContent.add("&c" + player.getHealth().getRoundedValue() + "/" + player.getMaxHealth().getRoundedValue() + "❤");
        if (player.getDefense().getValue() != 0) {
            actionBarContent.add("&a" + player.getDefense().getRoundedValue() + "❈ Defense");
            // TODO Location change
        }
        actionBarContent.add("&b" + player.getMana().getRoundedValue() + "/" + player.getIntelligence().getRoundedValue() + "✎ Mana");
        sendActionBar(player, actionBarContent.toString());
    }

    public void setPlayerHealth(SBPlayer player) {
        double maxHealth = player.getMaxHealth().getValue();
        double health = player.getHealth().getValue();
        Player bukkitPlayer = player.getPlayerBind();
        bukkitPlayer.setMaxHealth(calculateHearts(maxHealth) * 2);
        bukkitPlayer.setHealth(calculateHearts(health) * 2);
    }

    public void updatePlayer(SBPlayer player) {
        manageActionBar(player);
        setPlayerHealth(player);
        manageInventory(player);
    }

    public static void manageInventory(SBPlayer player) {
        Player bukkitPlayer = player.getPlayerBind();
        PlayerInventory inventory = bukkitPlayer.getInventory();
        boolean changeMade = false;
        for (int i = 0; i < 36; i++) {
            ItemStack item = inventory.getContents()[i];
            if (item == null) continue;
            if (item.getAmount() <= 0) continue;
            if (item.getType() == (Material.AIR)) continue;
            NBTItem nbtItem = new NBTItem(item);
            if (!nbtItem.hasTag("rarity")) {
                inventory.setItem(i, SBItem.fromVanillaItem(item));
                changeMade = true;
            }
        }
        boolean armorChanged = updateArmor(inventory);

        if (changeMade || armorChanged) {
            bukkitPlayer.updateInventory();
        }
    }

    public static boolean updateArmor(PlayerInventory inventory) {
        boolean changed = false;
        ItemStack helm = inventory.getHelmet();
        ItemStack chest = inventory.getChestplate();
        ItemStack leg = inventory.getLeggings();
        ItemStack boot = inventory.getBoots();

        if (helm != null) {
            if (helm.getAmount() != 0 && helm.getType() != Material.AIR) {
                NBTItem nbtItem = new NBTItem(helm);
                if (!nbtItem.hasTag("rarity")) {
                    inventory.setHelmet(SBItem.fromVanillaItem(helm));
                    changed = true;
                }
            }
        }
        if (chest != null) {
            if (chest.getAmount() != 0 && chest.getType() != Material.AIR) {
                NBTItem nbtItem = new NBTItem(chest);
                if (!nbtItem.hasTag("rarity")) {
                    inventory.setChestplate(SBItem.fromVanillaItem(chest));
                    changed = true;
                }
            }
        }
        if (leg != null) {
            if (leg.getAmount() != 0 && leg.getType() != Material.AIR) {
                NBTItem nbtItem = new NBTItem(leg);
                if (!nbtItem.hasTag("rarity")) {
                    inventory.setLeggings(SBItem.fromVanillaItem(leg));
                    changed = true;
                }
            }
        }
        if (boot != null) {
            if (boot.getAmount() != 0 && boot.getType() != Material.AIR) {
                NBTItem nbtItem = new NBTItem(boot);
                if (!nbtItem.hasTag("rarity")) {
                    inventory.setBoots(SBItem.fromVanillaItem(boot));
                    changed = true;
                }
            }
        }
        return changed;
    }

    private boolean isChanged(PlayerInventory inventory, boolean changed, ItemStack helm, ItemStack chest) {

        return changed;
    }

    public void damagePlayer(SBPlayer player, SBUtils.Damage damage) {
        player.setHealth(player.getHealth().getValue() - damage.getValue());
    }
}
